package PPT.PPT.controller;

import PPT.PPT.domain.Application;
import PPT.PPT.domain.Mentoring;
import PPT.PPT.domain.repository.Dto.MentoringRequestDto;
import PPT.PPT.domain.repository.Dto.MentoringResponseDto;
import PPT.PPT.service.ApplicationService;
import PPT.PPT.service.MentoringService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequiredArgsConstructor
public class MentoringController {

    private final MentoringService mentoringService;

    @PostMapping("/mentorings/new")
    public ResponseEntity<MentoringResponseDto> createMentoring(@RequestBody MentoringRequestDto dto) {
        Long savedId = mentoringService.startMentoring(dto);
        Mentoring mentoring = mentoringService.findMentoring(savedId);
        MentoringResponseDto responseDto = MentoringResponseDto.from(mentoring);
        return ResponseEntity.ok().body(responseDto);
    }

    @GetMapping("/mentorings/mentor/{id}")
    public ResponseEntity<List<MentoringResponseDto>> getMentoringsAsMentor(@PathVariable("id") Long id) {
        List<Mentoring> mentoringList = mentoringService.findByMentor(id);
        List<MentoringResponseDto> dtos = mentoringList.stream().map(MentoringResponseDto::from).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping("/mentorings/mentee/{id}")
    public ResponseEntity<List<MentoringResponseDto>> getMentoringsAsMentee(@PathVariable("id") Long id) {
        List<Mentoring> mentoringList = mentoringService.findByMentee(id);
        List<MentoringResponseDto> dtos = mentoringList.stream().map(MentoringResponseDto::from).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping("/mentorings/{id}")
    public ResponseEntity<MentoringResponseDto> getMentoring(@PathVariable("id") Long id) {
        Mentoring mentoring = mentoringService.findMentoring(id);
        MentoringResponseDto responseDto = MentoringResponseDto.from(mentoring);
        return ResponseEntity.ok().body(responseDto);
    }
}
