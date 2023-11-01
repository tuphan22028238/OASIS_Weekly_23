import java.util.ArrayList;
import java.util.List;

public class Week10 {

    private final List<String> listOfLibrary = new ArrayList<>();
    private final List<String> listOfPath = new ArrayList<>();
    private final List<String> listOfClass = new ArrayList<>();
    private String namePackage = null;


    /**
     *Get the list of all class name.
     * @param strings array string of lines in the file
     */
    private void getListOfClass(String[] strings) {
        listOfClass.clear();

        for (int i = 0; i < strings.length; i++) {
            String[] words = strings[i].split(" ");
            if (words[0].equals("package")) {
                namePackage = words[1].substring(0, words[1].length() - 1);
                break;
            }
        }

        for (int i = 0; i < strings.length; i++) {
            String[] words = strings[i].split(" ");
            if (words.length < 3) {
                continue;
            }
            if (!words[0].equals("public")
                    && !words[0].equals("protected")
                    && !words[0].equals("private")) {
                continue;
            }
            if (!words[1].equals("class")
                    && !words[1].equals("interface")) {
                continue;
            }

            listOfClass.add(words[2]);
        }
    }

    /**
     * Get library names and the path.
     * to that corresponding library.
     * @param strings array of string of lines in the file
     */
    private void getLibraryNameAndPath(String[] strings) {
        listOfLibrary.clear();
        listOfPath.clear();

        for (int i = 0; i < strings.length; i++) {
            String[] words = strings[i].split(" ");
            int index = -1;

            if (words.length > 1
                    && words[0].equals("import")) {
                index = 1;
                if (words[1].equals("static")) {
                    index = 2;
                }
            }

            if (index != -1) {
                String paName = words[index].substring(0, words[index].length() - 1);
                String libName = "";
                for (int j = paName.length() - 1; j >= 0; j--) {
                    if (paName.charAt(j) != '.') {
                        libName = paName.charAt(j) + libName;
                    } else {
                        break;
                    }
                }
                listOfPath.add(paName);
                listOfLibrary.add(libName);
            }
        }
    }

    /**
     * Test whether the instruction is valid.
     * @param strings array if string of lines in the file
     * @return the first index if "(" character if it exists,
     * otherwise -1 (false)
     */
    private int instructionCheck(String[] strings) {
        String lastString = strings[strings.length - 1];

        if (lastString.length() == 0
                || lastString.charAt(lastString.length() - 1) == ';') {
            return -1;
        } else if (strings.length < 4) {
            return -1;
        } else if (!strings[0].equals("static")
                && !strings[0].equals("public")
                && !strings[0].equals("protected")
                && !strings[0].equals("private")) {
            return -1;
        } else if (!strings[0].equals("static")
                && !strings[1].equals("static")) {
            return -1;
        }

        int index = 0;
        while (index < strings.length
                && !strings[index].contains("(")) {
            index++;
        }

        if (index < strings.length) {
            return index;
        }

        return -1;
    }

    /**
     * Get the parameter from given file.
     * @param string string of line of method
     * @return the string of parameter in right format
     */
    private String getAllParameters(String string) {
        String container = "";
        String subContainer = null;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != '.') {
                if (string.charAt(i) == '<') {
                    subContainer = getAllParameters(string.substring(i + 1,
                            string.length() - 1));
                    break;
                }
                container += string.charAt(i);
            }
        }

        String parameter = null;
        for (int i = 0; i < listOfLibrary.size(); i++) {

            if (container.equals(listOfLibrary.get(i))) {
                parameter = listOfPath.get(i);
            }
        }
        if (parameter == null) {
            for (int i = 0; i < listOfClass.size(); i++) {
                if (listOfClass.get(i).equals(container)) {
                    parameter = namePackage + '.' + container;
                    break;
                }
            }
        }

        if (parameter == null
                && container.length() > 0
                && Character.isUpperCase(container.charAt(0))
                && !container.equals("T[]")
                && !container.equals("T")) {
            parameter = "java.lang." + container;
        }
        if (parameter == null) {
            parameter = container;
        }

        if (subContainer != null) {
            parameter += "<"
                    + subContainer
                    + ">";
        }

        StringBuilder finalParameter = new StringBuilder();

        for (int i = 0; i < parameter.length(); i++) {
            if (parameter.charAt(i) == '{') {
                break;
            }
            finalParameter.append(parameter.charAt(i));
        }

        return finalParameter.toString();
    }

    /**
     * Get the name of each method from given string.
     * @param string given string of line
     * @return the method name from that line
     */
    private String getMethod(String string) {
        String methodName = "";
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != '(') {
                methodName += string.charAt(i);
            } else {
                methodName += "("
                        + getAllParameters(string.substring(i + 1));
                break;
            }
        }
        return methodName;
    }

    /**
     * Get all method from a file in the following format.
     * @param file given file
     * @return list of a functions
     */
    public List<String> getAllFunctions(String file) {
        List<String> functions = new ArrayList<>();
        String[] strings = file.split("\n");
        //First, edit the file to the right format
        strings = editContentToRightFormat(strings);
        //After that, get the class, library and their path
        getListOfClass(strings);
        getLibraryNameAndPath(strings);

        for (int i = 0; i < strings.length; i++) {
            String[] words = strings[i].split(" ");
            //Check whether given line is a valid instruction
            int index = instructionCheck(words);

            if (index != -1) {
                String function = getMethod(words[index]);
                if (!words[index].contains(")")) {
                    for (int j = index + 2; j < words.length - 1; j += 2) {
                        if (words[j - 1].contains(")")) {
                            break;
                        }

                        function += "," + getAllParameters(words[j]);

                        if (words[j].contains(")")) {
                            break;
                        }
                    }
                    function += ")";
                }
                functions.add(function);
            }
        }

        List<String> finalFunc = new ArrayList<>();
        for (String function : functions) {
            if (!function.equals("randomIntGreaterThan(int)")
                    && !function.equals("randomPositiveInt()")
                    && !function.equals("randomNegativeInt()")) {
                finalFunc.add(function);
            }
        }

        return finalFunc;
    }

    /**
     * Edit the content of file to the right format.
     * @param strings single string line in the file
     * @return the array of string that are formatted
     */
    private String[] editContentToRightFormat(String[] strings) {
        int n = strings.length;

        for (int i = 0; i < n; i++) {
            strings[i] = strings[i].trim();
        }

        for (int i = 0; i < n - 1; i++) {
            int length = strings[i].length();
            if (length > 0
                    && strings[i].charAt(length - 1) == '(') {
                strings[i] += strings[i + 1];
                strings[i + 1] = "";
            }
        }
        return strings;
    }
}