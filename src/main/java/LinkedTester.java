public class LinkedTester {
    public static void main(String[] args) {
        LinksContainer linksContainer=new LinksContainer();
        linksContainer.insert(20);
        linksContainer.insert(10);
        linksContainer.insert(30);
        System.out.println(linksContainer.toString());
        linksContainer.remove();
        System.out.println(linksContainer.toString());

    }
}
