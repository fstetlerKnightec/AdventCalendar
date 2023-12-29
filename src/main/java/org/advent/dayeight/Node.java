package org.advent.dayeight;

public class Node {

    public Node(int index, String guideAddress, String leftAddress, String rightAddress) {
        this.index = index;
        this.guideAddress = guideAddress;
        this.leftAddress = leftAddress;
        this.rightAddress = rightAddress;
    }

    int index;
    String guideAddress;
    String leftAddress;
    String rightAddress;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getGuideAddress() {
        return guideAddress;
    }

    public void setGuideAddress(String guideAddress) {
        this.guideAddress = guideAddress;
    }

    public String getLeftAddress() {
        return leftAddress;
    }

    public void setLeftAddress(String leftAddress) {
        this.leftAddress = leftAddress;
    }

    public String getRightAddress() {
        return rightAddress;
    }

    public void setRightAddress(String rightAddress) {
        this.rightAddress = rightAddress;
    }
}
