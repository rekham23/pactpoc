<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Consumer Driven Contract Testing</title>
</head>
<body>

<script type="text/javascript">
  function checkContract()
  {
	  
	  var ele1= document.getElementById('attributekey');
	  var ele2= document.getElementById('attributeval');
	  var hidEle= document.getElementById('jsonArgs');
	  if(ele1.value.trim()==='' && ele2.value.trim()===''){
		  
	  }else{
		  if(hidEle.value===''){
			  hidEle.value= ele1.value+":"+ele2.value;
		  }else{
			  hidEle.value=hidEle.value+";"+ ele1.value+":"+ele2.value;
		  }
		  
		  ele1.value="";
		  ele2.value="";
	  }
	  
	  var t = document.getElementById("theTable");
	  var rows = t.getElementsByTagName("tr");
	  var r = rows[rows.length - 1];
	  r.parentNode.insertBefore(getTemplateRow(), r);
	  
	  	   
  }
  
  var maxID = 0;
  function getTemplateRow() {
  var x = document.getElementById("templateRow").cloneNode(true);
  x.id = "";
  x.style.display = "";
  x.innerHTML = x.innerHTML.replace(/{id}/, ++maxID);
  return x;
  }
  /*function addRow() {
  var t = document.getElementById("theTable");
  var rows = t.getElementsByTagName("tr");
  var r = rows[rows.length - 1];
  r.parentNode.insertBefore(getTemplateRow(), r);

  }*/
</script>

	<h2>Consumer Driven Contract Testing</h2>
	
	
	
	<form action="/generatecontract" method="POST" modelAttribute="input">
	<input type="hidden" name="jsonArgs" id="jsonArgs" /> 
	<!-- <input type hidden name="outputlists" id="outputlists"> -->
		Service Url:<input type="text" name="serviceurl" />
		<br> <br>Contract Attribute Key : <input type="text" id="attributekey" name="attributekey" /> Contract Attribute Value : <input type="text" id="attributeval" name="attributeval" />
		<!-- <br><br> Format : <select name="format">
			<option value="">select format</option>
			<option value="string">String</option>
			<option value="numeric">Numeric</option>
			<option value="decimal">Decimal</option> -->
		
		<br><br> <input type="button" name="addContract" value="Add Contract" onClick = "checkContract();"/><br><br>
		
		
		<!-- <table id="theTable">
		<tr>
		<td>Attribute Key</td>
		<td>Attribute Value</td>
		</tr>
		<tr id="templateRow" style="display:none">
		<td>{jsonArgs}</td>
		<td><input /></td>
		</tr>
		</table> -->
		<!-- <br><br> <input type="submit" class="button" name="addContract" value="Add Contract" onClick = "checkContract();"/><br><br> -->
		
		 <%-- <strong>List of attributes added.....</strong><br><br>
		<strong>${inputs.jsonArgs}</strong><br><br><br> --%>
		
		Request Method:<input type="text" name="reqmethod" /><br><br>
		
		Maven Path:<input type="text" name="mvnPath" /><br><br>
		
		Working Directory Path(Consumer): <input type="text" name="workingDirPomPathConsumer" /> <br><br>
		
		<input type="submit" class="button" name = "generate" value="Generate Contract" />  <input type="submit" class="button" name="publish" value="Publish" /> <br><br><br>	
				
		Working Directory Path(Provider): <input type="text" name="workingDirPomPathProvider" /><br><br>
		
		<input type="submit" class="button" name="verify" value="Verify Contract" /> <br>
		
		
		
		
		
		
		
	</form>

</body>
</html>