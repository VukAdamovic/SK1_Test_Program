package sk_projekat1;

public class StorageTester {
    public static void main(String[] args) {

        try {
           Class.forName("sk_projekat1.ImplementationLocal");
           //Class.forName("sk_projekat1.ImplementationDrive");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            String path = "D:/";
            Storage storage = StorageManager.getStorage(path);
            storage.createStorage("TestStorage",path,500,"csv,txt", 5);
            storage.createFolder("Folder1",".");
            storage.createFolder("Folder2",".");
           storage.createFolder("Folder3","/Folder2");
           storage.createFile("File1.txt","/Folder1");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

      //  if(StorageManager.existsStorage(path)){
            //lista operacija bez kreiranja storaga
            //System.out.println("Storage " + path + "  exists");

           // storage.createFolder("Folder1","");
        //}else{
          //  System.out.println("Storage " + path + " does not exists");
            //lista operacija samo za kreiranje sotaga

            //nako toga lista sa operacijama nad storigom
        //}

      //  storage.createStorage(path)
    }
}