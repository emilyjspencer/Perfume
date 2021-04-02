package com.EmilySpencer.perfume.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_gen")
	@SequenceGenerator(name = "review_gen", sequenceName = "REVIEW_SEQ", allocationSize = 1)
	private long reviewId;

	@Column
	private String title;

	@Column
	private String body;

	@Column
	private LocalDate dateOfReview;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "userId")
	private User user;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "perfumeId")
	private Perfume perfume;

	public Review(String title, String body, LocalDate dateOfReview, User user, Perfume perfume) {
		this.title = title;
		this.body = body;
		this.dateOfReview = dateOfReview;
		this.user = user;
		this.perfume = perfume;
	}

	public Review() {
		super();
	}

	public long getReviewId() {
		return reviewId;
	}

	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public LocalDate getDateOfReview() {
		return dateOfReview;
	}

	public void setDateOfReview(LocalDate dateOfReview) {
		this.dateOfReview = dateOfReview;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Perfume getPerfume() {
		return perfume;
	}

	public void setPerfume(Perfume perfume) {
		this.perfume = perfume;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + ((dateOfReview == null) ? 0 : dateOfReview.hashCode());
		result = prime * result + ((perfume == null) ? 0 : perfume.hashCode());
		result = prime * result + (int) (reviewId ^ (reviewId >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
			return false;
		if (dateOfReview == null) {
			if (other.dateOfReview != null)
				return false;
		} else if (!dateOfReview.equals(other.dateOfReview))
			return false;
		if (perfume == null) {
			if (other.perfume != null)
				return false;
		} else if (!perfume.equals(other.perfume))
			return false;
		if (reviewId != other.reviewId)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", title=" + title + ", body=" + body + ", dateOfReview=" + dateOfReview
				+ ", user=" + user + ", perfume=" + perfume + "]";
	}
	
}
