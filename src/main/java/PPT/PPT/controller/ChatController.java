package PPT.PPT.controller;

import PPT.PPT.domain.repository.dto.ChatDto;
import PPT.PPT.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ChatController {

    private final SimpMessagingTemplate template;
    private final ChatService chatService;

//    @ResponseBody
//    @PostMapping("/chat")
//    public ResponseEntity<String> sendChat(@RequestBody ChatDto chatDto) {
//        chatService.createChat(chatDto);
//        return ResponseEntity.ok().body("send complete!");
//    }

    @ResponseBody
    @GetMapping("/chat/{mentoringId}")
    public ResponseEntity<List<ChatDto>> chatHistory(@PathVariable("mentoringId") Long id) {
        List<ChatDto> chatDtoList = chatService.findChatByMentoringId(id);
        return ResponseEntity.ok().body(chatDtoList);
    }

    @MessageMapping("/chat/message")
    public void message(ChatDto msg) {
        chatService.createChat(msg);
        log.info("msg = {}", msg.getMessage());
        log.info("mentoringId= {}", msg.getMentoringId());
        template.convertAndSend("/sub/chat/mentoring/" + msg.getMentoringId().toString(), msg);
    }
}
