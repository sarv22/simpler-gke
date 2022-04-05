package simpgke.simp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import simpgke.simp.model.Emp;
import simpgke.simp.repo.EmpRepo;



@Service
public class EmpServiceImpl implements EmpService {
	
	 EmpRepo empRepo;
	 
	 public EmpServiceImpl(EmpRepo empRepo) {
		 this.empRepo=empRepo;
	 }

	@Override
	public List<Emp> getEmps() {
		// TODO Auto-generated method stub
		List<Emp> emps=new ArrayList<Emp>();
		empRepo.findAll().forEach(emps::add);
		return emps;
	}

	@Override
	public Emp getEmpById(Long empid) {
		// TODO Auto-generated method stub
		return empRepo.findById(empid).get();
	}

	@Override
	public Emp insert(Emp emp) {
		// TODO Auto-generated method stub
		return empRepo.save(emp);
	}

	@Override
	public void updateEmp(Long empid, Emp emp) {
		// TODO Auto-generated method stub
		/*Emp empfromDb= empRepo.findById(empid).get();
		System.out.println(empfromDb.toString());
		empfromDb.setEmpName(emp.getEmpName());
		*/
		
	}

	@Override
	public void deleteEmp(Long empid) {
		// TODO Auto-generated method stub
		empRepo.deleteById(empid);
		
	}

}