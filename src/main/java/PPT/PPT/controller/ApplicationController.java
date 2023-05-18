package PPT.PPT.controller;

import PPT.PPT.domain.Application;
import PPT.PPT.domain.repository.Dto.ApplicationDto;
import PPT.PPT.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@Slf4j
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping("/application/new")
    public ResponseEntity<ApplicationDto> createApply(@RequestBody ApplicationDto dto) {
        log.info("dto: {}", dto.getMenteeId());
        log.info("dto: {}", dto.getMentorId());
        applicationService.apply(dto);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/application/received/{id}")
    public ResponseEntity<List<ApplicationDto>> getReceivedApp(@PathVariable("id") Long mentorId) {
        List<Application> receivedApp = applicationService.receivedApplication(mentorId);
        List<ApplicationDto> dtoList = receivedApp.stream()
                .map(ApplicationDto::from)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(dtoList);
    }

    @GetMapping("/application/sent/{id}")
    public ResponseEntity<List<ApplicationDto>> getSentApp(@PathVariable("id") Long menteeId) {
        List<Application> sentApp = applicationService.sentApplication(menteeId);
        List<ApplicationDto> dtoList = sentApp.stream()
                .map(ApplicationDto::from)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(dtoList);
    }


}
