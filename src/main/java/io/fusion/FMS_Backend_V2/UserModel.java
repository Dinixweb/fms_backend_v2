package io.fusion.FMS_Backend_V2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserModel {

    @Id
    private String userId;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String accountType;
}
