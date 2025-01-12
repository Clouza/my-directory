public class Document {
    private String nameDocument;

    public Document(String nameDocument) {
        this.nameDocument = nameDocument;
    }

    public String getNameDocument() {
        return nameDocument;
    }

    public void setNameDocument(String nameDocument) {
        this.nameDocument = nameDocument;
    }

    @Override
    public String toString() {
        return "Document: " + nameDocument;
    }
}