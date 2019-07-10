package ufal.com.br.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Sinal {

    @Id
    @Column(name = "sinal_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "gloss")
    private String gloss;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="sinal_composition", joinColumns={@JoinColumn(referencedColumnName="sinal_id")}
            , inverseJoinColumns={@JoinColumn(referencedColumnName="sinal_id")})
    private List<Sinal> sinals;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="sinal_meaning", joinColumns={@JoinColumn(referencedColumnName="sinal_id")}
            , inverseJoinColumns={@JoinColumn(referencedColumnName="meaning_id")})
    private List<Meaning> meanings;

    @Column(name = "url_video")
    private String urlVideo;

    @OneToMany(mappedBy = "sinal", targetEntity = Status.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Status> statusList;
    

    // Constructors
    public Sinal(){}

    public Sinal(int id, String gloss, List<Sinal> sinals, List<Meaning> meanings, String urkVideo){
        this.gloss = gloss;
        this.sinals = sinals;
        this.meanings = meanings;
        this.urlVideo = urkVideo;
        this.id = id;
    }

    public Sinal(String gloss, List<Sinal> sinals, List<Meaning> meanings, String urkVideo){
        this.gloss = gloss;
        this.sinals = sinals;
        this.meanings = meanings;
        this.urlVideo = urkVideo;
    }

    public Sinal(String gloss, List<Meaning>meanings, String urlVideo){
        this.gloss = gloss;
        this.meanings = meanings;
        this.urlVideo = urlVideo;
    }

    // Get - Set

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGloss() {
        return gloss;
    }

    public void setGloss(String gloss) {
        this.gloss = gloss;
    }

    public List<Sinal> getSinals() {
        return sinals;
    }

    public void setSinals(List<Sinal> sinals) {
        this.sinals = sinals;
    }

    public List<Meaning> getMeanings() {
        return meanings;
    }

    public void setMeanings(List<Meaning> meanings) {
        this.meanings = meanings;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    public List<Status> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<Status> statusList) {
        this.statusList = statusList;
    }
}
