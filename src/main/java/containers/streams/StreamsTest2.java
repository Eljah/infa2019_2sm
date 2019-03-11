package containers.streams;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * Created by eljah32 on 3/11/2019.
 */
public class StreamsTest2 {

    public static void main(String[] args) {
        //List<Double> doubleStream=Stream.generate(Math::random).limit(100).sorted().collect(Collectors.toList());
        List<Double> doubleList = Stream.generate(Math::random).limit(10).sorted().collect(Collectors.toCollection(ArrayList::new));

        System.out.println(doubleList);

        //boolean anyMatchGreaterThan1000=doubleStream.stream().
        boolean anyMatchGreaterThan1000 = doubleList.parallelStream().
                peek((doubleValue) -> {
                    System.out.println("Call the first peek: " + doubleValue);
                }).peek(
                (doubleValue) -> {
                    System.out.println("Call the second peek" + doubleValue);
                }
        )
                .allMatch((s) -> s > -1000);
        //.anyMatch((s)->s>-1000);
        System.out.println(anyMatchGreaterThan1000);

        DoubleStream doubleStream = DoubleStream.generate(Math::random).limit(10000).sorted();
        DoubleSummaryStatistics doubleSummaryStatistics = doubleStream.summaryStatistics();
        System.out.println("Average " + doubleSummaryStatistics.getAverage());
        System.out.println("Max " + doubleSummaryStatistics.getMax());
        System.out.println("Min " + doubleSummaryStatistics.getMin());
        System.out.println("Count " + doubleSummaryStatistics.getCount());
        System.out.println("Sum " + doubleSummaryStatistics.getSum());

        //DoubleSummaryStatistics doubleSummaryStatistics2=Stream.generate(Math::random).limit(10).sorted().collect(Collectors.summarizingDouble(Double::doubleValue));
        System.out.println("Sum1 " + Stream.generate(Math::random).
//                parallel().
//                        peek((doubleValue)->{
//                            System.out.println("Call the first peek: "+doubleValue);
//                        }).
        limit(100).
//                peek((doubleValue)->{
//                    System.out.println("Call the second peek: "+doubleValue);
//                }).
        sorted().collect(Collectors.summarizingDouble(Double::doubleValue)).getSum());


        System.out.println((Stream.generate(Math::random).limit(100).reduce((x, y) -> y + x)));
        System.out.println((Stream.generate(Math::random).limit(100).reduce((x, y) -> y * x)));
        System.out.println((Stream.generate(Math::random).limit(100).reduce((x, y) -> y - x)));
        System.out.println((Stream.generate(Math::random).limit(10).
                peek((doubleValue) -> {
                    System.out.println("Call the first peek: " + doubleValue);
                }).
                reduce((x, y) -> y + y)));
        System.out.println((Stream.generate(Math::random).limit(10).
                peek((doubleValue) -> {
                    System.out.println("Call the first peek: " + doubleValue);
                }).
                reduce((x, y) -> x)));
        System.out.println((Stream.generate(Math::random).limit(10).
                peek((doubleValue) -> {
                    System.out.println("Call the first peek: " + doubleValue);
                }).
                reduce((x, y) -> y)));
        System.out.println((Stream.generate(() -> 1d).limit(10).
                peek((doubleValue) -> {
                    System.out.println("Call the first peek: " + doubleValue);
                }).
                reduce((x, y) -> x + x)));

        System.out.println((Stream.generate(() -> 1d).parallel().limit(10).
                peek((doubleValue) -> {
                    System.out.println("Call the first peek: " + doubleValue);
                }).
                reduce((x, y) -> x + x)));


        System.out.println((Stream.generate(() -> 1d).limit(10).
                peek((doubleValue) -> {
                    System.out.println("Call the first peek: " + doubleValue);
                }).
                reduce((x, y) -> x)));

        System.out.println((Stream.generate(() -> 1d).parallel().limit(10).
                peek((doubleValue) -> {
                    System.out.println("Call the first peek: " + doubleValue);
                }).map(i -> i.toString()).
                reduce((x, y) -> x + x)));


        System.out.println((Stream.generate(() -> 1d).parallel().limit(10).
                peek((doubleValue) -> {
                    System.out.println("Call the first peek: " + doubleValue);
                }).
                reduce((x, y) -> y + y)));

        System.out.println((Stream.generate(() -> 1d).parallel().limit(10).
                peek((doubleValue) -> {
                    System.out.println("Call the first peek: " + doubleValue);
                })
                .reduce((x, y) -> {
                    System.out.println("x=" + x + ", y=" + y);
                    return x + x;
                })));

        System.out.println((Stream.<Double>empty().
                peek((doubleValue) -> {
                    System.out.println("Call the first peek: " + doubleValue);
                }).
                reduce((x, y) -> x + x)));

        System.out.println((Stream.generate(() -> 1d).limit(100).reduce(0d,(x, y) -> y + x)));
        System.out.println((Stream.generate(() -> 1d).limit(100).reduce(1d,(x, y) -> y + x)));
        System.out.println((Stream.generate(() -> 10d).limit(100).reduce(1d,(x, y) -> y * x)));
        System.out.println((Stream.generate(() -> 10d).limit(100).reduce(0d,(x, y) -> y * x)));

        System.out.println("1.0".length());

        System.out.println((Stream.generate(() -> 1d).limit(100).map(i -> i.toString()).reduce(0,(total, word)-> total+ word.length(),(total1,total2)->total1+total2)));

    }
}
