package pl.anikiel.springbootcourse.persistence.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "courses")
public class Course extends BaseEntity{

    @Column(name = "name")
    private String name;

}
