import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Week8Task2 {
    /**
     * Null pointer exception.
     */
    public void nullPointerEx() throws NullPointerException {
        String a = null;
        System.out.println(a.length());
    }

    /**
     * Array Index Out Of Bounds Exception.
     */
    public void arrayIndexOutOfBoundsEx() throws ArrayIndexOutOfBoundsException {
        throw new ArrayIndexOutOfBoundsException();
    }

    /**
     * Arithmetic Exception.
     * @throws ArithmeticException a
     */
    public void arithmeticEx() throws ArithmeticException {
        int c = 5 / 0;
    }

    public void fileNotFoundEx() throws FileNotFoundException {
        FileReader read = new FileReader("123.txt");
    }

    public void ioEx() throws IOException {
        throw new IOException();
    }

    /**
     * Test null pointer ex.
     * @return string
     */
    public String nullPointerExTest() {
        try {
            nullPointerEx();
        } catch (NullPointerException e) {
            return "Lỗi Null Pointer";
        }
        return "Không có lỗi";
    }

    /**
     * Test array.
     * @return string
     */
    public String arrayIndexOutOfBoundsExTest() {
        try {
            arrayIndexOutOfBoundsEx();
        } catch (IndexOutOfBoundsException e) {
            return "Lỗi Array Index Out of Bounds";
        }
        return "Không có lỗi";
    }

    /**
     * Test arithmetic.
     * @return string a
     */
    public String arithmeticExTest() {
        try {
            arithmeticEx();
        } catch (ArithmeticException e) {
            return "Lỗi Arithmetic";
        }
        return "Không có lỗi";
    }

    /**
     * Test file not found.
     * @return string
     */
    public String fileNotFoundExTest() {
        try {
            fileNotFoundEx();
        } catch (FileNotFoundException e) {
            return "Lỗi File Not Found";
        }
        return "Không có lỗi";
    }

    /**
     * Test ioe.
     * @return string
     */
    public String ioExTest() {
        try {
            ioEx();
        } catch (IOException e) {
            return "Lỗi IO";
        }
        return "Không có lỗi";
    }
}
