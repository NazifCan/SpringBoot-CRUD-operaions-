package com.nazifcankabakcioglu.springbootrestapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootRestApiApplication implements CommandLineRunner {

	@Autowired
	private ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestApiApplication.class, args);


		System.out.println();

	}

	@Override
	public void run(String... args) throws Exception {
		int getBeanDefinitionCount = applicationContext.getBeanDefinitionCount();

		System.out.println(getBeanDefinitionCount);

		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

		for (String beanDefinitionName:beanDefinitionNames) {
			if(beanDefinitionName.startsWith("u"))
			System.out.println(beanDefinitionName);
		}


	}
}
