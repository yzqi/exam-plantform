package exam.paperContext.application;

import exam.paperContext.domain.model.blankQuiz.BlankQuiz;
import exam.paperContext.domain.model.blankQuiz.BlankQuizId;
import exam.paperContext.domain.model.blankQuiz.BlankQuizRepository;
import exam.paperContext.domain.model.blankQuiz.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class BlankQuizApplicationService {
    private BlankQuizRepository blankQuizRepository;

    @Autowired
    public BlankQuizApplicationService(BlankQuizRepository blankQuizRepository) {
        this.blankQuizRepository = blankQuizRepository;
    }

    public BlankQuizId create(CreateBlankQuizCommand command) {
        final BlankQuiz blankQuiz = BlankQuiz.create(command);

        blankQuizRepository.save(blankQuiz);

        return blankQuiz.getId();
    }

    public void revise(String blankQuizId, UpdateBlankQuizCommand command) {
        final BlankQuiz blankQuiz = blankQuizRepository.findById(new BlankQuizId(blankQuizId));

        if (Objects.isNull(blankQuiz)) {
            throw new NotFoundException("Not found blank quiz.");
        }

        blankQuiz.revise(command);

        blankQuizRepository.save(blankQuiz);
    }

    public List<BlankQuiz> getAll() {
        return blankQuizRepository.getAll().stream().filter(blankQuiz -> !blankQuiz.getIsDeleted()).collect(Collectors.toList());
    }

    public void delete(String blankQuizId) {
        final BlankQuiz blankQuiz = blankQuizRepository.findById(new BlankQuizId(blankQuizId));

        if (Objects.isNull(blankQuiz)) {
            throw new NotFoundException("Not found blank quiz.");
        }

        blankQuiz.delete();

        blankQuizRepository.save(blankQuiz);
    }
}
