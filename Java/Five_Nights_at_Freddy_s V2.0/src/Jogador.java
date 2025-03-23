
import java.io.Serializable;
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
    private int record;
    private int mortes;
    private int historia;

    public Jogador() {
        historia = 1;
    }

    public int getRecord() {
        return record;
    }

    public void setRecord(int record) {
        this.record = record;
    }

    public int getMortes() {
        return mortes;
    }

    public void setMortes(int mortes) {
        this.mortes = mortes;
    }

    public int getHistoria() {
        return historia;
    }

    public void setHistoria(int historia) {
        this.historia = historia;
    }

    @Override
    public String toString() {
        return "Record: " + getRecord() + " pontos\n|Modo História: noite " + getHistoria()
                + "\n|Número de Mortes: " + getMortes();
    }
}
