package francescaBattistini;

import francescaBattistini.dao.EventoDAO;
import francescaBattistini.entities.Evento;
import francescaBattistini.entities.TipoEvento;
import francescaBattistini.exceptions.NotFoundException;
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
//---------------------- ESERCIZIO 1 savare ------------------------------------
     //6. costruisco la colonna
     //Evento evento1 = new Evento("cassandra",LocalDate.of(2023,12,31),"teatro",TipoEvento.PRIVATO,5);
     //ed.save(evento1);
     //Evento evento2 = new Evento("gesualdo",LocalDate.of(2023,12,31),"teatro",TipoEvento.PRIVATO,5);
     //ed.save(evento2);
     //Evento evento3 = new Evento("Gasman",LocalDate.of(2023,12,31),"teatro",TipoEvento.PUBBLICO,5);
     //ed.save(evento3);
//---------------------- ESERCIZIO 2 ricerca per id------------------------------------

     //Evento cassandra = ed.getById(4);
     //System.out.println(cassandra);
     try {
         Evento getDb = ed.getById(6);
         System.out.println(getDb);
     }catch (NotFoundException exception){
         System.out.println(exception.getMessage());
     }
//---------------------- ESERCIZIO 3 eliminare per id------------------------------------

     ed.trovaPerIDeElimina(3);
     /*try {
         Evento getDb = ed.getById(2);// trovami l'id 2
         System.out.println(getDb);
         ed.trovaPerIDeElimina(2);
     }catch (NotFoundException exception){
         System.out.println(exception.getMessage());
     }*/
     //3. Best practices, alla fine di tutto sempre bene chiudere le risorse aperte
     em.close();
     emf.close();
    }
}
