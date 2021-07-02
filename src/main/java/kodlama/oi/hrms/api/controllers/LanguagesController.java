package kodlama.oi.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.oi.hrms.business.abstracts.LanguagesService;
import kodlama.oi.hrms.core.utilities.results.DataResult;
import kodlama.oi.hrms.core.utilities.results.Result;
import kodlama.oi.hrms.entities.concretes.Languages;

@RestController
@RequestMapping("/api/languages")
@CrossOrigin
public class LanguagesController {
	private LanguagesService languagesService;
	
    @Autowired
    public LanguagesController(LanguagesService languagesService) {
        this.languagesService = languagesService;
    }

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<Languages>>> getAll() {
        DataResult<List<Languages>> result = languagesService.getAll();
        return ResponseEntity.ok(result);
    }

    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody @Valid Languages languages) {
        return ResponseEntity.ok(this.languagesService.add(languages));
    }

    @PostMapping("/delete")
    public ResponseEntity<Result> delete(@RequestBody @Valid Languages languages) {
        return ResponseEntity.ok(this.languagesService.delete(languages));
    }

    @PostMapping("/update")
    public ResponseEntity<Result> update(@RequestBody @Valid Languages languages) {
        return ResponseEntity.ok(this.languagesService.update(languages));
    }

    @GetMapping("/findAllByLanguageId")
    public ResponseEntity<DataResult<List<Languages>>> findAllByLanguageId(@RequestParam int id) {
        DataResult<List<Languages>> result = languagesService.findAllById(id);
        return ResponseEntity.ok(result);
    }

}
