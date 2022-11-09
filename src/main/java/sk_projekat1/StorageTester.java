package sk_projekat1;

import java.util.Scanner;

public class StorageTester {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        args = new String[1];
        args[0] = in.next();

        if (args[0] == null) {
            System.out.println("You have to insert the absolute path.");
            System.exit(0);
        }

        try {
           Class.forName("sk_projekat1.ImplementationLocal");
           //Class.forName("sk_projekat1.ImplementationDrive");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

//        String path = args[0];
        Storage st = StorageManager.getStorage();
//        st.createStorage("Storage", "/Users/adjenadic", 1000, "csv", 10);

        String menu1 = "Choose an option:" +
                "\n\t1. Create folder" +
                "\n\t2. Create file" +
                "\n\t3. Move file" +
                "\n\t4. Rename file object" +
                "\n\t5. Delete file object" +
                "\n\t6. Import file object" +
                "\n\t7. Export file object" +
                "\n\t8. Search files" +
                "\n\t9. Exit";

        if (StorageManager.existsStorage(args[0])) {
            System.out.println("Your storage exists.\n");
            try {
                while (true) {
                    String inLine = in.nextLine();
                    if (inLine.equalsIgnoreCase("1")) {
                        while (true) {
                            System.out.println("If you want to create a folder in the root directory, type '.'");
                            System.out.println("If you want to create subfolders, type '/' before the root directory and between directories.");
                            System.out.println("Enter the folder name and the path separated by a space.");
                            inLine = in.nextLine();
                            String[] inLineSplit = inLine.split(" ");

                            if (inLineSplit.length != 2) {
                                System.out.println("Invalid argument, try again.");
                                break;
                            }

                            System.out.println("Folder created successfully.");
                            st.createFolder(inLineSplit[0], inLineSplit[1]);
                            break;
                        }
                    } else if (inLine.equalsIgnoreCase("9")) {
                        System.exit(0);
                    }
                    System.out.println(menu1);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            // TODO
        }
    }
}