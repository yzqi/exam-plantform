package exam.paperContext.domain.model.blankQuiz;

import exam.paperContext.shared.ValueObject;

public class BlankQuizId implements ValueObject<BlankQuizId> {
    private String id;

    @Override
    public boolean sameValueAs(BlankQuizId other) {
        return id.equals(other);
    }

    @Override
    public String toString() {
        return id;
    }
}
