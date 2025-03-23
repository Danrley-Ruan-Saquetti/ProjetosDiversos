package views;

/**
 *
 * @author Dan Ruan
 */
public class FPrincipal extends javax.swing.JFrame {

    public FPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuBarra = new javax.swing.JMenuBar();
        miCadastro = new javax.swing.JMenu();
        miCadCategoria = new javax.swing.JMenuItem();
        miCadCliente = new javax.swing.JMenuItem();
        miConsultas = new javax.swing.JMenu();
        miConCategoria = new javax.swing.JMenuItem();
        miConCliente = new javax.swing.JMenuItem();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("jCheckBoxMenuItem2");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        miCadastro.setText("Cadastro");

        miCadCategoria.setText("Categoria");
        miCadastro.add(miCadCategoria);

        miCadCliente.setText("Cliente");
        miCadastro.add(miCadCliente);

        menuBarra.add(miCadastro);

        miConsultas.setText("Consultas");

        miConCategoria.setText("Categotia");
        miConsultas.add(miConCategoria);

        miConCliente.setText("Cliente");
        miConsultas.add(miConCliente);

        menuBarra.add(miConsultas);

        setJMenuBar(menuBarra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 768, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 453, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuBar menuBarra;
    public javax.swing.JMenuItem miCadCategoria;
    public javax.swing.JMenuItem miCadCliente;
    private javax.swing.JMenu miCadastro;
    public javax.swing.JMenuItem miConCategoria;
    public javax.swing.JMenuItem miConCliente;
    private javax.swing.JMenu miConsultas;
    // End of variables declaration//GEN-END:variables
}
