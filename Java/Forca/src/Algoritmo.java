
public class Algoritmo {

    private String palavra;
    private boolean letra[];
    private int vida;

    public Algoritmo(String palavra) {
        this.palavra = palavra;
        letra = new boolean[palavra.length()];
        vida = 10;
    }

    public void revelarLetra(String l) {
        boolean errar = true;
        for (int i = 0; i < getLetra().length; i++) {
            if (l.equals(getPalavra().substring(i, i + 1))) {
                letra[i] = true;
            }
            if (getLetra()[i]) {
                errar = false;
            }
        }
        if (errar) {
            letraErrada();
        }
    }

    public boolean verificarPalavra() {
        for (int i = 0; i < getLetra().length; i++) {
            if (!getLetra()[i]) {
                return false;
            }
        }
        return true;
    }

    public void letraErrada() {
        setVida(getVida() - 1);
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public boolean[] getLetra() {
        return letra;
    }

    public void setLetra(boolean[] letra) {
        this.letra = letra;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
}
