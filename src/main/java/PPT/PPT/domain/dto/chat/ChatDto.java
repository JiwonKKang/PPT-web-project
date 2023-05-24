package PPT.PPT.domain.dto.chat;

import PPT.PPT.domain.entity.Chat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChatDto {

    private Long mentoringId;
    private Long userId;
    private String message;
    private LocalDateTime createTime;

    public static ChatDto from(Chat chat) {
        ChatDto chatDto = new ChatDto();
        chatDto.mentoringId = chat.getMentoring().getId();
        chatDto.userId = chat.getSender().getId();
        chatDto.message = chat.getMessage();
        chatDto.createTime = chat.getCreateTime();

        return chatDto;
    }
}
