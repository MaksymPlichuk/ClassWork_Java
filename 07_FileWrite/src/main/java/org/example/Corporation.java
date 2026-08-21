package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import netscape.javascript.JSObject;

import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Corporation {
    private Map<String,Worker> db = new HashMap<>();
    Scanner scanner = new Scanner(System.in);
    private Path path;

    public void startProgram(){
        changeSavePath();
        loadFormFile();
        while (true) {
            System.out.println("[ 1 ] - Print Database\n[ 2 ] - Add Worker\n[ 3 ] - Edit Worker\n[ 4 ] - Delete Worker\n[ 5 ] - Search by Surname" +
                    "\n[ 6 ] - Find by Age\n[ 7 ] - Filter by Surname\n[ 8 ] - Change Save Path\n[ 0 ] - Exit");

            System.out.print("\nEnter choice: ");
            //scanner.nextInt() залищає \n після себе
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> showAll();
                case 2 -> {
                    createWorker();
                    saveToFile();
                }
                case 3 -> {
                    editWorker();
                    saveToFile();
                }
                case 4 -> {
                    deleteWorker();
                    saveToFile();
                }
                case 5 -> findBySurname();
                case 6 -> filterByAge();
                case 7 -> filterBySurname();
                case 8 -> changeSavePath();
                case 0 -> {
                    saveToFile();
                    return; }
                default -> System.out.println("Wrong choice");
            }
        }
    }



    private void createWorker(){
        System.out.print("\nEnter worker surname: ");
        String surname = scanner.nextLine();

        if (db.containsKey(surname)) {
            System.out.println("Worker with this surname exists! Can't add");
            return;
        }

        System.out.print("\nEnter worker name: ");
        String name = scanner.nextLine();

        System.out.print("\nEnter worker age: ");
        int age =  Integer.parseInt(scanner.nextLine());

        db.put(surname,new Worker(name,surname,age));
        System.out.print("\nWorker was added");
    }

    private void editWorker(){
        System.out.print("\nEnter worker's surname to edit: ");
        String surname = scanner.nextLine();

        if (!db.containsKey(surname)){
            System.out.println("This worker doesn't exist");
            return;
        }
        Worker worker = db.get(surname);

        System.out.print("\nEnter new surname: ");
        String newSur = scanner.nextLine();
        System.out.print("\nEnter new name: ");
        String newNam = scanner.nextLine();
        System.out.print("\nEnter new age: ");
        int newAge =  Integer.parseInt(scanner.nextLine());

        db.remove(surname);
        db.put(newSur, new Worker(newNam,newSur,newAge));
        System.out.println("\nWorker updated");
    }
    private void deleteWorker(){
        System.out.print("\nEnter worker's surname to delete: ");
        String surname = scanner.nextLine();

        if (!db.containsKey(surname)){
            System.out.println("This worker doesn't exist");
            return;
        }
        db.remove(surname);
        System.out.println("\nWorker was deleted");

    }
    private void findBySurname(){
        System.out.print("\nEnter worker's surname to find: ");
        String surname = scanner.nextLine();

        if (!db.containsKey(surname)){
            System.out.println("This worker doesn't exist");
            return;
        }
        Worker worker = db.get(surname);
        System.out.println(worker);
    }

    private void showAll() {
        if (db.isEmpty()) {
            System.out.println("Db is empty");
            return;
        }
        db.forEach((sur,worker)-> System.out.println(sur+": "+worker));
    }

    private void filterByAge(){
        if (db.isEmpty()) {
            System.out.println("Db is empty");
            return;
        }
        System.out.print("\nEnter age to find workers: ");
        int age =  Integer.parseInt(scanner.nextLine());
        var filteredValues = db.values().stream().filter(w ->w.getAge()==age);
        filteredValues.forEach(w-> System.out.println(w));
    }

    private void filterBySurname(){
        if (db.isEmpty()) {
            System.out.println("Db is empty");
            return;
        }
        System.out.print("\nEnter surname to find workers: ");
        char surname = Character.toLowerCase(scanner.nextLine().charAt(0));
        var filteredValues = db.values().stream().filter(w ->w.getSurName().toLowerCase().charAt(0)==surname);
        filteredValues.forEach(w-> System.out.println(w));
    }

    private void saveToFile(){
        if (path == null || path.toString().isEmpty()) {
            System.out.print("\n Enter path to save: ");
            path = Paths.get(scanner.nextLine());
        }

//        String fixedPath = path.toString();
//        String keys = db.keySet().toString();
//        String values = db.values().toString();
//для Save був використаний gson
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonStr = gson.toJson(db);

        try {
            //Files.write(path,List.of(fixedPath,keys,values));
            Files.writeString(path,jsonStr);
            System.out.println("\u001B[44m Saved progress... \u001B[0m");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    private void changeSavePath(){
        System.out.print("\nEnter new save path: ");
        try {
            path = Paths.get(scanner.nextLine());
            System.out.println("\nPath Changed!\n");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void loadFormFile(){
        if (path == null) {
            System.out.println("File is Empty");
            return;
        }

        try {
           //List<String> data = Files.readAllLines(path);

            String jsonString = Files.readString(path);

            Gson gson = new Gson();
            Type type = new TypeToken<Map<String,Worker>>(){}.getType();
            db = gson.fromJson(jsonString, type);

            System.out.println("\u001B[44m Data loaded... \u001B[0m");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
