/*
 * Created on Jul 13, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package aero.nettracer.persistence.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dummy_bagtag")
public class BagTag {

    private int id;
    private String bagnumber;

    @Id
    @GeneratedValue
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="bagnumber")
    public String getBagnumber()
    {
        return bagnumber;
    }

    public void setBagnumber(String bagnumber) {
        this.bagnumber=bagnumber;
    }

}