package com.lab1.tree;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.util.ArrayList;
import java.util.Scanner;

public class Tree {
    private static Scanner in;
    private  static  BinaryTree tree = new BinaryTree();

    public static void main(String[] args){
        in=new Scanner(System.in);

        while(true){
            System.out.println("Введите команду");
            System.out.println("add для добавления");
            System.out.println("delete для удаления по номеру");
            System.out.println("find для поиска");
            System.out.println("output для вывода");
            System.out.println("height для вывода высоты дерева");
            System.out.println("sortmas для сортировки массива");
            System.out.println("balans для балансирови дерева");
            String command="";
            command=in.nextLine();
            switch (command){
                case "add":
                    add();
                    break;
                case "delete":
                    if(!tree.isEmpty()) delete();
                    else System.out.println("Дерево не содержит элементов");
                    break;
                case "find":
                    Object[] temp=tree.toArray();
                    if(temp.length==0){
                        System.out.println("Дерево не содержит элементов");
                        break;
                    }
                    int indEl;
                    while (true){
                        System.out.println("Введите индекс элемента");
                        try {
                            indEl=Integer.parseInt(in.nextLine());
                            if(indEl>0)break;
                        } catch (NumberFormatException e){
                            System.out.println("Некорректное число");
                        }
                    }
                    final int ind = indEl;
                    ArrayList<Node> node=new ArrayList<Node>();
                    for(int i=0;i<temp.length;i++){
                        node.add((Node)temp[i]);
                    }
                    node.forEach((Node n) -> {
                        if (n.getNumber()==ind){
                            System.out.println(n);
                        }
                    });
                    break;
                case "output":
                    Object[] string = tree.output();
                    for (Object s : string) {
                        System.out.println(s);
                    }
                    break;
                case "height":
                    System.out.println(tree.height());
                    break;
                case "sortmas":
                    sortMas();
                    break;
                case "balans":
                    balance();
                    break;
                default:
                    System.out.println("Команда не распознана. Повторите ввод");
                    break;
            }
            System.out.println("");
        }
    }

    private static void add(){
        int index;
        while (true) {
            System.out.println("Введите индекс числа: ");
            String temp=in.nextLine();
            try {
                index=Integer.parseInt(temp);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Некорректное число");
            }
        }
        Node n=new Node(index);
        tree.add(n);
    }

    private static void delete(){
        int n=0;
        while (true){
            System.out.println("Введите индекс элемента: ");
            try{
                n=Integer.parseInt(in.nextLine());
                System.out.println("Удален элемент " + tree.delete(n));
                break;
            } catch (NumberFormatException e){
                System.out.println("Некорректное число");
            } catch (NullPointerException e){
                System.out.println("Элемента с таким индексом не существует");
            }
        }
    }

    private static void sortMas(){
        System.out.println("Введите количество элементов в массиве:");
        int count;
        count=Integer.parseInt(in.nextLine());
        int[] mas=new int[count];
        System.out.println("Введите элементы: ");
        for(int i=0;i<count;i++)
            mas[i]=Integer.parseInt(in.next());
        BinaryTree masTree = new BinaryTree();
        for(int i=0;i<count;i++){
            masTree.add(new Node(mas[i]));
        }
        Object[] string = masTree.toArray();
        for (Object s : string) {
            System.out.println(s);
        }
    }

    private static void balance(){
        tree.balance();
        Object[] string = tree.output();
        for (Object s : string) {
            System.out.println(s);
        }
    }
}
