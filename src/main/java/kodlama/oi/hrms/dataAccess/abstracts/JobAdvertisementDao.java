package kodlama.oi.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.oi.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	List<JobAdvertisement> getByIsActive(boolean isActive);
	List<JobAdvertisement> getByIsActiveOrderByApplicationDeadLineAsc(boolean isActive);
	List<JobAdvertisement> getByIsActiveAndEmployer_Id(boolean isActive, int id);
}
