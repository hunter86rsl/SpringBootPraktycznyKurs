package pl.anikiel.springbootcourse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.anikiel.springbootcourse.exception.WrongIdException;
import pl.anikiel.springbootcourse.model.UserDTO;
import pl.anikiel.springbootcourse.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(value = "/registry", method = RequestMethod.POST)
    public UserDTO registry(@RequestBody UserDTO userDTO) {
        if (idExist(userDTO)) {
            throw new WrongIdException("Created user shouldn't have id");
        }
        return userService.createUser(userDTO);
    }

    @RequestMapping(value = "/confirm/{id}", method = RequestMethod.PUT)
    public UserDTO confirm(@PathVariable(value = "id") Long id) {
        return new UserDTO();
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public UserDTO edit(@RequestBody UserDTO userDTO) {
        if (!idExist(userDTO)) {
            throw new WrongIdException("Edited user must have id");
        }
        return userService.editUser(userDTO);
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public UserDTO add(@RequestBody UserDTO userDTO) {
        if(idExist(userDTO))
            throw new WrongIdException("Tworzony użytkownik nie powinien posiadać ID.");
        return userService.createUser(userDTO);
    }

    private boolean idExist(UserDTO userDTO) {
        return userDTO.getId() != null;
    }

}
