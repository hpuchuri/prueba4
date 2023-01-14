package pe.gob.vuce.sgringesta.constants;

public class ConstantesGenerales {

    static {
    }

    public final static String ROOT_WEB_APPLICATION_CONTEXT = "org.springframework.web.context.WebApplicationContext.ROOT";
    public static final String SEPARADOR_FILE_LIQUIDACION_CDA = "|";
    // Codificación
    public static final String UTF8 = "UTF-8";
    // Nombres de campos HashMap
    public static final String NM_fileName = "fileName";
    // Nombres de parámetros ?
    public static final String URI_PROXY_COMMON_HOSTNAME = "https://landing-test.vuce.gob.pe";
    public static final String URI_PROXY_COMMON_HOSTNAME_LOCAL = "http://localhost:8030";

    public static final String URI_PROXY_COMMON_SERVICE = "/v1/vuce-services/pasarela/commons";
    public static final String URI_PROXY_COMMON_METHOD_LISTA_INGESTA = "/ingesta/listado";
    public static final String URI_PROXY_COMMON_METHOD_UPDATE_INGESTA = "/ingesta/actualizaColaIngesta";
    // Constantes util
    public static final String NC_fechaCompara = "dd/MM/yyyy";
    // Alertas
    public static final String ALERTA_PROCESO_ASUNTO = "Error procesando Liquidación";
    // WS
    public static final String NWS_HEADER_CONTENT = "Content-type";
    public static final String NWS_HEADER_CONTENT_VALUE = "application/json";
    public static final String NWS_HEADER_ACCEPT = "Accept";
    public static final String NWS_HEADER_ACCEPT_VALUE = "*/*";
}
