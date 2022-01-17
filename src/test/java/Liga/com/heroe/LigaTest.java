package Liga.com.heroe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import Liga.com.heroe.Model.Membro;
import Liga.com.heroe.Repository.MembroRepository;

@SpringBootTest
public class LigaTest {

	@Autowired
	private MembroRepository MembroRepository;
	
	@Test
	public void CreateTest (){
		Membro Membro = new Membro(1L,"Flash","Terra","Super Velocidade","MetaHumano");
		MembroRepository.save(Membro);
		assertNotNull(Membro);
	}
	
	@Test
	public void DeleteTest(){
		Membro Membro = new Membro(1L,"Flash","Terra","Super Velocidade","MetaHumano");
		MembroRepository.save(Membro);
		Long id = Membro .getId();
		boolean presente1 = MembroRepository.findById(id).isPresent();
		MembroRepository.deleteById(id);
		boolean presente2 = MembroRepository.findById(id).isPresent();
		assertTrue(presente1);
		assertFalse(presente2);
	}
	
	@Test
	public void UpdateTest () {
		String nome = "Arqueiro Verde";
		Membro Membro = new Membro(1L,"Flash","Terra","Super Velocidade","MetaHumano");
		MembroRepository.save(Membro);
		Membro seller = MembroRepository.findById(1L).get();
		seller.setNome(nome);
		Membro liga = MembroRepository.save(seller);
		assertEquals(liga.getNome(),nome);
	}
}
