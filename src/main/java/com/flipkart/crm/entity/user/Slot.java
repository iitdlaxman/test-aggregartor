package com.flipkart.crm.entity.user;



import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by laxman.muttineni on 17/07/17.
 */
@Entity
@Table(name="Slot")
public class Slot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private DateTime fromTime;

    private DateTime tiTime;

    public Slot() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DateTime getFromTime() {
        return fromTime;
    }

    public void setFromTime(DateTime fromTime) {
        this.fromTime = fromTime;
    }

    public DateTime getTiTime() {
        return tiTime;
    }

    public void setTiTime(DateTime tiTime) {
        this.tiTime = tiTime;
    }
}

