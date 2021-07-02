package kodlama.oi.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.oi.hrms.entities.concretes.Cv;
import kodlama.oi.hrms.entities.dtos.CvDto;

public interface CvDao extends JpaRepository<Cv, Integer>{
	List<Cv> getById(int id);
	
	@Query("Select new kodlama.oi.hrms.entities.dtos.CvDto(c.id,c.photo,c.coverLetter,j) From Cv c JOIN c.candidates j Where c.id=:id")
	CvDto getCvDetailsById(int id);

}
