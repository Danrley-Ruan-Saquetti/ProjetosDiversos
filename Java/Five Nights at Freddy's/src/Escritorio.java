
public class Escritorio {

    private final Game game;
    private boolean portaDir, portaEsq, camera, luzD, luzE;
    private boolean animaPortaEsqCo, animaPortaEsqPi, animaPortaDirFr, animaPortaDirCh;
    private int bateria, contRuidoEP;
    private boolean contRuidoDC, contRuidoDF, contRuidoEC;

    public Escritorio(Game jogo) {
        game = jogo;
        animaPortaEsqCo = false;
        animaPortaDirFr = false;
        animaPortaEsqPi = false;
        animaPortaDirCh = false;
        portaDir = false;
        portaEsq = false;
        bateria = 100;
        luzD = false;
        luzE = false;
        camera = false;
        contRuidoEP = 0;
        contRuidoEC = false;
        contRuidoDF = false;
        contRuidoDC = false;
    }

    //Controle de Portas
    public void abrirPortaDir() {
        if (!isCamera()) {
            setPortaDir(false);
        } else {
            System.out.println("SISTEMA: Impossível abrir a porta. A câmera esta aberta!");
        }
    }

    public void fecharPortaDir() {
        if (!isCamera()) {
            setLuzD(false);
            setLuzE(false);
            setPortaDir(true);
        } else {
            System.out.println("SISTEMA: Impossível fechar a porta. A câmera esta aberta!");
        }
    }

    public void abrirPortaEsq() {
        if (!isCamera()) {
            setPortaEsq(false);
        } else {
            System.out.println("SISTEMA: Impossível abrir a porta. A câmera esta aberta!");
        }
    }

    public void fecharPortaEsq() {
        if (!isCamera()) {
            setLuzE(false);
            setLuzD(false);
            setPortaEsq(true);
        } else {
            System.out.println("SISTEMA: Impossível fechar a porta. A câmera esta aberta!");
        }
    }

    //Controle de Câmera
    public void abrirCamera() {
        setLuzE(false);
        setLuzD(false);
        setCamera(true);
    }

    public void fecharCamera() {
        setCamera(false);
    }

    //Controle de Luz
    public void ligarLuzE() {
        if (!isCamera()) {
            setLuzD(false);
            setLuzE(true);
            setBateria(getBateria() - 1);
        } else {
            System.out.println("SISTEMA: Impossível ligar a luz. A câmera esta aberta!");
        }
    }

    public void desligarLuzE() {
        setLuzE(false);
    }

    public void ligarLuzD() {
        if (!isCamera()) {
            setLuzE(false);
            setLuzD(true);
            setBateria(getBateria() - 1);

        } else {
            System.out.println("SISTEMA: Impossível ligar a luz. A câmera esta aberta!");
        }
    }

    public void desligarLuzD() {
        setLuzD(false);
    }

    //Portas
    public boolean isPortaDir() {
        return portaDir;
    }

    public void setPortaDir(boolean porta) {
        portaDir = porta;
    }

    public boolean isPortaEsq() {
        return portaEsq;
    }

    public void setPortaEsq(boolean porta) {
        portaEsq = porta;
    }

    //Bateria
    public int getBateria() {
        return bateria;
    }

    public void setBateria(int bat) {
        bateria = bat;
        if (getBateria() <= 0) {
            System.out.print("\nSISTEMA: A bateria acabou! O FREDDY TE MATOU!");
            game.setStatus(false);
            game.setDica(1);
        }
    }

    //Luzes
    public boolean isLuzD() {
        return luzD;
    }

    public void setLuzD(boolean luz) {
        luzD = luz;
    }

    public boolean isLuzE() {
        return luzE;
    }

    public void setLuzE(boolean luz) {
        luzE = luz;
    }

    //Câmera
    public boolean isCamera() {
        return camera;
    }

    public void setCamera(boolean cam) {
        camera = cam;
    }

    //Animatronic na porta
    public boolean isAnimaPortaEsqCo() {
        return animaPortaEsqCo;
    }

    public void setAnimaPortaEsqCo(boolean animatronic) {
        animaPortaEsqCo = animatronic;
    }

    public boolean isAnimaPortaDirFr() {
        return animaPortaDirFr;
    }

    public void setAnimaPortaDirFr(boolean animatronic) {
        animaPortaDirFr = animatronic;
    }

    public boolean isAnimaPortaDirCh() {
        return animaPortaDirCh;
    }

    public void setAnimaPortaDirCh(boolean animatronic) {
        animaPortaDirCh = animatronic;
    }

    public boolean isAnimaPortaEsqPi() {
        return animaPortaEsqPi;
    }

    public void setAnimaPortaEsqPi(boolean animatronic) {
        animaPortaEsqPi = animatronic;
    }

    //Ruído
    public int getContRuidoEP() {
        return contRuidoEP;
    }

    public void setContRuidoEP(int cont) {
        contRuidoEP = cont;
    }

    public boolean getContRuidoEC() {
        return contRuidoEC;
    }

    public void setContRuidoEC(boolean cont) {
        contRuidoEC = cont;
    }

    public boolean getContRuidoDF() {
        return contRuidoDF;
    }

    public void setContRuidoDF(boolean cont) {
        contRuidoDF = cont;
    }

    public boolean getContRuidoDC() {
        return contRuidoDC;
    }

    public void setContRuidoDC(boolean cont) {
        contRuidoDC = cont;
    }
}
