package ufal.com.br.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "facialExpression")
public class FacialExpression {

    @Id
    @Column(name = "facialexp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "facialExpression", targetEntity = Moment.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Moment> moments;

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @return the moments
     */
    public List<Moment> getMoments() {
        return moments;
    }
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @param moments the moments to set
     */
    public void setMoments(List<Moment> moments) {
        this.moments = moments;
    }
}
