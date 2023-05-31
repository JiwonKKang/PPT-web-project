package PPT.PPT.repository;

import PPT.PPT.domain.dto.member.UpdateMemberDto;
import PPT.PPT.domain.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public Optional<Member> findByEmail(String email) {
        return em.createQuery("select m from Member m where m.email = :email", Member.class)
                .setParameter("email", email)
                .getResultList()
                .stream().findAny();
    }

    public void updateMember(UpdateMemberDto dto) {
        Member member = findByEmail(dto.getEmail()).get();
        member.setSkill(dto.getSkill());
        member.setInterestSkill(dto.getInterestSkill());
    }

}
