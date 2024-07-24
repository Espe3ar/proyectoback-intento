package com.ucema.proga3.clase.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.ucema.proga3.clase.Model.Sede;

@Entity
@Table(name = "cancha")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo", discriminatorType = DiscriminatorType.STRING)
public abstract class Cancha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cancha")
    private Long id;
    @Column(name = "numero_cancha")
    private int Numero;
    @Column(name = "precio_hora")
    private float PrecioxHora;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "id_sede", nullable = false)
    private Sede sede;
   @OneToMany(mappedBy = "canchaReservada",cascade = {CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.LAZY)
    private List<Reserva> listaReservas;

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public Cancha(){}
    public Cancha(int Numero, float PrecioxHora){
        this.Numero=Numero;
        this.PrecioxHora=PrecioxHora;
        this.listaReservas =new ArrayList<>();
    }
   /* public boolean Disponible(Date fYhsEntrada, Date fYhsSalida){
        boolean dispo=true;

        //for (Reserva reserva: listaReservas) {
            //if(reserva.getFechayHoraEntrada().isEqual(fYhsEntrada)){
                dispo=false;
                break;
            }
        }
        return dispo;
    }*/


    public int getNumero() {
        return Numero;
    }

    public void setNumero(int numero) {
        Numero = numero;
    }

    public float getPrecioxHora() {
        return PrecioxHora;
    }

    public void setPrecioxHora(float precioxHora) {
        PrecioxHora = precioxHora;
    }

    public abstract float CalcularCostoLuz();
    public void AgregarReserva(Reserva reserva){
        listaReservas.add(reserva);
    }
    public List<Reserva> getListaReservas() {
        return listaReservas;
    }


}
