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
public class GrandMaster implements User {
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

    @Override
    public String getUsername() {
        return account.getUsername();
    }

    @Override
    public Role getRole() {
        return Role.GRANDMASTER;
    }

    @Override
    public boolean credsValid(String username, String password) {
        // TODO check for hashing
        return username.equals(this.account.getUsername()) && password.equals(this.account.getPassword());
    }

}
