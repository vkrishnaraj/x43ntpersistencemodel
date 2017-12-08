package aero.nettracer.persistence.model;

import aero.nettracer.persistence.model.wtq.WorldTracerQueue;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class AgentViewWT_PXF extends WT_PXF {

    private WorldTracerQueue wtq;

    @OneToOne
    @JoinColumn(name = "wt_queue_id")
    @org.hibernate.annotations.Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.PERSIST })
    public WorldTracerQueue getWtq() {
        return wtq;
    }

    public void setWtq(WorldTracerQueue wtq) {
        this.wtq = wtq;
    }

}
