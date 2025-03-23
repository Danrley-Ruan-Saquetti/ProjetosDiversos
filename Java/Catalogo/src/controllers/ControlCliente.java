package controllers;

import entities.Cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import models.DaoCliente;
import views.FCadCliente;
import views.FConCliente;
import views.ModelCliente;

/**
 *
 * @author Dan Ruan
 */
public class ControlCliente {

    private FCadCliente fCadCliente;
    private FConCliente fConCliente;
    private ModelCliente modelCliente;
    private DaoCliente daoCli;
    private Cliente clienteSelecionado;

    public ControlCliente() {
        this.fCadCliente = new FCadCliente(null, true);
        this.fConCliente = new FConCliente(null, true);
        this.modelCliente = new ModelCliente();
        this.daoCli = new DaoCliente();
        this.clienteSelecionado = null;
        inicializaComponentes();
    }

    private void inicializaComponentes() {
        this.fConCliente.tbClientes.setModel(this.modelCliente);

        this.fCadCliente.btGravar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarCliente();
            }
        });

        this.fCadCliente.btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelarCadastro();
            }
        });

        this.fConCliente.btEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executarEdicao();
            }
        });

        this.fConCliente.btExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluirCliente();
            }
        });

        this.fConCliente.btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelarConsulta();
            }
        });
    }

    public void executarCadastro() {
        limparCadastro();
        this.fCadCliente.setVisible(true);
    }

    private void cadastrarCliente() {
        if (this.clienteSelecionado == null) {
            String nome = this.fCadCliente.inputNome.getText();
            String cpf = this.fCadCliente.inputCpf.getText();
            String email = this.fCadCliente.inputEmail.getText();
            String endereco = this.fCadCliente.inputEndereco.getText();
            String telefone = this.fCadCliente.inputTelefone.getText();

            if (daoCli.selecionar(cpf) == null) {
                if (!"".equals(nome) || !"".equals(cpf) || !"".equals(email) || !"".equals(endereco) || !"".equals(telefone)) {
                    Cliente cliente = new Cliente(cpf, nome, email, telefone, endereco);
                    addClienteLista(cliente);
                    if (this.daoCli.inserir(cliente)) {
                        JOptionPane.showMessageDialog(null, "Sucesso ao cadastrar o Cliente");
                        cancelarCadastro();
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao cadastrar o Cliente");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Cliente com o mesmo CPF já cadastrado");
            }
        } else {
            editarCliente();
        }
    }

    private void executarEdicao() {
        int indiceSelecionado = this.fConCliente.tbClientes.getSelectedRow();

        if (indiceSelecionado >= 0) {
            selecionarCliente();
            this.fCadCliente.inputNome.setText(this.clienteSelecionado.getNome());
            this.fCadCliente.inputCpf.setText(this.clienteSelecionado.getCpf());
            this.fCadCliente.inputEmail.setText(this.clienteSelecionado.getEmail());
            this.fCadCliente.inputEndereco.setText(this.clienteSelecionado.getEndereco());
            this.fCadCliente.inputTelefone.setText(this.clienteSelecionado.getTelefone());

            cancelarConsulta();
            this.fCadCliente.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um registro da lista de Categoria.");
        }
    }

    private void editarCliente() {
        String nome = this.fCadCliente.inputNome.getText();
        String cpf = this.fCadCliente.inputCpf.getText();
        String email = this.fCadCliente.inputEmail.getText();
        String endereco = this.fCadCliente.inputEndereco.getText();
        String telefone = this.fCadCliente.inputTelefone.getText();

        if (!"".equals(nome) && !"".equals(cpf) && !"".equals(email) && !"".equals(endereco) && !"".equals(telefone)) {
            if (!this.clienteSelecionado.getNome().equals(nome) || !this.clienteSelecionado.getCpf().equals(cpf) || !this.clienteSelecionado.getEmail().equals(email) || !this.clienteSelecionado.getEndereco().equals(endereco) || !this.clienteSelecionado.getTelefone().equals(telefone)) {
                this.clienteSelecionado.setNome(nome);
                this.clienteSelecionado.setCpf(cpf);
                this.clienteSelecionado.setEmail(email);
                this.clienteSelecionado.setEndereco(endereco);
                this.clienteSelecionado.setTelefone(telefone);

                if (this.daoCli.editar(this.clienteSelecionado)) {
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
            JOptionPane.showMessageDialog(null, "O campo do \"Nome\", \"CPF\", \"Email\", \"Endereço\" e \"Telefone\" é obrigatório.");
        }
    }

    private void cancelarEdicao() {
        this.clienteSelecionado = null;
        fCadCliente.setVisible(false);
        executarConsulta();
    }

    private void excluirCliente() {
        if (!daoCli.listar().isEmpty()) {
            int indiceSelecionado = this.fConCliente.tbClientes.getSelectedRow();

            if (indiceSelecionado >= 0) {
                System.out.println(indiceSelecionado);
                Cliente c = this.modelCliente.getCliente(indiceSelecionado);

                if (JOptionPane.showConfirmDialog(null, "Deseja excluir a Cliente " + c.getNome() + "?") == 0) {
                    if (daoCli.remover(c)) {
                        JOptionPane.showMessageDialog(null, "Cliente excluída com sucesso.");
                        this.modelCliente.excluirCliente(indiceSelecionado);
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao excluir a Cliente.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um registro da Cliente.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não há clientes para excluir.");
        }
    }

    private void carregarConsulta() {
        limparConsulta();
        for (Cliente cliente : daoCli.listar()) {
            addClienteLista(cliente);
        }
    }

    private void addClienteLista(Cliente c) {
        this.modelCliente.inserirClientes(c);
    }

    private void limparCadastro() {
        this.fCadCliente.inputNome.setText(null);
        this.fCadCliente.inputCpf.setText(null);
        this.fCadCliente.inputEndereco.setText(null);
        this.fCadCliente.inputTelefone.setText(null);
        this.fCadCliente.inputEmail.setText(null);
    }

    private void selecionarCliente() {
        this.clienteSelecionado = this.modelCliente.getCliente(this.fConCliente.tbClientes.getSelectedRow());
    }

    private void cancelarCadastro() {
        limparCadastro();
        this.fCadCliente.setVisible(false);
    }

    public void executarConsulta() {
        carregarConsulta();
        this.fConCliente.setVisible(true);
    }

    private void cancelarConsulta() {
        this.fConCliente.setVisible(false);
        limparConsulta();
    }

    private void limparConsulta() {
        this.modelCliente.limpar();
    }
}
