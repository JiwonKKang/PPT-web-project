package PPT.PPT.service;

import PPT.PPT.domain.Application;
import PPT.PPT.domain.Member;
import PPT.PPT.domain.Mentoring;
import PPT.PPT.domain.repository.Dto.MentoringRequestDto;
import PPT.PPT.domain.repository.MemberRepository;
import PPT.PPT.domain.repository.MentoringRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MentoringService {

    private final MentoringRepository mentoringRepository;
    private final MemberRepository memberRepository;
    private final ApplicationService applicationService;

    public Long startMentoring(MentoringRequestDto dto) {
        Member mentor = memberRepository.findOne(dto.getMentorId());
        Member mentee = memberRepository.findOne(dto.getMenteeId());
        Mentoring mentoring = Mentoring.createMentoring(mentor, mentee, dto.getTitle());

        Application app = applicationService.findOne(dto.getApplicationId());
        app.deleteApplication(mentor, mentee);
        applicationService.delete(app); // 신청을 수락하여 멘토링이 시작되었다면 신청을 삭제

        return mentoringRepository.save(mentoring);
    }

    public List<Mentoring> findByMentor(Long mentorId) {
        return mentoringRepository.findByMentor(mentorId);
    }

    public List<Mentoring> findByMentee(Long menteeId) {
        return mentoringRepository.findByMentee(menteeId);
    }

    public Mentoring findMentoring(Long mentoringId) {
        return mentoringRepository.findOne(mentoringId);
    }


}
