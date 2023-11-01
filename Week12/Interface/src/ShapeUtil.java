import java.util.List;

public class ShapeUtil {
    /**
     * Get info of the list.
     * @param shapes shapes list
     * @return info of shapes list
     */
    public String printInfo(List<GeometricObject> shapes) {
        String result = "";
        result += "Circle:\n";
        for (GeometricObject x: shapes) {
            if (x instanceof Circle) {
                result += x.getInfo();
                result += "\n";
            }
        }

        result += "Triangle:\n";
        for (GeometricObject x: shapes) {
            if (x instanceof Triangle) {
                result += x.getInfo();
                result += "\n";
            }
        }
        return result;
    }
}
