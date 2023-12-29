package org.advent.dayeight;

public class Node {

    public Node(int index, String adress, String leftPointer, String rightPointer) {
        this.index = index;
        this.address = adress;
        this.leftPointer = leftPointer;
        this.rightPointer = rightPointer;
    }

    int index;
    String address;
    String leftPointer;
    String rightPointer;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLeftPointer() {
        return leftPointer;
    }

    public void setLeftPointer(String leftPointer) {
        this.leftPointer = leftPointer;
    }

    public String getRightPointer() {
        return rightPointer;
    }

    public void setRightPointer(String rightPointer) {
        this.rightPointer = rightPointer;
    }
}
