package com.Tonysasasa.videomeetingweb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean; // a method-level annotation and a direct analog of the XML <bean/> element

import com.Tonysasasa.videomeetingweb.user.User;
import com.Tonysasasa.videomeetingweb.user.UserList;
import com.Tonysasasa.videomeetingweb.video.VideoServerBackend;

import java.io.IOException;

@SpringBootApplication
public class VideomeetingApplication {

	public static void main(String[] args) throws IOException, InterruptedException {

		SpringApplication.run(VideomeetingApplication.class, args);
		VideoServerBackend.runExecution();
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserList userlist) {
		return args -> {
			userlist.registerUser(User.builder()
					.username("Tony")
					.email("tony@mail.com")
					.password("aaa")
					.build());

			userlist.registerUser(User.builder()
					.username("Tim")
					.email("tim@mail.com")
					.password("aaa")
					.build());

			userlist.registerUser(User.builder()
					.username("Bill")
					.email("bill@mail.com")
					.password("aaa")
					.build());

		};
	}
}
