package pl.anikiel.springbootcourse.service;

import pl.anikiel.springbootcourse.model.CourseDTO;
import pl.anikiel.springbootcourse.model.UserDTO;
import pl.anikiel.springbootcourse.persistence.model.Course;
import pl.anikiel.springbootcourse.persistence.model.User;

public class Mapper {
    public static CourseDTO courseToDTO(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setName(course.getName());

        return courseDTO;
    }

    public static Course dtoToCourse(CourseDTO courseDTO) {
        Course course = new Course();
        course.setActive(true);
        course.setId(courseDTO.getId());
        course.setName(courseDTO.getName());

        return course;
    }

    public static UserDTO userToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setAdmin(user.isAdmin());
        userDTO.setAuthor(user.isAdmin());
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setPassword(user.getPassword());

        return userDTO;
    }

    public static User dtoToUser(UserDTO userDTO) {
        User user = new User();
        user.setActive(true);
        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setAdmin(userDTO.isAdmin());
        user.setAuthor(userDTO.isAuthor());

        return user;
    }
}