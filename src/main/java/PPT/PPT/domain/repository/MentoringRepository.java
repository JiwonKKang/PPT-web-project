package PPT.PPT.domain.repository;

import PPT.PPT.domain.Mentoring;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MentoringRepository {

    private final EntityManager em;

    public Long save(Mentoring mentoring) {
        em.persist(mentoring);
        return mentoring.getId();
    }

    public Mentoring findOne(Long id) {
        return em.find(Mentoring.class, id);
    }

    public List<Mentoring> findAll() {
        return em.createQuery("select m from Mentoring m", Mentoring.class)
                .getResultList();
    }

    public List<Mentoring> findByMentor(Long id) {
        return em.createQuery("select m from Mentoring m where m.mentor.id = :id", Mentoring.class)
                .setParameter("id", id)
                .getResultList();
    }

    public List<Mentoring> findByMentee(Long id) {
        return em.createQuery("select m from Mentoring m where m.mentee.id = :id", Mentoring.class)
                .setParameter("id", id)
                .getResultList();
    }
}
