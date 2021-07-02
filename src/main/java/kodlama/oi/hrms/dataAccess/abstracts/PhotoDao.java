package kodlama.oi.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlama.oi.hrms.entities.concretes.PhotoInfo;

public interface PhotoDao extends JpaRepository<PhotoInfo, Integer>{
	
	PhotoInfo getById(int id);

}
