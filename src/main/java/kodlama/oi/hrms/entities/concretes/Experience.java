package kodlama.oi.hrms.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="experience")
@AllArgsConstructor
@NoArgsConstructor
public class Experience {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="start_date")
	private LocalDateTime startDate;
	
	@Column(name="exit_date")
	private LocalDateTime exitDate;
	
	@ManyToOne
	@JoinColumn(name="candidates_id")
	private Candidates candidates;
	
	@JoinColumn(name="id", insertable = false, updatable = false)
	@ManyToOne
	@JsonIgnore
	private Cv cv;

}
