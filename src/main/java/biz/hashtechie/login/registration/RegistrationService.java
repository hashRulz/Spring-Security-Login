package biz.hashtechie.login.registration;

import biz.hashtechie.login.Appuser;
import biz.hashtechie.login.constants.AppUserRole;
import biz.hashtechie.login.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private EmailValidator emailValidator;

    @Autowired
    private AppUserService appUserService;

    public String register(RegisterRequest registerRequest) {
        boolean isValidEmail = emailValidator.test(registerRequest.getEmail());

        if(!isValidEmail){
            throw new IllegalStateException("Email not Valid");
        }
        return appUserService.signUpuser(new Appuser
                (registerRequest.getFirstName(),
                        registerRequest.getPassword(),
                        registerRequest.getEmail(),
                        registerRequest.getLastName(),
                        AppUserRole.USER
                ));
    }
}
