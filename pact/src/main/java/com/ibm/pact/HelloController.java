package com.ibm.pact;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ibm.pact.bean.CDCInput;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }
    
     
    
    CDCInput inputs = new CDCInput();
    String mvnPath = "";
	String serviceUrl = "";
	String workingDirPomPathConsumer = "";
	String workingDirPomPathProvider = "";
	String jsonArgs =  "";
	String reqMethod = "";
	
	
	
    
	/*@GetMapping("input")
	public ModelAndView create(CDCInput cdcinput) {
		return new ModelAndView("input");
	}*/

	@PostMapping("/generatecontract")
	public ModelAndView generatecontract(CDCInput input) throws InterruptedException {
		ModelAndView model = new ModelAndView("view");
		// CDCInput bean will be automatically binded to view . refer @ModelAttribute
		
		inputs.setServiceurl(input.getServiceurl());
		inputs.setAttributekey(input.getAttributekey());
		inputs.setAttributeval(input.getAttributeval());
		inputs.setJsonArgs(input.getJsonArgs());
		inputs.setReqmethod(input.getReqmethod());
		inputs.setMvnPath(input.getMvnPath());
		inputs.setWorkingDirPomPathConsumer(input.getWorkingDirPomPathConsumer());
		inputs.setWorkingDirPomPathProvider(input.getWorkingDirPomPathProvider());
		
		System.out.println(inputs);
		
		 try
	        {
	            // Run and get the output.
				 /*mvnPath="C:/apache-maven-3.3.9/bin/mvn.cmd";
				 serviceUrl = "/foos";
				 workingDirPomPathConsumer = "C:/workspaces/pact/microservices-pact-maven-master/microservices-pact-consumer/pom.xml";
				 */
			 
				 mvnPath=inputs.getMvnPath();
				 serviceUrl = inputs.getServiceurl();
				 workingDirPomPathConsumer = inputs.getWorkingDirPomPathConsumer();
				 jsonArgs = inputs.getJsonArgs();
				 reqMethod = inputs.getReqmethod();
				 
				 
				 
				 //String outlist[] = runCommand(mvnPath + " clean test "+"-DjsonArgs=" + jsonArgs +" -Dserviceurl=" + serviceUrl + "-DreqMethod=" + reqMethod +" -f " + workingDirPomPathConsumer);
				   String outlist = (String) runCommand(mvnPath + " clean test "+"-DjsonArgs=" + jsonArgs + " -Dserviceurl=" + serviceUrl + " -Dreqmethod=" + reqMethod + " -f " + workingDirPomPathConsumer);
				 
				 //String outlist[] = runCommand("C:/apache-maven-3.3.9/bin/mvn.cmd clean test -Dserviceurl=/foos -f C:/workspaces/pact/microservices-pact-maven-master/microservices-pact-consumer/pom.xml");
	            /*for (int i = 0; i < outlist.length(); i++){
	                System.out.println(outlist);
	            }*/
	            //model.addObject("outlist", outlist.toString());
	            System.out.println("=================================="); 
	            //System.out.println(Arrays.toString(outlist)); 
	            model.addObject("outlist", outlist);
	            //model.addObject("outlist", Arrays.toString(outlist).trim().split("\\s*,\\s*"));
	        }   
	        catch (IOException e) { 
	            System.err.println(e); 
	        }
		
		//model.addObject("inputs", inputs);
		
	return model;
	
	}

	@GetMapping("/input")
	public ModelAndView viewData(CDCInput input) {

		ModelAndView model = new ModelAndView("input");
		return model;
	}
	
	
	@RequestMapping(value="/generatecontract", params = "addContract", method = RequestMethod.POST)
	public ModelAndView addContract(CDCInput input) {
		
		ModelAndView model = new ModelAndView("input");
		
		//inputs.setServiceurl(input.getServiceurl());
		//inputs.setAttributekey(input.getAttributekey());
		//inputs.setAttributeval(input.getAttributeval());
		inputs.setJsonArgs(input.getJsonArgs());
		//inputs.setReqmethod(input.getReqmethod());
		
		System.out.println(inputs);
		
		model.addObject("inputs", inputs);
		
		
		return model;
		
	}
	
	
	@RequestMapping(value="/generatecontract", params = "publish", method = RequestMethod.POST)
	public ModelAndView publish(CDCInput input) throws InterruptedException {
		
		ModelAndView model = new ModelAndView("publishconsole");
		
		inputs.setServiceurl(input.getServiceurl());
		inputs.setAttributekey(input.getAttributekey());
		inputs.setAttributeval(input.getAttributeval());
		inputs.setJsonArgs(input.getJsonArgs());
		inputs.setReqmethod(input.getReqmethod());
		inputs.setMvnPath(input.getMvnPath());
		inputs.setWorkingDirPomPathConsumer(input.getWorkingDirPomPathConsumer());
		inputs.setWorkingDirPomPathProvider(input.getWorkingDirPomPathProvider());
	
		
		System.out.println(inputs);
		
		
		 try
	        {
	           	mvnPath=inputs.getMvnPath();
                workingDirPomPathConsumer = inputs.getWorkingDirPomPathConsumer();
				
				//String outlist[] = runCommand(mvnPath + " pact:publish "+" -f " + workingDirPomPathConsumer);
                String outlist =(String) runCommand(mvnPath + " pact:publish "+" -f " + workingDirPomPathConsumer);
				 
	            /*for (int i = 0; i < outlist.length; i++){
	                System.out.println(outlist[i]);
	        }  */
	            //model.addObject("outlist", Arrays.toString(outlist));
                model.addObject("outlist", outlist);
	        }     
	        catch (IOException e) { 
	            System.err.println(e); 
	        }
		
		//model.addObject("inputs", inputs);
		
		
		return model;
		
	}
	
	
	
	@RequestMapping(value="/generatecontract", params = "verify", method = RequestMethod.POST)
	public ModelAndView verify(CDCInput input) throws InterruptedException {
		
		ModelAndView model = new ModelAndView("verifyconsole");
		
		inputs.setServiceurl(input.getServiceurl());
		inputs.setAttributekey(input.getAttributekey());
		inputs.setAttributeval(input.getAttributeval());
		inputs.setJsonArgs(input.getJsonArgs());
		inputs.setReqmethod(input.getReqmethod());
		inputs.setMvnPath(input.getMvnPath());
		inputs.setWorkingDirPomPathConsumer(input.getWorkingDirPomPathConsumer());
		inputs.setWorkingDirPomPathProvider(input.getWorkingDirPomPathProvider());
	
		
		System.out.println(inputs);
		
		
		 try
	        {
	            // Run and get the output.
				 //mvnPath="C:/apache-maven-3.3.9/bin/mvn.cmd";
			 	mvnPath=inputs.getMvnPath();
				 //serviceUrl = "/foos";
				 
				 //workingDirPomPathProvider = "C:/workspaces/pact/microservices-pact-maven-master/microservices-pact-provider/pom.xml";
				 workingDirPomPathProvider= inputs.getWorkingDirPomPathProvider();
				 
				 String outlist =(String) runCommand(mvnPath + " pact:verify "+" -f " + workingDirPomPathProvider);
				 				 
				 //String outlist[] = runCommand(mvnPath + " pact:verify "+" -f " + workingDirPomPathProvider);
				 //String outlist[] = runCommand(mvnPath + " clean test "+"-DjsonArgs=" + jsonArgs + " -Dserviceurl=" + serviceUrl + " -Dreqmethod=" + reqMethod + " -f " + workingDirPomPathConsumer);
				 //String outlist[] = runCommand("C:/apache-maven-3.3.9/bin/mvn.cmd clean test -Dserviceurl=/foos -f C:/workspaces/pact/microservices-pact-maven-master/microservices-pact-consumer/pom.xml");
	            /*for (int i = 0; i < outlist.length; i++){
	                System.out.println(outlist[i]);
	               
	        }  */
	          //  model.addObject("outlist", Arrays.toString(outlist));
				  model.addObject("outlist", outlist);
	        }     
	        catch (IOException e) { 
	            System.err.println(e); 
	        }
			
		return model;
		
	}
	
	/*static public String[] runCommand(String cmd)throws IOException
	{

	                // The actual procedure for process execution:
	                //runCommand(String cmd);
	                // Create a list for storing output.
	                ArrayList list = new ArrayList();
	                // Execute a command and get its process handle
	                Process proc = Runtime.getRuntime().exec(cmd);
	                // Get the handle for the processes InputStream
	                InputStream istr = proc.getInputStream();
	                // Create a BufferedReader and specify it reads
	                // from an input stream.

	                BufferedReader br = new BufferedReader(new InputStreamReader(istr));
	                String str; // Temporary String variable
	                // Read to Temp Variable, Check for null then
	                // add to (ArrayList)list
	                while ((str = br.readLine()) != null) 
	                    list.add(str);
	                    // Wait for process to terminate and catch any Exceptions.
	                        try { 
	                            proc.waitFor(); 
	                            }
	                        catch (InterruptedException e) {
	                            System.err.println("Process was interrupted"); 
	                            }
	                        // Note: proc.exitValue() returns the exit value.
	                        // (Use if required)
	                        br.close(); // Done.
	                        // Convert the list to a string and return
	                        return (String[])list.toArray(new String[0]);
	}
*/
	
	
	static public String  runCommand(String cmd)throws IOException, InterruptedException
	{
 Process p = null;

	    try {
	        p = Runtime.getRuntime().exec(cmd);
	    } catch (IOException e) {
	        System.err.println("Error on exec() method");
	        e.printStackTrace();
	    }

    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    copy(p.getInputStream(), stream);
    ///System.out.println(+"------------------------------------");
	    System.out.println("********************************88888"+stream.toString()+"8888888888888***************************88888");
	    p.waitFor();
return stream.toString();
	}

	/*static String copy(InputStream in, OutputStream out) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    while (true) {
	        int c = in.read();
	        if (c == -1)
	            break;
	        out.write((char) c);
	        sb.append((char) c);
	    }
	    return sb.toString();
	}*/
	
	static void copy(InputStream in, OutputStream out) throws IOException {
		StringBuilder sb = new StringBuilder();
	    while (true) {
	        int c = in.read();
	        if (c == -1)
	            break;
	        out.write((char) c);
	        sb.append((char) c);
	    }
	    //return sb.toString();
	} 
	
	

}


    
