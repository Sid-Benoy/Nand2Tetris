import java.nio.file.Files;
import java.nio.file.Path;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class Parser {
    File file;
    Path filePath;
    BufferedReader reader;
    public Parser(String fileName) throws IOException {
        this.file = new File(fileName);
        this.filePath = file.toPath();
        reader = Files.newBufferedReader(filePath); 
    }

    public String hasMoreLines() throws IOException {
        String line;
        while((line = reader.readLine()) != null) {
            if (line.trim().isEmpty())
                continue;
            if (line.charAt(0) == '/' || line.isEmpty() || line.charAt(0) == '\n' || line.charAt(0) == '\r') {
                continue;
            }
            return line; 
        }
        return null;
        
    }

    public String advance() throws IOException {
        String line = hasMoreLines();
        if (line == null) {
            return null;
        }
        return line;
    }

    public String commandType(String line) {
        String[] split = line.split(" ");
        if (split[0].equals("push"))
            return "C_PUSH";
        else if (split[0].equals("pop"))
            return "C_POP";
        else if (split[0].equals("label"))
            return "C_LABEL";
        else if (split[0].equals("goto"))
            return "C_GOTO";
        else if (split[0].equals("if-goto"))
            return "C_IF";
        else if (split[0].equals("function"))
            return "C_FUNCTION";
        else if (split[0].equals("return"))
            return "C_RETURN";
        else if (split[0].equals("call"))
            return "C_CALL";
        else
            return "C_ARITHMETIC";
    }


    public String arg1(String line) {
        String[] split = line.split(" ");
        if (commandType(line).equals("C_ARITHMETIC")){
            return split[0];
        }
        else{
            return split[1];
        }
    }

    public int arg2(String line) {
        String[] split = line.split(" ");
        return Integer.parseInt(split[2]);
    }

}

