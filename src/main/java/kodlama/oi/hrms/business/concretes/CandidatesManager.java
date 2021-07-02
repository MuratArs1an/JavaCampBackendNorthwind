package kodlama.oi.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.oi.hrms.business.abstracts.CandidateCheckService;
import kodlama.oi.hrms.business.abstracts.CandidatesService;
import kodlama.oi.hrms.core.utilities.results.DataResult;
import kodlama.oi.hrms.core.utilities.results.ErrorResult;
import kodlama.oi.hrms.core.utilities.results.Result;
import kodlama.oi.hrms.core.utilities.results.SuccessDataResult;
import kodlama.oi.hrms.core.utilities.results.SuccessResult;
import kodlama.oi.hrms.dataAccess.abstracts.CandidatesDao;
import kodlama.oi.hrms.entities.concretes.Candidates;

@Service
public class CandidatesManager implements CandidatesService{
	
	private CandidatesDao candidatesDao;
	private CheckManager checkManager;
	private CandidateCheckService candidateCheckService;

	
	@Autowired
	public CandidatesManager(CandidatesDao candidatesDao) {
		super();
		this.candidatesDao=candidatesDao;
	}

	@Override
	public DataResult<List<Candidates>> getAll() {
		return new SuccessDataResult<List<Candidates>>(this.candidatesDao.findAll(),
				"Adaylar Listelendi ") ;
	}

	@Override
	public Result add(Candidates candidates) {
		if(candidateCheckService.loginControl(candidates) && checkManager.emailControl() ) {
			this.candidatesDao.save(candidates);
			return new SuccessResult("Adaylar Kayit Edildi");
			
		}else {
			return new ErrorResult("Adaylar Kayit Islemi Basarisiz");
			
		}
		
		
	}

	@Override
	public DataResult<Candidates> getById(int id) {
		return new SuccessDataResult<>(this.candidatesDao.getById(id));
	}

}
