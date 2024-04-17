//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        BSTree myEmployees = new BSTree();

        myEmployees.insert(50, "Bugs Bunny");
        myEmployees.insert(30, "Mickey Mouse");
        myEmployees.insert(80, "Minnie Mouse");
        myEmployees.insert(25, "Donald Duck");
        myEmployees.insert(65, "Pluto");
        myEmployees.insert(40, "Santa Claus");
        myEmployees.insert(100, "Queen Elsa");
        myEmployees.insert(70, "Anna");
        myEmployees.insert(58, "Olaf");
        System.out.println();
        System.out.println(myEmployees.preOrderString());
        System.out.println(myEmployees.inOrderString());
        System.out.println(myEmployees.postOrderString());
        System.out.println();
        System.out.println(myEmployees);
        System.out.println(myEmployees.findIdNumOf("Olaf"));
        System.out.println(myEmployees.findIdNumOf("Minnie Mouse"));
        System.out.println(myEmployees.findIdNumOf("Santa Claus"));
        System.out.println(myEmployees.numEntriesBetween(50, 25));
        System.out.println(myEmployees.numEntriesBetween(30, 25));
        System.out.println(myEmployees.numEntriesBetween(25, 40));
        System.out.println(myEmployees.numEntriesBetween(100, 58)) ;
        System.out.println(myEmployees.numEntriesBetween(25, 70));
        System.out.println(myEmployees.numEntriesBetween(40, 65));

    }
}