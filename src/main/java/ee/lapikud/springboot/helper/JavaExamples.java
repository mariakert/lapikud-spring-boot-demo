package ee.lapikud.springboot.helper;

import java.util.Optional;

public class JavaExamples {

    /**
     * when a field is a static field, it means you can access it by calling it straight from the class:
     * JavaExamples.string
     */
    public static String string;


    /**
     * static fields are commonly used when they are also final fields to access an immutable constant
     * best practice for naming final fields is naming them in uppercase letters
     * final field cannot be changed after
     */
    public static final String STRING_2 = "string2";

    /**
     * when you create a JavaExamples e = new JavaExamples(), you can access stringExample by calling e.stringExample
     * usually not a good idea by coding standards
     */
    public String stringExample;

    /**
     * works the same way as public but only in the same package as JavaExamples
     * usually not the best practice to use package-private fields
     */
    String stringExample2;

    /**
     * field can only be accessed by its accessor(s): getter and setter
     * best practice in Java conventions
     * getter and setter are not mandatory if you only use these fields inside the class
     */
    private String stringExample3;

    /**
     * getter - for accessing the value of stringExample3 outside of JavaExamples
     */
    public String getStringExample3() {
        return stringExample3;
    }

    /**
     * setter - for changing the value of stringExample3 inside or outside of helper
     */
    public void setStringExample3(String stringExample3) {
        this.stringExample3 = stringExample3;
    }

    /**
     * "void" means that the method is not returning any values
     * good for doing tasks that don't require a result
     * for example logging or printing results to console or setting a new value to a field
     */
    public void nonReturningMethodExample() {
        //any time you call this method, stringExample3 is set to either "example" or null
        if (stringExample3 == null) {
            stringExample3 = "example";
        } else {
            stringExample3 = null;
        }
    }

    /**
     * when method isn't a void method, it needs to return a value
     * for example, a calculator
     * Integer after public means that this method has to return an Integer (numeric) value
     */
    public Integer add() {
        return 1 + 1;
    }

    /**
     * this is a good way to have a more dynamic return statement
     */
    public Integer add(int first, int second) {
        return first + second;
    }

    /**
     * optionals are a good way of dealing with null values without getting a NullPointerException
     * example on String below but can be used on any object
     */
    public void optionalExample() {
        //non-empty optional
        Optional<String> optional = Optional.of("string");
        //empty optional
        Optional<String> empty = Optional.empty();

        //getting an optional value goes like this
        String stringFromOptional = optional.get();

        //this will fail because it is an empty optional
        String emptyString = empty.get();

        //but what if we are not sure if optional is empty or not?
        //we can find out by calling:
        if (optional.isPresent()) {
            //do something like print the value
            System.out.println(optional.get().toUpperCase());
        }

        //or even shorter - you can run the same command in functional way with lambda
        //s is a lambda representation of the String "string" that was set with Optional.of
        optional.ifPresent(s -> System.out.println(s.toUpperCase()));
    }
}
