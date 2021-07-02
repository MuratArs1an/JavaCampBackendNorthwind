package kodlama.oi.hrms.business.abstracts;

import java.util.List;

import kodlama.oi.hrms.core.utilities.results.DataResult;
import kodlama.oi.hrms.core.utilities.results.Result;
import kodlama.oi.hrms.entities.concretes.Cv;
import kodlama.oi.hrms.entities.dtos.CvDto;

public interface CvService {
	
	DataResult<List<Cv>> getAll();
	
	DataResult<Cv> getById(int id);
	
	DataResult<CvDto> getCvDetailsById(int id);
	
	Result add(Cv cv);
	
	Result update(Cv cv);
	
	Result delete(int id);

}
