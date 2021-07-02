package kodlama.oi.hrms.dataAccess.abstracts;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;


import kodlama.oi.hrms.entities.concretes.Education;

public interface EducationDao extends JpaRepository<Education, Integer> {
	
	List<Education>findByIdOrderByEndDateDesc(int id);
	List<Education> findByIdOrderByEndDate(int idWithoutDesc);

}
