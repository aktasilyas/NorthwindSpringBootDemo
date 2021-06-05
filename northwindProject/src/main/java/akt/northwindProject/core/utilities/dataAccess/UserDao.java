package akt.northwindProject.core.utilities.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import akt.northwindProject.core.utilities.entitites.User;

public interface UserDao extends JpaRepository<User, Integer> {

	User findByEmail(String email);
}
