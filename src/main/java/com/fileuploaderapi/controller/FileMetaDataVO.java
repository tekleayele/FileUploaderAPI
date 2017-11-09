package com.fileuploaderapi.controller;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Tekle Ayele
 *
 */

@Entity
public class FileMetaDataVO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	public String name;
	public String type;
	public long size;
	public Timestamp createdTimeStamp;

	public FileMetaDataVO() {

	}

	public FileMetaDataVO(String name, String type, long size, Timestamp createdTimeStamp) {
		super();
		this.name = name;
		this.type = type;
		this.size = size;
		this.createdTimeStamp = createdTimeStamp;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public Timestamp getCreatedTimeStamp() {
		return createdTimeStamp;
	}

	public void setCreatedTimeStamp(Timestamp createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}

}
