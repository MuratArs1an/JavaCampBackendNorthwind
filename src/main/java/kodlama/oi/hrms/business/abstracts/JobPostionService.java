package kodlama.oi.hrms.business.abstracts;

import java.util.List;

import kodlama.oi.hrms.core.utilities.results.DataResult;
import kodlama.oi.hrms.core.utilities.results.Result;
import kodlama.oi.hrms.entities.concretes.JobPosition;


public interface JobPostionService {
	DataResult<List<JobPosition>> getAll();
	Result add(JobPosition jobPosition);
	
}
