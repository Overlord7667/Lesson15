import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Person{
    private String name;
    private String surname;
    private String phone;

    public Person(String name, String surname, String phone) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString(){
        return  this.name + "=" + this.surname + "=" + this.phone;
    }
    public String inFo(){return  this.name + " " + this.surname + " " + this.phone;}
}

public class Main {
    public static void main(String[] args) {
        int select = 0;
        Scanner scanner;
        File file = null;
        List <Person> list = new ArrayList<>();
        try {
            File folder = new File("Persons");
            if (!folder.exists()){
                folder.mkdir();
            }

            if (folder.isDirectory()) {
                file = new File(folder.getAbsolutePath() + "/list.txt");
                if (!file.exists()) {
                    file.createNewFile();
                }
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            while ((line = reader.readLine()) !=null){
//                System.out.println(line);
                String [] array = line.split("=");
                Person person = new Person(array [0], array[1],array[2]);
                list.add(person);
            }
        }catch (Exception ex){

        }

        do {
            try {
                System.out.println("""
                0 - Criate
                1 - Read
                2 - Update
                3 - Delete
                """);
                scanner =  new Scanner(System.in);
                select = scanner.nextInt();
                if (select == 0){
                    scanner =  new Scanner(System.in);
                    System.out.println("Create");
                    System.out.println("Enter name : ");
                    String name = scanner.nextLine();
                    System.out.println("Enter surname : ");
                    String surname = scanner.nextLine();
                    System.out.println("Enter phone : ");
                    String phone = scanner.next();
                    Person person = new Person(name,surname,phone);
                    list.add(person);
                    FileWriter fileWriter = new FileWriter(file);
                    for (Person p:list){
                        fileWriter.append(p.toString() + "\n");
                    }
                    fileWriter.flush();
                    fileWriter.close();
                }
                else if (select == 1) {
                    System.out.println("Read");
//                    FileReader fileReader = new FileReader(file);
                    for (Person person:list){
//                        fileReader.read(file);
                        System.out.println(person.inFo());
                    }
                }
                else if (select==2) {
                    System.out.println("Update");

                    for (int a = 0; a<list.size(); a++){
                        System.out.println(a+1 + ") " + list.get(a).inFo());

                    }
                    System.out.println("Change index for update");
                    scanner = new Scanner(System.in);
                    select = scanner.nextInt();
                    select--;

                    if (select >=0 && select < list.size()){
                        System.out.println("Vibor sdelan");
                        System.out.println("Chto hotite izmenit");
                        System.out.println("""
                                1 - name
                                2 - surname
                                3 - phone
                                """);
                        Scanner scanner1 = new Scanner(System.in);
                        scanner = new Scanner(System.in);
                        int ichangeFor = scanner1.nextInt();
                        if (ichangeFor == 1){
                            System.out.println("Update name : " + list.get(select).getName());
                            String name = scanner.nextLine();
                            list.get(select).setName(name);
                        } else if (ichangeFor == 2) {
                            System.out.println("Update surname : " + list.get(select).getSurname());
                            String surname = scanner.nextLine();
                            list.get(select).setSurname(surname);
                        } else if (ichangeFor == 3) {
                            System.out.println("Update phone : " + list.get(select).getPhone());
                            String phone = scanner.next();
                            list.get(select).setPhone(phone);
                        }
                        FileWriter fileWriter = new FileWriter(file);
                        for (Person p:list){
                            fileWriter.append(p.toString() + "\n");
                        }
                        fileWriter.flush();
                        fileWriter.close();
                    }
                }
                else if (select==3) {
                    System.out.println("Delete");
                }
                else {
                    System.out.println("Select not found");
                }
            }catch (Exception exception){
                System.out.println("Message = " + exception.getMessage());
            }
        }while (true);
//        try {
//            File folder = new File("test");
//            if (!folder.exists()){
//                folder.mkdir();
//            }
//
//            if (folder.isDirectory()){
//                System.out.println(folder.getName() + " is directory");
//                File file = new File(folder.getAbsolutePath() + "/text.txt");
//                if (!file.exists()){
//                    file.createNewFile();
//                }
//
//
//                List<Person> list = new ArrayList<>();
//                list.add(new Person("Tile","Lindeman","88005553535"));
//                list.add(new Person("Margaret","Tatcher","923893576756"));
//                list.add(new Person("Nikola","Tesla","7635654357763"));
//                if (file.isFile()){
//                    System.out.println(file.getName() + " is file");
//                    FileWriter fileWriter = new FileWriter(file);
////                    for (Person person:list){
////                        fileWriter.write(person.toString()+"\n");
////                    }
//                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//                    list.get(0).setName("Alisiya");
//                    Scanner scanner = new Scanner(System.in);
//                    System.out.println("Enter name : ");
//                    String name = scanner.next();
//                    System.out.println("Enter surname : ");
//                    String surname = scanner.next();
//                    System.out.println("Enter phone : ");
//                    String phone = scanner.next();
//                    Person person = new Person(name,surname,phone);
//                    list.add(person);
//
//                    fileWriter = new FileWriter(file);
//                    for (Person p:list){
//                        fileWriter.write(p.toString() + "\n");
//                    }
//
//                    System.out.print("Enter index for delete : \n");
//                    int count = 1;
//                    for (Person p:list){
//                        System.out.println(count++ + ") " + p.toString());
//                    }
//                    scanner = new Scanner(System.in);
//                    int index = scanner.nextInt();
//                    index--;
//                    if (index>=0 && index < list.size()){
//                        list.remove(index);
//                        fileWriter = new FileWriter(file);
//                        for (Person p:list){
//                            fileWriter.write(p.toString()+"\n");
//                        }
//                    }else {
//                        System.out.println("No index");
//                    }
//
////                    fileWriter.write("Text1\n");
////                    fileWriter.write("Text2\n");
//                    fileWriter.flush();
//                    fileWriter.close();
//                    File[] files = folder.listFiles();
//                    System.out.println("--------------------------");
//                    for (File subFile:files){
//                        if (subFile.isFile()){
//                            System.out.println(subFile.getName() + " is file");
//                        }
//                        if (subFile.isDirectory()){
//                            System.out.println(subFile.getName() + " is directory");
//                        }
//                    }
//                }
//
//
//            }
//        }catch (IOException ex){
//            System.out.println(ex.getMessage());
//        }
    }
}