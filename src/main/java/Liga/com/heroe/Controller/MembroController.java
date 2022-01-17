package Liga.com.heroe.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import Liga.com.heroe.DTO.MembroDTO;
import Liga.com.heroe.Model.Membro;
import Liga.com.heroe.Service.MembroService;

@RestController
@RequestMapping(value = "/membros")
public class MembroController {	
	@Autowired
	private MembroService service;
	
	@GetMapping
	public ResponseEntity<List<MembroDTO>> findAll() {
		System.out.println("List of Sellers:");
		List<MembroDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MembroDTO> findById(@PathVariable Long id) {
		System.out.println("Seller:");
		MembroDTO v = new MembroDTO(service.findById(id));
		return ResponseEntity.ok(v);
	}
	
	@PostMapping
	public ResponseEntity<Membro> save(@RequestBody Membro Membro) throws Exception {
		try {
			Membro save = service.save(Membro);
			System.out.println("New Seller Saved Sucessfully.");
			return new ResponseEntity<>(save, null, HttpStatus.CREATED);
		}
		catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Membro> update(@PathVariable Long id,@RequestBody Membro Membro) {
		return ResponseEntity.ok(service.update(id, Membro));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		System.out.println("Seller Deleted Sucessfully.");
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
