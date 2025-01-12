import java.util.LinkedList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

public class MyDirectory {
    private String nameMyDirectory;
    private LinkedList<Directory> listOfDirectory;
    private Scanner scanner;

    public MyDirectory(String nameMyDirectory) {
        this.nameMyDirectory = nameMyDirectory;
        this.listOfDirectory = new LinkedList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addDirectory() {
        System.out.print("Enter directory name: ");
        String dirName = scanner.nextLine();
        listOfDirectory.add(new Directory(dirName));
        System.out.println("Directory added successfully!");
    }

    public void addDocument() {
        if (listOfDirectory.isEmpty()) {
            System.out.println("No directories exist. Please create a directory first.");
            return;
        }

        System.out.println("Available directories:");
        for (int i = 0; i < listOfDirectory.size(); i++) {
            System.out.println(i + ". " + listOfDirectory.get(i).getNameDirectory());
        }

        System.out.print("Select directory number: ");
        int dirIndex = Integer.parseInt(scanner.nextLine());

        if (dirIndex >= 0 && dirIndex < listOfDirectory.size()) {
            System.out.print("Enter document name: ");
            String docName = scanner.nextLine();
            listOfDirectory.get(dirIndex).addDocument(new Document(docName));
            System.out.println("Document added successfully!");
        } else {
            System.out.println("Invalid directory number!");
        }
    }

    public void sortDirectoryByName() {
        Collections.sort(listOfDirectory, new Comparator<Directory>() {
            @Override
            public int compare(Directory d1, Directory d2) {
                return d1.getNameDirectory().compareToIgnoreCase(d2.getNameDirectory());
            }
        });
        System.out.println("Directories sorted successfully!");
    }

    public void findItem() {
        System.out.print("Enter name to search: ");
        String searchName = scanner.nextLine().toLowerCase();
        boolean found = false;

        // Search in directories
        for (Directory dir : listOfDirectory) {
            if (dir.getNameDirectory().toLowerCase().contains(searchName)) {
                System.out.println("Found Directory: " + dir.getNameDirectory());
                found = true;
            }
            // Search in documents
            for (Document doc : dir.getListOfDocument()) {
                if (doc.getNameDocument().toLowerCase().contains(searchName)) {
                    System.out.println("Found Document: " + doc.getNameDocument() +
                            " in Directory: " + dir.getNameDirectory());
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No matching items found.");
        }
    }

    public void displayAll() {
        if (listOfDirectory.isEmpty()) {
            System.out.println("No directories exist.");
            return;
        }

        System.out.println("\nDirectory Structure:");
        System.out.println("Root: " + nameMyDirectory);
        for (Directory dir : listOfDirectory) {
            System.out.println("└── " + dir.getNameDirectory());
            for (Document doc : dir.getListOfDocument()) {
                System.out.println("    └── " + doc.getNameDocument());
            }
        }
    }

    public void run() {
        while (true) {
            System.out.println("\n=== MyDirectory Menu ===");
            System.out.println("1. Add directory");
            System.out.println("2. Add document");
            System.out.println("3. Sort directory by name");
            System.out.println("4. Find a directory/document");
            System.out.println("5. Display directory and document");
            System.out.println("6. Exit");
            System.out.print("Choose option (1-6): ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addDirectory();
                    break;
                case "2":
                    addDocument();
                    break;
                case "3":
                    sortDirectoryByName();
                    break;
                case "4":
                    findItem();
                    break;
                case "5":
                    displayAll();
                    break;
                case "6":
                    System.out.println("Thank you for using MyDirectory!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option! Please choose 1-6.");
            }
        }
    }
}