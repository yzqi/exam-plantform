package exam.paperContext.userInterface;

import exam.paperContext.domain.model.blankQuiz.BlankQuizId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BlankQuizDTO {
    private String uri;

    public static BlankQuizDTO from(BlankQuizId blankQuizId) {
        return new BlankQuizDTO("quizzes/" + blankQuizId);
    };
}
