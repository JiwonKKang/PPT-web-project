package PPT.PPT.controller;


import PPT.PPT.domain.dto.member.LoginForm;
import PPT.PPT.domain.dto.member.LoginResponseDto;
import PPT.PPT.exception.MemberNotFoundException;
import PPT.PPT.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginForm form) {
        LoginResponseDto responseDto = loginService.login(form);
        return ResponseEntity.ok().body(responseDto);

    }

    @PostMapping("/test")//JWT인증 테스트
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
