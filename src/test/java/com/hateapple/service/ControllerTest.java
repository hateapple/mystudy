package com.hateapple.service;

import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ControllerTest {

    @Test
    public void controllerTest(){
        List list = mock(List.class);
        list.add(1);
        list.clear();

        verify(list).clear();
    }
}
