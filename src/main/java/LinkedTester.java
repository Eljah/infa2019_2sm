public class LinkedTester {
    public static void main(String[] args) {
        LinksContainer linksContainer=new LinksContainer();
        linksContainer.insert(20);
        linksContainer.insert(10);
        linksContainer.insert(30);
        System.out.println(linksContainer.toString());
        linksContainer.remove();
        System.out.println(linksContainer.toString());


        SortedLinksContainer sortedLinksContainer = new SortedLinksContainer();
        sortedLinksContainer.insert(3);
        //sortedLinksContainer.insert(20);
        //sortedLinksContainer.insert(1);
        sortedLinksContainer.remove();

        System.out.println(sortedLinksContainer);

    }
}
