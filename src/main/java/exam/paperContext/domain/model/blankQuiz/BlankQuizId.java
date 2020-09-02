package exam.paperContext.domain.model.blankQuiz;

import exam.paperContext.shared.ValueObject;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class BlankQuizId implements ValueObject<BlankQuizId> {
    private String id;

    public static BlankQuizId nextId() {
        return new BlankQuizId(UUID.randomUUID().toString());
    }

    @Override
    public boolean sameValueAs(BlankQuizId other) {
        return id.equals(other);
    }

    @Override
    public String toString() {
        return id;
    }
}
