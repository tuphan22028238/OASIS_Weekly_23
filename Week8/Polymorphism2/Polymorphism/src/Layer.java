import java.util.ArrayList;
import java.util.List;

public class Layer {
    private List<Shape> shapes = new ArrayList<>();

    /**
     * Add shape.
     */
    public void addShape(Shape shape) {
        if (shape != null) {
            shapes.add(shape);
        }
    }
    
    public void removeCircles() {
        shapes.removeIf(shape -> (shape instanceof Circle));
    }

    /**
     * Info.
     * @return info
     */
    public String getInfo() {
        String s = "Layer of crazy shapes:";
        for (Shape shape : shapes) {
            s += "\n" + shape.toString();
        }
        return s;
    }

    /**
     * Remove duplicate.
     */
    public void removeDuplicates() {
        for (int i = 0; i < shapes.size(); i++) {
            Shape newShape = shapes.get(i);
            for (int j = 0; j < shapes.size(); j++) {
                if (shapes.get(j).equals(newShape)) {
                    shapes.remove(j);
                }
            }
            shapes.add(i, newShape);
        }
    }
}
