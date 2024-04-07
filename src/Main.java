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
        System.out.println(myEmployees);
    }
}