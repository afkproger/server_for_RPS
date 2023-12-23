package ru.technolog.sorting_algorithms_server.calcs.sorting;

import java.util.Objects;

public class Node<T extends Comparable<T>> {
    public Node() {
    } // конструктор по умолчанию

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(data, node.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    private final int ZEROFORCOMPAREVALUES = 0; // ноль для сравнений в компараторе
    private T data; // данные в узле
    private Node<T> left; // левый потомок
    private Node<T> right; // правый потомок


    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public void addNewNode(T value) {
        Node<T> node = new Node<>(value);

        if (node.data.compareTo(data) < ZEROFORCOMPAREVALUES) {
            if (left == null) {
                left = node;
            } else {
                left.addNewNode(value);
            }
        } else {
            if (right == null) {
                right = node;
            } else {
                right.addNewNode(value);
            }
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
