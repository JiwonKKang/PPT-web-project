package PPT.PPT.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;

    private String skill; // 전문 분야

    private String interestSkill; // 흥미 분야

    private String company;

    private String email;

    private String password;

    private int career;

    public Member(String name, String skill, String interestSkill, String company, int career) {
        this.name = name;
        this.skill = skill;
        this.interestSkill = interestSkill;
        this.company = company;
        this.career = career;
    }

    public Member(String name, String skill, String interestSkill, String company, String email, String password, int career) {
        this.name = name;
        this.skill = skill;
        this.interestSkill = interestSkill;
        this.company = company;
        this.email = email;
        this.password = password;
        this.career = career;
    }

    @OneToMany(mappedBy = "mentor", fetch = FetchType.LAZY)
    private List<Application> receivedApp = new ArrayList<>();

    @OneToMany(mappedBy = "mentee", fetch = FetchType.LAZY)
    private List<Application> sentApp = new ArrayList<>();
}
