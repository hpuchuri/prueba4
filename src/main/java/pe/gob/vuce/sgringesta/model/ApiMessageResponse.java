package pe.gob.vuce.sgringesta.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

/**
 * Objeto usado para retornar mensaje de 2xx,3xx,4xx,5xx
 */
@Schema(description = "Objeto usado para retornar mensaje de 2xx,3xx,4xx,5xx")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-06T01:24:38.459Z[GMT]")


public class ApiMessageResponse   {
  @JsonProperty("type_message")
  private String typeMessage = null;

  @JsonProperty("alias_message")
  private String aliasMessage = null;

  @JsonProperty("description_message")
  private String descriptionMessage = null;

  public ApiMessageResponse(String typeMessage, String aliasMessage, String descriptionMessage) {
    this.typeMessage = typeMessage;
    this.aliasMessage = aliasMessage;
    this.descriptionMessage = descriptionMessage;
  }

  public ApiMessageResponse typeMessage(String typeMessage) {
    this.typeMessage = typeMessage;
    return this;
  }

  /**
   * Tipo de mensaje como: ERROR, VALIDATION, SUCCESSFULL
   * @return typeMessage
   **/
  @Schema(description = "Tipo de mensaje como: ERROR, VALIDATION, SUCCESSFULL")
  
    public String getTypeMessage() {
    return typeMessage;
  }

  public void setTypeMessage(String typeMessage) {
    this.typeMessage = typeMessage;
  }

  public ApiMessageResponse aliasMessage(String aliasMessage) {
    this.aliasMessage = aliasMessage;
    return this;
  }

  /**
   * Descripcion corta del mensaje como APP_BASE
   * @return aliasMessage
   **/
  @Schema(description = "Descripcion corta del mensaje como APP_BASE")
  
    public String getAliasMessage() {
    return aliasMessage;
  }

  public void setAliasMessage(String aliasMessage) {
    this.aliasMessage = aliasMessage;
  }

  public ApiMessageResponse descriptionMessage(String descriptionMessage) {
    this.descriptionMessage = descriptionMessage;
    return this;
  }

  /**
   * Descripcion larga del mensaje
   * @return descriptionMessage
   **/
  @Schema(description = "Descripcion larga del mensaje")
  
    public String getDescriptionMessage() {
    return descriptionMessage;
  }

  public void setDescriptionMessage(String descriptionMessage) {
    this.descriptionMessage = descriptionMessage;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiMessageResponse apiMessageResponse = (ApiMessageResponse) o;
    return Objects.equals(this.typeMessage, apiMessageResponse.typeMessage) &&
        Objects.equals(this.aliasMessage, apiMessageResponse.aliasMessage) &&
        Objects.equals(this.descriptionMessage, apiMessageResponse.descriptionMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(typeMessage, aliasMessage, descriptionMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiMessageResponse {\n");
    
    sb.append("    typeMessage: ").append(toIndentedString(typeMessage)).append("\n");
    sb.append("    aliasMessage: ").append(toIndentedString(aliasMessage)).append("\n");
    sb.append("    descriptionMessage: ").append(toIndentedString(descriptionMessage)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
