import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

class FileReaderSingleton{
    private static FileReaderSingleton instance;
    private BufferedReader reader;
    private void openFile(){
        try {
            reader = new BufferedReader(new FileReader("data.txt"));
        } catch (FileNotFoundException  e) {
            e.printStackTrace();
        }
    }
    private FileReaderSingleton() {
        openFile();
    }
    public void closeFile(){
        try{
            if (this.reader != null); {
                this.reader.close();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static FileReaderSingleton getInstance(){
        if (instance == null) {
            instance = new FileReaderSingleton();
        }
        return instance;
    }
    public String readLineFromFile(){
        try{
            return this.reader.readLine();
        }
        catch (IOException e) {
            System.err.println("Cannot read line from file: "+e.getMessage());
            return null;
        }
    }

}



// Class A for reading from the file
class FileReaderClassA {
    FileReaderSingleton fileReader;
    public FileReaderClassA(FileReaderSingleton fileReader) {
        this.fileReader = fileReader;
    }
    public void readFileLine() {
        String line = fileReader.readLineFromFile();
        if (line != null) {
            System.out.println("FileReaderClassA: " + line);
        }
    }
}

// Class B for reading from the file
class FileReaderClassB {
    FileReaderSingleton fileReader;
    public FileReaderClassB(FileReaderSingleton fileReader) {
        this.fileReader = fileReader;
    }
    public void readFileLine() {
        String line = fileReader.readLineFromFile();
        if (line != null) {
            System.out.println("FileReaderClassB: " + line);
        }
    }
}

public class App {
    public static void main(String[] args) {
        FileReaderSingleton fileReader = FileReaderSingleton.getInstance();
        FileReaderClassA readerA = new FileReaderClassA(fileReader);
        FileReaderClassB readerB = new FileReaderClassB(fileReader);

        // Call the readFileLine() method on both instances
        readerA.readFileLine();
        readerB.readFileLine();
        readerB.readFileLine();
        fileReader.closeFile();
        readerA.readFileLine();
        readerB.readFileLine();

    }
}