import java.util.LinkedList;
import java.util.Queue;

public class AdoptAPet {

    public static void main(String[] args) {
        AdoptAPet solve = new AdoptAPet();
        Pet pet = new Pet("Sadie", "dog", 4);
        solve.addPet(pet);
        pet = new Pet("Woof", "cat", 7);
        solve.addPet(pet);
        pet = new Pet("Chirpy", "dog", 2);
        solve.addPet(pet);
        pet = new Pet("Lola", "dog", 1);
        solve.addPet(pet);
        // Adoption 1
        Person person = new Person("Bob", "dog");
        solve.adoptAPet(person);

    }
    Queue<Pet> queueCat = new LinkedList<>();
    Queue<Pet> queueDog = new LinkedList<>();

    public void addPet(Pet p) {
        if (p.type == "dog") {
            queueDog.add(p);
        } else if (p.type == "cat") {
            queueCat.add(p);
        }
    }

    public void adoptAPet(Person p) {
        Pet adopted = new Pet();
        if (p.preference == "dog") {
            if (queueDog.isEmpty()) {
                adopted = queueCat.poll();
            } else {
                adopted = queueDog.poll();
            }
        }

        else if (p.preference == "cat") {
            if (queueCat.isEmpty()) {
                adopted = queueDog.poll();
            } else {
                adopted = queueCat.poll();
            }
        }

        //see if the name and type print out right
        System.out.println(adopted.name + ", " + adopted.type);

    }

    public static class Pet {
        String name;
        String type;
        int shelterTime;

        Pet() {
        }

        Pet(String n, String t, int s) {
            this.name = n;
            this.type = t;
            this.shelterTime = s;
        }

    }

    public static class Person {
        String name;
        String preference;

        Person(String n, String p) {
            this.name = n;
            this.preference = p;
        }

    }

}