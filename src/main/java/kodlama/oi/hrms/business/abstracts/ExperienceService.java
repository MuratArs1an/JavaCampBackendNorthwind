package kodlama.oi.hrms.business.abstracts;

import java.util.List;

import kodlama.oi.hrms.core.utilities.results.DataResult;
import kodlama.oi.hrms.core.utilities.results.Result;
import kodlama.oi.hrms.entities.concretes.Experience;

public interface ExperienceService {
	
    DataResult<List<Experience>> getAll();

    Result add(Experience experience);

    Result update(Experience experience);

    Result delete(int id);

    DataResult<List<Experience>> findById(int id);

}
