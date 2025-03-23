package controllers;

import entities.Categoria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import models.DaoCategoria;
import views.FCadCategoria;
import views.FConCategoria;
import views.ModelCategoria;

/**
 *
 * @author Dan Ruan
 */
public class ControlCategoria {

    private FCadCategoria fCadCategoria;
    private FConCategoria fConCategoria;
    private ModelCategoria modelCategoria;
    private DaoCategoria daoCat;
    private Categoria categoriaSelecionada;

    public ControlCategoria() {
        this.fCadCategoria = new FCadCategoria(null, true);
        this.fConCategoria = new FConCategoria(null, true);
        this.modelCategoria = new ModelCategoria();
        this.daoCat = new DaoCategoria();
        this.categoriaSelecionada = null;
        inicializaComponentes();
    }

    private void inicializaComponentes() {
        this.fConCategoria.tbCategorias.setModel(this.modelCategoria);

        this.fCadCategoria.btCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarCategoria();
            }
        });

        this.fCadCategoria.btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelarCadastro();
            }
        });

        this.fConCategoria.btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelarConsulta();
            }
        });

        this.fConCategoria.btExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluirCategoria();
            }
        });

        this.fConCategoria.btEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executarEdicao();
            }
        });
    }

    public void executarCadastro() {
        limparCadastro();
        this.fCadCategoria.setVisible(true);
    }

    private void cadastrarCategoria() {
        if (this.categoriaSelecionada == null) {
            String nome = this.fCadCategoria.inputNome.getText();

            if (!"".equals(nome)) {
                if (this.daoCat.inserir(new Categoria(nome))) {
                    JOptionPane.showMessageDialog(null, "Sucesso ao cadastrar a Categoria.");
                    cancelarCadastro();
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar a Categoria.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "O campo do \"Nome\" é obrigatório.");
            }
        } else {
            editarCategoria();
        }
    }

    private void executarEdicao() {
        int indiceSelecionado = this.fConCategoria.tbCategorias.getSelectedRow();

        if (indiceSelecionado >= 0) {
            selecionarCategoria();
            this.fCadCategoria.inputNome.setText(this.categoriaSelecionada.getNome());

            cancelarConsulta();
            this.fCadCategoria.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um registro da lista de Categoria.");
        }
    }

    private void editarCategoria() {
        String nome = this.fCadCategoria.inputNome.getText();

        if (!"".equals(nome)) {
            if (!nome.equals(this.categoriaSelecionada.getNome())) {
                this.categoriaSelecionada.setNome(nome);

                if (this.daoCat.editar(this.categoriaSelecionada)) {
                    JOptionPane.showMessageDialog(null, "Sucesso ao editar a Categoria.");
                    cancelarEdicao();
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar a Categoria.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nada alterado.");
                cancelarEdicao();
            }
        } else {
            JOptionPane.showMessageDialog(null, "O campo do \"Nome\" é obrigatório.");
        }
    }

    private void cancelarEdicao() {
        this.categoriaSelecionada = null;
        fCadCategoria.setVisible(false);
        executarConsulta();
    }

    private void excluirCategoria() {
        if (!daoCat.listar().isEmpty()) {
            int indiceSelecionado = this.fConCategoria.tbCategorias.getSelectedRow();

            if (indiceSelecionado >= 0) {
                System.out.println(indiceSelecionado);
                Categoria c = this.modelCategoria.getCategoria(indiceSelecionado);

                if (JOptionPane.showConfirmDialog(null, "Deseja excluir a Categoria " + c.getNome() + "?") == 0) {
                    if (daoCat.remover(c)) {
                        JOptionPane.showMessageDialog(null, "Categoria excluída com sucesso.");
                        this.modelCategoria.excluirCategoria(indiceSelecionado);
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao excluir a Categoria.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um registro da categoria.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não há categorias para excluir.");
        }
    }

    private void carregarConsulta() {
        limparConsulta();
        for (Categoria categoria : daoCat.listar()) {
            addCategoriaLista(categoria);
        }
    }

    private void addCategoriaLista(Categoria c) {
        this.modelCategoria.inserirCategorias(c);
    }

    private void selecionarCategoria() {
        this.categoriaSelecionada = this.modelCategoria.getCategoria(this.fConCategoria.tbCategorias.getSelectedRow());
    }

    private void limparCadastro() {
        this.fCadCategoria.inputNome.setText(null);
    }

    private void cancelarCadastro() {
        limparCadastro();
        this.fCadCategoria.setVisible(false);
    }

    public void executarConsulta() {
        carregarConsulta();
        this.fConCategoria.setVisible(true);
    }

    private void limparConsulta() {
        this.modelCategoria.limpar();
    }

    private void cancelarConsulta() {
        limparConsulta();
        this.fConCategoria.setVisible(false);
    }
}
