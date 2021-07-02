package kodlama.oi.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.oi.hrms.business.abstracts.LanguagesService;
import kodlama.oi.hrms.core.utilities.results.DataResult;
import kodlama.oi.hrms.core.utilities.results.ErrorDataResult;
import kodlama.oi.hrms.core.utilities.results.ErrorResult;
import kodlama.oi.hrms.core.utilities.results.Result;
import kodlama.oi.hrms.core.utilities.results.SuccessDataResult;
import kodlama.oi.hrms.core.utilities.results.SuccessResult;
import kodlama.oi.hrms.dataAccess.abstracts.LanguagesDao;
import kodlama.oi.hrms.entities.concretes.Languages;

@Service
public class LanguagesManager implements LanguagesService {
	
	private LanguagesDao languagesDao;
	
	@Autowired
	public LanguagesManager(LanguagesDao languagesDao) {
		super();
		this.languagesDao=languagesDao;
	}

	@Override
	public DataResult<List<Languages>> findAllById(int id) {
        List<Languages> languages = languagesDao.findAllById(id);

        if (languages.isEmpty()) {
            return new ErrorDataResult<>("Information for these languages could not be found.");

        } else {
            return new SuccessDataResult<>(languages, "Languages have been successfully added");
        }
	}

	@Override
	public DataResult<Languages> getById(int id) {
        Optional<Languages> languages = this.languagesDao.findById(id);

        if (!languages.isPresent()) {
            return new ErrorDataResult<>("Language not found");
        } else {
            return new SuccessDataResult<>(languages.get());
        }
	}

	@Override
	public DataResult<List<Languages>> getAll() {
		return new SuccessDataResult<>(this.languagesDao.findAll(), "Listed language data");
	}

	@Override
	public Result add(Languages languages) {
        if (getById(languages.getId()).getData() != null) {
            return new ErrorResult("id: " + languages.getId() + "Language Name: " + languages.getLanguage() + "Same language cannot repeat");
        } else {
            this.languagesDao.save(languages);
            return new SuccessResult("Added new language");
        }
	}

	@Override
	public Result update(Languages languages) {
		this.languagesDao.save(languages);
		return new SuccessResult("Language Updated");
	}

	@Override
	public Result delete(Languages languages) {
		this.languagesDao.delete(languages);
		return new SuccessResult("Language Deleted");
	}

}
