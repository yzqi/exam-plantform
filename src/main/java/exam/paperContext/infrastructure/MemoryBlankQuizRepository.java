package exam.paperContext.infrastructure;

import exam.paperContext.domain.model.blankQuiz.BlankQuiz;
import exam.paperContext.domain.model.blankQuiz.BlankQuizId;
import exam.paperContext.domain.model.blankQuiz.BlankQuizRepository;
import exam.paperContext.domain.model.blankQuiz.NotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class MemoryBlankQuizRepository implements BlankQuizRepository {
    private Set<BlankQuiz> blankQuizSet = new HashSet<>();

    @Override
    public void save(BlankQuiz blankQuiz) {
        blankQuizSet.add(blankQuiz);
    }

    @Override
    public BlankQuiz findById(BlankQuizId blankQuizId) {
        return blankQuizSet.stream()
                           .filter(blankQuiz -> blankQuiz.getId().equals(blankQuizId) && !blankQuiz.getIsDeleted())
                           .findFirst()
                           .orElseThrow(() -> new NotFoundException("Not found blank quiz"));
    }

    @Override
    public List<BlankQuiz> findAll() {
        return new ArrayList<>(blankQuizSet);
    }
}
