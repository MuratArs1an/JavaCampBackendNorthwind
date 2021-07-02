package kodlama.oi.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import kodlama.oi.hrms.business.abstracts.CloudinaryPhotoService;
import kodlama.oi.hrms.business.abstracts.PhotoService;
import kodlama.oi.hrms.core.utilities.results.DataResult;
import kodlama.oi.hrms.core.utilities.results.Result;
import kodlama.oi.hrms.core.utilities.results.SuccessDataResult;
import kodlama.oi.hrms.core.utilities.results.SuccessResult;
import kodlama.oi.hrms.dataAccess.abstracts.PhotoDao;
import kodlama.oi.hrms.entities.concretes.PhotoInfo;

@Service
public class PhotoManager implements PhotoService {

	private PhotoDao photoDao;
	private CloudinaryPhotoService cloudinaryPhotoService;
	
	@Autowired
	public PhotoManager(PhotoDao photoDao) {
		super();
		this.photoDao=photoDao;

	}
	
	@Override
	public Result add(PhotoInfo photoInfo, MultipartFile imageFile) {
	       @SuppressWarnings("unchecked")
	        Map<String, String> uploadImage = this.cloudinaryPhotoService.uploadPhoto(imageFile).getData();
	        photoInfo.setPhotoUrl(uploadImage.get("url"));
	        this.photoDao.save(photoInfo);
		return new SuccessResult("Photo Has Been Added");
	}

	@Override
	public Result update(PhotoInfo photoInfo) {
        this.photoDao.save(photoInfo);
        return new SuccessResult("Photo Has Been Updated");
	}

	@Override
	public Result delete(int id) {
        this.photoDao.deleteById(id);
        return new SuccessResult("Photo Has Been Deleted");
	}

	@Override
	public DataResult<PhotoInfo> getById(int id) {
		 return new SuccessDataResult<>(this.photoDao.getById(id));
	}

	@Override
	public DataResult<List<PhotoInfo>> getAll() {
		 return new SuccessDataResult<>(this.photoDao.findAll());
	}
	

}
