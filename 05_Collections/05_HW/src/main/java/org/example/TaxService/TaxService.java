package org.example.TaxService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;


public class TaxService {
    private Map<String, Person> db = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("[ 1 ] - Print Database\n[ 2 ] - Print by Id\n[ 3 ] - Print by fine type\n[ 4 ] - Print by city\n[ 5 ] - Add new Person to Db" +
                    "\n[ 6 ] - Add fine to Person\n[ 7 ] - Remove fine\n[ 8 ] - Edit Person's info\n[ 0 ] - Exit");

            System.out.print("\nEnter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> printAll();
                case 2 -> printById();
                case 3 -> printByFineType();
                case 4 -> printByCity();
                case 5 -> addPerson();
                case 6 -> addFine();
                case 7 -> removeFine();
                case 8 -> editInfo();
                case 0 -> { return; }
                default -> System.out.println("Wrong choice");
            }
        }
    }


    private void printAll() {
        if (db.isEmpty()) {
            System.out.println("Db is empty");
            return;
        }
        for (Person person : db.values()){
            System.out.println(person);
        }
    }

    private void printById() {
        System.out.print("\nEnter Id: ");
        String id = scanner.next();
        Person person = db.get(id);
        if (person != null) {
            System.out.println(person);
        } else {
            System.out.println("Person with this id not found");
        }
    }
    private void printByFineType(){
        System.out.print("\nEnter fine type: ");
        String type = scanner.next().toLowerCase();

        List<Person> result = db.values().stream().filter(p->p.getFines().stream()
                .anyMatch(f->f.getType().toLowerCase().contains(type))).toList();

        if (result.isEmpty()){
            System.out.println("No people with this fine type were found");
            return;
        }
        else {
            System.out.printf("\nFound %d people\n",result.size());
            for (var person : result){
                System.out.println(person);
            }
        }
    }
    private void printByCity(){
        System.out.print("\nEnter City: ");
        String city = scanner.next().toLowerCase();

        List<Person> result = db.values().stream().filter(p->p.getCity().toLowerCase().contains(city)).toList();

        if (result.isEmpty()){
            System.out.println("No people with this city were found");
        }
        else {
            System.out.printf("\nFound %d people\n",result.size());
            for (var person : result){
                System.out.println(person);
            }
        }

    }
    private void addPerson(){
        System.out.println("\nEnter Id");
        String id = scanner.next();

        var check = db.get(id);
        if (check != null) {
            System.out.println("This id taken");
            return;
        }

        System.out.println("\nEnter fullname");
        String fullname = scanner.next();

        System.out.println("\nEnter city");
        String city = scanner.next();

        db.put(id,new Person(id,fullname,city));
        System.out.println("\nPerson added");
    }

    private void addFine(){
        System.out.println("\nEnter person id");
        String id = scanner.next();

        Person person = db.get(id);
        if (person==null) {
            System.out.println("\nPerson with this id not found");
            return;
        }
        System.out.println("\nEnter fine type");
        String type = scanner.next();
        System.out.println("\nEnter fine amount");
        double amount = scanner.nextDouble();

        person.getFines().add(new Fine(type,amount));
        System.out.println("\nFine added");
    }

    private void removeFine(){
        System.out.println("\nEnter person id");
        String id = scanner.next();

        Person person = db.get(id);
        if (person==null) {
            System.out.println("\nPerson with this id not found");
            return;
        }

        List<Fine> fines = person.getFines();

        if (fines.isEmpty()) {
            System.out.println("This person has no Fines!");
            return;
        }
        System.out.println("\n--Fines--");
        fines.forEach(f-> System.out.println(f));

        System.out.println("\nEnter fine type to remove: ");
        String type = scanner.next();

        fines.stream().filter(s->s.getType().toLowerCase().contains(type.toLowerCase()))
                .findFirst()
                .ifPresent(f->fines.remove(f));
        System.out.println("Fine was deleted");
    }

    private void editInfo(){
        System.out.println("\nEnter person id to update");
        String id = scanner.next();

        Person person = db.get(id);
        if (person==null) {
            System.out.println("\nPerson with this id not found");
            return;
        }

        System.out.print("\nEnter new full name");
        String newName = scanner.next();
        person.setFullName(newName);

        System.out.print("\nEnter new city");
        String newCity = scanner.next();
        person.setCity(newCity);

        System.out.println("\nPerson Updated");

        List<Fine> fines = person.getFines();


        if (fines.isEmpty()) {
            System.out.println("This person has no Fines!");
            return;
        }
        System.out.println("\n--Fines--");
        fines.forEach(f-> System.out.println(f));

        System.out.println("\nEnter fine type to edit");
        String type = scanner.next();

        Fine f = fines.stream().filter(s->s.getType().toLowerCase().contains(type.toLowerCase()))
                .findFirst().orElseThrow();

        System.out.print("\nEnter new fine type");
        String newType = scanner.next();
        f.setType(newType);

        System.out.println("\nEnter new amount");
        double newAmount = scanner.nextDouble();
        f.setAmount(newAmount);

        System.out.println("Fine was updated");
    }


}



