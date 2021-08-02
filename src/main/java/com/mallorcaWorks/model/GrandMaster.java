package com.mallorcaWorks.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("GRAND_MASTER")
public class GrandMaster extends User {

    @Override
    public Role getRole() {
        return Role.GRANDMASTER;
    }

}
