
import java.io.Serializable;
import java.text.DecimalFormat;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jogador")
public class Jogador implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private final String nome;
    private final int senha;
    private int vitoriaRoleta, derrotaRoleta, totalRoleta;
    private int vitoriaCacaNiquel, derrotaCacaNiquel, totalCacaNiquel;
    private int vitoriaBingo, derrotaBingo, totalBingo;
    private int vitoriaGeneral, derrotaGeneral, totalGeneral;
    private int vitoriaPoker, derrotaPoker, totalPoker;
    private int vitoriaTotal, derrotaTotal, totalJogos;
    private double vR_dR, vC_dC, vB_dB, vG_dG, vP_dP, vT_dT;
    private double saldo, saldoLucrado, saldoPerdido;

    public Jogador() {
        nome = "Guest";
        senha = 0;
        saldo = 50;
        vitoriaRoleta = 0;
        derrotaRoleta = 0;
        totalRoleta = 0;
        vitoriaCacaNiquel = 0;
        derrotaCacaNiquel = 0;
        totalCacaNiquel = 0;
        vitoriaBingo = 0;
        derrotaBingo = 0;
        totalBingo = 0;
        vitoriaGeneral = 0;
        derrotaGeneral = 0;
        totalGeneral = 0;
        vitoriaPoker = 0;
        derrotaPoker = 0;
        totalPoker = 0;
        vitoriaTotal = 0;
        derrotaTotal = 0;
        totalJogos = 0;
        vR_dR = 0;
        vC_dC = 0;
        vB_dB = 0;
        vG_dG = 0;
        vP_dP = 0;
        vT_dT = 0;
        saldoLucrado = 0;
        saldoPerdido = 0;
    }

    public Jogador(String n, int c) {
        nome = n;
        senha = c;
        saldo = 50;
        vitoriaRoleta = 0;
        derrotaRoleta = 0;
        totalRoleta = 0;
        vitoriaCacaNiquel = 0;
        derrotaCacaNiquel = 0;
        totalCacaNiquel = 0;
        vitoriaBingo = 0;
        derrotaBingo = 0;
        totalBingo = 0;
        vitoriaGeneral = 0;
        derrotaGeneral = 0;
        totalGeneral = 0;
        vitoriaPoker = 0;
        derrotaPoker = 0;
        totalPoker = 0;
        vitoriaTotal = 0;
        derrotaTotal = 0;
        totalJogos = 0;
        vR_dR = 0;
        vC_dC = 0;
        vB_dB = 0;
        vG_dG = 0;
        vP_dP = 0;
        vT_dT = 0;
        saldoLucrado = 0;
        saldoPerdido = 0;
    }

    public void atualizarSaldo(double valor) {
        setSaldo(getSaldo() + valor);
        if (getSaldo() > 99999999.99) {
            setSaldo(99999999.99);
        }
        atualizarVB_DB();
        atualizarVC_DC();
        atualizarVG_DG();
        atualizarVP_DP();
        atualizarVR_DR();
        atualizarVT_DT();
    }

    public void atualizarVR_DR() {
        if (getTotalRoleta() > 0) {
            setvR_dR((getVitoriaRoleta() * 100) / getTotalRoleta());
        }
    }

    public void atualizarVC_DC() {
        if (getTotalCacaNiquel() > 0) {
            setvC_dC((getVitoriaCacaNiquel() * 100) / getTotalCacaNiquel());
        }
    }

    public void atualizarVB_DB() {
        if (getTotalBingo() > 0) {
            setvB_dB((getVitoriaBingo() * 100) / getTotalBingo());
        }
    }

    public void atualizarVG_DG() {
        if (getTotalGeneral() > 0) {
            setvG_dG((getVitoriaGeneral() * 100) / getTotalGeneral());
        }
    }

    public void atualizarVP_DP() {
        if (getTotalPoker() > 0) {
            setvP_dP((getVitoriaPoker() * 100) / getTotalPoker());
        }
    }

    public void atualizarVT_DT() {
        if (getTotalJogos() > 0) {
            setvT_dT((getVitoriaTotal() * 100) / getTotalJogos());
        }
    }

    public String getNome() {
        return nome;
    }

    public int getSenha() {
        return senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getVitoriaRoleta() {
        return vitoriaRoleta;
    }

    public void setVitoriaRoleta(int vitoriaRoleta) {
        this.vitoriaRoleta = vitoriaRoleta;
    }

    public int getDerrotaRoleta() {
        return derrotaRoleta;
    }

    public void setDerrotaRoleta(int derrotaRoleta) {
        this.derrotaRoleta = derrotaRoleta;
    }

    public int getTotalRoleta() {
        return totalRoleta;
    }

    public void setTotalRoleta(int totalRoleta) {
        this.totalRoleta = totalRoleta;
    }

    public int getVitoriaCacaNiquel() {
        return vitoriaCacaNiquel;
    }

    public void setVitoriaCacaNiquel(int vitoriaCacaNiquel) {
        this.vitoriaCacaNiquel = vitoriaCacaNiquel;
    }

    public int getDerrotaCacaNiquel() {
        return derrotaCacaNiquel;
    }

    public void setDerrotaCacaNiquel(int derrotaCacaNiquel) {
        this.derrotaCacaNiquel = derrotaCacaNiquel;
    }

    public int getTotalCacaNiquel() {
        return totalCacaNiquel;
    }

    public void setTotalCacaNiquel(int totalCacaNiquel) {
        this.totalCacaNiquel = totalCacaNiquel;
    }

    public int getVitoriaBingo() {
        return vitoriaBingo;
    }

    public void setVitoriaBingo(int vitoriaBingo) {
        this.vitoriaBingo = vitoriaBingo;
    }

    public int getDerrotaBingo() {
        return derrotaBingo;
    }

    public void setDerrotaBingo(int derrotaBingo) {
        this.derrotaBingo = derrotaBingo;
    }

    public int getTotalBingo() {
        return totalBingo;
    }

    public void setTotalBingo(int totalBingo) {
        this.totalBingo = totalBingo;
    }

    public int getVitoriaGeneral() {
        return vitoriaGeneral;
    }

    public void setVitoriaGeneral(int vitoriaGeneral) {
        this.vitoriaGeneral = vitoriaGeneral;
    }

    public int getDerrotaGeneral() {
        return derrotaGeneral;
    }

    public void setDerrotaGeneral(int derrotaGeneral) {
        this.derrotaGeneral = derrotaGeneral;
    }

    public int getTotalGeneral() {
        return totalGeneral;
    }

    public void setTotalGeneral(int totalGeneral) {
        this.totalGeneral = totalGeneral;
    }

    public int getVitoriaPoker() {
        return vitoriaPoker;
    }

    public void setVitoriaPoker(int vitoriaPoker) {
        this.vitoriaPoker = vitoriaPoker;
    }

    public int getDerrotaPoker() {
        return derrotaPoker;
    }

    public void setDerrotaPoker(int derrotaPoker) {
        this.derrotaPoker = derrotaPoker;
    }

    public int getTotalPoker() {
        return totalPoker;
    }

    public void setTotalPoker(int totalPoker) {
        this.totalPoker = totalPoker;
    }

    public int getVitoriaTotal() {
        return vitoriaTotal;
    }

    public void setVitoriaTotal(int vitoriaTotal) {
        this.vitoriaTotal = vitoriaTotal;
    }

    public int getDerrotaTotal() {
        return derrotaTotal;
    }

    public void setDerrotaTotal(int derrotaTotal) {
        this.derrotaTotal = derrotaTotal;
    }

    public int getTotalJogos() {
        return totalJogos;
    }

    public void setTotalJogos(int jogosTotais) {
        this.totalJogos = jogosTotais;
    }

    public double getvR_dR() {
        return vR_dR;
    }

    public void setvR_dR(double vR_dR) {
        this.vR_dR = vR_dR;
    }

    public double getvC_dC() {
        return vC_dC;
    }

    public void setvC_dC(double vC_dC) {
        this.vC_dC = vC_dC;
    }

    public double getvB_dB() {
        return vB_dB;
    }

    public void setvB_dB(double vB_dB) {
        this.vB_dB = vB_dB;
    }

    public double getvG_dG() {
        return vG_dG;
    }

    public void setvG_dG(double vG_dG) {
        this.vG_dG = vG_dG;
    }

    public double getvP_dP() {
        return vP_dP;
    }

    public void setvP_dP(double vP_dP) {
        this.vP_dP = vP_dP;
    }

    public double getvT_dT() {
        return vT_dT;
    }

    public void setvT_dT(double vT_dT) {
        this.vT_dT = vT_dT;
    }

    public double getSaldoLucrado() {
        return saldoLucrado;
    }

    public void setSaldoLucrado(double saldoLucrado) {
        this.saldoLucrado = saldoLucrado;
    }

    public double getSaldoPerdido() {
        return saldoPerdido;
    }

    public void setSaldoPerdido(double saldoPerdido) {
        this.saldoPerdido = saldoPerdido;
    }

    public String espaco(double valor) {
        return "";
    }
    
    public String instrucao() {
        return "";
    }

    @Override
    public String toString() {
        DecimalFormat dF = new DecimalFormat("0.00");
        atualizarVB_DB();
        atualizarVC_DC();
        atualizarVG_DG();
        atualizarVP_DP();
        atualizarVR_DR();
        atualizarVT_DT();

        return "+-\n|Nome = " + getNome() + "\tSenha = " + getSenha()
                + "\n|Saldo = " + dF.format(getSaldo()) + "\tSaldo Lucrado = " + dF.format(getSaldoLucrado()) + "\tSaldo Perdido = " + dF.format(getSaldoPerdido())
                + "\n|Roleta - Total de jogos       = " + getTotalRoleta() + "\t Vitória = " + getVitoriaRoleta() + "\t Derrota = " + getDerrotaRoleta() + "\t V/D = " + dF.format(getvR_dR()) + "%"
                + "\n|Caça Níqueis - Total de jogos = " + getTotalCacaNiquel() + "\t Vitória = " + getVitoriaCacaNiquel() + "\t Derrota = " + getDerrotaCacaNiquel() + "\t V/D = " + dF.format(getvC_dC()) + "%"
                + "\n|Bingo - Total de jogos        = " + getTotalBingo() + "\t Vitória = " + getVitoriaBingo() + "\t Derrota = " + getDerrotaBingo() + "\t V/D = " + dF.format(getvB_dB()) + "%"
                + "\n|General - Total de jogos      = " + getTotalGeneral() + "\t Vitória = " + getVitoriaGeneral() + "\t Derrota = " + getDerrotaGeneral() + "\t V/D = " + dF.format(getvG_dG()) + "%"
                + "\n|Poker - Total de jogos        = " + getTotalPoker() + "\t Vitória = " + getVitoriaPoker() + "\t Derrota = " + getDerrotaPoker() + "\t V/D = " + dF.format(getvP_dP()) + "%"
                + "\n|Total de Jogos                = " + getTotalJogos() + "\t Vitoria = " + getVitoriaTotal() + "\t Derrota = " + getDerrotaTotal() + "\t V/D = " + dF.format(getvT_dT()) + "%\n+-";
    }
}
