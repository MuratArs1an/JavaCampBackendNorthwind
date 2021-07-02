package kodlama.oi.hrms.business.abstracts;

import kodlama.oi.hrms.entities.concretes.Candidates;

public interface CandidateCheckService {
	public boolean loginControl(Candidates candidates);
}
