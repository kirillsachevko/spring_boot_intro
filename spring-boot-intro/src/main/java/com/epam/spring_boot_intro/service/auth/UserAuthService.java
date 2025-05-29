package com.epam.spring_boot_intro.service.auth;

import com.epam.spring_boot_intro.model.User;
import com.epam.spring_boot_intro.repository.UserRepository;
import com.epam.spring_boot_intro.util.Authority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserAuthService extends DefaultOAuth2UserService {
    private final UserRepository userRepository;

    public UserAuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        String userName = oAuth2User.getAttribute("login");

        User user = userRepository.findByName(userName)
                .orElseGet(() -> registerNewUser(userName));

        Set<Authority> userRoles = user.getRoles();


        return new DefaultOAuth2User(
                Collections.singleton(() ->
                        userRoles.contains(Authority.ADMIN) ? Authority.ADMIN.name() : Authority.USER.name()),
                oAuth2User.getAttributes(),
                "login");
    }

    private User registerNewUser(String userName) {
        User user = new User();
        user.setName(userName);

        Set<Authority> userRoles = new HashSet<>();
        userRoles.add(Authority.USER);

        user.setRoles(userRoles);

        return userRepository.save(user);
    }
}
