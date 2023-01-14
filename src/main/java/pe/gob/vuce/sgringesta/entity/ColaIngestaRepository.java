package pe.gob.vuce.sgringesta.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaIngestaRepository extends JpaRepository<ColaIngesta, String> {
	List<ColaIngesta> getList();


}
