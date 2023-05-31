package PPT.PPT.service;

import PPT.PPT.domain.dto.member.UpdateMemberDto;
import PPT.PPT.domain.entity.Member;
import PPT.PPT.repository.MemberQueryRepository;
import PPT.PPT.repository.MemberRepository;
import PPT.PPT.domain.dto.member.MemberSearch;
import PPT.PPT.domain.dto.member.MemberResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<MemberResponseDto> recommendMentor(Long memberId) {
        Member member = memberRepository.findOne(memberId);
        List<Member> mentors = memberQueryRepository.findMentorByInterest(member.getInterestSkill());
        return mentors.stream().map(MemberResponseDto::from).collect(Collectors.toList());
    }

    @Transactional
    public void update(UpdateMemberDto dto) {
        memberRepository.updateMember(dto);
    }

}
