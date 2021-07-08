package com.myspace.githook_1;

public class LogEntry {

    String Type;
    String Field;
    String oldVal;
    String newVal;
    String id;
    String  Classname;

    public String getClassname() {
        return this.Classname;
    }

    public void setClassName(String Classname) {
        this.Classname = Classname;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return this.Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getField() {
        return this.Field;
    }

    public void setField(String Field) {
        this.Field = Field;
    }

    public String getOldVal() {
        return this.oldVal;
    }

    public void setOldVal(String oldVal) {
        this.oldVal = oldVal;
    }

    public String getNewVal() {
        return this.newVal;
    }

    public void setNewVal(String newVal) {
        this.newVal = newVal;
    }
    
    @Override
    public String toString() {
        return "{" +
            " Type='" + getType() + "'" +
            ", Field='" + getField() + "'" +
            ", oldVal='" + getOldVal() + "'" +
            ", newVal='" + getNewVal() + "'" +
            ", id='" + getId() + "'" +
            ", Classname='" + getClassname() + "'" +
            "}";
    }
}
