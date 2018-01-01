package com.ibm.pact.bean;

public class CDCInput {
	
	private String serviceurl;
	private String attributekey;
	private String attributeval;
	private String jsonArgs;
	private String reqmethod;
	private String mvnPath;
	private String workingDirPomPathConsumer;
	private String workingDirPomPathProvider;
	private String [] outputlists;
	
	
	public String getServiceurl() {
		return serviceurl;
	}
	public void setServiceurl(String serviceurl) {
		this.serviceurl = serviceurl;
	}
	/*public String getAttribute() {
		return attributekey;
	}
	public void setAttribute(String attributekey) {
		this.attributekey = attributekey;
	}*/
	
	public String getAttributeval() {
		return attributeval;
	}
	public String getAttributekey() {
		return attributekey;
	}
	public void setAttributekey(String attributekey) {
		this.attributekey = attributekey;
	}
	public void setAttributeval(String attributeval) {
		this.attributeval = attributeval;
	}
	public String getJsonArgs() {
		return jsonArgs;
	}
	public void setJsonArgs(String jsonArgs) {
		this.jsonArgs = jsonArgs;
	}
	
	public String getReqmethod() {
		return reqmethod;
	}
	public void setReqmethod(String reqmethod) {
		this.reqmethod = reqmethod;
	}
	
	public String getMvnPath() {
		return mvnPath;
	}
	public void setMvnPath(String mvnPath) {
		this.mvnPath = mvnPath;
	}
	public String getWorkingDirPomPathConsumer() {
		return workingDirPomPathConsumer;
	}
	public void setWorkingDirPomPathConsumer(String workingDirPomPathConsumer) {
		this.workingDirPomPathConsumer = workingDirPomPathConsumer;
	}
	public String getWorkingDirPomPathProvider() {
		return workingDirPomPathProvider;
	}
	public void setWorkingDirPomPathProvider(String workingDirPomPathProvider) {
		this.workingDirPomPathProvider = workingDirPomPathProvider;
	}
	
	
	public String[] getOutputlists() {
		return outputlists;
	}
	public void setOutputlists(String[] outputlists) {
		this.outputlists = outputlists;
	}
	@Override
	public String toString() {
		return "CDCInput [serviceurl=" + serviceurl + ", attributekey=" + attributekey + ", attributeval="
				+ attributeval + ", jsonArgs=" + jsonArgs + " , reqmethod=" + reqmethod + ", mvnPath=" + mvnPath + ", workingDirPomPathConsumer=" + workingDirPomPathConsumer + ", workingDirPomPathProvider=" + workingDirPomPathProvider + ", outputlists=" +outputlists+"]";
		
		
	}



}
