
package outerspace;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase extends JPanel implements ActionListener {
    Random aleatorio = new Random();
    private int x = 0, y = 0;
    private int pont = 0;
    private int velocidade = 1;
    private int contador = 0;
    // Serial gerado automaticamente apenas para efeito de serialização
    private static final long serialVersionUID = -5079021684583630134L;
    private Image fundo;
    private Nave nave;
    private Timer timer;
    private List<Meteoro> meteoro;
    private int emJogo;
    private int[][] coordenadas = { { 1000, 30 }, { 1000, 200 }, { 1200, 400 },
                    { 1400, 300 }, { 1600, 150 }, { 1800, 400 }, { 2000, 60 },
                    { 2200, 100 }, { 2400, 300 }, { 2600, 400 }, { 2800, 200 }, { 3000, 50 },
                    { 3100, 200 }, { 3200, 400 }, { 3400, 10 }, { 3600, 70 }, { 4000, 250 },
                    { 4000, 400 }, { 4000, 62 }, { 4000, 100 } };

    public Fase() {
        setFocusable(true);
        setDoubleBuffered(true);
        addKeyListener(new TecladoAdapter());
        ImageIcon referencia = new ImageIcon(OuterSpace.class.getResource("/outerspace/imagem/Fundo.png"));
        fundo = referencia.getImage();
        nave = new Nave();
        emJogo = 1;
        inicializarInimigos();
        timer = new Timer(3, this);
        timer.start();
    }
      
    public void velocidadeMeteoro(int valor) {
        this.velocidade = valor;
    }
    
    public void inicializarInimigos() {
        verificaDificuldade(contador);
        contador = contador + 1;
        meteoro = new ArrayList<>();
        for (int j = 0; j < 1; j++) {
            for (int i = 0; i < coordenadas.length; i++) {
                do{
                    this.x = aleatorio.nextInt(4000);
                } while(x<1000 || x>4000);
                do{
                    this.y = aleatorio.nextInt(400);
                } while(y<10 || y>400);
                meteoro.add(new Meteoro(this.x, this.y, this.velocidade));//coordenadas[i][1]
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(fundo, 0, 0, null);
        if (emJogo==1) {
            graficos.drawImage(nave.getImagem(), nave.getX(), nave.getY(), this);
            List<Disparo> disparo = nave.getDisparo();
            for (int i = 0; i < disparo.size(); i++) {
                Disparo d = (Disparo) disparo.get(i);
                graficos.drawImage(d.getImagem(), d.getX(), d.getY(), this);
            }
            for (int i = 0; i < meteoro.size(); i++) {
                Meteoro m = meteoro.get(i);
                graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);
            }
            graficos.setColor(Color.red);
            graficos.drawString("Inimigos: " + meteoro.size(), 5, 15);
            graficos.setColor(Color.green);
            graficos.drawString("Pontuação: " + pont, 115, 15);
            graficos.setColor(Color.white);
            graficos.drawString("Fase: " + contador, 230, 15);
        } else if(emJogo==2) {
            ImageIcon vitoria = new ImageIcon(OuterSpace.class.getResource("/outerspace/imagem/YouWin.png"));
            graficos.drawImage(vitoria.getImage(), 0, 0, null);
        } else if(emJogo==3) {
            ImageIcon nextLevel = new ImageIcon(OuterSpace.class.getResource("/outerspace/imagem/NextLevel.png"));
            graficos.drawImage(nextLevel.getImage(), 0, 0, null);
        } else if(emJogo==4) {
            ImageIcon fimJogo = new ImageIcon(OuterSpace.class.getResource("/outerspace/imagem/GameOver.jpg"));
            graficos.drawImage(fimJogo.getImage(), 0, 0, null);
        }
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (meteoro.size() == 0) {
            if(contador==5) {
                emJogo = 2;
            } else {
                emJogo = 3;
            }
        }
        List<Disparo> disparo = nave.getDisparo();
        for (int i = 0; i < disparo.size(); i++) {
            Disparo d = (Disparo) disparo.get(i);
            if (d.isVisible()) {
                d.mexer();
            } else {
                disparo.remove(i);
            }
        }
        for (int i = 0; i < meteoro.size(); i++) {
            Meteoro m = meteoro.get(i);
            if (m.isVisible()) {
                m.mexer();
            } else {
                meteoro.remove(i);
            }
        }
        nave.mexer();
        checarColisoes();
        repaint();
    }

    public void checarColisoes() {
        Rectangle formaNave = nave.getBounds();
        Rectangle formaMeteoro;
        Rectangle formaDisparo;

        for (int i = 0; i < meteoro.size(); i++) {
            Meteoro tempMeteoro = meteoro.get(i);
            formaMeteoro = tempMeteoro.getBounds();
            if (formaNave.intersects(formaMeteoro)) {
                nave.setVisivel(false);
                tempMeteoro.setVisible(false);
                emJogo = 4;
            }
        }
        List<Disparo> disparo = nave.getDisparo();
        for (int i = 0; i < disparo.size(); i++) {
            Disparo tempDisparo = disparo.get(i);
            formaDisparo = tempDisparo.getBounds();
            for (int j = 0; j < meteoro.size(); j++) {
                Meteoro tempMeteoro = meteoro.get(j);
                formaMeteoro = tempMeteoro.getBounds();
                if (formaDisparo.intersects(formaMeteoro)) {
                    tempMeteoro.setVisible(false);
                    tempDisparo.setVisible(false);
                    pont =  pont + 1;
                    
                }
            }
        }
    }
    
    private void verificaDificuldade(int nFase) {
        if(nFase==4) {
            nave.aumentarDificuldade(1);
            nave.velocidadeDisparo(3);
            this.velocidadeMeteoro(5);
        } else if(nFase==3) {
            nave.aumentarDificuldade(2);
            nave.velocidadeDisparo(4);
            this.velocidadeMeteoro(4);
        } else if(nFase==2) {
            nave.aumentarDificuldade(3);
            nave.velocidadeDisparo(5);
            this.velocidadeMeteoro(3);
        } else if(nFase==1) {
            nave.aumentarDificuldade(4);
            nave.velocidadeDisparo(6);
            this.velocidadeMeteoro(2);
        }
    }
    
    private class TecladoAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                if(emJogo==3) {
                    if(contador!=5) {
                        emJogo = 1;
                        nave = new Nave();
                        inicializarInimigos();
                    }
                }
            }
        nave.keyPressed(e);
        }
        @Override
        public void keyReleased(KeyEvent e) {
            nave.keyReleased(e);
        }
    }
}
