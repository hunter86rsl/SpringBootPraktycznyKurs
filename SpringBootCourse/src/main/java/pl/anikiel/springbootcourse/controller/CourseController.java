package pl.anikiel.springbootcourse.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.anikiel.springbootcourse.model.CourseDTO;
import pl.anikiel.springbootcourse.exception.WrondIdException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/course")
public class CourseController {

    private List<CourseDTO> courses = new ArrayList<>();

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO courseDTO) {

        if (courseDTO.getId() == null || courseDTO.getId() < 0) {
            throw new WrondIdException("Variable id is null or less then 0");
        }

        courses.add(courseDTO);
        System.out.println(courseDTO.getName());
        System.out.println(courseDTO.getLengthInSeconds());

        return new ResponseEntity<>(courseDTO, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/available", method = RequestMethod.GET)
    public ResponseEntity<List<CourseDTO>> getAvailableCourses() {
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @RequestMapping(value = "buy/{id}", method = RequestMethod.POST)
    public CourseDTO buyCourse(@PathVariable(value = "id") Long id) {
        System.out.println("buyCourse");
        return getCourse(id);
    }

    @RequestMapping(value = "buy2", method = RequestMethod.POST)
    public CourseDTO buyCourse2(@RequestParam(value = "id") Long id) {
        System.out.println("buyCourse2");
        return getCourse(id);
    }

    //    @RequestMapping(value = "/bought", method = RequestMethod.GET)
//    public ResponseEntity<List<CourseDTO>> getBoughtCourses() {
//        return new ResponseEntity<>(courses, HttpStatus.ACCEPTED);
//    }
    private CourseDTO getCourse(Long id) {
        CourseDTO courseDTO = null;

        for (CourseDTO c : courses) {
            if (c.getId() != null && c.getId().equals(id)) {
                courseDTO = c;
                break;
            }
        }

        if (courseDTO == null) {
            // TODO
        }
        return courseDTO;
    }

}
