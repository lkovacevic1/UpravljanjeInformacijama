package studsluzba.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import studsluzba.model.StudProgram;
import studsluzba.model.Student;
import studsluzba.repositories.StudProgramRepository;
import studsluzba.repositories.StudentRepository;

@Service
public class StudProgramService {
	
	@Autowired 
	StudentRepository studentRepo;
	
	@Autowired
	StudProgramRepository studProgramRepo;
	
	public StudProgram saveStudProgram(String punNaziv, String skraceniNaziv){
		StudProgram sp = new StudProgram();
		sp.setNazivStudPrograma(punNaziv);
		sp.setOznaka(skraceniNaziv);
		return studProgramRepo.save(sp);				
	}
	
	public List<StudProgram> loadAll(){
		Iterable<StudProgram> iter = studProgramRepo.findAll();
		List<StudProgram> rez = new ArrayList<StudProgram>();		
		iter.forEach(rez::add);
		return rez;
	}
}
