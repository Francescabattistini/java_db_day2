package francescaBattistini.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
//parte 1.
@Entity //questa classe dovrà essere mappata ad una specifica tabbela nel dp  e sarà hyb  a creare la tabella
// e la modificherà se sarà necessaria FILO INVISIBILE TRA LE DUE
@Table (name = "evento")//2.non è necessaria serve per personalizzare il nome della tabella


public class Evento  {

    @Id // <-- Annotazione OBBLIGATORIA! Serve per indicare quale colonna saràà la chiave primaria PK della mia tabella. Ogni tabella
    // deve avere una PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // OPZIONALE. Serve per chiedere al DB di gestire lui la creazione della chiave primaria
    // Se non la usassi vorrebbe dire che dovrei essere io ad inserire manualmente tale id.
    // IDENTITY chiede al db di rendere quel long un bigserial
    private long id;
    @Column(name = "titolo", nullable = false) //serve per personalizzare la colonna (nome,notnull,true/false, lunghezza campo ecc)
    private String titolo;
    @Column(name = "data", nullable = false)
    private LocalDate dataEvento;
    @Column(name = "tipo_evento")
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;
    @Column(name = "numero", nullable = false)
    private int numeroMassimoPartecipanti;

    public Evento() {// OBBLIGATORIO nelle entities il costruttore vuoto! Serve a JPA per poterci fornire degli oggetti di tipo Student
        // quando andremo a leggere dalla tabella students

    }

    public Evento(String titolo, LocalDate dataEvento, TipoEvento tipoEvento, int numeroMassimoPartecipanti) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public long getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }


    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", tipoEvento=" + tipoEvento +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                '}';
    }
}
