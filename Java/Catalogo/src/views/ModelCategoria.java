package views;

import entities.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dan Ruan
 */
public class ModelCategoria extends AbstractTableModel {

    private List<Categoria> categorias = new ArrayList<>();

    @Override
    public int getRowCount() {
        return categorias.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int i, int j) {
        Categoria c = categorias.get(i);

        switch (j) {
            case 0: {
                return c.getId();
            }
            case 1: {
                return c.getNome();
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
        }
        return "";
    }
    
    public void limpar() {
        categorias.clear();
    }
    
    public void excluirCategoria(int i) {
        categorias.remove(i);
        fireTableRowsDeleted(i, i);
    }
    
    public Categoria getCategoria(int i) {
        return categorias.get(i);
    }
    
    public void inserirCategorias(Categoria c) {
        categorias.add(c);
        fireTableRowsInserted(categorias.size() - 1, categorias.size() - 1);
    }
}
