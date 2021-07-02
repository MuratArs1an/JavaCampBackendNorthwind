package kodlama.oi.hrms.entities.dtos;

import java.util.List;

import kodlama.oi.hrms.entities.concretes.Candidates;
import kodlama.oi.hrms.entities.concretes.Education;
import kodlama.oi.hrms.entities.concretes.Experience;
import kodlama.oi.hrms.entities.concretes.Languages;
import kodlama.oi.hrms.entities.concretes.PrograminSkills;
import kodlama.oi.hrms.entities.concretes.SocialMedia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {

	private int id;
	private String photo;
	private String coverLetter;
	private Candidates candidates;
	
	private List<Languages> languages;
	private List<Education> education;
	private List<Experience> experience;
	private List<PrograminSkills> programingSkills;
	private List<SocialMedia> socialMedia;
	
	public CvDto(int id, String photo, String coverLetter, Candidates candidates) {
	        super();
	        this.id = id;
	        this.photo = photo;
	        this.coverLetter = coverLetter;
	        this.candidates = candidates;
	    }
}
