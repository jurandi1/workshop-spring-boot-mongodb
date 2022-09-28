package com.junior.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.junior.workshopmongo.domain.Post;
import com.junior.workshopmongo.domain.User;
import com.junior.workshopmongo.dto.AuthorDTO;
import com.junior.workshopmongo.repository.PostRepository;
import com.junior.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMY"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("27/09/2022"), "Partiu viagem", "Vou viajar para São Paulo, abraços!", new AuthorDTO(maria)); 
		Post post2 = new Post(null, sdf.parse("28/09/2022"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria)); 

		
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

	
}
