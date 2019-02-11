/**
 * Created by Ilya Evlampiev on 11.02.2019.
 */
public class ArrayTester {
    public static void main(String[] args) {
        ArrayContainer arrayContainer=new ArrayContainer(100);
        arrayContainer.insert(10);
        arrayContainer.insert(20);
        //System.out.println(arrayContainer.readUnit(0));
        //System.out.println(arrayContainer.readUnit(1));
        //System.out.println(arrayContainer.readUnit(5));
        arrayContainer.insert(15);
        arrayContainer.insert(30);
        arrayContainer.insert(31);

        System.out.println(arrayContainer.toString());
        arrayContainer.remove(1);
        System.out.println(arrayContainer.toString());
        arrayContainer.remove(2);
        System.out.println(arrayContainer.toString());
        //arrayContainer.remove(3);
        //System.out.println(arrayContainer.toString());
        //arrayContainer.remove(3);
        //System.out.println(arrayContainer.toString());
        arrayContainer.insert(2,41);
        System.out.println(arrayContainer.toString());
        //arrayContainer.insert(5,41);
        //System.out.println(arrayContainer.toString());

        SortedArrayContainer sortedArrayContainer=new SortedArrayContainer(100);
        sortedArrayContainer.insert(10);
        sortedArrayContainer.insert(20);
        System.out.println(sortedArrayContainer);
        sortedArrayContainer.insert(15);
        sortedArrayContainer.insert(12);
        System.out.println(sortedArrayContainer);

    }
}
