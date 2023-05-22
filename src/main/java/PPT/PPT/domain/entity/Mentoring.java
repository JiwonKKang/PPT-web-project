package PPT.PPT.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Mentoring {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mentoring_id")
    private Long id;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member mentor;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member mentee;

    public static Mentoring createMentoring(Member mentor, Member mentee, String title) {
        Mentoring mentoring = new Mentoring();
        mentoring.setTitle(title);
        mentoring.setMentor(mentor);
        mentoring.setMentee(mentee);
        return mentoring;
    }
}
