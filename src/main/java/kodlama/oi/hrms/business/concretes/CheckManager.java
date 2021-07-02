package kodlama.oi.hrms.business.concretes;

import kodlama.oi.hrms.entities.concretes.Employer;

public class CheckManager {
	
	public boolean emailControl() {
		return true;
	}
	
	public boolean domainControl(Employer employer) {
		if(employer.getEmail().substring(employer.getEmail().indexOf("@")+1)==employer.getWeb()) {
			return true;
		}else {
			return false;
		}
	}

	public boolean systemUserApproval() {
		return true;
	}
	
	public boolean passwordCheck(Employer employer) {
		if(employer.getPassword()==employer.getPasswordAgain()) {
			return true;
		}else {
			return false;
		}
		
	}
}

