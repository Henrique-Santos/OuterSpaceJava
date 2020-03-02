    
package outerspace;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

public class OuterSpace extends JFrame {
    
    // Serial gerado automaticamente apenas para efeito de serialização
    private static final long serialVersionUID = 1L;
    // Método construtor
    public OuterSpace() {
        construirMenuBar();
        construirFase();
        configurarTela();
    }
        
    public static void start(String[] args) {
        new OuterSpace();
        
    }
    
    private JMenuBar construirMenuBar() {
        // Barra de Menu
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBorder(new LineBorder(Color.red));
        // Menu
        JMenu menu = new JMenu("Opções");
        // Item de Menu
        JMenuItem sobre = new JMenuItem("Sobre");
        // Adiciona uma ação no item de menu
        sobre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostra uma caixa de mensagem
                JOptionPane.showMessageDialog(null, "Modificado por Toxic Games \n Versão 2.0 - 2018", "Informações", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        JMenuItem pausar = new JMenuItem("Pausar 10s");
        pausar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try { Thread.sleep (10000); } catch (InterruptedException ex) {}
            }
        });
        JMenuItem reiniciar = new JMenuItem("Reiniciar");
        reiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                OuterSpace.start(new String[0]);
            }
        });
        // Item da barra de menu
        JMenuItem sair = new JMenuItem("Sair");
        // Adiciona uma ação no item de menu
        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        menu.add(sobre);
        // Adiciona uma linha separadora nos items de menu
        menu.add(new JSeparator());
        menu.add(reiniciar);
        menu.add(new JSeparator());
        menu.add(pausar);
        menu.add(new JSeparator());
        menu.add(sair);
        menuBar.add(menu);
        setJMenuBar(menuBar);
        return menuBar;
    }

	private JPanel construirFase() {
            Fase fase = new Fase();
            add(fase);
            return fase;
	}

	private void configurarTela() {
            // Largura e altura da janela em pixels
            setSize(730, 541);
            // Não permite redimensionar a janela
            setResizable(false);
            // Fecha toda a aplicação ao ser apertado o botão X
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // Faz a janela aparecer centralizada
            setLocationRelativeTo(null);
            // Referência se a janela está visivel ou não
            setVisible(true);
            // Titulo da Janela
            setTitle("OuterSpace");
	}
}
