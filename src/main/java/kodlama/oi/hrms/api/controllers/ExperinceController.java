package kodlama.oi.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.oi.hrms.business.abstracts.ExperienceService;
import kodlama.oi.hrms.core.utilities.results.DataResult;
import kodlama.oi.hrms.core.utilities.results.Result;
import kodlama.oi.hrms.entities.concretes.Experience;

@RestController
@RequestMapping("/api/experince")
@CrossOrigin
public class ExperinceController {

	private ExperienceService experienceService;
	
	@Autowired
	public ExperinceController(ExperienceService experienceService) {
		super();
		this.experienceService=experienceService;
	}
	
    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<Experience>>> getAll() {
        DataResult<List<Experience>> result = experienceService.getAll();
        return ResponseEntity.ok(result);
    }
    
    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody Experience experince  ) {
        return ResponseEntity.ok(this.experienceService.add(experince));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Result> delete(@RequestBody int id) {
        return ResponseEntity.ok(this.experienceService.delete(id));
    }

    @PostMapping("/update")
    public ResponseEntity<Result> update(@RequestBody Experience experince) {
        return ResponseEntity.ok(this.experienceService.update(experince));
    }
    
    
}
