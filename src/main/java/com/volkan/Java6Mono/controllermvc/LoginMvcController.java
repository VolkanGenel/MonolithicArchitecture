package com.volkan.Java6Mono.controllermvc;

import com.volkan.Java6Mono.repository.entity.Musteri;
import com.volkan.Java6Mono.service.MusteriService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class LoginMvcController {
    private final MusteriService musteriService;

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    //html dosyasındaki form method="post" action="login" olmalıdır.
    @PostMapping("/login")
    public ModelAndView login(String user,String password) { //html dosyasında name="user" ve name="password" alanı gerekli
        if(musteriService.doLogin(user, password))
            return new ModelAndView("redirect:/musteri");
        return  new ModelAndView("login");
    }
    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView register(String name,String username,String password,String email,String confirm) {
        musteriService.save(Musteri.builder()
                        .ad(name)
                        .username(username)
                        .password(password)
                        .email(email)
                .build());
        return new ModelAndView("login");
    }
}
