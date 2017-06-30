package com.excel.apps.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class UploadItem {
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name = "file")
	private String file;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
	
	/*private String name;
    private String description;
    private CommonsMultipartFile []multipartFile;
     
    public CommonsMultipartFile[] getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(CommonsMultipartFile[] multipartFile) {
		this.multipartFile = multipartFile;
	}
	public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }*/
	
	
   
}
