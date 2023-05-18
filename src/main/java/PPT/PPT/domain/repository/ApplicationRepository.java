package PPT.PPT.domain.repository;

import PPT.PPT.domain.Application;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ApplicationRepository {

        private final EntityManager em;

        public Long save(Application application) {
            em.persist(application);
            return application.getId();
        }

        public Application findOne(Long id) {
            return em.find(Application.class, id);
        }

        public void delete(Application application) {
            em.remove(application);
        }
}
