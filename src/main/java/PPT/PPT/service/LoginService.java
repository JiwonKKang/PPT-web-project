package PPT.PPT.service;

import PPT.PPT.domain.dto.member.LoginForm;
import PPT.PPT.domain.dto.member.LoginResponseDto;
import PPT.PPT.domain.dto.mentoring.MentoringRequestDto;
import PPT.PPT.domain.entity.Application;
import PPT.PPT.domain.entity.Member;
import PPT.PPT.domain.entity.Mentoring;
import PPT.PPT.exception.MemberNotFoundException;
import PPT.PPT.repository.MemberRepository;
import PPT.PPT.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Transactional
@RequiredArgsConstructor
@Service
public class LoginService {

    @Value("${jwt.secret}")
    private String secretKey;
    private Long expiredMs = 1000 * 60 * 60 * 5l;


    private final MemberRepository memberRepository;

    public LoginResponseDto login(LoginForm form) {
        Member loginMember = memberRepository.findByEmail(form.getEmail())
                .filter(member -> member.getPassword().equals(form.getPassword()))
                .orElseThrow(()-> new MemberNotFoundException("회원을 찾을수 없습니다."));
        String token = JwtUtil.creatJwt(loginMember.getEmail(), secretKey, expiredMs);
        return new LoginResponseDto(token, loginMember.getId(), loginMember.getEmail(), loginMember.getName());



    }
}

