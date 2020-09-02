package exam.paperContext.domain.model.blankQuiz;

import java.util.List;

public interface BlankQuizRepository {
    void save(BlankQuiz blankQuiz);

    BlankQuiz findById(BlankQuizId blankQuizId);

    List<BlankQuiz> getAll();
}
