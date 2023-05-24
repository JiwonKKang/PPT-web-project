package PPT.PPT.service;

import PPT.PPT.domain.entity.Chat;
import PPT.PPT.domain.entity.Member;
import PPT.PPT.domain.entity.Mentoring;
import PPT.PPT.repository.ChatRepository;
import PPT.PPT.repository.MemberRepository;
import PPT.PPT.repository.MentoringRepository;
import PPT.PPT.domain.dto.chat.ChatDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ChatService {

    private final ChatRepository chatRepository;
    private final MentoringRepository mentoringRepository;
    private final MemberRepository memberRepository;

    public Long createChat(ChatDto dto) {
        Member member = memberRepository.findOne(dto.getUserId());
        Mentoring mentoring = mentoringRepository.findOne(dto.getMentoringId());

        Chat chat = Chat.builder()
                .sender(member)
                .createTime(dto.getCreateTime())
                .mentoring(mentoring)
                .message(dto.getMessage())
                .build();
        chatRepository.save(chat);

        return chat.getId();
    }

    public List<ChatDto> findChatByMentoringId(Long id) {
        List<Chat> chats = chatRepository.findByMentoringId(id);

        return chats.stream().map(ChatDto::from).collect(Collectors.toList());
    }
}
