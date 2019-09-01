package javaAdvancedLesson17.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class University {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String name;

	@Column(name = "level_of_accreditation")
	private Integer levelOfAccreditation;

	@Column(name = "quantity_of_institutes")
	private Integer quantityOfInstitutes;

	@Column(name = "quantity_of_students")
	private Integer quantityOfStudents;

	@Column
	private String address;

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

	public Integer getLevelOfAccreditation() {
		return levelOfAccreditation;
	}

	public void setLevelOfAccreditation(Integer levelOfAccreditation) {
		this.levelOfAccreditation = levelOfAccreditation;
	}

	public Integer getQuantityOfInstitutes() {
		return quantityOfInstitutes;
	}

	public void setQuantityOfInstitutes(Integer quantityOfInstitutes) {
		this.quantityOfInstitutes = quantityOfInstitutes;
	}

	public Integer getQuantityOfStudents() {
		return quantityOfStudents;
	}

	public void setQuantityOfStudents(Integer quantityOfStudents) {
		this.quantityOfStudents = quantityOfStudents;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Univercity [id=" + id + ", name=" + name + ", levelOfAccreditation=" + levelOfAccreditation
				+ ", quantityOfInstitutes=" + quantityOfInstitutes + ", quantityOfStudents=" + quantityOfStudents
				+ ", address=" + address + "]";
	}
}
