package com.flipkart.crm.entity.interview;


import com.flipkart.crm.entity.user.Slot;

import javax.persistence.*;

/**
 * Created by laxman.muttineni on 17/07/17.
 */
@Entity
@Table(name="RequestToSlot")
public class RequestToSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "requestId", referencedColumnName = "id", nullable = false)
    private Request requestId;

    @ManyToOne
    @JoinColumn(name = "slotId", referencedColumnName = "id", nullable = false)
    private Slot slotId;

    public RequestToSlot() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Request getRequestId() {
        return requestId;
    }

    public void setRequestId(Request requestId) {
        this.requestId = requestId;
    }

    public Slot getSlotId() {
        return slotId;
    }

    public void setSlotId(Slot slotId) {
        this.slotId = slotId;
    }
}