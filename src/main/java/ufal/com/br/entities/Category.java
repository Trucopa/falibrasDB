package ufal.com.br.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Category")
public class Category implements Serializable{

    //private static final long serialVersionUID = 1L;

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "categoriesList")
    private List<Meaning> meaningsList;


    // Constructors
    public Category(int id, String name){
        this.id = id;
        this.name = name;
    }
    public Category(String name){
        this.name = name;
    }
    public Category(){}


    // Get - Set

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<Meaning> getMeaningsList() {
        return meaningsList;
    }

    public void setMeaningsList(List<Meaning> meaningsList) {
        this.meaningsList = meaningsList;
    }
}