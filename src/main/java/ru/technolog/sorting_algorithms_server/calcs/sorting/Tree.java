package ru.technolog.sorting_algorithms_server.calcs.sorting;

import java.util.*;
public class Tree<T extends Comparable<T>>{

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tree<?> tree = (Tree<?>) o;
        return startTimer == tree.startTimer && countOfSortedElements == tree.countOfSortedElements && Objects.equals(toSaveDataAboutSorting, tree.toSaveDataAboutSorting) && Objects.equals(root, tree.root);
    }

    @Override
    public int hashCode() {
        return Objects.hash(toSaveDataAboutSorting, startTimer, countOfSortedElements, root);
    }

    /*Хранит данные о сортировке, где ключ - коли-во отсортированных элементов,
         а значение это время сортировки */
    private  Map<Integer , Long> toSaveDataAboutSorting = new HashMap<>();
    private  long startTimer = 0;
    private  int countOfSortedElements = 0; // количество отсортированных элементов в текущем листе

    public  Map<Integer, Long> getToSaveDataAboutSorting() {
        return toSaveDataAboutSorting;
    }

    private Node<T> root; // ссылка на корневой элемент дерева

    /* метод для создания дерева с помощью
    коллекции имплементирующей интерфейс*/
    public  Tree<T> toCreateTreeFromList(List<T> listForCreate){
        Tree<T> tree = new Tree<>();
        for (var value : listForCreate){
            tree.addElementToTree(value);
        }
        return tree;
    }
    /*Метод для добавления элементов в дерево */
    public void addElementToTree(T data){
        if (root == null){
            root = new Node<>(data);
            return;
        }
        // рекурсивный выход
        root.addNewNode(data);
    }

    /*Инфиксный обход дерева*/
    public List<T> inorder (){
        if (root == null){
            return new ArrayList<>();
        }
        startTimer = System.currentTimeMillis();
        return inorder(root);

    }

    /*Инфиксный обход - реализация*/
    private List<T> inorder(Node<T> node){
        List<T> list = new ArrayList<>();

        if(node != null){
            /*рекурсивно обходим дерево*/
            if(node.getLeft() != null){
                list.addAll(inorder(node.getLeft()));
            }

            list.add(node.getData());
            countOfSortedElements++;
            if(node.getRight() != null){
                list.addAll(inorder(node.getRight()));
            }
        }

        return list;

    }

    public List<T> toMakeInorder (){
        // Сброс данных перед новым обходом
        countOfSortedElements = 0;
        toSaveDataAboutSorting.clear();
        startTimer = System.nanoTime();  // Запуск таймера
        return inorderWithOutRecursion();
    }

    private List<T> inorderWithOutRecursion(){
        List<T> list = new ArrayList<>();
        Stack<Node<T>> stack = new Stack<>();
        Node<T> current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }
            current = stack.pop();
            // Замер времени при добавлении элемента
            list.add(current.getData());
            countOfSortedElements++;
            long endTime = System.nanoTime();
            long sortingTime = endTime - startTimer;
            toSaveDataAboutSorting.put(countOfSortedElements, sortingTime);

            current = current.getRight();
        }

        return list;
    }
}