package simpgke.simp.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import simpgke.simp.model.Emp;
import simpgke.simp.service.EmpService;



@RestController
@RequestMapping("/api/v1/emp")
public class EmpController {
	EmpService empService;
	
	public EmpController(EmpService empService) {
		this.empService=empService;
	}
	//
	@GetMapping
	public ResponseEntity<List<Emp>> getAllEmps(){
		List<Emp> emps=empService.getEmps();
		return new ResponseEntity<List<Emp>>(emps, HttpStatus.ACCEPTED);
	}
	//
	@GetMapping("/{empId}")
	public ResponseEntity<Emp> getEmp(@PathVariable Long empId){
		return new ResponseEntity<Emp>(empService.getEmpById(empId),HttpStatus.ACCEPTED);
		
	}
	//
	@PostMapping(path= "/", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Emp> saveEmp(@RequestBody Emp emp) {
        Emp emp1 = empService.insert(emp);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("emp", "/api/v1/emp/" + emp1.getClass().toString());
        return new ResponseEntity<>(emp1, httpHeaders, HttpStatus.CREATED);

	}
	//
	@PutMapping({"/{todoId}"})
    public ResponseEntity<Emp> updateEmp(@PathVariable("empId") Long empId, @RequestBody Emp emp) {
        empService.updateEmp(empId, emp);
        return new ResponseEntity<>(empService.getEmpById(empId), HttpStatus.OK);
    }
	//
	 @DeleteMapping({"/{empId}"})
	    public ResponseEntity<Emp> deleteEmp(@PathVariable("empId") Long empId) {
	        empService.deleteEmp(empId);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	
}
