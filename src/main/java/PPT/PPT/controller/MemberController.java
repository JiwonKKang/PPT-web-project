package PPT.PPT.controller;

import PPT.PPT.domain.entity.Member;
import PPT.PPT.domain.repository.dto.member.MemberRequestDto;
import PPT.PPT.domain.repository.dto.member.MemberResponseDto;
import PPT.PPT.domain.repository.MemberSearch;
import PPT.PPT.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @ResponseBody
    @PostMapping("/members/new")
    public ResponseEntity<MemberResponseDto> createMember(@RequestBody MemberRequestDto dto) {
        Member member = new Member(dto.getName(),
                dto.getSkill(), dto.getInterestSkill(),
                dto.getCompany(), dto.getEmail(),
                dto.getPassword(), dto.getCareer());
        memberService.join(member);
        MemberResponseDto responseDto = MemberResponseDto.from(member);
        return ResponseEntity.ok().body(responseDto);
    }

    @GetMapping("/members")
    public String getMembers(@ModelAttribute("memberSearch") MemberSearch cond, Model model) {
        List<Member> members = memberService.findMembers(cond);
        model.addAttribute("members", members);
        return "members/memberList";
    }

//    @ResponseBody
//    @GetMapping("/members")
//    public ResponseEntity<List<MemberResponseDto>> getMembers(@ModelAttribute("memberSearch") MemberSearch cond) {
//        List<Member> members = memberService.findMembers(cond);
//        List<MemberResponseDto> dtos = members.stream().map(MemberResponseDto::from).collect(Collectors.toList());
//        return ResponseEntity.ok().body(dtos);
//    }

    @GetMapping("/members/{id}")
    public ResponseEntity<MemberResponseDto> getMember(@PathVariable("id") Long id) {
        Member member = memberService.findOne(id);
        MemberResponseDto resDto = MemberResponseDto.from(member);
        return ResponseEntity.ok().body(resDto);
    }

    @GetMapping("/members/recommend/{id}")
    public ResponseEntity<List<MemberResponseDto>> recommendMentor(@PathVariable("id") Long id) {
        List<MemberResponseDto> memberResponseDtos = memberService.recommendMentor(id);
        return ResponseEntity.ok().body(memberResponseDtos);
    }
}
