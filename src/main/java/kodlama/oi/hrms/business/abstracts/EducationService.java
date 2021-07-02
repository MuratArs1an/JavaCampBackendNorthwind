package kodlama.oi.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;

import kodlama.oi.hrms.core.utilities.results.DataResult;
import kodlama.oi.hrms.core.utilities.results.Result;
import kodlama.oi.hrms.entities.concretes.Education;

public interface EducationService {
	
	DataResult<List<Education>>getAll();
	
	Result add(Education education);
	
	Result update(Education education);
	
	Result delete(int id);
	
	DataResult<List<Education>>findByIdOrderByEndDateDesc(int id, Sort.Direction direction);

	DataResult<List<Education>> findByIdOrderByEndDate(int idWithoutDesc);
}
