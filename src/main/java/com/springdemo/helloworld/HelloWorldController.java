package com.springdemo.helloworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
public class HelloWorldController {
    Logger logger = LoggerFactory.getLogger(HelloWorldController.class);


    @RequestMapping
    public String helloWorld() {

        Function<String, String> prwti = (value) -> value + " prwti";
        Function<String, String> defteri = (value) -> value + " defteri";

        Function<String, String> logThenSqrt = defteri.compose(prwti);

        System.out.println(logThenSqrt.apply("Alexakis"));// Output: 1.06

        Function<String, String> sqrtThenLog = defteri.andThen(prwti);

        System.out.println(sqrtThenLog.apply("Alexakis"));


        Function<Double, Function<Double, Double>> weight = mass -> gravity -> mass * gravity;

        Function<Double, Double> weightOnEarth = weight.apply(9.81);
        logger.info("My weight on Earth: " + weightOnEarth.apply(60.0));

        Function<Double, Double> weightOnMars = weight.apply(3.75);
        logger.info("My weight on Mars: " + weightOnMars.apply(60.0));


        return "Hello world!!!!!!";
    }

    @GetMapping("/goodbye")
    public String goodBye() {
        return "Good bye from Spring boot";
    }

    @GetMapping("/functional")
    public String functional() {
        List<Integer> list1 = Arrays.asList(9, 2, 61, 52, 6, 1, 8);
        List<Integer> list2 = Arrays.asList(6, 2, 9, 5, 1, 52, 1, 7);
        List<String> listString = Arrays.asList("ena", "dyo", "tria", "tesera", "pente", "eksi", "epta", "okto");

        Function<String,String> functionAdd = n -> n + "@";
        Function<String,String> functionAddMore  = n -> n + "$$";
        Function<String,String> functionAndThen  =functionAdd.andThen(functionAddMore);
        Function<String,String> functionCompose  =functionAdd.compose(functionAddMore);


        List<String> collect1 = listString.stream().map(functionCompose::apply).collect(Collectors.toList());
//        listString.forEach(functionAdd::apply);
//        listString.forEach(functionAddMore::apply);

        CustomerBuilder.Customer a = new CustomerBuilder("Alex", "Xela").with(customer -> {
            customer.setSex("male");
            customer.setAge(36);
            customer.setAddress("akadimias");
        } ).build();


        collect1.forEach(System.out::println);


        Consumer printer = n -> logger.info("o arithmos mas einai {}",n);

//        CallbackWithParams sample = () -> System.out.println("o arithmos mas einai ");



        CallBack callback = new CallBack(){

            @Override
            public void run(String n) {
                logger.info("PIGAME PISWWWW !!! {}",n);
            }
        };

        list1.sort((n1, n2) -> n1.compareTo(n2));

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(4, 5, 6);
        List<Integer> numbers3 = Arrays.asList(7, 8, 9);
        int sum = numbers3.stream().filter(number -> number % 2 == 0)
                .mapToInt(e -> e * 2)
                .sum();
        List<List<Integer>> listOfLists = Arrays.asList(numbers1, numbers2, numbers3, list2, list1);

        List<Integer> flatList = new java.util.ArrayList<>(listOfLists.stream()
                .flatMap(Collection::stream)
                .peek(n -> logger.info("o arithmos mas einai {}",n))
                .toList());

        List<CallBack> collect = flatList.stream().map(n -> new CallBack() {
            @Override
            public void run(String n) {
                logger.info("Callback ::::: o arithmos mas einai {}", n);
            }
        }).collect(Collectors.toList());

        flatList.sort(Integer::compareTo);

        collect.forEach(n -> n.run(""));


        callback.run("POUTSES !!!");

        return "This is a Functional Programming test";
    }


}
