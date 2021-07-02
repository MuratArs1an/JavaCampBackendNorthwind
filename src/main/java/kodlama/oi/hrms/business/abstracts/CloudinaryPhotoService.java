package kodlama.oi.hrms.business.abstracts;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlama.oi.hrms.core.utilities.results.DataResult;

public interface CloudinaryPhotoService {
	DataResult<Map> uploadPhoto(MultipartFile multipartFile);
}
