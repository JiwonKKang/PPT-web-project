package PPT.PPT.controller;

import PPT.PPT.JwtTokenProvider;
import PPT.PPT.domain.dto.member.LoginForm;
import PPT.PPT.domain.entity.Member;
import PPT.PPT.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class LoginController {

    private final LoginService loginService;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginForm form, HttpServletRequest req) {
        Member loginMember = loginService.login(form);

        if (loginMember != null) {
            String token = jwtTokenProvider.createToken(loginMember.getUsername(), loginMember.getRoles());
            return ResponseEntity.ok().body(token);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("요청한 이메일을 찾을 수 없습니다.");
    }

    @PostMapping("/test")
    public String test() { 
        return "테스트 통과!";
    }

    @PostMapping("/logout")
    public ResponseEntity logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return ResponseEntity.ok().body(null);
    }
}
