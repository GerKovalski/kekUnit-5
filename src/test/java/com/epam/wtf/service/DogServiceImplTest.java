package com.epam.wtf.service;
import com.epam.wtf.model.Dog;
import com.epam.wtf.service.impl.DogServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Collections;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class DogServiceImplTest {
    @Mock
    DogServiceImpl dogService = new DogServiceImpl();
    @Test
    public void testGetDogNames() {
        when(dogService.getDogNames()).thenReturn(Collections.singletonList("Sharick"));
        assertFalse(dogService.getDogNames().isEmpty());
    }
    @Test
    public void testGetNullDogNames() {
        when(dogService.getDogNames()).thenReturn(null);
        assertNull(dogService.getDogNames());
    }
    @Test
    public void testGetDogCount() {
        when(dogService.getDogCounts()).thenReturn(1);
        assertEquals(1, dogService.getDogCounts());
    }
    @Test
    public void testGetDogCountForName() {
        when(dogService.getDogCounts(anyString())).thenReturn(1);
        assertEquals(1, dogService.getDogCounts("Sharick"));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetDogCountForWrongName() {
        when(dogService.getDogCounts("dogName")).thenThrow(IllegalArgumentException.class);
        dogService.getDogCounts("dogName");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddNullDog() {
        when(dogService.addDog(null)).thenThrow(IllegalArgumentException.class);
        dogService.addDog(null);
    }
    @Test
    public void testAddDog() {
        when(dogService.addDog("Sharick")).thenReturn(new Dog());
        assertNotNull(dogService.addDog("Sharick"));
    }
    @Test
    public void testAddEmptyDog() {
        when(dogService.addDog("")).thenReturn(null);
        assertNull(dogService.addDog(""));
    }
}