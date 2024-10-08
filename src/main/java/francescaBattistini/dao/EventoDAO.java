package francescaBattistini.dao;

import francescaBattistini.entities.Evento;
import francescaBattistini.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventoDAO {
    // DAO (Data Access Object) è un Design Pattern. Questa classe serve per semplificare l'accesso al DB fornendo tutta una serie di metodi
    // custom più pratici di quelli dell'Entity Manager. Semplificare nel senso anche di nascondere alcuni dettagli implementativi, che in alcuni
    // casi potrebbero essere anche ben complessi. Nascondendoli forniremo a chi ha bisogno di interagire con la tabella degli studenti dei metodi
    // semplici e più immediati magari dotandoli anche di nomi appropriati e "parlanti".
    private final EntityManager entityManager;

    public EventoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    //--------->CREO EVENTO<------------------

    public void save(Evento newEvento) {
        // 1. Chiediamo all'entity manager di creare una nuova transazione
        EntityTransaction transaction = entityManager.getTransaction();

        // 2. Facciamo la partire la transazione
        transaction.begin();

        // 3. Aggiungiamo il nuovo studente al Persistence Context (a questo step lo studente non fa ancora parte del db)
        entityManager.persist(newEvento);

        // 4. Chiudiamo la transazione (qua lo studente verrà effettivamente inviato al db)
        transaction.commit();

        System.out.println("L'evento" + newEvento.getTitolo() + " è stato salvato correttamente nel db");
//2 metodo
        /* try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(evento);
            t.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/

    } // Dato un nuovo Evento me lo salverà nel db




    // ------------------>CERCO PER ID<------------------
     public  Evento getById (long eventoId) {
         Evento getById = entityManager.find(Evento.class,eventoId);
         if(getById==null) throw new NotFoundException(eventoId);//gestisce la casistica se non trova l'evento
         return  getById;

  //2. metodo
   //  return entityManager.find(Evento.class, eventoId);
    }







    // ------------------>ELIMINO PER ID<------------------
    public void trovaPerIDeElimina(long eventoId){
// 0. Cerco lo studente nel db
        Evento getId = this.getById(eventoId);

        // 1. Chiediamo all'entity manager di creare una nuova transazione
        EntityTransaction transaction = entityManager.getTransaction();

        // 2. Facciamo la partire la transazione
        transaction.begin();

        // 3. Rimuoviamo lo studente dal persistence (a questo step ancora non sarà rimosso dal DB)
        entityManager.remove(getId);

        // 4. Chiudiamo la transazione (qua lo studente verrà effettivamente rimosso dal db)
        transaction.commit();

        System.out.println("Lo studente " +getId.getTitolo() + " è stato rimosso dal DB!");
//SECONDO MODO CON IL TRY
        /*try {
            EntityTransaction t = em.getTransaction();
            Event found = em.find(Event.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("Elemento eliminato");
            } else System.out.println("Elemento non trovato");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/
    }  // Dato un id cancella lo studente se lo trova, altrimenti eccezione


}
