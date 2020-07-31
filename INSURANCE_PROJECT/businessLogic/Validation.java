package businessLogic;

import model.Login;

public class Validation {
	
	public boolean checkAdminLogin(Login log) {
		if(log.getUsername().equals("admin") && log.getPassword().equals("admin"))
			return true;
		else 
		return false;
	}

	public boolean checkAgentLogin(Login log) {
		if(log.getUsername().equals("agent") && log.getPassword().equals("agent"))
			return true;
		else 
		return false;
	}
}
