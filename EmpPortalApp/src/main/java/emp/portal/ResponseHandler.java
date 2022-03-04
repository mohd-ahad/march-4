package emp.portal;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
	public static ResponseEntity<Object> generateresponse(String message,HttpStatus status)
	{
		Map<String,Object> map= new HashMap<String,Object>();
		map.put("message",message);
		map.put("status", status.value());
		
		return new ResponseEntity<Object>(map,status);
	}
	public static ResponseEntity<Object> validateresponse(String message, String field, HttpStatus status)
	{
		Map<String,Object> map= new HashMap<String,Object>();
		map.put("message",message);
		map.put("field",field);
		return new ResponseEntity<Object>(map,status);
	}


}
