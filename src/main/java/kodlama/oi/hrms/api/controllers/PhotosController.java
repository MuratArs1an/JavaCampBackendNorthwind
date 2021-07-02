package kodlama.oi.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlama.oi.hrms.business.abstracts.CandidatesService;
import kodlama.oi.hrms.business.abstracts.PhotoService;
import kodlama.oi.hrms.core.utilities.results.DataResult;
import kodlama.oi.hrms.core.utilities.results.Result;
import kodlama.oi.hrms.entities.concretes.Candidates;
import kodlama.oi.hrms.entities.concretes.PhotoInfo;

@RestController
@RequestMapping("/api/images")
@CrossOrigin
public class PhotosController {

	private PhotoService photoService;
	private CandidatesService candidatesService;
	
	@Autowired
	public PhotosController(PhotoService photoService, CandidatesService candidatesService) {
		super();
		this.candidatesService=candidatesService;
		this.photoService=photoService;
	}
	@PostMapping("/add")	
	public Result add(@RequestParam(value = "id") int id, @RequestParam(value = "imageFile") MultipartFile imageFile) {
		Candidates candidates=this.candidatesService.getById(id).getData();
		PhotoInfo photoInfo= new PhotoInfo();
		photoInfo.setCandidates(candidates);
		return this.photoService.add(photoInfo, imageFile);
	}
	
	@PostMapping("/update")
	public Result update(@RequestParam PhotoInfo photoInfo) {
		return this.photoService.update(photoInfo);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.photoService.delete(id);
	}
	@GetMapping("/getall")
	public DataResult<List<PhotoInfo>> getAll(){
		return this.photoService.getAll();
	}
    @GetMapping("/getById")
    public DataResult<PhotoInfo> getById(@RequestParam int id) {
        return this.photoService.getById(id);
    }
}
