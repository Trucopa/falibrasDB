package ufal.com.br.entities;

import javax.persistence.*;

@Entity
public class Transition {

    @Id
    @Column(name = "transition_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToOne(mappedBy = "transition", fetch = FetchType.LAZY)
    private Status status;


    // Constructor

    public Transition(String description) {
        this.description = description;
    }

    public Transition(){}

    public Transition(int id, String description){
        this.id = id;
        this.description = description;
    }

    // Get - Set
	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
