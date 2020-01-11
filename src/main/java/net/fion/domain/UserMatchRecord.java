package net.fion.domain;

import java.util.List;

public class UserMatchRecord {

	private List<String> records;

	public UserMatchRecord() {}

	public UserMatchRecord(List<String> records) {
		this.records = records;
	}

	/* getter */
	public List<String> getRecords() {
		return records;
	}

	/* toString */
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
