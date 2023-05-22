package PPT.PPT.domain.repository;

import PPT.PPT.domain.entity.Application;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

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
