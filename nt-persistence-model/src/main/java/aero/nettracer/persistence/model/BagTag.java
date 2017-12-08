/*
 * Created on Jul 13, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package aero.nettracer.persistence.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dummy_bagtag")
public class BagTag implements Serializable {

    private static final long serialVersionUID = 5712336990487032404L;

    @Id @GeneratedValue
    @Column(name="id")
    private int Dummy_Tag_ID;

    @Column(name="bagnumber")
    private String bagnumber;

    public int getDummy_Tag_ID() {
        return Dummy_Tag_ID;
    }

    public void setDummy_Tag_ID(int Dummy_Tag_ID) {
        this.Dummy_Tag_ID = Dummy_Tag_ID;
    }

    public String getBagnumber()
    {
        return bagnumber;
    }

    public void setBagnumber(String bagnumber) {
        this.bagnumber=bagnumber;
    }

}