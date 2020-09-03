package exam.paperContext.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class CreateBlankQuizCommand {
    private String createdBy;
    private String content;
    private String referenceAnswer;
    private Integer score;
}