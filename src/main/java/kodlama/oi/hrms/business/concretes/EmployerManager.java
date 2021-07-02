package kodlama.oi.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.oi.hrms.business.abstracts.EmployerService;
import kodlama.oi.hrms.core.utilities.results.DataResult;
import kodlama.oi.hrms.core.utilities.results.ErrorResult;
import kodlama.oi.hrms.core.utilities.results.Result;
import kodlama.oi.hrms.core.utilities.results.SuccessDataResult;
import kodlama.oi.hrms.core.utilities.results.SuccessResult;
import kodlama.oi.hrms.dataAccess.abstracts.EmployerDao;
import kodlama.oi.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private CheckManager checkManager;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao=employerDao;
		
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),
				"Is Verenler Listelendi");
	}

	@Override
	public Result add(Employer employer) {
		
		if(checkManager.emailControl() && checkManager.domainControl(employer) && checkManager.systemUserApproval()
				&& checkManager.passwordCheck(employer)) {
			this.employerDao.save(employer);
			return new SuccessResult("Is Veren Eklendi");
		}else {
			return new ErrorResult("Is Veren Kayit Edilemedi");
		}

	}

}
