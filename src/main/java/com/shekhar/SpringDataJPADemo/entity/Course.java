package com.shekhar.SpringDataJPADemo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "tbl_Course",
        uniqueConstraints = @UniqueConstraint(
                name = "course_unique",
                columnNames = "title"
        )
)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long courseId;
    private String credit;
    private String title;
}
