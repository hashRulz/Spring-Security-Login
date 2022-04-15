package biz.hashtechie.login.registration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class RegisterRequest {

    private  String firstName;
    private  String lastName;
    private  String email;
    private  String password;
}
