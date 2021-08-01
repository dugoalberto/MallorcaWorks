package com.mallorcaWorks.model;

import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "Accounts")
public class Account {
    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
