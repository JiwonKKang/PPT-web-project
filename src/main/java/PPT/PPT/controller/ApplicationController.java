package PPT.PPT.controller;

import PPT.PPT.domain.entity.Application;
import PPT.PPT.domain.dto.application.ApplicationRequestDto;
import PPT.PPT.domain.dto.application.ApplicationResponseDto;
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
@CrossOrigin(origins = "*")
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping("/applications/new")
    public ResponseEntity<ApplicationResponseDto> createApply(@RequestBody ApplicationRequestDto dto) {
        Long applyId = applicationService.apply(dto);
        Application app = applicationService.findOne(applyId);
        ApplicationResponseDto responseDto = ApplicationResponseDto.from(app);
        return ResponseEntity.ok().body(responseDto);
    }

    @GetMapping("/applications/received/{id}")
    public ResponseEntity<List<ApplicationResponseDto>> getReceivedApp(@PathVariable("id") Long mentorId) {
        List<Application> receivedApp = applicationService.receivedApplication(mentorId);
        List<ApplicationResponseDto> dtoList = receivedApp.stream()
                .map(ApplicationResponseDto::from)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(dtoList);
    }

    @GetMapping("/applications/sent/{id}")
    public ResponseEntity<List<ApplicationResponseDto>> getSentApp(@PathVariable("id") Long menteeId) {
        List<Application> sentApp = applicationService.sentApplication(menteeId);
        List<ApplicationResponseDto> dtoList = sentApp.stream()
                .map(ApplicationResponseDto::from)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(dtoList);
    }

    @GetMapping("/applications/{id}")
    public ResponseEntity<ApplicationResponseDto> getApplication(@PathVariable("id") Long id) {
        Application application = applicationService.findOne(id);
        ApplicationResponseDto dto = ApplicationResponseDto.from(application);
        return ResponseEntity.ok().body(dto);
    }


}
