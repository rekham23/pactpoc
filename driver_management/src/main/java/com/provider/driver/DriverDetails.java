package com.provider.driver;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)
public class DriverDetails {

   // private int value;
   private Long phoneno;
   private String location;
   private String name;
   private Boolean incentiveBool;
   @JsonFormat(pattern="dd/MM/yyyy")
   private Date tripDate;
   private String tripDateString;
   public String getTripDateString() {
	   if(tripDate!=null)
	   tripDateString = new SimpleDateFormat("dd/MM/yyyy").format(tripDate);
	   return tripDateString;
}

public void setTripDateString(String tripDateString) {
	this.tripDateString = tripDateString;
}

private String datetripturn;
   //private String tripDate;
   
   /* public DriverDetails(int value) {
        this.value = value;
    }*/
    
    public DriverDetails(Long phoneno, String location, String name) {	
       
		this.phoneno = phoneno;
		this.location = location;
		this.name = name;
		//this.driverid = driverid;
    }
    
   // public DriverDetails(long phoneno, String location, String name, String dt,  String datetripturn) {	
    public DriverDetails(Long phoneno, String location, String name, Boolean incentiveBool, Date tripDate,  String datetripturn) {
    //public DriverDetails(long phoneno, String location, String name, boolean incentiveBool, String datetripturn) {
        
		this.phoneno = phoneno;
		this.location = location;
		this.name = name;
		this.incentiveBool= incentiveBool;
		//this.dt=dt;
		 this.tripDate = tripDate;
		this.datetripturn = datetripturn;
		
		//this.driverid = driverid;
    }
   
   public DriverDetails(){
	   
   }

    /*public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }*/
    
    public Long getPhoneno() {
        return phoneno;
    }
	
	 public String getLocation() {
        return location;
    }

	public String getName() {
		return name;
	}

	
	/*public long getLocationid() {
		return locationid;
	}*/

	/*public void setLocationid(long locationid) {
		this.locationid = locationid;
	}*/

	public void setPhoneno(Long phoneno) {
		this.phoneno = phoneno;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*public boolean isIncentive() {
		return incentive;
	}

	public void setIncentive(boolean incentive) {
		this.incentive = incentive;
	}*/
	
	


	public String getDatetripturn() {
		return datetripturn;
	}

	public Date getTripDate() {
		return tripDate;
	}

	public void setTripDate(Date tripDate) {
		this.tripDate = tripDate;
	}

	public Boolean isIncentiveBool() {
		return incentiveBool;
	}

	public void setIncentiveBool(Boolean incentiveBool) {
		this.incentiveBool = incentiveBool;
	}

	public void setDatetripturn(String datetripturn) {
		this.datetripturn = datetripturn;
	}

	

	/*public String getDt() {
		return dt;
	}

	public void setDt(String dt) {
		this.dt = dt;
	}*/

	

			
}
