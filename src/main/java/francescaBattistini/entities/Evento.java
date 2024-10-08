package francescaBattistini.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
//parte 1.
@Entity //questa classe dovrà essere mappata ad una specifica tabbela nel dp  e sarà hyb  a creare la tabella
// e la modificherà se sarà necessaria FILO INVISIBILE TRA LE DUE
@Table (name = "evento")//2.non è necessaria serve per personalizzare il nome della tabella


public class Evento  {

    @Id //obligatoria serve per indicare la colonna chiave primaria della mia tabella
    private long id;
    @Column(name = "titolo", nullable = false) //serve per personalizzare la colonna (nome,notnull,true/false, lunghezza campo ecc)
    private String titolo;
    @Column(name = "data", nullable = false)
    private LocalDate dataEvento;
    @Column(name = "tipo_evento")
    private TipoEvento tipoEvento;
    @Column(name = "numero", nullable = false)
    private int numeroMassimoPartecipanti;



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
