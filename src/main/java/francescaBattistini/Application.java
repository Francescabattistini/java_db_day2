package francescaBattistini;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    //secondo step dopo persistence
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4d12");


    public static void main(String[] args) {


        System.out.println("Hello World!");
    }
}
