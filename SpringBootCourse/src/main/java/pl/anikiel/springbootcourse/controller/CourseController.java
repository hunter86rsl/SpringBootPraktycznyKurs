package pl.anikiel.springbootcourse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.anikiel.springbootcourse.exception.WrongIdException;
import pl.anikiel.springbootcourse.model.CourseDTO;
import pl.anikiel.springbootcourse.service.CourseService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/course")
public class CourseController {

    private List<CourseDTO> courses = new ArrayList<>();

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO courseDTO) {

        if (courseDTO.getId() != null) {
            throw new WrongIdException("Created course shouldn't have id");
        }

        System.out.println("/course/create" + courseDTO.getName());
        CourseDTO dto = courseService.createCourse(courseDTO);

        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/available", method = RequestMethod.GET)
    public ResponseEntity<List<CourseDTO>> getAvailableCourses() {
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }

    @RequestMapping(value = "buy/{id}", method = RequestMethod.GET)
    public CourseDTO buyCourse(@PathVariable(value = "id") Long id) {
//        System.out.println("buyCourse");
//        Course course = new Course();
//        course.setName("ccc1");
//        courseService.save(course);
        return null;
//        return Mapper.courseToDTO(c);
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
