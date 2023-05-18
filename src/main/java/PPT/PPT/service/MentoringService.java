package PPT.PPT.service;

import PPT.PPT.domain.Member;
import PPT.PPT.domain.Mentoring;
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

    public Long startMentoring(Long mentorId, Long menteeId) {
        Member mentor = memberRepository.findOne(mentorId);
        Member mentee = memberRepository.findOne(menteeId);
        Mentoring mentoring = Mentoring.createMentoring(mentor, mentee);

        return mentoringRepository.save(mentoring);
    }

    public List<Mentoring> findByMentor(Long mentorId) {
        return mentoringRepository.findByMentor(mentorId);
    }

    public List<Mentoring> findByMentee(Long menteeId) {
        return mentoringRepository.findByMentee(menteeId);
    }
}
