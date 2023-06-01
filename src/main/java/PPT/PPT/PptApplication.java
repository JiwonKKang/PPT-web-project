package PPT.PPT;

import PPT.PPT.repository.ApplicationRepository;
import PPT.PPT.repository.MemberRepository;
import PPT.PPT.repository.MentoringRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class PptApplication {

	public static void main(String[] args) {
		SpringApplication.run(PptApplication.class, args);
	}
}
