package com.tekbbes.viajes.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "citys")
public class City implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(unique = true, nullable = false)
	@NotEmpty(message = " Cannot be empty")
	private String name;
	
	
	@NotNull(message="Cannot be empty")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Country country;
	
}
