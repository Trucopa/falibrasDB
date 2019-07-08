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
}
