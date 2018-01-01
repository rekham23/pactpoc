package pact;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;

public class MavenTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		//mvn clean -f C:\Users\IBM_ADMIN\IBM\rationalsdp\workspace\SWBWebProject\pom.xml
		
		String mvnPath = "";
		String serviceUrl = "";
		String workingDirPomPath = "";
		String reqmethod ="";
		String jsonArgs="";
		
		
		/* try
        {
            // Run and get the output.
			 mvnPath="C:/apache-maven-3.3.9/bin/mvn.cmd";
			 //serviceUrl = "/foos";
			 serviceUrl = "/driver-details";
			 reqmethod = "GET";
			 jsonArgs = "phoneno:9739849842L;location:Domalur";
			 //workingDirPomPath = "C:/workspaces/pact/microservices-pact-maven-master/microservices-pact-consumer/pom.xml";
			 
			 //workingDirPomPath = "C:/workspaces/pact/microservices-pact-maven-master/microservices-pact-provider/pom.xml";
			 
			 workingDirPomPath = "C:/workspaces/pact/microservices-pact-maven-master/consumer-detail/pom.xml";
			 
			 //String outlist[] = runCommand(mvnPath + " clean test "+"-Dserviceurl=" + serviceUrl + " -f " + workingDirPomPath);
			 
			 String outlist[] = runCommand(mvnPath + " clean test "+"-DjsonArgs=" + jsonArgs + " -Dserviceurl=" + serviceUrl + " -Dreqmethod=" + reqmethod + " -f " + workingDirPomPath);
			 
			 
			 
			 //String outlist[]=runCommand("C:/apache-maven-3.3.9/bin/mvn.cmd clean test -DjsonArgs=phoneno:9739849842L;location:Domalur -Dserviceurl=/driver-details -Dreqmethod=GET -f C:/workspaces/pact/microservices-pact-maven-master/consumer-detail/pom.xml");
			 
			 //String outlist[] = runCommand(mvnPath + " pact : verify "+"-f " + workingDirPomPath);
			 //mvn clean test -DjsonArgs=phoneno:9739849842L;location:Domalur -Dserviceurl=/driver-details -Dreqmethod=GET
			 //String outlist[] = runCommand("C:/apache-maven-3.3.9/bin/mvn.cmd clean test -Dserviceurl=/foos -f C:/workspaces/pact/microservices-pact-maven-master/microservices-pact-consumer/pom.xml");
            for (int i = 0; i < outlist.length; i++)
                System.out.println(outlist[i]);
        }   
        catch (IOException e) { 
            System.err.println(e); 
        }
    }

	static public String[] runCommand(String cmd)throws IOException
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
	
	trip-detail{
		phoneno:9739849842L;
		location:Domalur;
		name:Tom;
		data:{
			a=12;
			b=13
		}
	},driver-detail{phoneno:9739849842L;location:Domalur;name:Tom}

*/
		
		Process p = null;

	    try {
	    	mvnPath="C:/apache-maven-3.3.9/bin/mvn.cmd";
			 //serviceUrl = "/foos";
			 //serviceUrl = "/driver-details";
			 serviceUrl = "/driver-details/driver";
			 reqmethod = "GET";
			 jsonArgs = "phoneno:9739849842;location:Domalur;name:Tom";
			 //jsonArgs="phoneno:9739849842;location:Domalur;name:Tom;incentiveBool:true;tripDate:28/12/2017;datetripturn:Fourth";
			 //workingDirPomPath = "C:/workspaces/pact/microservices-pact-maven-master/microservices-pact-consumer/pom.xml";
			 
			 //workingDirPomPath = "C:/workspaces/pact/microservices-pact-maven-master/microservices-pact-provider/pom.xml";
			 
			 //workingDirPomPath = "C:/workspaces/pact/microservices-pact-maven-master/consumer-detail/pom.xml";
			//workingDirPomPath = "C:/Ignite/pactpoc/uber-management/pom.xml";
			workingDirPomPath = "C:/Ignite/pactpoc/passenger-management/pom.xml";
	        p = Runtime.getRuntime().exec(mvnPath + " clean test "+"-DjsonArgs=" + jsonArgs + " -Dserviceurl=" + serviceUrl + " -Dreqmethod=" + reqmethod + " -f " + workingDirPomPath);
	    } catch (IOException e) {
	        System.err.println("Error on exec() method");
	        e.printStackTrace();
	    }

	    copy(p.getInputStream(), System.out);
	    p.waitFor();

	}

	static void copy(InputStream in, OutputStream out) throws IOException {
	    while (true) {
	        int c = in.read();
	        if (c == -1)
	            break;
	        out.write((char) c);
	    }
	}
	

}
