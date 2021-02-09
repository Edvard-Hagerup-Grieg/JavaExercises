// Бинарное дерево поиска

import Exercises3_2.BinaryTree;

public class Exercises3_2 {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(10);
        tree.add(5);
        tree.add(3);
        tree.add(4);
        tree.add(7);
        tree.add(6);
        tree.add(9);
        tree.add(30);
        tree.add(20);
        tree.add(31);
        tree.add(22);

        System.out.println("Initialized binary tree:");
        System.out.println(tree);

        tree.remove(5);

        System.out.println("The binary tree after removing element 5:");
        System.out.println(tree);

        tree.remove(10);

        System.out.println("The binary tree after removing root:");
        System.out.println(tree);

        tree.remove(11);

        System.out.println("The binary tree after removing a nonexistent element (no change):");
        System.out.println(tree);
    }
}
