package aero.nettracer.persistence.model;


import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Proxy(lazy = false)
@Table(name="lffoundbylocation")
public class LFFoundByLocation {
    @Id
    @GeneratedValue
    private long id;

    @Column(name="description",length = 128)
    String description;


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
