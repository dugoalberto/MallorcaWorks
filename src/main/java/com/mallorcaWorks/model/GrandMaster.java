package com.mallorcaWorks.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "GrandMasters")
public class GrandMaster {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @OneToOne()
    @JoinColumn(name = "account", referencedColumnName = "username")
    private Account account;

}
