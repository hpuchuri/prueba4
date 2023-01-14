package pe.gob.vuce.sgringesta.entity;

import org.json.simple.JSONObject;
import pe.gob.vuce.sgringesta.model.IngestaDatosRequest;

import javax.persistence.*;
import javax.validation.Valid;

@Table(name="cola_ingesta", catalog = "vuceca01", schema = "grobj")
@Entity
@NamedNativeQueries({
    @NamedNativeQuery(
        name = "ColaIngesta.getList",
        query = "SELECT c.cola_ingesta_id, c.cuerpo " +
				"FROM grobj.cola_ingesta c WHERE c.cola_ingesta_id in (106) " +
				"ORDER BY cola_ingesta_id " ,
			resultClass= ColaIngesta.class
    )


})

public class ColaIngesta extends JSONObject {
    @Id
    @GeneratedValue
	@Column(name ="cola_ingesta_id")
    private String colaIngestaID;

	@Basic
	@Column(name ="cuerpo")
    private @Valid String cuerpo;


	public ColaIngesta() {
	}

	public ColaIngesta(String colaIngestaID, @Valid String cuerpo
					   ) {
		this.colaIngestaID = colaIngestaID;
		this.cuerpo = cuerpo;
	}

	public ColaIngesta(@Valid String cuerpo
	) {
		this.cuerpo = cuerpo;
	}

	public String getColaIngestaID() {
		return colaIngestaID;
	}

	public void setColaIngestaID(String colaIngestaID) {
		this.colaIngestaID = colaIngestaID;
	}

	public @Valid String getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(@Valid String cuerpo) {
		this.cuerpo = cuerpo;
	}
}
