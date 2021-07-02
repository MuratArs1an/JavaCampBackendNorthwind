package kodlama.oi.hrms.business.abstracts;

import java.util.List;

import kodlama.oi.hrms.core.utilities.results.DataResult;
import kodlama.oi.hrms.core.utilities.results.Result;
import kodlama.oi.hrms.entities.concretes.Employer;

public interface EmployerService {
	DataResult<List<Employer>> getAll();
	Result add(Employer employer);
}
