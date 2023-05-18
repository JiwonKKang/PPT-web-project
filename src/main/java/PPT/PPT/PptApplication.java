package PPT.PPT;

import PPT.PPT.domain.repository.ApplicationRepository;
import PPT.PPT.domain.repository.MemberRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class PptApplication {

	public static void main(String[] args) {
		SpringApplication.run(PptApplication.class, args);
	}

	@Bean
	@Profile("local")
	public TestDataInit testDataInit(MemberRepository memberRepository, ApplicationRepository applicationRepository) {
		return new TestDataInit(memberRepository, applicationRepository);
	}
}
