package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.FPrincipal;

/**
 *
 * @author Dan Ruan
 */
public class ControllerPrincipal {

    private FPrincipal fPrincipal;
    private ControlCategoria controlCategoria;
    private ControlCliente controlCliente;

    public ControllerPrincipal() {
        this.fPrincipal = new FPrincipal();
        this.controlCategoria = new ControlCategoria();
        this.controlCliente = new ControlCliente();
        inicializaComponentes();
    }

    private void inicializaComponentes() {
        this.fPrincipal.miCadCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarCategoria();
            }
        });
        
        this.fPrincipal.miCadCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarCliente();
            }
        });
        
        this.fPrincipal.miConCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarCatergotias();
            }
        });
        
        this.fPrincipal.miConCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarClientes();
            }
        });
    }

    private void cadastrarCategoria() {
        controlCategoria.executarCadastro();
    }
    
    private void cadastrarCliente() {
        controlCliente.executarCadastro();
    }
    
    private void consultarCatergotias() {
        controlCategoria.executarConsulta();
    }
    
    private void consultarClientes() {
        controlCliente.executarConsulta();
    }

    public void executar() {
        this.fPrincipal.setVisible(true);
    }
}
