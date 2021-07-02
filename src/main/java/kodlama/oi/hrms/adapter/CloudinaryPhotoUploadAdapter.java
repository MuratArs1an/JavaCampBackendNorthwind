package kodlama.oi.hrms.adapter;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;


import kodlama.oi.hrms.business.abstracts.CloudinaryPhotoService;
import kodlama.oi.hrms.core.utilities.results.DataResult;
import kodlama.oi.hrms.core.utilities.results.SuccessDataResult;


public class CloudinaryPhotoUploadAdapter implements CloudinaryPhotoService {
	
	private final Cloudinary cloudinary;

	 public CloudinaryPhotoUploadAdapter() {

	        this.cloudinary = new Cloudinary(ObjectUtils.asMap (
	                "cloud_name", "da6xlhueu",
	                "api_key", "766215715978869",
	                "api_secret", "aXBQ7mblPrHEpjlaF7Iq7z7PQN0"));
	    }

	@Override
	public DataResult<Map> uploadPhoto(MultipartFile multipartFile) {
		   try {
	            @SuppressWarnings("unchecked")
	            Map<String, String> resultMap = (Map<String, String>) cloudinary.uploader().upload(multipartFile.getBytes(), ObjectUtils.emptyMap());
	            return new SuccessDataResult<Map>(resultMap);
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
	}



}
