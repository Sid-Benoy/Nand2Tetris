import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class translator {
    public static void main(String[] args) throws IOException {
        Parser parser = new Parser("Nand2Tetris/projects/07/simpleadd.vm");
        CodeWriter codeWriter = new CodeWriter("Nand2Tetris/projects/07/output.asm", "Nand2Tetris/projects/07/simpleadd.vm");
        int iteration = 0;
        while (true) {
            String line = parser.advance();
            if (line == null) {
                break;
            }
            String ctype = parser.commandType(line);
            String arg1 = "";
            int arg2 = 0;
            if (!ctype.equals("C_RETURN"))
            {
                arg1 = parser.arg1(line);
            }
            if (ctype.equals("C_PUSH") || ctype.equals("C_POP") || ctype.equals("C_FUNCTION") || ctype.equals("C_CALL"))
            {
                arg2 = parser.arg2(line);
            }

            if (ctype.equals("C_ARITHMETIC")) {
                codeWriter.writeArithmetic(arg1, iteration);
            }
            else {
                codeWriter.writePushPop(ctype, arg1, arg2);
            }
            iteration += 1;
        }
        codeWriter.close();
    }
}



