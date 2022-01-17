package Liga.com.heroe.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Liga.com.heroe.DTO.MembroDTO;
import Liga.com.heroe.Model.Membro;
import Liga.com.heroe.Repository.MembroRepository;

@Service
public class MembroService {

	@Autowired
	private MembroRepository repository;
	
	public List<MembroDTO> findAll() {
		List<Membro> result = repository.findAll();
		return result.stream().map(x -> new
		MembroDTO(x)).collect(Collectors.toList());
	}
	
	public Membro findById(Long id) {
		Optional<Membro> m = repository.findById(id);
		return m.get();
	}
	
	public Membro save(Membro Membro) {
		Membro m = repository.save(Membro);
		return m;
	}
	
	@Transactional
	public Membro update(Long id,Membro Membro) {
		Membro m = repository.getById(id);
		m.setId(id); 
		m.setNome(Membro.getNome());
		m.setTipo(Membro.getTipo());
		m.setPlaneta(Membro.getPlaneta());
		m.setPoder(Membro.getPoder());
		Membro lig = repository.save(m);
		return lig;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
