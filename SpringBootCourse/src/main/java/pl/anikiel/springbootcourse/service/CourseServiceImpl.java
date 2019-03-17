package pl.anikiel.springbootcourse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.anikiel.springbootcourse.model.CourseDTO;
import pl.anikiel.springbootcourse.persistence.model.Course;
import pl.anikiel.springbootcourse.persistence.repository.CourseRepo;

@Service
public class CourseServiceImpl extends BaseServiceImpl<Course, Long, CourseRepo> implements CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public CourseRepo getRepository() {
        return courseRepo;
    }

    @Override
    public CourseDTO getCourseDtoById(Long id) {
        return Mapper.courseToDTO(getOne(id));
    }
}
