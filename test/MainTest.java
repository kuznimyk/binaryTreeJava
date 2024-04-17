import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testInsertion() {
        BSTree tree = new BSTree();
        tree.insert(5, "Node5");
        tree.insert(3, "Node3");
        tree.insert(7, "Node7");

        assertEquals("Node5 Node3 Node7", tree.inOrderString().trim());
    }

    @Test
    public void testTraversal() {
        BSTree tree = new BSTree();
        tree.insert(5, "Node5");
        tree.insert(3, "Node3");
        tree.insert(7, "Node7");

        assertEquals("Node5 Node3 Node7", tree.inOrderString().trim());
        assertEquals("Node3 Node7 Node5", tree.postOrderString().trim());
        assertEquals("Node5 Node3 Node7", tree.preOrderString().trim());
    }

    @Test
    public void testSearch() {
        BSTree tree = new BSTree();
        tree.insert(5, "Node5");
        tree.insert(3, "Node3");
        tree.insert(7, "Node7");

        assertEquals("Node5", tree.findNameOf(5));
        assertEquals("NOT FOUND", tree.findNameOf(10));
    }

    @Test
    public void testDistance() {
        BSTree tree = new BSTree();
        tree.insert(5, "Node5");
        tree.insert(3, "Node3");
        tree.insert(7, "Node7");

        assertEquals(2, tree.numEntriesBetween(3, 7));
    }
}