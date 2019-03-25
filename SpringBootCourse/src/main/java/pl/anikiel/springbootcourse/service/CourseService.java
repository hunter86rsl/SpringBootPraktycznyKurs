package pl.anikiel.springbootcourse.service;

import pl.anikiel.springbootcourse.model.CourseDTO;
import pl.anikiel.springbootcourse.persistence.model.Course;
import pl.anikiel.springbootcourse.persistence.repository.CourseRepo;

import java.util.List;

public interface CourseService extends BaseService<Course, Long, CourseRepo> {

    CourseDTO createCourse(CourseDTO courseDTO);

    List<CourseDTO> getAllCourses();
}
