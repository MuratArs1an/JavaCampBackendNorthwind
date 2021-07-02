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
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="education")
public class Education {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotBlank
	@Column(name="school_name")
	private String schoolName;
	
	@NotBlank
	@Column(name="department")
	private String department;
	
	@Column(name="start_date")
	private LocalDateTime startDate;
	
	@Column(name="end_date")
	private LocalDateTime endDate;
	
	@ManyToOne
	@JoinColumn(name="candidates_id")
	private Candidates candidates;
	
	@JoinColumn(name="id", insertable = false, updatable = false)
	@ManyToOne
	@JsonIgnore
	private Cv cv;
	

}
