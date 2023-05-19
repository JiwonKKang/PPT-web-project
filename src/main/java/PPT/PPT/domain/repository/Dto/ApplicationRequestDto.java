package PPT.PPT.domain.repository.Dto;

import PPT.PPT.domain.Application;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationRequestDto {

    private Long mentorId;
    private Long menteeId;
    private Long price;
    private String motivation;

}
