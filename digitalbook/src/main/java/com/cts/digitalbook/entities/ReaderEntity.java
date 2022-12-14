package com.cts.digitalbook.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "READER_DETAILS")
public class ReaderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "READER_ID")
	private int readerId;

	@Column(name = "READER_NAME")
	private String readerName;

	@Column(name = "READER_EMAIL")
	private String readerEmail;

	public ReaderEntity(String readerName, String readerEmail) {

		this.readerName = readerName;
		this.readerEmail = readerEmail;
	}

	public ReaderEntity(int readerId, String readerName, String readerEmail) {

		this(readerName, readerEmail);
		this.readerId = readerId;

	}

	public int getReaderId() {
		return readerId;
	}

	public void setReaderId(int readerId) {
		this.readerId = readerId;
	}

	public String getReaderName() {
		return readerName;
	}

	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}

	public String getReaderEmail() {
		return readerEmail;
	}

	public void setReaderEmail(String readerEmail) {
		this.readerEmail = readerEmail;
	}

	@Override
	public String toString() {
		return "Reader [readerId=" + readerId + ", readerName=" + readerName + ", readerEmail=" + readerEmail + "]";
	}

}
