package exam.paperContext.domain.model.blankQuiz;

import exam.paperContext.shared.Entity;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BlankQuiz implements Entity<BlankQuiz> {
    private BlankQuizId id;
    private String createdBy;
    private String updatedBy;
    private String content;
    private String referenceAnswer;
    private Integer score;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
    private Boolean isDeleted;

    private BlankQuiz(BlankQuizId id, String createdBy, String content, String referenceAnswer, Integer score) {
        this.id = id;
        this.createdBy = createdBy;
        this.content = content;
        this.referenceAnswer = referenceAnswer;
        this.score = score;
        this.updatedBy = createdBy;
        this.isDeleted = false;
        this.createdTime = LocalDateTime.now();
        this.updatedTime = LocalDateTime.now();
    }

    public static BlankQuiz create(BlankQuizId id, String createdBy, String content, String referenceAnswer, Integer score) {
        return new BlankQuiz(id, createdBy, content, referenceAnswer, score);
    }

    @Override
    public boolean sameIdentityAs(BlankQuiz other) {
        return id.sameValueAs(other.id);
    }
}
