package PPT.PPT.domain.repository.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberRequestDto {
    
    private String name;
    private String email;
    private String password;
    private String skill;
    private String interestSkill;
    private String company;
    private int career;

}
