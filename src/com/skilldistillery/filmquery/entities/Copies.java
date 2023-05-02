package com.skilldistillery.filmquery.entities;

public class Copies {
private String condition;
private int copyId;

public Copies() {}

public Copies(String cond, int copyId) {
	this.condition = cond;
	this.copyId = copyId;
}

public String getCondition() {
	return condition;
}

public void setCondition(String condition) {
	this.condition = condition;
}

public int getCopyId() {
	return copyId;
}

@Override
public String toString() {
	return "copy : " + copyId + " condtion : " + condition ;
}

public void setCopyId(int copyId) {
	this.copyId = copyId;
}



}
