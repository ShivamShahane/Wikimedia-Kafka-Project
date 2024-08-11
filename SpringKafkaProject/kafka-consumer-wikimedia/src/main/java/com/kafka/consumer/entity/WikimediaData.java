package com.kafka.consumer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;


@Entity
@Table(name = "wikimedia_recentchange")

public class WikimediaData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	private String wikiEventData;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWikiEventData() {
		return wikiEventData;
	}

	public void setWikiEventData(String wikiEventData) {
		this.wikiEventData = wikiEventData;
	}

	@Override
	public String toString() {
		return "WikimediaData [id=" + id + ", wikiEventData=" + wikiEventData + ", getId()=" + getId()
				+ ", getWikiEventData()=" + getWikiEventData() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
