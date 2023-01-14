package pe.gob.vuce.sgringesta.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.json.simple.JSONObject;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * IngestaDatoRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-06T01:24:38.459Z[GMT]")


public class IngestaDatosRequest {
  @JsonProperty("tabla")
  private String tabla = null;

  @JsonProperty("tipo")
  private String tipo = null;

  @JsonProperty("fecha_generacion")
  private String fechaGeneracion = null;

  @JsonProperty("datos")
  private JSONObject datos = null;

  public IngestaDatosRequest tabla(String tabla) {
    this.tabla = tabla;
    return this;
  }

  /**
   * Tabla de la Ingesta de Datos
   * @return tabla
   **/
  @Schema(description = "Entidad de la ingesta")

  public String getTabla() {
    return tabla;
  }

  public void setTabla(String tabla) {
    this.tabla = tabla;
  }

  public IngestaDatosRequest tipo(String tipo) {
    this.tipo = tipo;
    return this;
  }

  /**
   * Tipo la Ingesta de Datos
   * @return tipo
   **/
  @Schema(description = "Tipo de la ingesta")

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public IngestaDatosRequest datos(JSONObject datos) {
    this.datos = datos;
    return this;
  }

  /**
   * Datos de la ingesta de STRING en formato JSON
   * @return datos
   **/
  @Schema(description = "Fecha de Generacion de la ingesta de Date en formato JSON")

  public String getFechaGeneracion() {
    return fechaGeneracion;
  }

  public void setFechaGeneracion(String fechaGeneracion) {
    this.fechaGeneracion = fechaGeneracion;
  }

  /**
   * Datos de la ingesta de STRING en formato JSON
   * @return datos
   **/
  @Schema(description = "Datos de la ingesta de STRING en formato JSON")

  public JSONObject getDatos() {
    return datos;
  }

  public void setDatos(JSONObject datos) {
    this.datos = datos;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IngestaDatosRequest sgrSelectividadRequest = (IngestaDatosRequest) o;
    return Objects.equals(this.tabla, sgrSelectividadRequest.tabla) &&
            Objects.equals(this.tipo, sgrSelectividadRequest.tipo) &&
            Objects.equals(this.fechaGeneracion, sgrSelectividadRequest.fechaGeneracion) &&
            Objects.equals(this.datos, sgrSelectividadRequest.datos);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tabla, tipo, fechaGeneracion, datos);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SgrSelectividadRequest {\n");

    sb.append("    tabla: ").append(toIndentedString(tabla)).append("\n");
    sb.append("    tipo: ").append(toIndentedString(tipo)).append("\n");
    sb.append("    fechaGeneracion: ").append(toIndentedString(fechaGeneracion)).append("\n");
    sb.append("    datos: ").append(toIndentedString(datos)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
