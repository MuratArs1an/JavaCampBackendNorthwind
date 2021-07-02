package kodlama.oi.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="social_media")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","cv"})
public class SocialMedia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="github_url")
	private String gitHubUrl;
	
	@Column(name="linkedin_url")
	private String linkedInUrl;
	
	@ManyToOne
	@JoinColumn(name="candidates_id")
	private Candidates candidates;
	
	@JoinColumn(name="id", insertable = false, updatable = false)
	@ManyToOne
	@JsonIgnore
	private Cv cv;

}
