package kodlama.oi.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.oi.hrms.entities.concretes.Languages;

public interface LanguagesDao extends JpaRepository<Languages, Integer>{
	List<Languages> findAllById(int id);
	
	Languages getById(int id);

}
