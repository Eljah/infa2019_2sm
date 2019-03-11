package containers.streams;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * Created by eljah32 on 3/11/2019.
 */
public class StreamsTest2 {

    public static void main(String[] args) {
        List<Double> doubleList = Stream.generate(Math::random).limit(100).sorted().collect(Collectors.toList());
//        List<Double> doubleList = Stream.generate(Math::random).limit(10).sorted().collect(Collectors.toCollection(ArrayList::new));
//
//        System.out.println(doubleList);
//
        //boolean anyMatchGreaterThan1000=doubleList.stream().
        boolean anyMatchGreaterThan1000 = doubleList.parallelStream().
                peek((doubleValue) -> {
                    System.out.println("Call the first peek: " + doubleValue);
                }).peek(
                (doubleValue) -> {
                    System.out.println("Call the second peek" + doubleValue);
                }
        )
                //       .allMatch((s) -> s > -1000);
                .anyMatch((s) -> s > -1000);

        System.out.println(anyMatchGreaterThan1000);
//
        DoubleStream doubleStream = DoubleStream.generate(Math::random).limit(10000).sorted();
        DoubleSummaryStatistics doubleSummaryStatistics = doubleStream.summaryStatistics();
        System.out.println("Average " + doubleSummaryStatistics.getAverage());
        System.out.println("Max " + doubleSummaryStatistics.getMax());
        System.out.println("Min " + doubleSummaryStatistics.getMin());
        System.out.println("Count " + doubleSummaryStatistics.getCount());
        System.out.println("Sum " + doubleSummaryStatistics.getSum());
//
        Double d = 1d;
        d.doubleValue();
        DoubleSummaryStatistics doubleSummaryStatistics2 = Stream.generate(Math::random).limit(10).sorted().collect(Collectors.summarizingDouble(Double::doubleValue));
        System.out.println("Sum1 " + Stream.generate(Math::random).
                parallel().
                peek((doubleValue) -> {
                    System.out.println("Call the first peek: " + doubleValue);
                }).
                limit(100).
                peek((doubleValue) -> {
                    System.out.println("Call the second peek: " + doubleValue);
                }).
                sorted().collect(Collectors.summarizingDouble(Double::doubleValue)).getSum());
//
//
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
                reduce((x, y) -> x + x)));

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
//
//
        System.out.println((Stream.generate(() -> 1d).limit(10).
                peek((doubleValue) -> {
                    System.out.println("Call the first peek: " + doubleValue);
                }).
                reduce((x, y) -> x)));
//
        System.out.println((Stream.generate(() -> 1d).parallel().limit(10).
                peek((doubleValue) -> {
                    System.out.println("Call the first peek: " + doubleValue);
                }).map(i -> i.toString()).
                reduce((x, y) -> x + x)));
//
//
        System.out.println((Stream.generate(() -> 1d).parallel().limit(10).
                peek((doubleValue) -> {
                    System.out.println("Call the first peek: " + doubleValue);
                }).
                reduce((x, y) -> y + y)));
//
        System.out.println((Stream.generate(() -> 1d).parallel().limit(10).
                peek((doubleValue) -> {
                    System.out.println("Call the first peek: " + doubleValue);
                })
                .reduce((x, y) -> {
                    System.out.println("x=" + x + ", y=" + y);
                    return x + x;
                })));
//
        System.out.println((Stream.<Double>empty().
                peek((doubleValue) -> {
                    System.out.println("Call the first peek: " + doubleValue);
                }).
                reduce((x, y) -> x + x)));
//
        System.out.println((Stream.generate(() -> 1d).limit(100).reduce(0d, (x, y) -> x + y)));
        System.out.println((Stream.generate(() -> 1d).limit(100).reduce(1d, (x, y) -> x + y)));
        System.out.println((Stream.generate(() -> 10d).limit(100).reduce(1d, (x, y) -> x * y)));
        System.out.println((Stream.generate(() -> 10d).limit(100).reduce(0d, (x, y) -> x * y)));
        System.out.println((Stream.generate(() -> 10d).limit(100).reduce(0d, (x, y) -> y - x)));
        System.out.println((Stream.generate(() -> 10d).limit(100).reduce(0d, (x, y) -> x - y)));
