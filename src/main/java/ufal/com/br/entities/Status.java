package ufal.com.br.entities;

import javax.persistence.*;

@Entity
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private int id;

    @Column(name = "series")
    private int series;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sinal_id")
    private Sinal sinal;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "transition_id", referencedColumnName = "transition_id")
    private Transition transition;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "moment_id")
    private Moment moment;

    public Status(){}

    public Status(int series, Sinal sinal, Transition transition, Moment moment) {
        this.series = series;
        this.sinal = sinal;
        this.transition = transition;
        this.moment = moment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public Sinal getSinal() {
        return sinal;
    }

    public void setSinal(Sinal sinal) {
        this.sinal = sinal;
    }

    public Transition getTransition() {
        return transition;
    }

    public void setTransition(Transition transition) {
        this.transition = transition;
    }

    public Moment getMoment() {
        return moment;
    }

    public void setMoment(Moment moment) {
        this.moment = moment;
    }
}
