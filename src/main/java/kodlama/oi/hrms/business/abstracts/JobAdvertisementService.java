package kodlama.oi.hrms.business.abstracts;

import java.util.List;

import kodlama.oi.hrms.core.utilities.results.DataResult;
import kodlama.oi.hrms.core.utilities.results.Result;
import kodlama.oi.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	DataResult<List<JobAdvertisement>> getAll();
	Result add(JobAdvertisement jobAdvertisement);
	
	DataResult<List<JobAdvertisement>>getByIsActive(boolean isActive);
	
	DataResult<List<JobAdvertisement>>getByIsActiveOrderByApplicationDeadlineAsc(boolean isActive);
	
	DataResult<List<JobAdvertisement>>getByIsActiveAndEmployer_Id(boolean isActive, int id);
}

