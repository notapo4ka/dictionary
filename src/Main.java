import java.util.List;

public class Main {

    public static void main(String[] args) {
        FileData file = new FileData("testtt.txt", 1024, "D:\\Programming\\test");
        FileData secondFile = new FileData("more.txt", 360, "D:\\Programming\\test");
        FileData differentPathFile = new FileData("text.txt", 1024, "D:\\Programming\\work");
        FileNavigator navigator = new FileNavigator();

        navigator.add(file);
        navigator.add(secondFile);
        navigator.add(differentPathFile);

        System.out.println(navigator.getFiles(file));

        System.out.println();

        List list = navigator.find("D:\\Programming\\test");
        System.out.println(list);

        System.out.println();
        System.out.println(navigator.filterBySize(200));

        System.out.println();

        navigator.remove("D:\\Programming\\work");
        System.out.println(navigator.find("D:\\Programming\\work"));

        System.out.println();

        System.out.println(navigator.sortBySize());
    }
}