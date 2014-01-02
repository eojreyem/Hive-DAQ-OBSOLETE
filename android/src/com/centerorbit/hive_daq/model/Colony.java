package com.centerorbit.hive_daq.model;

public class Colony {

    private long colony_id;
    private String name;
    private String nfc_tag;
    private int yard_id;
    private String date_created;
    private String date_deleted;
    private int reason_deleted_id;
    private int source_type_id;
    private int bee_source_id;
    private int parent_colony_id;
    private int hive_type_id;
    private int queen_status_id;
    private int reigning_queen_id;
    private String note;


	public long getId() {
		return this.colony_id;
	}
	public void setId(long id) {
		this.colony_id = id;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

    public String getNFC() {
        return this.nfc_tag;
    }
    public void setNFC(String nfc) {
        this.nfc_tag = nfc;
    }

    public int getYardId() { return this.yard_id; }
    public void setYardId(int yard) {
        this.yard_id = yard;
    }

    public String getDateCreated() {
        return this.date_created;
    }
    public void setDateCreated(String date_created) {
        this.date_created = date_created;
    }

    public String getDateDeleted() {
        return this.date_deleted;
    }
    public void setDateDeleted(String date_deleted) { this.date_deleted = date_deleted;}

    public int getReasonDeletedId() { return this.reason_deleted_id; }
    public void setReasonDeletedId(int reason_deleted) {
        this.reason_deleted_id = reason_deleted;
    }

    public int getSourceTypeId() { return this.source_type_id; }
    public void setSourceTypeId(int source_type) {
        this.source_type_id = source_type;
    }

    public int getBeeSourceId() { return this.bee_source_id; }
    public void setBeeSourceId(int source) {
        this.bee_source_id = source;
    }

    public int getParentColonyId() { return this.parent_colony_id; }
    public void setParentColonyId(int parent_colony) { this.parent_colony_id = parent_colony;  }

    public int getHiveTypeId() { return this.hive_type_id; }
    public void setHiveTypeId(int hive_type) {
        this.hive_type_id = hive_type;
    }

    public int getQueenStatusId() { return this.queen_status_id; }
    public void setQueenStatusId(int queen_status) { this.queen_status_id = queen_status; }

    public int getReigningQueenId() { return this.reigning_queen_id; }
    public void setReigningQueenId(int reigning_queen) { this.reigning_queen_id = reigning_queen; }

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
