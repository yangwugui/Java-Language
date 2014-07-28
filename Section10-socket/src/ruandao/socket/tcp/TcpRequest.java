package ruandao.socket.tcp;

import java.io.Serializable;

public class TcpRequest  implements Serializable {
	String action;
	Object[] parameters;
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Object[] getParameters() {
		return parameters;
	}
	public void setParameters(Object[] parameters) {
		this.parameters = parameters;
	}
}
