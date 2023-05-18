package PPT.PPT.domain.repository;

import PPT.PPT.domain.Member;
import PPT.PPT.domain.QMember;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;

import static PPT.PPT.domain.QMember.*;

@Repository
public class MemberQueryRepository {

    private final JPAQueryFactory query;

    public MemberQueryRepository(EntityManager entityManager) {
        this.query = new JPAQueryFactory(entityManager);
    }

    public List<Member> findMembers(MemberSearch cond) {

        return query.select(member)
                .from(member)
                .where(skillLike(cond.getSkill()), companyLike(cond.getCompany()))
                .limit(1000)
                .fetch();
    }

    private BooleanExpression companyLike(String company) {
        if (StringUtils.hasText(company)) {
            return member.company.likeIgnoreCase("%" + company + "%");
        }
        return null;
    }

    private BooleanExpression skillLike(String skill) {
        if(StringUtils.hasText(skill)) {
            return member.skill.likeIgnoreCase("%" + skill + "%");
        }
        return null;
    }

}
