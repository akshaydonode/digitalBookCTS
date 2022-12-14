package com.cts.digitalbook.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SUBSCRIPTION_INFO")
public class SubscriptionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SUBSCRIPTION_ID")
	private int subscriptionId;

	@OneToOne
	@JoinColumn(name = "BOOK_ID")
	private BookEntity bookId;

	@OneToOne
	@JoinColumn(name = "READER_ID")
	private ReaderEntity readerId;

	@Column(name = "SUBSCRIPTION_DATE")
	private Date subscriptionDate;

	public int getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(int subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public BookEntity getBookId() {
		return bookId;
	}

	public void setBookId(BookEntity bookId) {
		this.bookId = bookId;
	}

	public ReaderEntity getReaderId() {
		return readerId;
	}

	public void setReaderId(ReaderEntity readerId) {
		this.readerId = readerId;
	}

	public Date getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(Date subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}

	@Override
	public String toString() {
		return "Subscription [subscriptionId=" + subscriptionId + ", bookId=" + bookId + ", readerId=" + readerId
				+ ", subscriptionDate=" + subscriptionDate + "]";
	}

}
