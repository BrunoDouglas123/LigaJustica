package Liga.com.heroe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Liga.com.heroe.Model.Membro;

@Repository
public interface MembroRepository extends JpaRepository <Membro,Long> {

}
