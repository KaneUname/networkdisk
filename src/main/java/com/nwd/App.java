package com.nwd;

//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.nwd.component")
public class App {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SpringApplication.run(App.class, args);
    }
}
