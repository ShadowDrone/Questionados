package app;

public class Respuesta {

    public Respuesta(String texto, boolean esCorrecta) {
        this.texto = texto;
        this.esCorrecta = esCorrecta;
    }

    public Respuesta(String texto) {
        this.texto = texto;
    }

    private String texto;
    private boolean esCorrecta;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean getEsCorrecta() {
        return esCorrecta;
    }

    public void setEsCorrecta(boolean esCorrecta) {
        this.esCorrecta = esCorrecta;
    }

}
