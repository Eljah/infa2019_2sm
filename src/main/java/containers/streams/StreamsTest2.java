package containers.streams;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by eljah32 on 3/11/2019.
 */
public class StreamsTest2 {

    public static void main(String[] args) {
        //List<Double> doubleStream=Stream.generate(Math::random).limit(100).sorted().collect(Collectors.toList());
        List<Double> doubleStream=Stream.generate(Math::random).limit(10).sorted().collect(Collectors.toCollection(ArrayList::new));

        System.out.println(doubleStream);

        //boolean anyMatchGreaterThan1000=doubleStream.stream().
        boolean anyMatchGreaterThan1000=doubleStream.parallelStream().
                peek((doubleValue)->{
            System.out.println("Call the first peek: "+doubleValue);
        }).peek(
                (doubleValue)->{
                    System.out.println("Call the second peek"+doubleValue);
                }
        )
        .allMatch((s)->s>-1000);
        //.anyMatch((s)->s>-1000);
        System.out.println(anyMatchGreaterThan1000);


    }
}
