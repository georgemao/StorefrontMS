package com.beans;

import com.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Car{


	private String id;

    private String vin;
	private String make;
	private String model;
	private String color;
    private Status status;

	public Car(){	}

	public Car(String vin, String make, String model, String color, Status status){
		this.vin = vin;
        this.make=make;
		this.model=model;
		this.color=color;
        this.status=status;
	}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake(){
		return this.make;
	}

	public String getModel(){
		return this.model;
	}

	public String getColor(){
		return this.color;
	}

	public void setMake(String make){
		this.make=make;
	}

	public void setModel(String model){
		this.model=model;
	}

	public void setColor(String color){
		this.color=color;
	}

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
	public String toString(){
		return vin+":"+make+":"+model+":"+color+":"+status;
	}
}