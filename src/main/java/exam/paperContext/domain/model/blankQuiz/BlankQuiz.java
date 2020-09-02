package exam.paperContext.domain.model.blankQuiz;

import exam.paperContext.application.CreateBlankQuizCommand;
import exam.paperContext.application.UpdateBlankQuizCommand;
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

    private BlankQuiz(String createdBy, String content, String referenceAnswer, Integer score) {
        this.id = BlankQuizId.nextId();
        this.createdBy = createdBy;
        this.content = content;
        this.referenceAnswer = referenceAnswer;
        this.score = score;
        this.updatedBy = createdBy;
        this.isDeleted = false;
        this.createdTime = LocalDateTime.now();
        this.updatedTime = LocalDateTime.now();
    }

    public static BlankQuiz create(CreateBlankQuizCommand command) {
        return new BlankQuiz(command.getCreatedBy(), command.getContent(),
                command.getReferenceAnswer(), command.getScore());
    }

    public void revise(UpdateBlankQuizCommand command) {
        this.content = command.getContent();
        this.referenceAnswer = command.getReferenceAnswer();
        this.score = command.getScore();
        this.updatedBy = command.getUpdatedBy();
        this.updatedTime = LocalDateTime.now();
    }

    @Override
    public boolean sameIdentityAs(BlankQuiz other) {
        return id.sameValueAs(other.id);
    }

    public void delete() {
        this.isDeleted = true;
        this.updatedTime = LocalDateTime.now();
    }
}
