package com.example.EmployeeService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmployeeService.Entity.Employee; 
import com.example.EmployeeService.service.EmployeeServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author Chandeshwar Thakur
 * @version 1.0
 * Controller layer
 */
@RestController
public class EmployeeController {

	//static Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeServiceImpl employeeService; 
	
	/*@Autowired
    private JWTUtility jwtUtil;
	
    @Autowired
    private AuthenticationManager authenticationManager;*/
    
	/**
	 * @author Chandeshwar Thakur
	 * @apiNote Method saveInformation
	 * @param employee Obj
	 * @return String
	 */
	@PostMapping("v1/saveInformation")
	public String saveInformation(@RequestBody Employee employee)
	{
		//logger.info("EmployeeController saveInformation Method Started:");
		String msg=employeeService.saveData(employee);
		//logger.info("EmployeeController saveInformation Method:get failed while saving data:msg:"+msg);
		return msg;
	}
	
	/**
	 * @author Chandeshwar Thakur
	 * @apiNote Method getEmployess
	 * @param employee Obj
	 * @return String
	 */
	@GetMapping("v1/employees")
	public String getEmployess()
	{
		//logger.info("EmployeeController getEmployess Method Started:");
		String json=null;
		try {
			json=new ObjectMapper().writeValueAsString(employeeService.getEmployess());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			return "Data Not Found under Database";
		}
		return json;
	}
	
	/*@PostMapping("/authenticate") 
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }*/
}
