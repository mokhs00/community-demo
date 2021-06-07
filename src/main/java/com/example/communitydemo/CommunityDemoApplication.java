package com.example.communitydemo;

import com.example.communitydemo.domain.Board;
import com.example.communitydemo.domain.User;
import com.example.communitydemo.domain.enums.BoardType;
import com.example.communitydemo.repository.BoardRepository;
import com.example.communitydemo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootApplication
public class CommunityDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommunityDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(UserRepository userRepository, BoardRepository boardRepository) {
		return (args) -> {
			User user = userRepository.save(User.builder().name("mokhs")
					.password("test")
					.email("mokhs00@naver.com")
					.createdDate(LocalDateTime.now())
					.build());
			IntStream.rangeClosed(1, 200).forEach(index ->
					boardRepository.save(Board.builder()
							.title("게시글 " + index)
							.subTitle("순서 " + index)
							.content("컨텐츠")
							.boardType(BoardType.free)
							.createdDate(LocalDateTime.now())
							.updatedDate(LocalDateTime.now())
							.build()));
		};
	}

}
