package PPT.PPT.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -465267409L;

    public static final QMember member = new QMember("member1");

    public final NumberPath<Integer> career = createNumber("career", Integer.class);

    public final StringPath company = createString("company");

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath interestSkill = createString("interestSkill");

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final ListPath<Application, QApplication> receivedApp = this.<Application, QApplication>createList("receivedApp", Application.class, QApplication.class, PathInits.DIRECT2);

    public final ListPath<Application, QApplication> sentApp = this.<Application, QApplication>createList("sentApp", Application.class, QApplication.class, PathInits.DIRECT2);

    public final StringPath skill = createString("skill");

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

