package pe.gob.vuce.sgringesta.constants;

public class ConstantesError {

    static {
    }

    public static final String ERR_WS = "Servicio no Disponible";
    public static final String ERR_WS_SERVICIO = "No se puede conectar al servicio de SUNAT";
    public static final String ERR_WS_SUNAT = "El servicio de SUNAT no se encuentra disponible";
    public static final String ERR_WS_SUNAT_PROCESO = "ERROR al procesar el archivo de Liquidacion de Pagos";
    public static final String ERR_WS_ARCHIVO_SUNAT = "No existe archivo de Liquidacion de Pagos de SUNAT";
    public static final String ERR_WS_PROXY_COMMON = "Hubo un error consultando el servicio para obtener datos de VUCE";
    public static final String ERR_WS_PROXY_COMMON_SERV = "El servicio para obtener los datos de VUCE no se encuentra disponible";
    public static final String ERR_WS_PROXY_COMMON_TB = "Se tuvo problemas con el servicio para obtener las liquidaciones de VUCE o no se encuentra disponible";
    public static final String ERR_WS_PROXY_COMMON_ANU_CPB = "Hubo un error con el servicio de anulación de CPB";
    public static final String ERR_WS_PROXY_COMMON_CONC_CPB = "Hubo un error con el servicio de conciliación de CPB";
    public static final String ERR_WS_PROXY_COMMON_RECPAGO = "Hubo un error actualizando el CPB como pagado";
    public static final String ERR_WS_PROXY_COMMON_PAGOEXT = "Hubo un error actualizando el CPB extornado";
    public static final String ERR_WS_PROXY_TRANSMISION = "Hubo un error con la respuesta del Proxy de Transmisiones";
    public static final String ERR_WS_PROXY_TRANSMISION_NODISP = "El servicio Proxy de Transmisiones no se encuentra disponible o presenta problemas";
    public static final String ERR_WS_PROXY_MENSAJE = "Hubo un error con la respuesta del Proxy de Mensajes";
    public static final String ERR_WS_PROXY_MENSAJE_NODISP = "El servicio Proxy de Mensajes no se encuentra disponible o presenta problemas";
    public static final String ERR_WS_NOTIF_COMPONENTE = "Hubo un error con el servicio de notificación del componente";


    public static final String ERR_IO = "Error procesando archivo";
    public static final String ERR_IO_CONVERSION = "Hubo un error procesando el archivo enviado desde SUNAT";
    public static final String ERROR = "Error";
    public static final String OK = "OK";
}
