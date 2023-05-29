package PPT.PPT.service;

import PPT.PPT.domain.dto.member.LoginForm;
import PPT.PPT.domain.dto.mentoring.MentoringRequestDto;
import PPT.PPT.domain.entity.Application;
import PPT.PPT.domain.entity.Member;
import PPT.PPT.domain.entity.Mentoring;
import PPT.PPT.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    public Member login(LoginForm form) {
        return memberRepository.findByEmail(form.getEmail())
                .filter(member -> member.getPassword().equals(form.getPassword()))
                .orElse(null);
    }
}
