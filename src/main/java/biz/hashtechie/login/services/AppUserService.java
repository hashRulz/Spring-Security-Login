package biz.hashtechie.login.services;

import biz.hashtechie.login.Appuser;
import biz.hashtechie.login.repository.AppUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements UserDetailsService {


    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AppUserRepository appUserRepository;
    private final static String USER_NOT_FOUND = "user with email %s not found";

    public AppUserService(BCryptPasswordEncoder bCryptPasswordEncoder, AppUserRepository appUserRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException(String.format(USER_NOT_FOUND , email)));
    }

    public String signUpuser(Appuser appuser){
        boolean user = appUserRepository.findByEmail(appuser.getEmail()).isPresent();

//        if(!user){
//            throw new IllegalStateException("email already taken");
//        }

        String encodePassword = bCryptPasswordEncoder.encode(appuser.getPassword());
        appuser.setPassword(encodePassword);
        appUserRepository.save(appuser);
        return "";
    }
}
