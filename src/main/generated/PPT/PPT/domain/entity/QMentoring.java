package PPT.PPT.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMentoring is a Querydsl query type for Mentoring
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMentoring extends EntityPathBase<Mentoring> {

    private static final long serialVersionUID = 490250700L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMentoring mentoring = new QMentoring("mentoring");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMember mentee;

    public final QMember mentor;

    public final StringPath title = createString("title");

    public QMentoring(String variable) {
        this(Mentoring.class, forVariable(variable), INITS);
    }

    public QMentoring(Path<? extends Mentoring> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMentoring(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMentoring(PathMetadata metadata, PathInits inits) {
        this(Mentoring.class, metadata, inits);
    }

    public QMentoring(Class<? extends Mentoring> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.mentee = inits.isInitialized("mentee") ? new QMember(forProperty("mentee")) : null;
        this.mentor = inits.isInitialized("mentor") ? new QMember(forProperty("mentor")) : null;
    }

}

