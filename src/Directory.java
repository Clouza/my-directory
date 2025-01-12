import java.util.LinkedList;

public class Directory {
    private String nameDirectory;
    private LinkedList<Document> listOfDocument;

    public Directory(String nameDirectory) {
        this.nameDirectory = nameDirectory;
        this.listOfDocument = new LinkedList<>();
    }

    public String getNameDirectory() {
        return nameDirectory;
    }

    public void setNameDirectory(String nameDirectory) {
        this.nameDirectory = nameDirectory;
    }

    public LinkedList<Document> getListOfDocument() {
        return listOfDocument;
    }

    public void addDocument(Document document) {
        listOfDocument.add(document);
    }

    @Override
    public String toString() {
        return "Directory: " + nameDirectory;
    }
}
