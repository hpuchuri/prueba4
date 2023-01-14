/**
 * @author: Leonardo Ivan Torres Ochoa [31/05/2020]
 * @updated: 31/05/2020
 * @description: Signature Service Api
 * @since-version: 1.0
 * @email: leonardotorres@adiera.com
 * @web: www.adieraservices.com
 */
package pe.gob.vuce.sgringesta.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import pe.gob.vuce.sgringesta.exception.ServiceException;
import pe.gob.vuce.sgringesta.model.IngestaDatosRequest;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class LibrariesApp {

    public static int MENU_ID_PERMISO_LECTURA = 1;
    public static int MENU_ID_PERMISO_ESCRITURA = 2;
    public static String MESSAGE_VALIDATION_ACCESO = "Usted no tiene acceso para esta accion!";
    public static String IDENTIFIER_VALIDATION_ACCESO = "400_NOT_PERMITED";

    public static String TAG_NODO_MENU = "NODO_MENU";
    public static int ROL_ID_DEFAULT = 2;
    public static String USERNAME_ADMIN = "admin";
    public static Integer DEFAULT_USUARIO_ID = 1;
    public static Integer ESTADO_EMISION_ID = 1;
    public static DateFormat dateFormat01 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String getDateFormat01()
    {
        Date date = Calendar.getInstance().getTime();
        return dateFormat01.format(date);
    }

    //LPad("Hi", 10, 'R') //gives "RRRRRRRRHi"
    //RPad("Hi", 10, 'R') //gives "HiRRRRRRRR"
    //RPad("Hi", 10, ' ') //gives "Hi        "
    public static String LPad(String str, Integer length, char car) {
        String result = str;
        if (length!=str.length()) {
            result = str + String.format("%" + (length - str.length()) + "s", "").replace(" ", String.valueOf(car));
        }
        return result;
    }

    public static String RPad(String str, Integer length, char car) {
        String result = str;
        if (length!=str.length()) {
            result = String.format("%" + (length - str.length()) + "s", "").replace(" ", String.valueOf(car)) + str;
        }
        return result;
    }

    public static String getNameMonth(String mes) {
        String result = "Enero";
        switch (mes) {
            case "01" : result = "Enero"; break;
            case "02" : result = "Febrero"; break;
            case "03" : result = "Marzo"; break;
            case "04" : result = "Abril"; break;
            case "05" : result = "Mayo"; break;
            case "06" : result = "Junio"; break;
            case "07" : result = "Julio"; break;
            case "08" : result = "Agosto"; break;
            case "09" : result = "Setiembre"; break;
            case "10" : result = "Octubre"; break;
            case "11" : result = "Noviembre"; break;
            case "12" : result = "Diciembre"; break;
        }
        return result;
    }
    public static String formatDateRange(String inicioRango, String finalRango) {
        //recibe YYYY-MM-DD
        String result = "Del " + inicioRango.substring(8,10) + "/" + inicioRango.substring(5,7) + "/" + inicioRango.substring(0,4) + " al " + finalRango.substring(8,10) + "/" + finalRango.substring(5,7) + "/" + finalRango.substring(0,4);
        return result;
    }

    public static String isEmpty(Object obj) {

        if(obj!=null) {

            if (obj instanceof Date) {
                return obj.toString();
            } else if(obj instanceof String) {
                return obj.toString();
            } else if (obj instanceof Integer) {
                return obj.toString();
            } else if (obj instanceof BigDecimal) {
                return obj.toString();
            }
        }

        return new String(" ");
    }

    /**
     * Retorna una cadena el tiempo en el formato yyyyMMddHHmmss mas un aleatorio de 6 digitos
     * @return Retorna una cadena String
     */
    public static String getRandomByYear() {
        Calendar cal = Calendar.getInstance();
        int nYear = cal.get(Calendar.YEAR);
        Random numero = new Random();
        int randomNum = numero.nextInt(9990000) + 1000000;
        return String.valueOf(nYear) + Integer.toString(randomNum);
    }
    public static String getUnique() {
        long timeNow = new Date().getTime();
        String fechaAhora = new SimpleDateFormat("yyyyMMddHHmmss").format(timeNow);

        Random numero = new Random();
        int randomNum = numero.nextInt(999000) + 100000;
        String codigo = Integer.toString(randomNum);

        return fechaAhora+codigo+"_";
    }
    public static String getToken() {
        UUID unique = UUID.randomUUID();
        return  unique.toString();
    }
    public static String createDirectory(String pathInitial) {
        String strRutaFinal = pathInitial;
        try {
            Calendar cal = Calendar.getInstance();
            int nYear = cal.get(Calendar.YEAR);
            int nMonth = cal.get(Calendar.MONTH) + 1;
            strRutaFinal =  String.valueOf(nYear)  + padleft("" + nMonth, 2, '0');
            File directory = new File(pathInitial + strRutaFinal);
            directory.mkdirs();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return strRutaFinal;
    }
    public static String padleft(String s, int n, char c) {
        int len = s.length();
        if (len >= n)
            return s;
        char[] buf = new char[n];
        for (int i = 0; i < n - len; i++)
            buf[i] = c;
        s.getChars(0, len, buf, n - len);
        return new String(buf);
    }
    public static Boolean isValidJson(String maybeJson) throws ServiceException {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            mapper.enable(JsonParser.Feature.STRICT_DUPLICATE_DETECTION);
            mapper.readTree(maybeJson);
            return true;
        } catch (IOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
    public static boolean validStringToDate(String fechaStr) throws ServiceException{
        try {
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            format.parse(fechaStr);
            return true;
        }catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }
    public static String updateJson(String maybeJson) throws ServiceException {
        String replaceString=maybeJson.replace("NULL","null");//replaces all occurrences of 'NULL' to 'null'
        return replaceString;
    }

    public static IngestaDatosRequest readJson(String fileJson){
        IngestaDatosRequest ingesta = new IngestaDatosRequest();
        JSONParser parser = new JSONParser();
        final ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> mapFromString = new HashMap<>();
        try {
            //mapper.configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true);
            mapper.configure(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature(),true);
            //mapper.configure(JsonReadFeature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER.mappedFeature(),true);
            mapFromString = mapper.readValue(fileJson, new TypeReference<Map<String, Object>>() {});
            JSONObject config = new JSONObject(mapFromString);
            //--add campos
            ingesta.setTabla((String) config.get("tabla"));
            ingesta.setTipo((String) config.get("tipo"));
            ingesta.setFechaGeneracion((String) config.get("fecha_generacion"));
            Map<String, Object> datosMap = mapper.readValue(updateJson((String) config.get("datos")),
                    new TypeReference<Map<String, Object>>() {});
            ingesta.setDatos(new JSONObject(datosMap));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ingesta;
    }

}

