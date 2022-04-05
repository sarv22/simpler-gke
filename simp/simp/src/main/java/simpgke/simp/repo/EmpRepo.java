package simpgke.simp.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import simpgke.simp.model.Emp;



@Repository
public interface EmpRepo extends CrudRepository<Emp, Long> {
	

}
