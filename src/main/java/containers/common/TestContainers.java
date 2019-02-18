package containers.common;

import containers.array.ArrayContainer;
import containers.linked.LinksContainer;

import java.util.*;

public class TestContainers {
    public static void main(String[] args) {
        Container arrayContainer=new ArrayContainer(1000);
        //LinksContainer arrayContainer=new LinksContainer();
        arrayContainer.insert(100);
        arrayContainer.insert(102);
        arrayContainer.insert(103);
        arrayContainer.insert(104);
        print(arrayContainer);
        ((ArrayContainer)arrayContainer).insert(2,90);
        print(arrayContainer);

        Container linkContainer=new LinksContainer();
        linkContainer.insert(200);
        linkContainer.insert(201);
        linkContainer.insert(202);
        print(linkContainer);

        }

    static void print(Container arrayContainer)
    {
        arrayContainer.display();
    }
}
