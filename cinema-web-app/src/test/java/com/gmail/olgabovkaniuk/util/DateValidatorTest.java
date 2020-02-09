package com.gmail.olgabovkaniuk.util;

import com.gmail.olgabovkaniuk.service.CinemaService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class DateValidatorTest {

    @Mock(answer = Answers.CALLS_REAL_METHODS)
    CinemaService cinemaService;

    @InjectMocks
    DateValidator dateValidator;

    @Test
    public void isValidIncorrectDataTest() {
        //given
        String incorrectDate = "ABCD";

        //when
        boolean isValid = dateValidator.isValid(incorrectDate);

        //then
        Assert.assertFalse(isValid);
    }

    @Test
    public void isValidCorrectDataTest() {
        //given
        String correctDate = "05/12/1987";

        //when
        boolean isValid = dateValidator.isValid(correctDate);

        //then
        Assert.assertTrue(isValid);
    }

}