package pl.learning;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DogService {

    public String foo(int barks){
        return IntStream.range(0, barks)
                .mapToObj(i -> "bark")
                .collect(Collectors.joining(", "));
    }
}
