package PPT.PPT.domain;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
public class ApplicationTest {

    @Autowired
    EntityManager em;

//    @Test
//    @Rollback(value = false)
//    public void createAppTest() throws Exception {
//
////        //given
////        Member mentor = new Member();
////        mentor.setName("멘토");
////        Member mentee = new Member();
////        mentee.setName("멘티");
////        Member mentee1 = new Member();
////        mentee1.setName("멘티1");
//
//        //when
//        Application application = Application.createApplication(mentor, mentee, "저는 스프링을 잘하고싶습니다");
//        Application application1 = Application.createApplication(mentor, mentee1, "저는 JPA을 잘하고싶습니다");
//
//        em.persist(application);
//        em.persist(application1);
//
//        //then
//        assertThat(mentor.getReceivedApp().stream().map(Application::getMentee).findFirst().get()).isEqualTo(mentee);
//        assertThat(mentee.getSentApp().stream().map(Application::getMentor).findFirst().get()).isEqualTo(mentor);
//
//    }


}