package kodlama.oi.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.oi.hrms.business.abstracts.SystemUserService;
import kodlama.oi.hrms.core.utilities.results.DataResult;
import kodlama.oi.hrms.core.utilities.results.Result;
import kodlama.oi.hrms.entities.concretes.SystemUser;

@RestController
@RequestMapping("/api/systemuser")
public class SystemUserController {
	
	private SystemUserService systemUserService;
	
	@Autowired
	public SystemUserController(SystemUserService systemUserService) {
		super();
		this.systemUserService=systemUserService;
		
	}

	@GetMapping("/getall")
	public DataResult<List<SystemUser>> getAll(){
		return this.systemUserService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody SystemUser systemUser) {
		return this.systemUserService.add(systemUser);
	}
}
