package software.ulpgc.katas;

import java.util.List;
import java.util.function.Function;

public class HistogramGenerator {

    public <T> Histogram compute(List<T> data, Function<T, ?> attributeExtractor){
        Histogram histogram = new Histogram();

        data.stream()
                .map(attributeExtractor)
                .forEach(value -> histogram.feed(value.toString()));

        return histogram;
    }
}
