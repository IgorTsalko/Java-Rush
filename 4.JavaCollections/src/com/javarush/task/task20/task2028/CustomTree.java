package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/*
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    Entry<String> root;

    public CustomTree() {
        this.root = new Entry<>("0");
    }

    @Override
    public boolean add(String s) {
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);
        Entry<String> newNode = new Entry<>(s);

        restoreOpportunityCanChild();
        while (!queue.isEmpty()) {
            Entry<String> currentNode = queue.poll();

            if (currentNode.isAvailableToAddChildren()) {
                if (currentNode.availableToAddLeftChildren) {
                    currentNode.leftChild = newNode;
                    currentNode.availableToAddLeftChildren = false;
                } else if (currentNode.availableToAddRightChildren) {
                    currentNode.rightChild = newNode;
                    currentNode.availableToAddRightChildren = false;
                }
                newNode.parent = currentNode;
                break;
            } else {

                if (currentNode.leftChild != null) {
                    queue.add(currentNode.leftChild);
                }

                if (currentNode.rightChild != null) {
                    queue.add(currentNode.rightChild);
                }
            }
        }
        return true;
    }

    private boolean canHaveChildren() {
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Entry<String> node = queue.remove();

            if (node.isAvailableToAddChildren()) {
                return true;
            }

            if (node.rightChild != null) {
                queue.add(node.rightChild);
            }

            if (node.leftChild != null) {
                queue.add(node.leftChild);
            }
        }

        return false;
    }

    private void restoreOpportunityCanChild() {
        if (!canHaveChildren()) {
            Queue<Entry<String>> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                Entry<String> node = queue.remove();

                if (!node.isAvailableToAddChildren()) {
                    if (node.leftChild == null) {
                        node.availableToAddLeftChildren = true;
                    }

                    if (node.rightChild == null) {
                        node.availableToAddRightChildren = true;
                    }
                }

                if (node.rightChild != null) {
                    queue.add(node.rightChild);
                }

                if (node.leftChild != null) {
                    queue.add(node.leftChild);
                }
            }
        }
    }

    @Override
    public int size() {
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);
        int count = -1;

        while (!queue.isEmpty()) {
            Entry<String> node = queue.remove();

            count++;

            if (node.rightChild != null) {
                queue.add(node.rightChild);
            }

            if (node.leftChild != null) {
                queue.add(node.leftChild);
            }
        }

        return count;
    }

    public String getParent(String s) {
        Entry<String> parent = null;

        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Entry<String> node = queue.remove();
            if (node.elementName.equals(s)) {
                parent = node.parent;
            } else {
                if (node.leftChild != null) {
                    queue.add(node.leftChild);
                }

                if (node.rightChild != null) {
                    queue.add(node.rightChild);
                }
            }
        }

        if (parent != null) {
            return parent.elementName;
        } else {
            return null;
        }
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        String str;
        try {
            str = (String) o;
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }

        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Entry<String> node = queue.remove();

            if (node.elementName.equals(str)) {
                if (node.parent != null) {
                    if (node.parent.leftChild != null &&
                            node.parent.leftChild.elementName.equals(str)) {
                        node.parent.leftChild = null;
                    } else {
                        node.parent.rightChild = null;
                    }
                }
                node.parent = null;

                removeAllLinks(node);
                break;
            } else {
                if (node.leftChild != null) {
                    queue.add(node.leftChild);
                }

                if (node.rightChild != null) {
                    queue.add(node.rightChild);
                }
            }
        }
        return true;
    }

    private void removeAllLinks(Entry<String> node) {
        if (node.rightChild != null) {
            removeAllLinks(node.leftChild);
        }

        if (node.rightChild != null) {
            removeAllLinks(node.rightChild);
        }
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    static class Entry<T> implements Serializable {

        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent;
        Entry<T> leftChild;
        Entry<T> rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }
}
