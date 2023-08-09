

import java.util.*;
import java.util.Comparator;
    abstract class Animal {

        String name;
        int time;
        public Animal(String n){
            name = n;
        }
        public void setTime(int t){

            time = t;
        }
        public int getTime(){
            return time;
        }
    }

    class Dog extends Animal {
        public Dog(String n) {super(n);}
    }

    class Cat extends Animal {
        public Cat(String n) {super(n);}
    }


    public class AdoptAPet {

        public static void main(String[] args){
            //copied from the spec
            Dog Sadie = new Dog("Sadie");
            Sadie.setTime(4);
            Cat Woof = new Cat("Woof");
            Woof.setTime(7);
            Dog Chirpy = new Dog("Chirpy");
            Chirpy.setTime(2);
            Dog Lola = new Dog("Lola");
            Lola.setTime(1);

            AdoptAPet shelter = new AdoptAPet();
            shelter.insert(Sadie);
            shelter.insert(Woof);
            shelter.insert(Chirpy);
            shelter.insert(Lola);

            System.out.println(Arrays.toString(shelter.dogs.toArray()));
            System.out.println(Arrays.toString(shelter.cats.toArray()));


            System.out.println(shelter.adopt("dog"));


            Cat Floofy = new Cat("Floofy");
            shelter.insert(Floofy);

            System.out.println(shelter.adopt("cat"));

            System.out.println(shelter.adopt("cat"));


            System.out.println(shelter.adopt("dog"));

            System.out.println(Arrays.toString(shelter.dogs.toArray())); //[Lola]
            System.out.println(Arrays.toString(shelter.cats.toArray())); //[]

        }


        Queue<Animal> dogs = new PriorityQueue<Animal>(10, new Comparator<Dog>() {
            public int compare(Animal d1, Animal d2) {
                if (d1.getTime() < d2.getTime()) {
                    return -1;
                } else if (d1.getTime() > d2.getTime()){
                    return 1;
                }
                return 0;
            }
        });
        Queue<Animal> cats = new PriorityQueue<Animal>(10, new Comparator<Cat>() {
            public int compare(Animal c1, Animal c2) {
                if (c1.getTime() < c2.getTime()) { //older cats in front
                    return -1;
                } else if (c1.getTime() > c2.getTime()){
                    return 1;
                }
                return 0;
            }
        });
        private int time = 0;

        public void insert(Animal a){
            a.setTime(time);
            time++;
            if (a instanceof Dog){
                dogs.offer(a);
            } else if (a instanceof Cat){
                cats.offer(a);
            }
        }

        public String adopt(String a){
            if (cats.isEmpty() && dogs.isEmpty()){
                return "Sorry! No pets available right now.";
            }
            else if (a == "dog"){
                if (!dogs.isEmpty()){
                    return dogs.poll().name;
                } else {
                    return cats.poll().name;
                }
            }
            else {
                if (!cats.isEmpty()){
                    return cats.poll().name;
                } else {
                    return dogs.poll().name;
                }
            }
        }



    }
