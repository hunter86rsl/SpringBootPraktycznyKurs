package pl.anikiel.springbootcourse.service;

import pl.anikiel.springbootcourse.model.CourseDTO;
import pl.anikiel.springbootcourse.persistence.model.Course;
import pl.anikiel.springbootcourse.persistence.repository.CourseRepo;

public interface CourseService extends BaseService<Course, Long, CourseRepo> {

    CourseDTO getCourseDtoById(Long id);
}
