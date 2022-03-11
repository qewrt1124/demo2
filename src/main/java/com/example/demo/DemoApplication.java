package com.example.demo;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		
		Game game = (Game) context.getBean("game");
		game.play();
		
		Movie movie = (Movie) context.getBean("movie");
		movie.play();
		
		Music music = (Music) context.getBean("music");
		music.play();

		ImageUtill util = (ImageUtill) context.getBean("image");
		try {
			util.save("http://ggoreb.com/images/luffy.jpg");
		} catch (IOException e) {
			e.printStackTrace();
		}	

		((AnnotationConfigApplicationContext) context).close();

	}

}
