/**
 * Created by Ilya Evlampiev on 11.02.2019.
 */
public class ArrayTester {
    public static void main(String[] args) {
        ArrayContainer arrayContainer=new ArrayContainer(100);
        arrayContainer.insert(10);
        arrayContainer.insert(20);
        System.out.println(arrayContainer.toString());
    }
}
