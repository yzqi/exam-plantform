package exam.paperContext.domain.service;

import exam.paperContext.domain.model.blankQuiz.BlankQuizId;
import exam.paperContext.domain.model.paper.Paper.BlankQuiz;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class BlankQuizDto {
    private BlankQuizId id;
    private String createdBy;
    private String updatedBy;
    private String content;
    private String referenceAnswer;
    private Integer score;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
    private Boolean isDeleted;

    public static BlankQuiz toBlankQuiz(BlankQuizDto blankQuizDto) {
        return BlankQuiz.builder()
                        .quizId(blankQuizDto.id.toString())
                        .score(blankQuizDto.score)
                        .build();
    }
}
