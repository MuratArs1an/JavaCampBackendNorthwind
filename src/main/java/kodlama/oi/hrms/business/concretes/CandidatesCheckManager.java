package kodlama.oi.hrms.business.concretes;

import kodlama.oi.hrms.business.abstracts.CandidateCheckService;
import kodlama.oi.hrms.entities.concretes.Candidates;

public class CandidatesCheckManager implements CandidateCheckService {

	@Override
	public boolean loginControl(Candidates candidates) {
		return true;
	}

}
