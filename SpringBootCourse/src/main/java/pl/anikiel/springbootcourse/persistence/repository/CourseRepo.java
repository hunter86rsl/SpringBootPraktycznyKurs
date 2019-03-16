package pl.anikiel.springbootcourse.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.anikiel.springbootcourse.persistence.model.Course;

public interface CourseRepo extends JpaRepository<Course, Long>, JpaSpecificationExecutor<Course> {

}
