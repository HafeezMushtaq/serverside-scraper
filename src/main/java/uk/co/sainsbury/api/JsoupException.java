package uk.co.sainsbury.api;

public class JsoupException extends Exception {

    private static final long serialVersionUID = -8584659345640355813L;

    public JsoupException(String errorMessage) {
        super(errorMessage);
    }

    public JsoupException(String errorMessage, Throwable t) {
        super(errorMessage, t);
    }

}
