package francescaBattistini.dao;

import francescaBattistini.entities.Evento;
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

    } // Dato un nuovo Evento me lo salverà nel db

}
