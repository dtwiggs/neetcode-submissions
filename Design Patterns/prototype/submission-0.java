interface Shape {
    Shape clone();
}

class Rectangle implements Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    @Override
    public Shape clone() {
        return new Rectangle(width, height);
        // Write your code here
    }
}

class Square implements Shape {
    private int length;

    public Square(int length) {
        this.length = length;
    }

    public int getLength() {
        return this.length;
    }

    @Override
    public Shape clone() {
        return new Square(length);
        // Write your code here
    }
}

class Test {
    public List<Shape> cloneShapes(List<Shape> shapes) {
        List<Shape> clonedShapes = new ArrayList<>(shapes.size());
        for(Shape curr : shapes){
            clonedShapes.add(curr.clone());
        }

        return clonedShapes;
        // Write your code here
    }
}