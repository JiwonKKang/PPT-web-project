package PPT.PPT;

import PPT.PPT.domain.Application;
import PPT.PPT.domain.Member;
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
        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);
        memberRepository.save(member4);
        memberRepository.save(member5);
        applicationRepository.save(Application.createApplication(member1, member2, "저는 김철수님과 함께 프로젝트를 진행하고 싶습니다.", 200000L));
        applicationRepository.save(Application.createApplication(member3, member4, "안녕하세요, 박민수님과 함께 일하고 싶습니다.",300000L));
        applicationRepository.save(Application.createApplication(member2, member5, "나지은님과 협업하고 싶습니다.",250000L));
        applicationRepository.save(Application.createApplication(member1, member4, "박민수님과 함께 프로젝트를 진행하고 싶습니다.",100000L));
        applicationRepository.save(Application.createApplication(member5, member3, "이영희님과의 협업을 기대합니다.", 150000L));

    }
}
