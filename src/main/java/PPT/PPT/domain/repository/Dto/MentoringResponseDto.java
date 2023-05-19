package PPT.PPT.domain.repository.Dto;

import PPT.PPT.domain.Mentoring;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MentoringResponseDto {

    private Long id;
    private String title;
    private Long mentorId;
    private Long menteeId;


    public static MentoringResponseDto from(Mentoring mentoring) {
        MentoringResponseDto mentoringResponseDto = new MentoringResponseDto();
        mentoringResponseDto.setId(mentoring.getId());
        mentoringResponseDto.setTitle(mentoring.getTitle());
        mentoringResponseDto.setMentorId(mentoring.getMentor().getId());
        mentoringResponseDto.setMenteeId(mentoring.getMentee().getId());
        return mentoringResponseDto;
    }
}
