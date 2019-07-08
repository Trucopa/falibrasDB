package ufal.com.br.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Moment {

    @Id
    @Column(name = "moment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="handsconfig_id")
    private HandsConfig handsConfig;

    @ManyToOne
    @JoinColumn(name="articulationpoint_id")
    private ArticulationPoint articulationPoints;

    @OneToMany(mappedBy = "moment", targetEntity = Status.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Status> statuses;

    @ManyToOne
    @JoinColumn(name = "facialExpression_id")
    private FacialExpression facialExpression;

    // Constructor

    public Moment(HandsConfig handsConfig, ArticulationPoint articulationPoints) {
        this.handsConfig = handsConfig;
        this.articulationPoints = articulationPoints;
    }

    // Get - Set


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HandsConfig getHandsConfig() {
        return handsConfig;
    }

    public void setHandsConfig(HandsConfig handsConfig) {
        this.handsConfig = handsConfig;
    }

    public ArticulationPoint getArticulationPoints() {
        return articulationPoints;
    }

    public void setArticulationPoints(ArticulationPoint articulationPoints) {
        this.articulationPoints = articulationPoints;
    }

    public List<Status> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<Status> statuses) {
        this.statuses = statuses;
    }
}
