package com.isaiahs.relationships.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="ninjas")
public class Ninja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message="Field required")
	private String firstName;
	@NotBlank(message="Field required")
	private String lastName;
	@Min(value=1, message="Age must be greater than 0.")
	private int age;
	@Column(updatable=false)
	@DateTimeFormat(pattern="MM/dd/yyy JJ:mm:ss")
	private Date createdAt;
	@DateTimeFormat(pattern="MM/dd/yyy JJ:mm:ss")
	private Date updatedAt;
	@ManyToOne(fetch=FetchType.LAZY) //Defines the 1:1 relationship with another entity. There are different options that you can have in the annotation, and it is extremely important that you use the correct one depending on which side of the relationship your entity is.
	@JoinColumn(name="dojo_id") // Defines mapping for composite foreign keys. It indicates that the corresponding table to this entity has a foreign key to the referenced table.
	private Dojo dojo;
	
	public Ninja() {
		
	}
	
	public Ninja(String firstName, String lastName, Integer age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public Dojo getDojo() {
		return dojo;
	}

	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
	}

	@PrePersist // runs the method right before the object is created
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate //runs a method when the object is modified
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
}
