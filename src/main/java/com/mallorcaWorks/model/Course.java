package com.mallorcaWorks.model;

import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Course{
    @Id

    @Column(name = "level")
    private String level;

    @Override
    public String toString() {
        return "Course{" +
                "level=" + level +
                '}';
    }
}
