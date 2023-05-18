package PPT.PPT.controller;

import PPT.PPT.domain.Mentoring;
import PPT.PPT.service.MentoringService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class MentoringController {

    private final MentoringService mentoringService;

    @PostMapping("/mentorings/new")
    public ResponseEntity<Mentoring> createMentoring() {

    }
}
