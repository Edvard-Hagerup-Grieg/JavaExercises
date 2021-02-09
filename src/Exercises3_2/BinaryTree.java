package Exercises3_2;

public class BinaryTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public BinaryTree(int rootKey) {
        root = new Node(rootKey);
    }

    public void add(int nodeKey) {
        addIteration(nodeKey, root);
    }

    private void addIteration(int nodeKey, Node currentNode) {
        if(nodeKey < currentNode.getKey()) {
            if(currentNode.getLeft() == null) {
                currentNode.setLeft(new Node(nodeKey));
            } else {
                addIteration(nodeKey, currentNode.getLeft());
            }
        } else {
            if(currentNode.getRight() == null) {
                currentNode.setRight(new Node(nodeKey));
            } else {
                addIteration(nodeKey, currentNode.getRight());
            }
        }
    }

    public void remove(int nodeKey) {
        removeIteration(nodeKey, root, null);
    }

    private void removeIteration(int nodeKey, Node currentNode, Node parentNode) {
        if(currentNode == null) {
            return;
        }

        if(nodeKey == currentNode.getKey()) {
            if(currentNode.getRight() != null) {
                Node rightSubtreeMinimum = currentNode.getRight();
                Node parentSubtreeMinimum = currentNode;
                while(rightSubtreeMinimum.getLeft() != null) {
                    parentSubtreeMinimum = rightSubtreeMinimum;
                    rightSubtreeMinimum = rightSubtreeMinimum.getLeft();
                }
                parentSubtreeMinimum.setLeft(rightSubtreeMinimum.getRight());
                rightSubtreeMinimum.setRight(currentNode.getRight());
                rightSubtreeMinimum.setLeft(currentNode.getLeft());
                if(parentNode != null) {
                    if(rightSubtreeMinimum.getKey() < parentNode.getKey()) {
                        parentNode.setLeft(rightSubtreeMinimum);
                    } else {
                        parentNode.setRight(rightSubtreeMinimum);
                    }
                } else {
                    root = rightSubtreeMinimum;
                }
            }
        } else if (nodeKey < currentNode.getKey()) {
            removeIteration(nodeKey, currentNode.getLeft(), currentNode);
        } else {
            removeIteration(nodeKey, currentNode.getRight(), currentNode);
        }
    }


    @Override
    public String toString() {
        return root.toString(new StringBuilder(), true, new StringBuilder()).toString();
    }
}
