package com.epam.wtf.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DogUtilTest {
    @Mock
    DogUtil dogUtil;
    private Answer<Boolean> answer = (invocation) -> {
        Object mock = invocation.getMock();
        System.out.println("mock object : " + mock.toString());
        Object[] args = invocation.getArguments();
        boolean val1;
        if (args[0].equals("Sharik")) {
            val1 = false;
        } else {
            val1 = true;
        }
        boolean val2 = false;
        boolean val3 = val1 ^ val2;
        System.out.println(val1 + " ^ " + val2);
        return val3;
    };

    @Test
    public void testAnswerIsVaccine() {
        when(dogUtil.isVaccine("Sharik")).thenAnswer(answer);
        when(dogUtil.isVaccine("Shrek")).thenAnswer(answer);
        assertFalse(dogUtil.isVaccine("Sharik"));
        assertTrue(dogUtil.isVaccine("Shrek"));
    }

    @Test
    public void testGenerateName() {
        when(dogUtil.generateName()).thenReturn("BonBon");
        assertEquals("BonBon", dogUtil.generateName());
    }
}