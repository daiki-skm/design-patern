import java.util.*;

class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("c", "b", "a", "d", "e");

        list.sort(new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(list);

        list.sort(new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(list);

        list.sort((o1, o2) -> o1.compareTo(o2));
        System.out.println(list);

        list.sort((o1, o2) -> o2.compareTo(o1));
        System.out.println(list);
    }
}