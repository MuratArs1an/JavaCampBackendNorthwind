package kodlama.oi.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.oi.hrms.business.abstracts.ExperienceService;
import kodlama.oi.hrms.core.utilities.results.DataResult;
import kodlama.oi.hrms.core.utilities.results.ErrorDataResult;
import kodlama.oi.hrms.core.utilities.results.ErrorResult;
import kodlama.oi.hrms.core.utilities.results.Result;
import kodlama.oi.hrms.core.utilities.results.SuccessDataResult;
import kodlama.oi.hrms.core.utilities.results.SuccessResult;
import kodlama.oi.hrms.dataAccess.abstracts.ExperienceDao;
import kodlama.oi.hrms.entities.concretes.Experience;

@Service
public class ExperinceManager implements ExperienceService {

	private ExperienceDao experienceDao;
	
	@Autowired
	public ExperinceManager(ExperienceDao experienceDao) {
		super();
		this.experienceDao=experienceDao;
	}
	
	@Override
	public DataResult<List<Experience>> getAll() {
		return new SuccessDataResult<>(this.experienceDao.findAll(), "Data Listed");
	}

	@Override
	public Result add(Experience experience) {
        if (findById(experience.getId()).getData() != null) {
            return new ErrorResult(experience.getId() + "Same experience cannot repeat");
        }
        this.experienceDao.save(experience);
        return new SuccessResult("New Experince Added");
	}

	@Override
	public Result update(Experience experience) {
        this.experienceDao.save(experience);
        return new SuccessResult("Experince Updated");
	}

	@Override
	public Result delete(int id) {
            this.experienceDao.deleteById(id);
            return new SuccessResult("Experince Deleted");
	}

	@Override
	public DataResult<List<Experience>> findById(int id) {
        List<Experience> experience = experienceDao.findById(id);

        if (experience.isEmpty()) {
            return new ErrorDataResult<>("This Work Experience Not Found");
        } else {
            return new SuccessDataResult<>(experience);
        }
	}

}
