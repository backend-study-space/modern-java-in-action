package CHAPTER3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteAroundPattern {

    public String processFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return br.readLine(); // 실제 작업 행
        }
    }

    @FunctionalInterface
    static interface BufferedReaderProcessor {
        String process(BufferedReader br) throws IOException;
    }

    public String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br); // 실제 작업 행
        }
    }

    public static void main(String[] args) throws IOException {
        ExecuteAroundPattern pattern = new ExecuteAroundPattern();

        pattern.processFile(br -> br.readLine() + br.readLine());
    }
}
