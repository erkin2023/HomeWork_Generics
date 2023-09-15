import model.Animal;
import model.Person;
import service.ServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 public class Main {
    public static void main(String[] args) {
        //Person
        List<Person> people = new ArrayList<>();
        Person person=new Person(1,"alina", 25);
        Person person1=new Person(2,"adela", 12);
        Person person2=new Person(2,"adela", 12);
        people.add(person);
        people.add(person1);
        people.add(person2);
        ServiceImpl<Person> personService = new ServiceImpl<>(people);

        //Animal
        List<Animal> animals = new ArrayList<>();
        Animal animal=new Animal(1, "Adel", 89);
        Animal animal1=new Animal(2, "Elina", 101);
        animals.add(animal);
        animals.add(animal1);
        ServiceImpl<Animal> animalService = new ServiceImpl<>(animals);





        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить элементы");
            System.out.println("2. Получить элемент по id");
            System.out.println("3. Получить все элементы");
            System.out.println("4. Сортировать по имени");
            System.out.println("5. Очистить список");
            System.out.println("6. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:

                    System.out.println("Введите тип элемента (1 - Person, 2 - Animal):");
                    int elementType = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Id с 1 и 2 уже есть ");
                    System.out.println("Введите id:");
                    long id = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Введите имя:");
                    String name = scanner.nextLine();
                    System.out.println("Введите возраст :");
                    String ageOrSound = scanner.nextLine();

                    if (elementType == 1) {
                        Person a=new Person((int) id, name, Integer.parseInt(ageOrSound));
                        System.out.println(personService.add(a));
                    } else if (elementType == 2) {
                        Animal a1=new Animal((int) id, name,  Integer.parseInt(ageOrSound));
                        System.out.println(animalService.add(a1));
                    } else {
                        System.out.println("Неверный тип элемента.");
                    }


                    break;
                case 2:
                    System.out.println("Введите тип элемента для поиска (1 - Person, 2 - Animal):");
                    int searchElementType = scanner.nextInt();
                    System.out.println("Введите id:");
                    long searchId = scanner.nextLong();

                    Object foundElement = null;
                    if (searchElementType == 1) {
                        foundElement = personService.getById(searchId);
                    } else if (searchElementType == 2) {
                        foundElement = animalService.getById(searchId);
                    } else {
                        System.out.println("Неверный тип элемента.");
                    }
                    if (foundElement != null) {
                        System.out.println(foundElement);
                    } else {
                        System.out.println("Элемент не найден.");
                    }
                    break;
                case 3:
                    System.out.println("Получаем все элементы:");
                    System.out.println(personService.getAll());
                    System.out.println(animalService.getAll());
                    break;
                case 4:
                    System.out.println("Сортировка по имени: ");
                    System.out.println("1. По возрастанию");
                    System.out.println("2. По убыванию");
                    int sortOrder = scanner.nextInt();
                    List<Person> sortedPeople = personService.sortByName(sortOrder);
                    List<Animal> sortedAnimals = animalService.sortByName(sortOrder);
                    System.out.println("Sorted by name:");
                    sortedPeople.forEach(System.out::println);
                    sortedAnimals.forEach(System.out::println);
                    break;
                case 5:
                    people.clear();
                    animals.clear();
                    System.out.println("Очищаем списки.");
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }
}
