package Liga.com.heroe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Liga.com.heroe.Model.Banido;

@Repository
public interface BanidoRepository extends JpaRepository <Banido,Long>{

}
