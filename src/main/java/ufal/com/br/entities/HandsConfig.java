package ufal.com.br.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class HandsConfig {

    @Id
    @Column(name = "handsconfig_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "handsConfig", targetEntity = Moment.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Moment> moments;

    // Constructor

    public HandsConfig(String description) {
        this.description = description;
    }

    //Get - Set


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
