package PPT.PPT.service;

import PPT.PPT.domain.Member;
import PPT.PPT.domain.repository.MemberQueryRepository;
import PPT.PPT.domain.repository.MemberRepository;
import PPT.PPT.domain.repository.MemberSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberQueryRepository memberQueryRepository;

    @Transactional
    public Long join(Member member) {
        memberRepository.save(member);
        return member.getId();
    }

    public Member findOne(Long id) {
        return memberRepository.findOne(id);
    }

    public List<Member> findMembers(MemberSearch cond) {
        return memberQueryRepository.findMembers(cond);
    }

}
