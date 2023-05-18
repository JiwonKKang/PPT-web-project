package PPT.PPT.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.mapping.ToOne;

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

    @ManyToOne(fetch = FetchType.LAZY)
    private Member mentor;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member mentee;

    public static Mentoring createMentoring(Member mentor, Member mentee) {
        Mentoring mentoring = new Mentoring();
        mentoring.setMentor(mentor);
        mentoring.setMentee(mentee);
        return mentoring;
    }
}
