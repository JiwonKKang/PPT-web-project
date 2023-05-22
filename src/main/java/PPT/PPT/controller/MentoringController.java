package PPT.PPT.controller;

import PPT.PPT.domain.entity.Mentoring;
import PPT.PPT.domain.repository.dto.mentoring.MentoringRequestDto;
import PPT.PPT.domain.repository.dto.mentoring.MentoringResponseDto;
import PPT.PPT.service.MentoringService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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
