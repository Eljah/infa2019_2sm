package reflection.annotations;

public class TestRun {
    public static void main(String[] args) {
        Person person = new Person("soufiane", "cheouati", "34");
        ObjectToJsonConverter serializer = new ObjectToJsonConverter();
        String jsonString = serializer.convertToJson(person);
        System.out.println(jsonString);

        Object someObject = new Object();
        String notreached=serializer.convertToJson(someObject);
        System.out.println(notreached);
    }
}
