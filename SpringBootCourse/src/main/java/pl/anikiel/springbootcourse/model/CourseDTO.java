package pl.anikiel.springbootcourse.model;

import lombok.Data;

@Data
//@AllArgsConstructor
public class CourseDTO {

    private Long id;
    private String name;
    private int lengthInSeconds;
}
