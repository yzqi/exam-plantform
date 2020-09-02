package exam.paperContext.application;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateBlankQuizCommand {
    private String updatedBy;
    private String content;
    private String referenceAnswer;
    private Integer score;
}