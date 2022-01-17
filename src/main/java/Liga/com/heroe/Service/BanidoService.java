package Liga.com.heroe.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Liga.com.heroe.DTO.BanidoDTO;
import Liga.com.heroe.Model.Banido;
import Liga.com.heroe.Model.Membro;
import Liga.com.heroe.Repository.BanidoRepository;
import Liga.com.heroe.Repository.MembroRepository;

@Service
public class BanidoService {

	@Autowired
	private BanidoRepository repository;
	@Autowired
	private MembroRepository vendrepository;
	
	public List<BanidoDTO> findAll() {
		List<Banido>result = repository.findAll();
		return result.stream().map(x -> new 
		BanidoDTO(x)).collect(Collectors.toList());
	}
	
	public Banido findById(Long id) {
		Optional<Banido> b = repository.findById(id);
		return b.get();
	}
	
	public Banido save(Banido Banido) {
		Membro Membro = vendrepository.findById
		(Banido.getMembro().getId()).get();
		Banido.setMembro(Membro);
		Banido b = repository.save(Banido);
		return b;
	}
	
	@Transactional
	public Banido update(Long id,Banido Banido) {
		Banido b = repository.getById(id);
		b.setId(id);
		b.setNome(Banido.getNome());
		b.setTipo(Banido.getTipo());
		b.setPlaneta(Banido.getPlaneta());
		b.setPoder(Banido.getPoder());
		Banido ban = repository.save(b);
		return ban;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
