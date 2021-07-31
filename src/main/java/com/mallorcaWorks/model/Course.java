package com.mallorcaWorks.model;

import lombok.*;
import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Course{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "level")
    private String level;

    @Column(name = "begin_date")
    private Date beginDate;

    @Column(name = "end_date")
    private Date endDate;

    @Override
    public String toString() {
        return "Course{" +
                "level=" + level +
                '}';
    }
}