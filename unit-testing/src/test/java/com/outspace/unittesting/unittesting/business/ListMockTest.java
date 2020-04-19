package com.outspace.unittesting.unittesting.business;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {

    List<String> mock = mock(List.class);

    @Test
    public void size_basic() {
        when(mock.size()).thenReturn(5);
        assertEquals(5, mock.size());
    }

    @Test
    public void returnDifferentValues() {
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock.size());    // the first call will return 5
        assertEquals(10, mock.size());    // the second call will return 10
    }
    @Test
    public void returnWithParameters() {
        when(mock.get(0)).thenReturn("in28minutes");
        assertEquals("in28minutes",mock.get(0));
        assertEquals(null,mock.get(1));
    }

    @Test
    public void returnWithGenericParameters() {
        when(mock.get(anyInt())).thenReturn("in28minutes");
        assertEquals("in28minutes",mock.get(0));
        assertEquals(null,mock.get(1));
    }

    @Test
    public void verificationBasics() {
        String value = mock.get(0);
        String value1 = mock.get(1);

        //Verify
        verify(mock).get(0);
        verify(mock).get(anyInt());
        verify(mock, times(2)).get(anyInt());
        verify(mock, atLeast(1)).get(anyInt());
        verify(mock, atMost(3)).get(anyInt());
        verify(mock, never()).get(2);
    }

    @Test
    public void argumentCapturing() {
        //SUT
        mock.add("SomeString");

        //Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        assertEquals("SomeString", captor.getValue());
    }

    @Test
    public void multipleCapturing() {
        //SUT
        mock.add("SomeString");
        mock.add("SomeString2");

        //Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add(captor.capture());

        List<String> allValues = captor.getAllValues();

        assertEquals("SomeString", allValues.get(0));
        assertEquals("SomeString2", allValues.get(1));
    }

    @Test
    public void mocking() {
        ArrayList arrayListMock = mock(ArrayList.class);
        arrayListMock.get(0);  //null
        arrayListMock.size();  // 0
        arrayListMock.add("Test");
        arrayListMock.add("Test2");
        arrayListMock.size(); //0

        when(arrayListMock.size()).thenReturn(5);
        arrayListMock.size(); //5
    }

    @Test
    public void spying() {
        ArrayList arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("Test0");
        arrayListSpy.get(0);  //null
        arrayListSpy.size();  // 0
        arrayListSpy.add("Test");
        arrayListSpy.add("Test2");
        arrayListSpy.size(); //0

        when(arrayListSpy.size()).thenReturn(5);
        arrayListSpy.size(); //5

        verify(arrayListSpy).add("Test2");
    }
}
