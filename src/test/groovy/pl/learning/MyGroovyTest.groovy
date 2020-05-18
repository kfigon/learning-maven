package pl.learning

import org.junit.Test

class MyGroovyTest {
    @Test
    void test() {
        def asd = "hello"
        println()
        println(asd + " from groovy!")

        assert asd == "hello"
    }

    @Test
    void testDogService() {
        def d = new DogService();
        def res = d.foo(3)
        assert res == 'bark, bark, bark'
    }
}