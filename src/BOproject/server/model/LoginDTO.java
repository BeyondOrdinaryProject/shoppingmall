package BOproject.server.model;

import java.io.Serializable;

public class LoginDTO implements Serializable{

	private static final long serialVersionUID = 1232533528L;
	
	private String user_id;
	private String user_pass;

	public LoginDTO() {
	}

	public LoginDTO(String user_id, String user_pass) {
		this.user_id = user_id;
		this.user_pass = user_pass;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pass() {
		return user_pass;
	}

	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}

	@Override
	public String toString() {
		return "LoginVO [user_id=" + user_id + ", user_pass=" + user_pass + "]";
	}
	
	
}
