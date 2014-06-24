package ruandao.argparser;

public abstract class ArgParser {
	private String[] arguments;
    private String[] switchChars;             // For example: "/", "-"
    private String[] switchSymbols;           // Switch character(s)
    private Boolean  caseSensitiveSwitches;   // Are switches case-sensitive?

    // Constructor that defaults to case-insensitive switches and 
    // defaults to "/" and "-" as the only valid switch characters
    public ArgParser(String[] arguments, String[] switchSymbols) {
        this(arguments, switchSymbols, false, new String[] { "/", "-" }) ;
    }


    // Constructor that defaults to "/" and "-" as the only valid switch characters
    public ArgParser(String[] arguments, String[] switchSymbols, Boolean caseSensitiveSwitches) {
        this(arguments, switchSymbols, caseSensitiveSwitches, new String[] { "/", "-" }) ;
    }


    // Constructor with no defaults
    public ArgParser(String[] arguments, String[] switchSymbols, Boolean caseSensitiveSwitches, String[] switchChars) {
        this.arguments = arguments;
    	this.switchSymbols = switchSymbols;
        this.caseSensitiveSwitches = caseSensitiveSwitches;
        this.switchChars   = switchChars;
    }


    // Every derived class must implement an OnUsage method
    public abstract void onUsage(String errorInfo);


    // Every derived class must implement an OnSwitch method or a switch is considerred an error
    protected SwitchStatus onSwitch(String switchSymbol, String switchValue) {
        return(SwitchStatus.Error);
    }


    // Every derived class must implement an OnNonSwitch method or a non-switch is considerred an error
    protected SwitchStatus onNonSwitch(String value) {
        return(SwitchStatus.Error);
    }


    // The derived class is notified after all command-line switches have been parsed.
    // The derived class can perform any sanity checking required at this time.
    protected SwitchStatus onDoneParse() {
        // By default, we'll assume that all parsing was successful
        return(SwitchStatus.Error);
    }

    // This Parse method parses an arbitrary set of arguments
    public Boolean parse() {
        SwitchStatus ss = SwitchStatus.NoError;	    // Assume parsing is sucessful.

        int ArgNum;
        for (ArgNum = 0; (ss == SwitchStatus.NoError) && (ArgNum < arguments.length); ArgNum++) {

            // Determine if this argument starts with a valid switch character
            Boolean fIsSwitch = false;
            for (int n = 0; !fIsSwitch && (n < switchChars.length); n++) {
                fIsSwitch = (arguments[ArgNum].startsWith(switchChars[n]));
            }

            if (fIsSwitch) {
                // Does the switch begin with a legal switch symbol?
                Boolean fLegalSwitchSymbol = false;
                int n;
                for (n = 0; !fLegalSwitchSymbol && (n < switchSymbols.length); n++) {
                    if (caseSensitiveSwitches) {
                        fLegalSwitchSymbol = arguments[ArgNum].startsWith(switchSymbols[n],1);
                    } else {
                        fLegalSwitchSymbol = arguments[ArgNum].toUpperCase().startsWith(switchSymbols[n].toUpperCase(),1); 
                    }
                    if (fLegalSwitchSymbol) break;
                }
                if (!fLegalSwitchSymbol) {
                    // User specified an unrecognized switch, exit
                    ss = SwitchStatus.Error;
                    break;
                } else {
                    // This is a legal switch, notified the derived class of this switch and its value
                    ss = onSwitch(
                        caseSensitiveSwitches ? switchSymbols[n] : switchSymbols[n].toLowerCase(), 
                        arguments[ArgNum].substring(1 + switchSymbols[n].length()));
                }
            } else {
                // This is not a switch, notified the derived class of this "non-switch value"
                ss = onNonSwitch(arguments[ArgNum]);
            }
        }

        // Finished parsing arguments
        if (ss == SwitchStatus.NoError) {
            // No error occurred while parsing, let derived class perform a 
            // sanity check and return an appropraite status
            ss = onDoneParse();
        }

        if (ss == SwitchStatus.ShowUsage) {
            // Status indicates that usage should be shown, show it
            onUsage(null);
        }

        if (ss == SwitchStatus.Error) {
            // Status indicates that an error occurred, show it and the proper usage
            onUsage((ArgNum == arguments.length) ? null : arguments[ArgNum]);
        }

        // Return whether all parsing was sucessful.
        return(ss == SwitchStatus.NoError);
    }

}
