package exam.paperContext.domain.model.blankQuiz;

import exam.paperContext.application.CreateBlankQuizCommand;
import exam.paperContext.application.UpdateBlankQuizCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;

public class BlankQuizTest {
    @Test
    void should_quiz_score_is_more_than_0() {
        Assertions.assertThrows(IllegalQuizScoreException.class, () -> {
            final String createdBy = "test";
            final String content = "content";
            final Integer score = -10;
            final String referenceAnswer ="answer";
            CreateBlankQuizCommand command = new CreateBlankQuizCommand(createdBy, content, referenceAnswer, score);

            BlankQuiz.create(command);
        });
    }

    @Test
    void should_quiz_score_is_less_than_100() {
        Assertions.assertThrows(IllegalQuizScoreException.class, () -> {
            final String createdBy = "test";
            final String content = "content";
            final Integer score = 101;
            final String referenceAnswer ="answer";
            CreateBlankQuizCommand command = new CreateBlankQuizCommand(createdBy, content, referenceAnswer, score);

            BlankQuiz.create(command);
        });
    }

    @Test
    void should_have_quiz_content() {
        Assertions.assertThrows(IllegalQuizException.class, () -> {
            final String createdBy = "test";
            final String content = null;
            final Integer score = 10;
            final String referenceAnswer ="answer";
            CreateBlankQuizCommand command = new CreateBlankQuizCommand(createdBy, content, referenceAnswer, score);

            BlankQuiz.create(command);
        });
    }

    @Test
    void should_have_quiz_referenceAnswer() {
        Assertions.assertThrows(IllegalQuizException.class, () -> {
            final String createdBy = "test";
            final String content = "content";
            final Integer score = 10;
            final String referenceAnswer = null;
            CreateBlankQuizCommand command = new CreateBlankQuizCommand(createdBy, content, referenceAnswer, score);

            BlankQuiz.create(command);
        });
    }

    @Test
    void should_have_quiz_score() {
        Assertions.assertThrows(IllegalQuizException.class, () -> {
            final String createdBy = "test";
            final String content = "content";
            final Integer score = null;
            final String referenceAnswer = "answer";
            CreateBlankQuizCommand command = new CreateBlankQuizCommand(createdBy, content, referenceAnswer, score);

            BlankQuiz.create(command);
        });
    }

    @Test
    void should_create_quiz_successfully() {
        final String createdBy = "test";
        final String content = "content";
        final Integer score = 10;
        final String referenceAnswer = "answer";
        CreateBlankQuizCommand command = new CreateBlankQuizCommand(createdBy, content, referenceAnswer, score);

        BlankQuiz blankQuiz = BlankQuiz.create(command);

        assertThat(blankQuiz, is(notNullValue()));
        assertThat(blankQuiz.getId(), is(notNullValue()));
        assertThat(blankQuiz.getContent(), is("content"));
        assertThat(blankQuiz.getCreatedBy(), is("test"));
        assertThat(blankQuiz.getScore(), is(10));
        assertThat(blankQuiz.getReferenceAnswer(), is("answer"));
        assertThat(blankQuiz.getCreatedTime(), instanceOf(LocalDateTime.class));
    }

    @Test
    void should_revise_quiz_successfully() {
        final String createdBy = "creator";
        final String content = "before content";
        final Integer score = 20;
        final String referenceAnswer = "before answer";
        CreateBlankQuizCommand command = new CreateBlankQuizCommand(createdBy, content, referenceAnswer, score);

        BlankQuiz toBeUpdatedBlankQuiz = BlankQuiz.create(command);

        final String updatedBy = "updater";
        final String updatedContent = "after content";
        final Integer updatedScore = 10;
        final String updatedReferenceAnswer = "after answer";
        UpdateBlankQuizCommand updateBlankQuizCommand = new UpdateBlankQuizCommand(updatedBy, updatedContent, updatedReferenceAnswer, updatedScore);

        toBeUpdatedBlankQuiz.revise(updateBlankQuizCommand);

        assertThat(toBeUpdatedBlankQuiz, is(notNullValue()));
        assertThat(toBeUpdatedBlankQuiz.getId(), is(notNullValue()));
        assertThat(toBeUpdatedBlankQuiz.getContent(), is("after content"));
        assertThat(toBeUpdatedBlankQuiz.getCreatedBy(), is("creator"));
        assertThat(toBeUpdatedBlankQuiz.getUpdatedBy(), is("updater"));
        assertThat(toBeUpdatedBlankQuiz.getScore(), is(10));
        assertThat(toBeUpdatedBlankQuiz.getReferenceAnswer(), is("after answer"));
        assertThat(toBeUpdatedBlankQuiz.getCreatedTime(), instanceOf(LocalDateTime.class));
        assertThat(toBeUpdatedBlankQuiz.getUpdatedTime(), instanceOf(LocalDateTime.class));
    }

    @Test
    void should_delete_quiz_successfully() {
        final String createdBy = "creator";
        final String content = "before content";
        final Integer score = 20;
        final String referenceAnswer = "before answer";
        CreateBlankQuizCommand command = new CreateBlankQuizCommand(createdBy, content, referenceAnswer, score);

        BlankQuiz toBeDeletedBlankQuiz = BlankQuiz.create(command);

        assertThat(toBeDeletedBlankQuiz.getIsDeleted(), is(false));

        toBeDeletedBlankQuiz.delete();

        assertThat(toBeDeletedBlankQuiz, is(notNullValue()));
        assertThat(toBeDeletedBlankQuiz.getId(), is(notNullValue()));
        assertThat(toBeDeletedBlankQuiz.getContent(), is("before content"));
        assertThat(toBeDeletedBlankQuiz.getCreatedBy(), is("creator"));
        assertThat(toBeDeletedBlankQuiz.getScore(), is(20));
        assertThat(toBeDeletedBlankQuiz.getReferenceAnswer(), is("before answer"));
        assertThat(toBeDeletedBlankQuiz.getCreatedTime(), instanceOf(LocalDateTime.class));
        assertThat(toBeDeletedBlankQuiz.getUpdatedTime(), instanceOf(LocalDateTime.class));
        assertThat(toBeDeletedBlankQuiz.getIsDeleted(), is(true));
    }
}
