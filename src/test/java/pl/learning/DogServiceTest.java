package pl.learning;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DogServiceTest {

    private DogService dogService;

    @Before
    public void setUp() {
        dogService = new DogService();
    }

    @Test
    public void foo() {
        String foo = dogService.foo(4);
        assertEquals("bark, bark, bark, bark", foo);
    }
}