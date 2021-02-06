package iowritebytes;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class StringToBytes {

    public void writeStringAsBytes(List<String> words, Path file){
        try(BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(Files.newOutputStream(file))){
            for (String word:words){
                if (!word.startsWith("_")){
                    bufferedOutputStream.write(word.getBytes());
                }
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("File is non-writeable!", ioException);
        }
    }

}
