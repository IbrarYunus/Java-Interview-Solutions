//package com.none;
//
//import java.util.ArrayList;
//import java.util.EmptyStackException;
//import java.util.Stack;
//
//public class SetOfStacks {
//    ArrayList<Stack> stacks = new ArrayList<Stack>();
//
//    public int capacity;
//
//    public SetOfStacks(int capacity) {
//        this.capacity = capacity;
//    }
//
//    public Stack getLastStack() {
//        if(stacks.size() == 0) return null;
//        return stacks.get(stacks.size() - 1);
//    }
//
//    public void push(int v) {
//        Stack last = getLastStack();
//
//        if(last != null && !last.isFull()) {
//            last.push(v);
//        } else {
//            Stack stack = new Stack();
//            stack.setSize(capacity);
//            stack.push(v);
//            stack.add(stack);
//        }
//    }
//
//    public int pop() {
//        Stack last = getLastStack();
//        if(last == null) throw  new EmptyStackException();
//        int v = (int)last.pop();
//        if(last.size() == 0) {
//            stacks.remove(stacks.size() - 1);
//        }
//        return v;
//    }
//
//    public boolean isEmpty(){
//        Stack last = getLastStack();
//        return last == null || last.isEmpty();
//    }
//
//    public int popAt(int index) {
//        return leftShift
//    }
//}
