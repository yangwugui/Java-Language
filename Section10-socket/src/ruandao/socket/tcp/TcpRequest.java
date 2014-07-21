package ruandao.socket.tcp;

import java.io.Serializable;

public class TcpRequest  implements Serializable {
	String action;
	Object[] parameter;
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Object[] getParameter() {
		return parameter;
	}
	public void setParameter(Object[] parameter) {
		this.parameter = parameter;
	}
}
