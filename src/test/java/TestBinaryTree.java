import model.BinaryTree;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestBinaryTree {

    private BinaryTree<Integer> createIntegerBinaryTree() {
        BinaryTree<Integer> bt = new BinaryTree<>();

        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);

        return bt;
    }

    private BinaryTree<String> createStringBinaryTree() {
        BinaryTree<String> bt = new BinaryTree<>();

        bt.add("b");
        bt.add("d");
        bt.add("f");
        bt.add("e");
        bt.add("h");
        bt.add("a");
        bt.add("m");

        return bt;
    }

    @Test
    public void testContainsValuesInBinaryTree() {
        BinaryTree<Integer> firstTree = createIntegerBinaryTree();
        BinaryTree<String> secondTree = createStringBinaryTree();

        assertTrue(firstTree.contains(6));
        assertTrue(secondTree.contains("b"));

        assertFalse(firstTree.contains(1));
        assertFalse(secondTree.contains("q"));
    }

    @Test
    public void testDeletingValuesFromTree() {
        BinaryTree<Integer> firstTree = createIntegerBinaryTree();
        BinaryTree<String> secondTree = createStringBinaryTree();

        assertTrue(firstTree.contains(6));
        assertTrue(secondTree.contains("b"));

        firstTree.delete(6);
        secondTree.delete("b");
        assertFalse(firstTree.contains(6));
        assertFalse(secondTree.contains("b"));
    }

    @Test
    public void testTraverse() {
        BinaryTree<Integer> firstTree = createIntegerBinaryTree();
        BinaryTree<String> secondTree = createStringBinaryTree();

        System.out.println("Integer binary tree \n");
        firstTree.walkFromRootThoughtAllTraverseTypes();
        System.out.println("String binary tree \n");
        secondTree.walkFromRootThoughtAllTraverseTypes();
    }
}
