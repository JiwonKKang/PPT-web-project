package PPT.PPT.domain.repository.dto.application;

import PPT.PPT.domain.entity.Application;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationResponseDto {

    private Long id;
    private String mentorName;
    private String menteeName;
    private String motivation;
    private Long price;
    private LocalDateTime date;

    public static ApplicationResponseDto from(Application application) {
        ApplicationResponseDto applicationResponseDto = new ApplicationResponseDto();
        applicationResponseDto.setId(application.getId());
        applicationResponseDto.setMentorName(application.getMentor().getName());
        applicationResponseDto.setMenteeName(application.getMentee().getName());
        applicationResponseDto.setMotivation(application.getMotivation());
        applicationResponseDto.setPrice(application.getPrice());
        applicationResponseDto.setDate(application.getApplicationDate());
        return applicationResponseDto;
    }

}
