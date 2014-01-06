package com.centerorbit.AME.model;

/**
 * Created by joe on 1/5/14.
 */

public class Queen {

    private long queen_id;
    private String name;
    private int in_colony_id;
    private long mother_queen_id;
    private int bee_source_id;
    private String date_created;
    private String date_mated;
    private String date_deleted;
    private int reason_deleted_id;
    private int race_id;
    private String mark_color_hex;
    private String note;


    public long getId() {
        return this.queen_id;
    }
    public void setId(long id) {
        this.queen_id = id;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getInColonyId() { return this.in_colony_id; }
    public void setInColonyId(int yard) {
        this.in_colony_id = in_colony_id;
    }

    public long getMotherQueenId() {
        return this.mother_queen_id;
    }
    public void setMotherQueenId(long mother_queen_id) {
        this.mother_queen_id = mother_queen_id;
    }

    public int getBeeSourceId() { return this.bee_source_id; }
    public void setBeeSourceId(int source) {
        this.bee_source_id = source;
    }

    public String getDateCreated() {
        return this.date_created;
    }
    public void setDateCreated(String date_created) {
        this.date_created = date_created;
    }

    public String getDateMated() {
        return this.date_mated;
    }
    public void setDateMated(String date_mated) {
        this.date_mated = date_mated;
    }

    public String getDateDeleted() {
        return this.date_deleted;
    }
    public void setDateDeleted(String date_deleted) { this.date_deleted = date_deleted;}

    public int getReasonDeletedId() { return this.reason_deleted_id; }
    public void setReasonDeletedId(int reason_deleted) {
        this.reason_deleted_id = reason_deleted;
    }

    public int getRaceId() { return this.race_id; }
    public void setRaceId(int race_id) {
        this.race_id = race_id;
    }

    public String getMarkColorHex() {
        return this.mark_color_hex;
    }
    public void setMarkColorHex(String mark_color_hex) { this.mark_color_hex = mark_color_hex;}

    public String getNote() {
        return this.note;
    }
    public void setNote(String note) {
        this.note = note;
    }

    // Will be used by the ArrayAdapter in the ListView
    @Override
    public String toString() {
        return this.name;
    }
}
