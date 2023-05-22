package PPT.PPT.domain.repository.dto.mentoring;

import PPT.PPT.domain.entity.Mentoring;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MentoringResponseDto {

    private Long id;
    private String title;
    private String mentorName;
    private String menteeName;


    public static MentoringResponseDto from(Mentoring mentoring) {
        MentoringResponseDto mentoringResponseDto = new MentoringResponseDto();
        mentoringResponseDto.setId(mentoring.getId());
        mentoringResponseDto.setTitle(mentoring.getTitle());
        mentoringResponseDto.setMentorName(mentoring.getMentor().getName());
        mentoringResponseDto.setMenteeName(mentoring.getMentee().getName());
        return mentoringResponseDto;
    }
}
