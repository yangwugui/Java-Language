package ruandao.argparser;

public class DemoArgParser extends ArgParser {
    // Members identifying command-line argument settings
    private int rows = 5;
    private int cols = 20;
    private String title = "----- NO TITLE -----";
    private char symbol = '@';
    
    // Give the set of valid command-line switches to the base class
    public DemoArgParser(String[] arguments) {
    	super(arguments, new String[] { "?", "r", "c", "s" }) ;
    }

    public int getRows(){
    	return this.rows;
    }
    
    public int getCols(){
    	return this.cols;
    }
    
    public String getTitle(){
    	return this.title;
    }
    
    public char getSymbol(){
    	return this.symbol;
    }
    
    // Shows application's usage info and also reports command-line argument errors.
    public void onUsage(String errorInfo) {
        if (errorInfo != null) {
            // An command-line argument error occurred, report it to user
            // errInfo identifies the argument that is in error.
            System.out.println("Command-line switch error: " + errorInfo + "\n" );
        }

        System.out.println("Usage: ArgParserDemo [-a] [-o] [-f<output-pathname>] [-c<codepage>] input-pathname...");
        System.out.println("   -?  Show this usage information");
        System.out.println("   -r  ");
        System.out.println("   -c  ");
        System.out.println("   -s  ");

    }

    // Called for each non-switch command-line argument (filespecs)
    @Override
    protected SwitchStatus onNonSwitch(String switchValue) {
    	if (switchValue.contains("!@#$%^&*()_+=-<>,.?/{}[]|:;''\"\\") )
    	{
    		System.out.println("标题中不能出现除字母数字外的特殊符号, 注意：可以出现空格。");
    		return SwitchStatus.Error;
    	}

        if(this.title=="----- NO TITLE -----") this.title = switchValue;
        else this.title += " " + switchValue;
        return SwitchStatus.NoError;
    }

    // Called for each switch command-line argument
    protected SwitchStatus onSwitch(String switchSymbol, String switchValue) {
        // NOTE: For case-insensitive switches, 
        //       switchSymbol will contain all lower-case characters

        SwitchStatus ss = SwitchStatus.NoError;
        do{  

	        if( switchSymbol == "?"){  // User wants to see Usage
	            ss = SwitchStatus.ShowUsage; 
	            break;
	        }
	        if( switchSymbol == "r") { // User wants to see all words sorted alphabetically
	            
	            break;
	        }
	        if( switchSymbol == "c") {  // User wants to see all words sorted by occurrence
	            
	            break;
	        }
	        if( switchSymbol == "s") { // User wants output redirected to a specified file
	            if (switchValue.length() < 1) {
	                System.out.println("No output file specified.");
	                ss = SwitchStatus.Error; 
	            } else {
	                symbol = switchValue.charAt(0);
	            }
	            break;
	        }
	        //default
	        System.out.println("Invalid switch: \"" + switchSymbol + "\".\n");
	        ss = SwitchStatus.Error; 
	        break;
        }while(false);
        
        return(ss);
    }


    // Called when all command-line arguments have been parsed
    protected SwitchStatus onDoneParse() {
        SwitchStatus ss = SwitchStatus.NoError;
        if (this.rows > cols) {
            ss = SwitchStatus.Error;
        }
        return(ss);
    }

}
