package PPT.PPT.domain.repository.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MentoringRequestDto {

    private Long applicationId;
    private Long mentorId;
    private Long menteeId;
    private String title;
}
