package com.tekbbes.viajes.model;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "travel")
public class Travel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@Column(name = "start_date", nullable = false)
	@NotNull(message = "Cannot be empty")
	private Date startDate;
	
	@Column(name="start_pickup_addres",nullable = false)
	@NotEmpty(message = "Cannot be empty")
	private String strartPickupAddres;
	
	@Column(name="end_date",nullable = true)
	private Date endDate;
	
	@Column(name="end_pickup_addres",nullable = false)
	@NotEmpty(message = "Cannot be empty")
	private String endPickupAddres;
	
	@NotNull(message = "Cannot be empty")
	@JoinColumn(name = "country_id")
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Country country;
	
	@NotNull(message = "Cannot be empty")
	@JoinColumn(name = "city_id")
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private City city;
	
	@NotNull(message = "Cannot be empty")
	@JoinColumn(name = "passenger_id")
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Passenger passenger;
	
	@NotNull(message = "Cannot be empty")
	@JoinColumn(name = "driver_id")
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Driver driver;
	
	@NotNull(message = "Cannot be empty")
	@JoinColumn(name = "car_id")
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Car car;
	
	@NotEmpty(message = "Cannot be empty")
	@Column(nullable = false)
	private String status;
	
	@NotEmpty(message = "Cannot be empty")
	@Column(name = "check_code", nullable = false)
	private String checkCode;
	
	@Column(name = "created_at",nullable = true)
	private Date createdAt;
	
	@Column(name = "updated_at",nullable = true)
	private Date updatedAt;
	
	@Column(nullable = false)
	@NotNull(message = "Cannot be empty")
	private Double price;
	
	@Column(name = "driver_location",nullable = false)
	private String driverLocation;
	

	}
