package model;


public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;

    public Node<T> add(T value) {
        return root = addRecursive(root, value);
    }

    public boolean contains(T value) {
        return containsRecursive(root, value);
    }

    public Node<T> delete(T value) {
        return deleteRecursive(root, value);
    }

    public void walkFromRootThoughtAllTraverseTypes() {
        traverseInOrder(root);
        System.out.println("\n");
        traversePreOrder(root);
        System.out.println("\n");
        traversePostOrder(root);
        System.out.println("\n");
    }

    public void traverseInOrder(Node<T> node) {
        if (node != null) {
            traverseInOrder(node.getLeft());
            System.out.print(" " + node.getValue().toString());
            traverseInOrder(node.getRight());
        }
    }

    public void traversePreOrder(Node<T> node) {
        if (node != null) {
            System.out.print(" " + node.getValue());
            traversePreOrder(node.getLeft());
            traversePreOrder(node.getRight());
        }
    }

    public void traversePostOrder(Node<T> node) {
        if (node != null) {
            traversePostOrder(node.getLeft());
            traversePostOrder(node.getRight());
            System.out.print(" " + node.getValue().toString());
        }
    }

    private Node<T> deleteRecursive(Node<T> current, T value) {
        if (current == null || value == null) {
            return null;
        }

        if (current.getValue().compareTo(value) == 0) {
            // No children
            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            }
            // Only one child
            if (current.getRight() == null) {
                return current.getLeft();
            }
            if (current.getLeft() == null) {
                return current.getRight();
            }

            // Two children
            T smallestValue = getSmallestValue(current.getRight());
            current.setValue(smallestValue);
            current.setRight(deleteRecursive(current.getRight(), smallestValue));
            return current;
        }

        if (current.getValue().compareTo(value) > 0) {
            current.setLeft(deleteRecursive(current.getLeft(), value));
        }
        if (current.getValue().compareTo(value) < 0) {
            current.setRight(deleteRecursive(current.getRight(), value));
        }
        return current;
    }

    private T getSmallestValue(Node<T> node) {
        return node.getLeft() == null ? node.getValue() : getSmallestValue(node.getLeft());
    }

    private Node<T> addRecursive(Node<T> current, T value) {
        if (current == null) {
            return new Node<>(value);
        }

        if (current.getValue().compareTo(value) > 0) {
            current.setLeft(addRecursive(current.getLeft(), value));
        } else if (current.getValue().compareTo(value) < 0) {
            current.setRight(addRecursive(current.getRight(), value));
        }

        return current;
    }

    private boolean containsRecursive(Node<T> current, T value) {
        if (current == null || value == null) {
            return false;
        }

        if (current.getValue().compareTo(value) == 0) {
            return true;
        }

        if (current.getValue().compareTo(value) > 0) {
            return containsRecursive(current.getLeft(), value);
        }

        return containsRecursive(current.getRight(), value);
    }
}
