package kodlama.oi.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.oi.hrms.business.abstracts.EducationService;
import kodlama.oi.hrms.core.utilities.results.DataResult;
import kodlama.oi.hrms.core.utilities.results.Result;
import kodlama.oi.hrms.entities.concretes.Education;

@RestController
@RequestMapping("/api/educations")
@CrossOrigin
public class EducationController {
	private EducationService educationService;
	
	@Autowired
	public EducationController(EducationService educationService) {
		super();
		this.educationService=educationService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Education>> getAll(){
		return this.educationService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody Education education) {
		return this.add(education);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestBody int id) {
		return this.delete(id);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Education education){
		return this.educationService.update(education);
	}
	
	@GetMapping("/findByEducationByEndDate")
	public DataResult<List<Education>> findByIdOrderByEndDateDesc(@RequestParam int id, @RequestParam Sort.Direction direction){
		return this.educationService.findByIdOrderByEndDateDesc(id, direction);
	}
}
