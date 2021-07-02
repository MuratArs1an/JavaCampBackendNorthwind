package kodlama.oi.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.oi.hrms.business.abstracts.CvService;
import kodlama.oi.hrms.business.abstracts.EducationService;
import kodlama.oi.hrms.business.abstracts.ExperienceService;
import kodlama.oi.hrms.business.abstracts.LanguagesService;
import kodlama.oi.hrms.core.utilities.results.DataResult;
import kodlama.oi.hrms.core.utilities.results.Result;
import kodlama.oi.hrms.entities.concretes.Cv;
import kodlama.oi.hrms.entities.concretes.Experience;
import kodlama.oi.hrms.entities.concretes.Languages;
import kodlama.oi.hrms.entities.concretes.PrograminSkills;
import kodlama.oi.hrms.entities.concretes.SocialMedia;
import kodlama.oi.hrms.entities.dtos.CvDto;

@Service
public class CvManager implements CvService{
	
	private CvDto cvDto;
	private EducationService educationService;
	private LanguagesService languagesService;
	private ExperienceService experienceService;
	private PrograminSkills programingSkills;
	private SocialMedia socialMedia;
	

	@Override
	public DataResult<List<Cv>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<Cv> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<CvDto> getCvDetailsById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add(Cv cv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(Cv cv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
