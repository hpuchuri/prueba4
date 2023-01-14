package pe.gob.vuce.sgringesta.exception;

public class WSException extends RuntimeException{
    private Integer liquidacionId;

    public WSException() {
        super();
    }

    public WSException(String message) {
        super(message);
    }

    public WSException(String message, Integer liquidacionId) {

        super(message);
        this.liquidacionId = liquidacionId;
    }

    public WSException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public WSException(String message, Throwable cause) {
        super(message, cause);
    }

    public WSException(Throwable cause) {
        super(cause);
    }

    public Integer getLiquidacionId() {
        return liquidacionId;
    }

    public void setLiquidacionId(Integer liquidacionId) {
        this.liquidacionId = liquidacionId;
    }
}
