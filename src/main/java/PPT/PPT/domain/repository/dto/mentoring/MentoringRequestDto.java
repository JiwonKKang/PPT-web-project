package PPT.PPT.domain.repository.dto.mentoring;

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
    private String title;
}
