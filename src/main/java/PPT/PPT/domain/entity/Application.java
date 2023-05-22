package PPT.PPT.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "mentee_id")
    private Member mentee;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "mentor_id")
    private Member mentor;

    private Long price;

    private String motivation;

    private LocalDateTime applicationDate;

    //==생성 메서드==//

    public static Application createApplication(Member mentor, Member mentee, String motivation, Long price) {
        Application application = new Application();
        application.setMotivation(motivation);
        application.setMentor(mentor);
        application.setMentee(mentee);
        application.setPrice(price);
        application.setApplicationDate(LocalDateTime.now());
        return application;
    }

    //==연관관계 메서드==//

    private void setMentor(Member mentor) {
        this.mentor = mentor;
        mentor.getReceivedApp().add(this);
    }

    private void setMentee(Member mentee) {
        this.mentee = mentee;
        mentee.getSentApp().add(this);
    }

    public void deleteApplication(Member mentor, Member mentee) {
        mentor.getReceivedApp().remove(this);
        mentee.getSentApp().remove(this);
        this.mentor = null;
        this.mentee = null;
    }


}

