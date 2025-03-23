package views;

import entities.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dan Ruan
 */
public class ModelCliente extends AbstractTableModel {

    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int i, int j) {
        Cliente c = clientes.get(i);

        switch (j) {
            case 0: {
                return c.getId();
            }
            case 1: {
                return c.getNome();
            }
            case 2: {
                return c.getCpf();
            }
            case 3: {
                return c.getEmail();
            }
            case 4: {
                return c.getTelefone();
            }
            case 5: {
                return c.getEndereco();
            }
        }

        return "";
    }

    @Override
    public String getColumnName(int j) {
        switch (j) {
            case 0: {
                return "Código";
            }
            case 1: {
                return "Nome";
            }
            case 2: {
                return "CPF";
            }
            case 3: {
                return "Email";
            }
            case 4: {
                return "Telefone";
            }
            case 5: {
                return "Endereço";
            }
        }
        return "";
    }
    
    public void limpar() {
        clientes.clear();
    }

    public void excluirCliente(int posicao) {
        clientes.remove(posicao);
        fireTableRowsDeleted(posicao, posicao);
    }

    public Cliente getCliente(int posicao) {
        return clientes.get(posicao);
    }

    public void inserirClientes(Cliente c) {
        clientes.add(c);
        fireTableRowsInserted(clientes.size() - 1, clientes.size() - 1);
    }
}
