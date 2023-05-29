package PPT.PPT.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
public class Member implements UserDetails {

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

    public Member() {

    }

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

    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
