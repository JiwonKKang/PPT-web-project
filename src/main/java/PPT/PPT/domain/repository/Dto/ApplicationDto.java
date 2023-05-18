package PPT.PPT.domain.repository.Dto;

import PPT.PPT.domain.Application;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationDto {

    private Long mentorId;
    private Long menteeId;
    private String motivation;

    public static ApplicationDto from(Application application) {
        ApplicationDto dto = new ApplicationDto();
        dto.setMotivation(application.getMotivation());
        dto.setMentorId(application.getMentor().getId());
        dto.setMenteeId(application.getMentee().getId());
        // 필요한 필드들을 설정


        return dto;
    }
}
