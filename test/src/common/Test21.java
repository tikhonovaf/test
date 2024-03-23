package common;

public class Test21 {
}


class Rectangle {

    private int width;
    private int height;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

class Square extends Rectangle {

    public void setSize(int size) {
        super.setWidth(size);
        super.setHeight(size);
    }
}