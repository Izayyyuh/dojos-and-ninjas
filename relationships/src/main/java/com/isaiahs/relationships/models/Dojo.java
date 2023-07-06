package com.isaiahs.relationships.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="dojos")
public class Dojo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min = 3, max = 150, message="Dojo name must be at least 3 characters")
	private String name;
	@Column(updatable=false)
	@DateTimeFormat(pattern="MM/dd/yyy JJ:mm:ss")
	private Date createdAt;
	@DateTimeFormat(pattern="MM/dd/yyy JJ:mm:ss")
	private Date updatedAt;
	@OneToMany(mappedBy="dojo", fetch=FetchType.LAZY) //Defines the 1:1 relationship with another entity. There are different options that you can have in the annotation, and it is extremely important that you use the correct one depending on which side of the relationship your entity is. "cascade=CascadeType.All": The operations that must be cascaded to the target of the association. This will make sure referential integrity is preserved in ALL actions. "mappedBy="person"): This will map the license attribute in the Person class to the person attribute in the License class. It represents the field that owns the relationship. This element is only specified on the inverse (non-owning) side of the association. "(fetch=FetchType.LAZY): Whether the association should be lazily loaded or must be eagerly fetched.
	private List<Ninja> ninjas;
	
	public Dojo() {
		
	}
	
	public Dojo(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Ninja> getNinjas() {
		return ninjas;
	}

	public void setNinjas(List<Ninja> ninjas) {
		this.ninjas = ninjas;
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate //runs a method when the object is modified
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
