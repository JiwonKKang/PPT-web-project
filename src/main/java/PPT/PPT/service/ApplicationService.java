package PPT.PPT.service;

import PPT.PPT.domain.entity.Application;
import PPT.PPT.domain.entity.Member;
import PPT.PPT.domain.repository.dto.application.ApplicationRequestDto;
import PPT.PPT.domain.repository.ApplicationRepository;
import PPT.PPT.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Long apply(ApplicationRequestDto dto) {

        Member mentee = memberRepository.findOne(dto.getMenteeId());
        Member mentor = memberRepository.findOne(dto.getMentorId());

        Application application = Application.createApplication(mentee, mentor, dto.getMotivation(), dto.getPrice());

        return applicationRepository.save(application);
    }

    public Application findOne(Long id) {
        return applicationRepository.findOne(id);
    }

    public List<Application> receivedApplication(Long mentorId) {
        return memberRepository.findOne(mentorId).getReceivedApp();
    }

    public List<Application> sentApplication(Long menteeId) {
        return memberRepository.findOne(menteeId).getSentApp();
    }

    @Transactional
    public void delete(Application application) {
        applicationRepository.delete(application);
    }

}
