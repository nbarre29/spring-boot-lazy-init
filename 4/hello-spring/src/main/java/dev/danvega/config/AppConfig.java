package dev.danvega.config;

import dev.danvega.repository.CourseRepository;
import dev.danvega.service.CourseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


@Configuration
public class AppConfig {


    @Bean
    public CourseRepository getCourseRepository() {
        return new CourseRepository();
    }

    @Bean("courseService")
    public CourseService getCourseService() {
        return new CourseService(getCourseRepository());
    }

}
