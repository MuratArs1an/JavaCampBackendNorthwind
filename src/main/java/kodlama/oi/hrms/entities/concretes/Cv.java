package kodlama.oi.hrms.entities.concretes;

import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cv")
public class Cv {
	
	@Column(name="id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="photo")
	private String photo;
	
	@Column(name="cover_letter")
	private String coverLetter;
	
	@JoinColumn(name="candidates_id")
	@ManyToOne
	private Candidates candidates;
	
	@OneToMany(mappedBy = "cv")
	private Set<PhotoInfo> photoInfo;
	
	@OneToMany(mappedBy = "cv")
	private Set<Languages> languages;
	
	@OneToMany(mappedBy = "cv")
	private Set<Education> education;
	
	@OneToMany(mappedBy = "cv")
	private Set<Experience> experience;
	
	@OneToMany(mappedBy = "cv")
	private Set<PrograminSkills> programinSkill;
	
	@OneToMany(mappedBy = "cv")
	private Set<SocialMedia> socialMedia;

}