//
        System.out.println("1.0".length());

        System.out.println((Stream.generate(() -> 1d).limit(100).map(i -> i.toString()).reduce(0, (total, word) -> total + word.length(), (total1, total2) -> total1 + total2)));
        // identy, accumulator, combiner

        System.out.println();

        System.out.println((Stream.generate(() -> 1d).limit(10).map(i -> i.toString()).reduce(0, (total, word) -> {
                    System.out.println("Total " + total + "; word " + word);
                    return total + word.length();
                },
                (total1, total2) -> {
                    System.out.println("Total1 " + total1 + "; total2 " + total2);
                    return total1 + total2;
                })));

        System.out.println();
//
        System.out.println((Stream.generate(() -> 1d).parallel().limit(100).map(i -> i.toString()).reduce(0, (total, word) -> {
                    System.out.println("Total " + total + "; word " + word);
                    return total + word.length();
                },
                (total1, total2) -> {
                    System.out.println("Total1 " + total1 + "; total2 " + total2);
                    return total1 + total2;
                })));


        System.out.println();
//
        Optional<Double> inverseOf1 = inverse(1d);
        Optional<Double> inverseOf0 = inverse(0d);

        System.out.println(inverseOf1);
        System.out.println(inverseOf0);
//
        Optional<String> string0 = string("Something");
        Optional<String> string1 = string("");
        Optional<String> string2 = string(null);
        Optional<String> string3 = string("Another something");
//
        Double calculation0 = 1d + inverseOf1.get();
        System.out.println(calculation0);
        //Double calculation=1d+inverseOf0.get();
        Double calculation = inverseOf0.isPresent() ? 1d + inverseOf0.get() : 1d; //hmm why not and better than

        System.out.println("Calculation 1: " + calculation);

        String sum = "aa" + string2 + string0 + string1;
        //String sum="aa"+string2.get()+string0.get()+string1.get();
//
        System.out.println("String sum 1: " + sum);
//
        Double calculation2 = inverseOf0.orElse(-1d);
        String sum2 = "aa" + string2.orElse("[none]") + string0.orElse("[none]") + string1.orElse("[none]");

        System.out.println("Calculation 2: " + calculation2);
        System.out.println("String sum 2: " + sum2);
//
        Double calculation3 = inverseOf0.orElseGet(() -> -1d);
        Supplier supplier = () -> {
            return "empty as on " + new Date().toString();
        };
        String sum3 = "aa" + string2.orElseGet(() -> {
            return "empty as on " + new Date().toString();
        }) + string0.orElseGet(supplier) + string1.orElseGet(supplier);

        System.out.println("Calculation 3: " + calculation3);
        System.out.println("String sum 3: " + sum3);
//
        StringBuilder stringBuilder = new StringBuilder();

        Stream<Optional<String>> optionalStream = Arrays.stream(new Optional[]{string0, string1, string2, string3});
        optionalStream.peek((str) -> {
            System.out.println("Put to StringBuilder " + str);
            str.ifPresent(stringBuilder::append);
        }).count();
        System.out.println("As placed to StringBuilder " + stringBuilder);

        List<Optional<String>> optionalList = new ArrayList<>();
        optionalList.add(string0);
        optionalList.add(string1);
        optionalList.add(string2);
        optionalList.add(string3);

        StringJoiner stringJoiner = new StringJoiner(", ");

        for (Optional<String> stringOptional : optionalList) {
            stringOptional.ifPresent(stringJoiner::add);
        }

        System.out.printf("As placed to StringJoiner " + stringJoiner);

    }

    //
    static Optional<Double> inverse(Double value) {
        return value == 0 ? Optional.empty() : Optional.of(1 / value);
    }

    static Optional<String> string(String str) {
        //return Optional.ofNullable(str);
        return (str==null || str.isEmpty()) ? Optional.empty() : Optional.ofNullable(str);

    }
}
