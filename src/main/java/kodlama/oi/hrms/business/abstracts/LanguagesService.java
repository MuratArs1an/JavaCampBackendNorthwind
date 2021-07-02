package kodlama.oi.hrms.business.abstracts;

import java.util.List;

import kodlama.oi.hrms.core.utilities.results.DataResult;
import kodlama.oi.hrms.core.utilities.results.Result;
import kodlama.oi.hrms.entities.concretes.Languages;

public interface LanguagesService {
	 DataResult<List<Languages>> findAllById(int id);

	 DataResult<Languages> getById(int id);

	 DataResult<List<Languages>> getAll();

	 Result add(Languages languages);

	 Result update(Languages languages);

	 Result delete(Languages languages);
}
