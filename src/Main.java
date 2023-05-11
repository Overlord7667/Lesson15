import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
        return  this.name + " " + this.surname + " " + this.phone;
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            File folder = new File("test");
            if (!folder.exists()){
                folder.mkdir();
            }

            if (folder.isDirectory()){
                System.out.println(folder.getName() + " is directory");
                File file = new File(folder.getAbsolutePath() + "/text.txt");
                if (!file.exists()){
                    file.createNewFile();
                }


                List<Person> list = new ArrayList<>();
                list.add(new Person("Tile","Lindeman","88005553535"));
                list.add(new Person("Margaret","Tatcher","923893576756"));
                list.add(new Person("Nikola","Tesla","7635654357763"));
                if (file.isFile()){
                    System.out.println(file.getName() + " is file");
                    FileWriter fileWriter = new FileWriter(file);
//                    for (Person person:list){
//                        fileWriter.write(person.toString()+"\n");
//                    }
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    list.get(0).setName("Alisiya");
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Enter name : ");
                    String name = scanner.next();
                    System.out.println("Enter surname : ");
                    String surname = scanner.next();
                    System.out.println("Enter phone : ");
                    String phone = scanner.next();
                    Person person = new Person(name,surname,phone);
                    list.add(person);

                    fileWriter = new FileWriter(file);
                    for (Person p:list){
                        fileWriter.write(p.toString() + "\n");
                    }

                    System.out.print("Enter index for delete : \n");
                    int count = 1;
                    for (Person p:list){
                        System.out.println(count++ + ") " + p.toString());
                    }
                    scanner = new Scanner(System.in);
                    int index = scanner.nextInt();
                    index--;
                    if (index>=0 && index < list.size()){
                        list.remove(index);
                        fileWriter = new FileWriter(file);
                        for (Person p:list){
                            fileWriter.write(p.toString()+"\n");
                        }
                    }else {
                        System.out.println("No index");
                    }

//                    fileWriter.write("Text1\n");
//                    fileWriter.write("Text2\n");
                    fileWriter.flush();
                    fileWriter.close();
                    File[] files = folder.listFiles();
                    System.out.println("--------------------------");
                    for (File subFile:files){
                        if (subFile.isFile()){
                            System.out.println(subFile.getName() + " is file");
                        }
                        if (subFile.isDirectory()){
                            System.out.println(subFile.getName() + " is directory");
                        }
                    }
                }


            }
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}