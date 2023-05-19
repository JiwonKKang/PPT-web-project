package PPT.PPT.domain.repository.Dto;

import PPT.PPT.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponseDto {
    private Long id;
    private String name;
    private String skill;
    private String interestSkill;
    private String company;
    private int career;

    public static MemberResponseDto from(Member member) {
        MemberResponseDto dto = new MemberResponseDto();
        dto.setId(member.getId());
        dto.setName(member.getName());
        dto.setSkill(member.getSkill());
        dto.setInterestSkill(member.getInterestSkill());
        dto.setCompany(member.getCompany());
        dto.setCareer(member.getCareer());
        return dto;
    }
}
