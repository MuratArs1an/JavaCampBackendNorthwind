package kodlama.oi.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.oi.hrms.business.abstracts.JobPostionService;
import kodlama.oi.hrms.core.utilities.results.DataResult;
import kodlama.oi.hrms.core.utilities.results.Result;
import kodlama.oi.hrms.core.utilities.results.SuccessDataResult;
import kodlama.oi.hrms.core.utilities.results.SuccessResult;
import kodlama.oi.hrms.dataAccess.abstracts.JobPositionDao;
import kodlama.oi.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPostionService{

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	
	@Override
	public DataResult<List<JobPosition>> getAll() {

		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),
				"Is Pozisyonlari Listelendi");
		
	}


	@Override
	public Result add(JobPosition jobPosition) {
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("Is Pozisyonu Eklendi");
	}




}
