package kodlama.oi.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.oi.hrms.business.abstracts.SystemUserService;
import kodlama.oi.hrms.core.utilities.results.DataResult;
import kodlama.oi.hrms.core.utilities.results.Result;
import kodlama.oi.hrms.core.utilities.results.SuccessDataResult;
import kodlama.oi.hrms.core.utilities.results.SuccessResult;
import kodlama.oi.hrms.dataAccess.abstracts.SystemUserDao;
import kodlama.oi.hrms.entities.concretes.SystemUser;

@Service
public class SystemUserManager implements SystemUserService{

	private SystemUserDao systemUserDao;
	
	public SystemUserManager(SystemUserDao systemUserDao) {
		super();
		this.systemUserDao=systemUserDao;
		
	}
	
	@Override
	public DataResult<List<SystemUser>> getAll() {
		return new SuccessDataResult<List<SystemUser>>(this.systemUserDao.findAll(),
				"Sistem Kullanicilari Listelendi");
	}

	@Override
	public Result add(SystemUser systemUser) {
		this.systemUserDao.save(systemUser);
		return new SuccessResult("Sistem Kullanici Kayit Edildi");
	}

}
