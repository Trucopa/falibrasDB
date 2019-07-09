package ufal.com.br.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class ArticulationPoint {

    @Id
    @Column(name = "articulationpoint_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "articulationPoints", targetEntity = Moment.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Moment> moments;


    // Constructor

    public ArticulationPoint(String description) {
        this.description = description;
    }
    public ArticulationPoint(int id, String description) {
        this.description = description;
        this.id = id;
    }
    public ArticulationPoint(){}

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

    public List<Moment> getMoments() {
        return moments;
    }

    public void setMoments(List<Moment> moments) {
        this.moments = moments;
    }
}
