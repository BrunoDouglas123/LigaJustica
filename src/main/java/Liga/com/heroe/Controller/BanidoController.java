package Liga.com.heroe.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Liga.com.heroe.DTO.BanidoDTO;
import Liga.com.heroe.Model.Banido;
import Liga.com.heroe.Service.BanidoService;

@RestController
@RequestMapping(value = "/banidos")
public class BanidoController {
	
	@Autowired
	private BanidoService service;
	
	@GetMapping
	public ResponseEntity<List<BanidoDTO>> findAll() {
		System.out.println("List of Products:");
		List<BanidoDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BanidoDTO> findById(@PathVariable Long id) {
		System.out.println("Product:");
		BanidoDTO p = new BanidoDTO(service.findById(id));
		return ResponseEntity.ok(p);
	}
	
	@PostMapping
	public ResponseEntity<BanidoDTO> save(@RequestBody Banido Banido) {
		System.out.println("New Product Saved Sucessfully.");
		BanidoDTO p = new BanidoDTO(service.save(Banido));
		return ResponseEntity.ok(p);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Banido> update(@PathVariable Long id,@RequestBody Banido Banido) {
		return ResponseEntity.ok(service.update(id, Banido));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		System.out.println("Product Deleted Sucessfully.");
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
