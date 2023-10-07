package com.hotelManagement.hotelManagement.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Services {

    public long getServiceID() {
		return serviceID;
	}

	public void setServiceID(long serviceID) {
		this.serviceID = serviceID;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ServiceUsage> getServiceUsages() {
		return serviceUsages;
	}

	public void setServiceUsages(List<ServiceUsage> serviceUsages) {
		this.serviceUsages = serviceUsages;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_ID")
    private long serviceID;

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "price")
    private double price;

    @Column(name = "description")
    private String desc;

    @Column(name = "status")
    private String status;

    //    @JsonManagedReference(value = "service-serviceUsage")
    @JsonBackReference(value = "serviceUsage-service")
    @OneToMany(mappedBy = "service")
    private List<ServiceUsage> serviceUsages;
}
