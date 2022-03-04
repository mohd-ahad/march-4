package io.ahad;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

import io.ahad.Repository.Emp_Direct_Repo;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="Employee1Application",version="2.0",description="With SignIn,SignUp Service"))
//@EnableJpaRepositories(basePackageClasses=Emp_Direct_Repo.class)
public class Employee1Application {

	public static void main(String[] args) {
		SpringApplication.run(Employee1Application.class, args);
	}
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}


}
