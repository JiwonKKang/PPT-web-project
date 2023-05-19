package PPT.PPT.controller;

import PPT.PPT.domain.Application;
import PPT.PPT.domain.repository.Dto.ApplicationRequestDto;
import PPT.PPT.domain.repository.Dto.ApplicationResponseDto;
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
    public ResponseEntity<ApplicationResponseDto> createApply(@RequestBody ApplicationRequestDto dto) {
        Long applyId = applicationService.apply(dto);
        Application app = applicationService.findOne(applyId);
        ApplicationResponseDto responseDto = ApplicationResponseDto.from(app);
        return ResponseEntity.ok().body(responseDto);
    }

    @GetMapping("/application/received/{id}")
    public ResponseEntity<List<ApplicationResponseDto>> getReceivedApp(@PathVariable("id") Long mentorId) {
        List<Application> receivedApp = applicationService.receivedApplication(mentorId);
        List<ApplicationResponseDto> dtoList = receivedApp.stream()
                .map(ApplicationResponseDto::from)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(dtoList);
    }

    @GetMapping("/application/sent/{id}")
    public ResponseEntity<List<ApplicationResponseDto>> getSentApp(@PathVariable("id") Long menteeId) {
        List<Application> sentApp = applicationService.sentApplication(menteeId);
        List<ApplicationResponseDto> dtoList = sentApp.stream()
                .map(ApplicationResponseDto::from)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(dtoList);
    }
}
