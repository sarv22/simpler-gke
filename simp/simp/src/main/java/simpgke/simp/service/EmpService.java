package simpgke.simp.service;

import java.util.List;

import simpgke.simp.model.Emp;



public interface EmpService {
	
	 List<Emp> getEmps();
	
	Emp getEmpById(Long empid);
	
	Emp insert (Emp emp);
	
	void updateEmp(Long empid, Emp emp);
	
	void deleteEmp(Long empid);

}