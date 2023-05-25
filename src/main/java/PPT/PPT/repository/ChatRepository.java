package PPT.PPT.repository;

import PPT.PPT.domain.entity.Chat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ChatRepository {

    private final EntityManager em;

    public Long save(Chat chat) {
        em.persist(chat);
        return chat.getId();
    }

    public List<Chat> findByMentoringId(Long id) {
        return em.createQuery("select c from Chat c where c.mentoring.id = :id", Chat.class)
                .setParameter("id", id)
                .getResultList();
    }

}
