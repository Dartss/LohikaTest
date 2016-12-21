package FilesReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilesDataReaderImpl implements FilesDataReader
{
    @Override
    public String readFile(String filePath) {
        String textFromFile = "";
        try{
            textFromFile = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return textFromFile;
    }
}
