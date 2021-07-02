package kodlama.oi.hrms.business.abstracts;

import java.util.List;

import kodlama.oi.hrms.core.utilities.results.DataResult;
import kodlama.oi.hrms.core.utilities.results.Result;
import kodlama.oi.hrms.entities.concretes.Candidates;


public interface CandidatesService {
	DataResult<List<Candidates>> getAll();
	DataResult<Candidates> getById(int id);
	Result add(Candidates candidates);

}
