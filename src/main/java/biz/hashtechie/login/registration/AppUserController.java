package biz.hashtechie.login.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/registration")
public class AppUserController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private EmailValidator emailValidator;

    @PostMapping
    public String register (@RequestBody RegisterRequest registerRequest ){
        return registrationService.register(registerRequest);
    }
}
