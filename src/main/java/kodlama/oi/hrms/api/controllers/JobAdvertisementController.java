package kodlama.oi.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.oi.hrms.business.abstracts.JobAdvertisementService;
import kodlama.oi.hrms.core.utilities.results.DataResult;
import kodlama.oi.hrms.core.utilities.results.Result;
import kodlama.oi.hrms.entities.concretes.JobAdvertisement;


@RestController
@RequestMapping("/api/jopadvertisement")
public class JobAdvertisementController {
	
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService=jobAdvertisementService;
		
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@GetMapping("/getbyactivejobs")
	public DataResult<List<JobAdvertisement>> getByIsActive(@RequestParam boolean isActive){
		return this.jobAdvertisementService.getByIsActive(isActive);
	}
	
	@GetMapping("/getbyactivejobsasciending")
	public DataResult<List<JobAdvertisement>>getByIsActiveOrderByApplicationDeadlineAsc(@RequestParam boolean isActive){
		return this.jobAdvertisementService.getByIsActiveOrderByApplicationDeadlineAsc(isActive);
	}
	
	@GetMapping("/getactivejobsbycompanyname")
	public DataResult<List<JobAdvertisement>> getByIsActiveAndEmployer_Id(@RequestParam boolean isActive,@RequestParam int id) {
		return this.getByIsActiveAndEmployer_Id(isActive, id);
	}

}
