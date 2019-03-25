package pl.anikiel.springbootcourse.service;

import pl.anikiel.springbootcourse.model.UserDTO;
import pl.anikiel.springbootcourse.persistence.model.User;
import pl.anikiel.springbootcourse.persistence.repository.UserRepo;

public interface UserService extends BaseService<User, Long, UserRepo> {

    UserDTO createUser(UserDTO userDTO);

    UserDTO editUser(UserDTO userDTO);

}
