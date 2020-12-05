package studsluzba.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studsluzba.model.StudProgram;
import studsluzba.model.Student;
import studsluzba.repositories.StudentRepository;

@Service
public class StudentiNaIspituService {
	
	@Autowired 
	StudentRepository studentRepo;
	
	public List<Student> loadAll(){
		Iterable<Student> iter = studentRepo.findAll();
		List<Student> rez = new ArrayList<Student>();		
		iter.forEach(rez::add);
		return rez;
	}

}
