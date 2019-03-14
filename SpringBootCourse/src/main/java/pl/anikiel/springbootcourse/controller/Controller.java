package pl.anikiel.springbootcourse.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.anikiel.springbootcourse.model.UserDTO;

@RestController
@RequestMapping(value = "/")
public class Controller {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName("Adrian");
        return "Hello End UserDTO";
    }
}
