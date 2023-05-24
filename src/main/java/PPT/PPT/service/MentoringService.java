package PPT.PPT.service;

import PPT.PPT.domain.entity.Application;
import PPT.PPT.domain.entity.Member;
import PPT.PPT.domain.entity.Mentoring;
import PPT.PPT.domain.dto.mentoring.MentoringRequestDto;
import PPT.PPT.repository.MentoringRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MentoringService {

    private final MentoringRepository mentoringRepository;
    private final ApplicationService applicationService;

    public Long startMentoring(MentoringRequestDto dto) {
        Application app = applicationService.findOne(dto.getApplicationId());
        Member mentor = app.getMentor();
        Member mentee = app.getMentee();
        Mentoring mentoring = Mentoring.createMentoring(mentor, mentee, dto.getTitle());
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
