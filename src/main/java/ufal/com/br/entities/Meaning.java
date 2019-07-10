package ufal.com.br.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Meaning")
public class Meaning implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "meaning_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description")
    private String description;


    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="category_meaning", joinColumns={@JoinColumn(referencedColumnName="meaning_id")}
            , inverseJoinColumns={@JoinColumn(referencedColumnName="category_id")})
    private List<Category> categoriesList;

    @ManyToMany(mappedBy = "meanings")
    private  List<Sinal> sinals;


    // Constructor
    public Meaning (String description, List<Category> categoriesList){
        this.description = description;
        this.categoriesList = categoriesList;
    }
    public Meaning (int id, String description){
        this.id = id;
        this.description = description;
    }
    public Meaning(String description){
        this.description = description;
    }
    public Meaning(){}


    //public void addCategory(Category category){
    //    categoriesList.add(category);
    //}


    // Get - Set

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescricao() {
        return description;
    }
    public void setDescricao(String descricao) {
        this.description = descricao;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Category> getCategoriesList() {
        return categoriesList;
    }

    public void setCategoriesList(List<Category> categoriesList) {
        this.categoriesList = categoriesList;
    }

    public List<Sinal> getSinals() {
        return sinals;
    }

    public void setSinals(List<Sinal> sinals) {
        this.sinals = sinals;
    }
}
