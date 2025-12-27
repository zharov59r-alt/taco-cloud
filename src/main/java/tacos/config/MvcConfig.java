package tacos.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Maps the URL "/" to the view named "home"
        registry.addViewController("/").setViewName("home");

        // Maps the URL "/login" to the view named "login"
        registry.addViewController("/login").setViewName("login");
    }
}