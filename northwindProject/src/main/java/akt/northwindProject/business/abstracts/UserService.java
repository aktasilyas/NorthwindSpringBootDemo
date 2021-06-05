package akt.northwindProject.business.abstracts;

import akt.northwindProject.core.utilities.entitites.User;
import akt.northwindProject.core.utilities.results.DataResult;
import akt.northwindProject.core.utilities.results.Result;

public interface UserService {

	Result add(User user);
	DataResult<User> findByEmail(String email);
}
