package francescaBattistini;

import francescaBattistini.dao.EventoDAO;
import francescaBattistini.entities.Evento;
import francescaBattistini.entities.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    //1.secondo step dopo persistence
private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");


 public static void main(String[] args) {


     EntityManager em =emf.createEntityManager();// mi vado a creare un unico Entiti manager per l'applicazione
     //2. può gestire tutte le tabelle che vogliamo perchè è associato al db

     // 4.creo classe dedicata che faccia tutte le cose che devo fare si chiamerà DaO
//5. segno la dao
     EventoDAO ed = new EventoDAO(em);
     //6. costruisco la colonna
     Evento evento1 = new Evento("Carlos Santana", LocalDate.of(2024,12, 30), TipoEvento.PRIVATO,10);
     ed.save(evento1);

     //3. Best practices, alla fine di tutto sempre bene chiudere le risorse aperte
     em.close();
     emf.close();
    }
}
