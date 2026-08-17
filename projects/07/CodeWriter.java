import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class CodeWriter {
    
    File outputFile;
    FileWriter writer;
    String inputFile;
    public CodeWriter(String fileName, String inputFile) throws IOException {
        outputFile = new File(fileName);
        writer = new FileWriter(outputFile, true);
        this.inputFile = inputFile;

    }

    public void writeArithmetic(String command, int iteration) throws IOException {
        if (command.equals("add")) {
            writer.write("@SP\n");
            writer.write("M=M-1\n");
            writer.write("A=M\n");
            writer.write("D=M\n");
            writer.write("@X\n");
            writer.write("M=D\n");
            writer.write("@SP\n");
            writer.write("M=M-1\n");
            writer.write("A=M\n");
            writer.write("D=M\n");
            writer.write("@X\n");
            writer.write("D=D+M\n");
            writer.write("@SP\n");
            writer.write("A=M\n");
            writer.write("M=D\n");
            writer.write("@SP\n");
            writer.write("M=M+1\n");
        }
        else if (command.equals("sub")) {
            writer.write("@SP\n");
            writer.write("M=M-1\n");
            writer.write("A=M\n");
            writer.write("D=M\n");
            writer.write("@X\n");
            writer.write("M=D\n");
            writer.write("@SP\n");
            writer.write("M=M-1\n");
            writer.write("A=M\n");
            writer.write("D=M\n");
            writer.write("@X\n");
            writer.write("D=D-M\n");
            writer.write("@SP\n");
            writer.write("A=M\n");
            writer.write("M=D\n");
            writer.write("@SP\n");
            writer.write("M=M+1\n");
        }
        else if (command.equals("neg")) {
            writer.write("@SP\n");
            writer.write("M=M-1\n");
            writer.write("A=M\n");
            writer.write("D=M\n");
            writer.write("@Y\n");
            writer.write("M=-D\n");
            writer.write("D=M\n");
            writer.write("@SP\n");
            writer.write("A=M\n");
            writer.write("M=D\n");
            writer.write("@SP\n");
            writer.write("M=M+1\n");
        }
        else if (command.equals("eq")) {
            writer.write("@SP\n");
            writer.write("M=M-1\n");
            writer.write("A=M\n");
            writer.write("D=M\n");
            writer.write("@X\n");
            writer.write("M=D\n");
            writer.write("@SP\n");
            writer.write("M=M-1\n");
            writer.write("A=M\n");
            writer.write("D=M\n");
            writer.write("@X\n");
            writer.write("D=D-M\n");
            writer.write("@EQ_TRUE" + iteration + "\n");
            writer.write("D;JEQ\n");
            writer.write("@SP\n");
            writer.write("A=M\n");
            writer.write("M=0\n");
            writer.write("@EQ_END" + iteration + "\n");
            writer.write("0;JMP\n");
            writer.write("(EQ_TRUE" + iteration + ")\n");
            writer.write("@SP\n");
            writer.write("A=M\n");
            writer.write("M=-1\n");
            writer.write("(EQ_END" + iteration + ")\n");
            writer.write("@SP\n");
            writer.write("M=M+1\n");
        }
        else if (command.equals("gt")) {
            writer.write("@SP\n");
            writer.write("M=M-1\n");
            writer.write("A=M\n");
            writer.write("D=M\n");
            writer.write("@X\n");
            writer.write("M=D\n");
            writer.write("@SP\n");
            writer.write("M=M-1\n");
            writer.write("A=M\n");
            writer.write("D=M\n");
            writer.write("@X\n");
            writer.write("D=D-M\n");
            writer.write("@GT_TRUE" + iteration + "\n");
            writer.write("D;JGT\n");
            writer.write("@SP\n");
            writer.write("A=M\n");
            writer.write("M=0\n");
            writer.write("@GT_END" + iteration + "\n");
            writer.write("0;JMP\n");
            writer.write("(GT_TRUE" + iteration + ")\n");
            writer.write("@SP\n");
            writer.write("A=M\n");
            writer.write("M=-1\n");
            writer.write("(GT_END" + iteration + ")\n");
            writer.write("@SP\n");
            writer.write("M=M+1\n");
        }
        else if (command.equals("lt")) {
            writer.write("@SP\n");
            writer.write("M=M-1\n");
            writer.write("A=M\n");
            writer.write("D=M\n");
            writer.write("@X\n");
            writer.write("M=D\n");
            writer.write("@SP\n");
            writer.write("M=M-1\n");
            writer.write("A=M\n");
            writer.write("D=M\n");
            writer.write("@X\n");
            writer.write("D=D-M\n");
            writer.write("@LT_TRUE" + iteration + "\n");
            writer.write("D;JLT\n");
            writer.write("@SP\n");
            writer.write("A=M\n");
            writer.write("M=0\n");
            writer.write("@LT_END" + iteration + "\n");
            writer.write("0;JMP\n");
            writer.write("(LT_TRUE" + iteration + ")\n");
            writer.write("@SP\n");
            writer.write("A=M\n");
            writer.write("M=-1\n");
            writer.write("(LT_END" + iteration + ")\n");
            writer.write("@SP\n");
            writer.write("M=M+1\n");
        }
        else if (command.equals("and")) {
            writer.write("@SP\n");
            writer.write("M=M-1\n");
            writer.write("A=M\n");
            writer.write("D=M\n");
            writer.write("@X\n");
            writer.write("M=D\n");
            writer.write("@SP\n");
            writer.write("M=M-1\n");
            writer.write("A=M\n");
            writer.write("D=M\n");
            writer.write("@X\n");
            writer.write("D=D&M\n");
            writer.write("@SP\n");
            writer.write("A=M\n");
            writer.write("M=D\n");
            writer.write("@SP\n");
            writer.write("M=M+1\n");
        }
        else if (command.equals("or")) {
            writer.write("@SP\n");
            writer.write("M=M-1\n");
            writer.write("A=M\n");
            writer.write("D=M\n");
            writer.write("@X\n");
            writer.write("M=D\n");
            writer.write("@SP\n");
            writer.write("M=M-1\n");
            writer.write("A=M\n");
            writer.write("D=M\n");
            writer.write("@X\n");
            writer.write("D=D|M\n");
            writer.write("@SP\n");
            writer.write("A=M\n");
            writer.write("M=D\n");
            writer.write("@SP\n");
            writer.write("M=M+1\n");
        }
        else if (command.equals("not")) {
            writer.write("@SP\n");
            writer.write("M=M-1\n");
            writer.write("A=M\n");
            writer.write("D=M\n");
            writer.write("@X\n");
            writer.write("M=!D\n");
            writer.write("D=M\n");
            writer.write("@SP\n");
            writer.write("A=M\n");
            writer.write("M=D\n");
            writer.write("@SP\n");
            writer.write("M=M+1\n");
        }
        writer.flush();

    }

    public void writePushPop(String command, String segment, int index) throws IOException {
        if (segment.equals("constant")) {
            writer.write("@" + index + "\n");
            writer.write("D=A\n");
            writer.write("@SP\n");
            writer.write("A=M\n");
            writer.write("M=D\n");
            writer.write("@SP\n");
            writer.write("M=M+1\n");

        }
        else if (segment.equals("local") && command.equals("C_POP")) {
            writer.write("@" + index + "\n");
            writer.write("D=A\n");
            writer.write("@LCL\n");
            writer.write("A=D+M\n");
            writer.write("D=A\n");
            writer.write("@addr\n");
            writer.write("M=D\n");
            writer.write("@SP\n");
            writer.write("M=M-1\n");
            writer.write("A=M\n");
            writer.write("D=M\n");
            writer.write("@addr\n");
            writer.write("A=M\n");
            writer.write("M=D\n");
        }
        else if (segment.equals("local") && command.equals("C_PUSH")) {
    
            writer.write("@" + index + "\n");
            writer.write("D=A\n");
            writer.write("@LCL\n");
            writer.write("A=D+M\n");
            writer.write("D=M\n");
            writer.write("@SP\n");
            writer.write("A=M\n");
            writer.write("M=D\n");
            writer.write("@SP\n");
            writer.write("M=M+1\n");

        }
        else if (segment.equals("temp") && command.equals("C_POP")) {
            writer.write("@" + index + "\n");
            writer.write("D=A\n");
            writer.write("@5\n");
            writer.write("D=D+A\n");
            writer.write("@addr\n");
            writer.write("M=D\n");
            writer.write("@SP\n");
            writer.write("M=M-1\n");
            writer.write("A=M\n");
            writer.write("D=M\n");
            writer.write("@addr\n");
            writer.write("A=M\n");
            writer.write("M=D\n");

        }
        else if (segment.equals("temp") && command.equals("C_PUSH")) {
      
            writer.write("@" + index + "\n");
            writer.write("D=A\n");
            writer.write("@5\n");
            writer.write("A=D+A\n");
            writer.write("D=M\n");
            writer.write("@SP\n");
            writer.write("A=M\n");
            writer.write("M=D\n");
            writer.write("@SP\n");
            writer.write("M=M+1\n");
            
        }
        else if (segment.equals("argument") && command.equals("C_POP")) {
            writer.write("@" + index + "\n");
            writer.write("D=A\n");
            writer.write("@ARG\n");
            writer.write("A=D+M\n");
            writer.write("D=A\n");
            writer.write("@addr\n");
            writer.write("M=D\n");
            writer.write("@SP\n");
            writer.write("M=M-1\n");
            writer.write("A=M\n");
            writer.write("D=M\n");
            writer.write("@addr\n");
            writer.write("A=M\n");
            writer.write("M=D\n");

        }
        else if (segment.equals("argument") && command.equals("C_PUSH")) {
    
            writer.write("@" + index + "\n");
            writer.write("D=A\n");
            writer.write("@ARG\n");
            writer.write("A=D+M\n");
            writer.write("D=M\n");
            writer.write("@SP\n");
            writer.write("A=M\n");
            writer.write("M=D\n");
            writer.write("@SP\n");
            writer.write("M=M+1\n");
        }
        else if (segment.equals("this") && command.equals("C_PUSH")) {
            writer.write("@" + index + "\n");
            writer.write("D=A\n");
            writer.write("@THIS\n");
            writer.write("A=D+M\n");
            writer.write("D=M\n");
            writer.write("@SP\n");
            writer.write("A=M\n");
            writer.write("M=D\n");
            writer.write("@SP\n");
            writer.write("M=M+1\n");
        }
        else if (segment.equals("this") && command.equals("C_POP")) {
            writer.write("@" + index + "\n");
            writer.write("D=A\n");
            writer.write("@THIS\n");
            writer.write("A=D+M\n");
            writer.write("D=A\n");
            writer.write("@addr\n");
            writer.write("M=D\n");
            writer.write("@SP\n");
            writer.write("M=M-1\n");
            writer.write("A=M\n");
            writer.write("D=M\n");
            writer.write("@addr\n");
            writer.write("A=M\n");
            writer.write("M=D\n");

        }
        else if (segment.equals("that") && command.equals("C_PUSH")) {
            writer.write("@" + index + "\n");
            writer.write("D=A\n");
            writer.write("@THAT\n");
            writer.write("A=D+M\n");
            writer.write("D=M\n");
            writer.write("@SP\n");
            writer.write("A=M\n");
            writer.write("M=D\n");
            writer.write("@SP\n");
            writer.write("M=M+1\n");
        }
        else if (segment.equals("that") && command.equals("C_POP")) {
            writer.write("@" + index + "\n");
            writer.write("D=A\n");
            writer.write("@THAT\n");
            writer.write("A=D+M\n");
            writer.write("D=A\n");
            writer.write("@addr\n");
            writer.write("M=D\n");
            writer.write("@SP\n");
            writer.write("M=M-1\n");
            writer.write("A=M\n");
            writer.write("D=M\n");
            writer.write("@addr\n");
            writer.write("A=M\n");
            writer.write("M=D\n");

        }
        else if (segment.equals("static") && command.equals("C_PUSH")) {
            String staticVarName = inputFile.substring(24, inputFile.lastIndexOf('.'));
            writer.write("@" + staticVarName + "." + index + "\n");
            writer.write("D=M\n");
            writer.write("@SP\n");
            writer.write("A=M\n");
            writer.write("M=D\n");
            writer.write("M=M+1\n");
        }
        else if (segment.equals("static") && command.equals("C_POP")) {
            String staticVarName = inputFile.substring(24, inputFile.lastIndexOf('.'));
            writer.write("@SP\n");
            writer.write("M=M-1\n");
            writer.write("A=M\n");
            writer.write("D=M\n");
            writer.write("@" + staticVarName + "." + index + "\n");
            writer.write("M=D\n");

        }
        else if (segment.equals("pointer") && command.equals("C_PUSH") && index == 0) {
            writer.write("@" + "THIS" + "\n");
            writer.write("D=M\n");
            writer.write("@SP\n");
            writer.write("A=M\n");
            writer.write("M=D\n");
            writer.write("@SP\n");
            writer.write("M=M+1\n");
        }
        else if (segment.equals("pointer") && command.equals("C_POP") && index == 0) {
            writer.write("@SP\n");
            writer.write("M=M-1\n");
            writer.write("A=M\n");
            writer.write("D=M\n");
            writer.write("@" + "THIS" + "\n");
            writer.write("M=D\n");
        }
        else if (segment.equals("pointer") && command.equals("C_PUSH") && index == 1) {
            writer.write("@" + "THAT" + "\n");
            writer.write("D=M\n");
            writer.write("@SP\n");
            writer.write("A=M\n");
            writer.write("M=D\n");
            writer.write("@SP\n");
            writer.write("M=M+1\n");
        }
        else if (segment.equals("pointer") && command.equals("C_POP") && index == 1) {
            writer.write("@SP\n");
            writer.write("M=M-1\n");
            writer.write("A=M\n");
            writer.write("D=M\n");
            writer.write("@" + "THAT" + "\n");
            writer.write("M=D\n");
        }
        writer.flush();
    }

    public void close() throws IOException {
        writer.write("(END)\n");
        writer.write("@END\n");
        writer.write("0;JMP\n");
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
