package PPT.PPT;

import PPT.PPT.domain.entity.Application;
import PPT.PPT.domain.entity.Member;
import PPT.PPT.domain.repository.ApplicationRepository;
import PPT.PPT.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Slf4j
@Transactional
public class TestDataInit {

    private final MemberRepository memberRepository;
    private final ApplicationRepository applicationRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void initData() {
        log.info("test data init");
        Member member1 = new Member("홍길동", "Java", "Spring", "ABC 회사", "hong@example.com", "password123", 3);
        Member member2 = new Member("김철수", "Python", "Django", "XYZ 회사", "kim@example.com", "securepass456", 2);
        Member member3 = new Member("이영희", "JavaScript", "React", "DEF 회사", "lee@example.com", "testpass789", 4);
        Member member4 = new Member("박민수", "C++", "Qt", "GHI 회사", "park@example.com", "mysecretpass", 5);
        Member member5 = new Member("나지은", "Ruby", "Ruby on Rails", "JKL 회사", "na@example.com", "pass1234", 1);
        Member member6 = new Member("송예진", "PHP, Laravel", "Vue.js", "MNO 회사", "song@example.com", "securepassword1", 3);
        Member member7 = new Member("정민호", "Python, Flask", "Django", "PQR 회사", "jung@example.com", "mypassword123", 2);
        Member member8 = new Member("김지수", "JavaScript, Vue.js", "React", "STU 회사", "kimji@example.com", "test12345", 4);
        Member member9 = new Member("이성우", "C#, ASP.NET", "ASP.NET Core", "VWX 회사", "lee@example.com", "strongpass678", 5);
        Member member10 = new Member("홍길순", "Ruby, Sinatra", "Ruby on Rails", "YZA 회사", "hongsun@example.com", "mypassword123", 1);
        Member member11 = new Member("이지은", "Java, Spring", "Spring Boot", "BCD 회사", "leeji@example.com", "testpass678", 3);
        Member member12 = new Member("최영민", "Python, Django", "Flask", "EFG 회사", "choi@example.com", "securepassword1", 2);
        Member member13 = new Member("박재훈", "JavaScript, React", "Angular", "HIJ 회사", "parkjh@example.com", "mysecretpass123", 4);
        Member member14 = new Member("김민지", "C++, Qt", "Qt Creator", "KLM 회사", "kimminji@example.com", "pass1234", 5);
        Member member15 = new Member("나현우", "Ruby, Ruby on Rails", "Sinatra", "NOP 회사", "nahyun@example.com", "strongpass678", 1);
        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);
        memberRepository.save(member4);
        memberRepository.save(member5);
        memberRepository.save(member6);
        memberRepository.save(member7);
        memberRepository.save(member8);
        memberRepository.save(member9);
        memberRepository.save(member10);
        memberRepository.save(member11);
        memberRepository.save(member12);
        memberRepository.save(member13);
        memberRepository.save(member14);
        memberRepository.save(member15);
        applicationRepository.save(Application.createApplication(member1, member2, "저는 김철수님과 함께 프로젝트를 진행하고 싶습니다.", 200000L));
        applicationRepository.save(Application.createApplication(member3, member4, "안녕하세요, 박민수님과 함께 일하고 싶습니다.", 300000L));
        applicationRepository.save(Application.createApplication(member2, member5, "나지은님과 협업하고 싶습니다.", 250000L));
        applicationRepository.save(Application.createApplication(member1, member4, "박민수님과 함께 프로젝트를 진행하고 싶습니다.", 100000L));
        applicationRepository.save(Application.createApplication(member5, member3, "이영희님과의 협업을 기대합니다.", 150000L));
        applicationRepository.save(Application.createApplication(member6, member7, "정민호님과의 프로젝트에 참여하고 싶습니다.", 180000L));
        applicationRepository.save(Application.createApplication(member8, member9, "이성우님과 함께 일하고 싶습니다.", 220000L));
        applicationRepository.save(Application.createApplication(member10, member11, "이지은님과의 협업을 기대합니다.", 260000L));
        applicationRepository.save(Application.createApplication(member12, member13, "박재훈님과의 프로젝트에 참여하고 싶습니다.", 190000L));
        applicationRepository.save(Application.createApplication(member14, member15, "나현우님과의 협업을 기대합니다.", 170000L));
        applicationRepository.save(Application.createApplication(member6, member8, "김지수님과의 협업을 기대합니다.", 230000L));
        applicationRepository.save(Application.createApplication(member10, member12, "최영민님과 함께 프로젝트를 진행하고 싶습니다.", 120000L));
        applicationRepository.save(Application.createApplication(member9, member11, "이지은님과의 프로젝트에 참여하고 싶습니다.", 210000L));
        applicationRepository.save(Application.createApplication(member13, member15, "나현우님과 협업하고 싶습니다.", 140000L));
    }
}
