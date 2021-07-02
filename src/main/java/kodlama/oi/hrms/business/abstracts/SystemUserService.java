package kodlama.oi.hrms.business.abstracts;

import java.util.List;

import kodlama.oi.hrms.core.utilities.results.DataResult;
import kodlama.oi.hrms.core.utilities.results.Result;
import kodlama.oi.hrms.entities.concretes.SystemUser;


public interface SystemUserService {
	DataResult<List<SystemUser>> getAll();
	Result add(SystemUser systemUser);

}
