package akt.northwindProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import akt.northwindProject.business.abstracts.UserService;
import akt.northwindProject.core.utilities.dataAccess.UserDao;
import akt.northwindProject.core.utilities.entitites.User;
import akt.northwindProject.core.utilities.results.DataResult;
import akt.northwindProject.core.utilities.results.Result;
import akt.northwindProject.core.utilities.results.SuccessDataResult;
import akt.northwindProject.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService
{

	private UserDao userDao;
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
	
		this.userDao.save(user);
		return new SuccessResult("Kullanici Eklendi");
	}

	@Override
	public DataResult<User> findByEmail(String email) {
	
		return new SuccessDataResult<User>(this.userDao.findByEmail(email),"kullanici bulundu");
	}

}
