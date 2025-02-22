//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog("a");
        dog.greets();

        Animal cat = new Cat("b");
        cat.greets();

        Cat cat1 = new Cat("asd");
        cat1.greets();
        Dog dog1 = new Dog("Adad");
        dog1.greets();
        BigDog bigDog1 = new BigDog("adad");
        bigDog1.greets();

        Animal animal1 = new Cat("ac");
        animal1.greets();
        Animal animal2 = new Dog("sdf");
        animal2.greets();
        Animal animal3 = new BigDog("sf");
        animal3.greets();

        Dog dog2 = (Dog)animal2;
        BigDog bigDog2 = (BigDog)animal3;
        Dog dog3 = (Dog)animal3;
        Cat cat2 = (Cat)animal2;
        dog2.greets(dog3);
        dog3.greets(dog2);
        dog2.greets(bigDog2);
        bigDog2.greets(dog2);
        bigDog2.greets(bigDog1);
    }
}