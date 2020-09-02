package exam.paperContext.userInterface;

import exam.paperContext.application.BlankQuizApplicationService;
import exam.paperContext.application.CreateBlankQuizCommand;
import exam.paperContext.application.UpdateBlankQuizCommand;
import exam.paperContext.domain.model.blankQuiz.BlankQuiz;
import exam.paperContext.domain.model.blankQuiz.BlankQuizId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/quizzes")
public class BlankQuizController {
    private final BlankQuizApplicationService blankQuizApplicationService;

    @Autowired
    public BlankQuizController(BlankQuizApplicationService blankQuizApplicationService) {
        this.blankQuizApplicationService = blankQuizApplicationService;
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    BlankQuizDTO create(@RequestBody CreateBlankQuizCommand command) {
        final BlankQuizId blankQuizId = blankQuizApplicationService.create(command);
        return BlankQuizDTO.from(blankQuizId);
    }

    @GetMapping
    List<BlankQuiz> getAll() {
        return blankQuizApplicationService.getAll();
    }

    @PutMapping("/{quizId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void revise(@PathVariable String quizId, @RequestBody UpdateBlankQuizCommand command) {
        blankQuizApplicationService.revise(quizId, command);
    }

    @DeleteMapping("/{quizId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable String quizId) {
        blankQuizApplicationService.delete(quizId);
    }
}
