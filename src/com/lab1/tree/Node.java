package com.lab1.tree;

public class Node implements Comparable{
    private int index;
    public Node(int index){
        this.index=index;
    }

    public int nextNumber(){
        return this.index;
    }
    public int getNumber(){
        return index;
    }

    @Override
    public int CompareTo(Object o){
        Node newN=(Node) o;
        if(this.index>newN.index) return  1;
        else{
            if(this.index<newN.index) return -1;
            else{
                return 0;
            }
        }
    }
}
