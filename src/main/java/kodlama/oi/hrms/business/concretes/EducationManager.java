package kodlama.oi.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import kodlama.oi.hrms.business.abstracts.EducationService;
import kodlama.oi.hrms.core.utilities.results.DataResult;
import kodlama.oi.hrms.core.utilities.results.Result;
import kodlama.oi.hrms.core.utilities.results.SuccessDataResult;
import kodlama.oi.hrms.core.utilities.results.SuccessResult;
import kodlama.oi.hrms.dataAccess.abstracts.EducationDao;
import kodlama.oi.hrms.entities.concretes.Education;

@Service
public class EducationManager implements EducationService {
	private EducationDao educationDao;
	
	@Autowired
	public EducationManager(EducationDao educationDao) {
		super();
		this.educationDao=educationDao;
	}
	@Override
	public DataResult<List<Education>> getAll() {
		return new SuccessDataResult<List<Education>>(this.educationDao.findAll(),"Data Listed");
	}

	@Override
	public Result add(Education education) {
		this.educationDao.save(education);
	    return new SuccessResult("Added new education");
	}

	@Override
	public Result update(Education education) {
		this.educationDao.save(education);
		return new SuccessResult("Education Information Updated");
	}

	@Override
	public Result delete(int id) {
		this.educationDao.deleteById(id);
		return new SuccessResult("Education Deleted") ;
	}
	
	@Override
	public DataResult<List<Education>> findByIdOrderByEndDate(int idWithoutDesc) {
		return new SuccessDataResult<>(educationDao.findByIdOrderByEndDate(idWithoutDesc));
	}
	

	@Override
	public DataResult<List<Education>> findByIdOrderByEndDateDesc(int id, Direction direction) {
		List<Education>candidatesCvEducation=direction.isAscending() 
				? educationDao.findByIdOrderByEndDate(id)
				: educationDao.findByIdOrderByEndDateDesc(id);
		
		return new SuccessDataResult<>(candidatesCvEducation);
	}


}
