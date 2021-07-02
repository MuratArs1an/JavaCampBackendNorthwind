package kodlama.oi.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlama.oi.hrms.core.utilities.results.DataResult;
import kodlama.oi.hrms.core.utilities.results.Result;
import kodlama.oi.hrms.entities.concretes.PhotoInfo;

public interface PhotoService {
	Result add(PhotoInfo photoInfo, MultipartFile multipartFile);
	
	Result update(PhotoInfo resumeImage);
	
	Result delete(int id);
	
	DataResult<PhotoInfo> getById(int id);
	
	DataResult<List<PhotoInfo>> getAll();
	

}
