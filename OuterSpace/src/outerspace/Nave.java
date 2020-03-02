
package outerspace;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class Nave extends Movel {
    
    private int velocidade = 10;
    private int dx, dy, vdxr = 5, vdxl = -5, vdyd = 5, vdyu = -5;
    private List<Disparo> disparo;

    public Nave() {
        ImageIcon referencia = new ImageIcon(OuterSpace.class.getResource("/outerspace/imagem/Nave.png"));
        imagem = referencia.getImage();
        altura = imagem.getHeight(null);
        largura = imagem.getWidth(null);
        disparo = new ArrayList<>();
        this.x = 100;
        this.y = 100;
    }
    // Não deixa o objeto ultrapassar os limites da tela
    public void mexer() {
        x += dx;
        y += dy;
        if (this.x < 1) {
            this.x = 1;
        }
        if (this.x > 685) {
            this.x = 685;
        }
        if (this.y < 1) {
            this.y = 1;
        }
        if (this.y > 460) {
            this.y = 460;
        }
    }
    
    public void atira() {
        this.disparo.add(new Disparo(this.x + this.largura, this.y + this.altura/ 3, this.velocidade));
    }

    public void keyPressed(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();
        if (codigo == KeyEvent.VK_SPACE) {
            atira();
        }
        if (codigo == KeyEvent.VK_UP) {
            dy = vdyu;
        }
        if (codigo == KeyEvent.VK_DOWN) {
            dy = vdyd;
        }
        if (codigo == KeyEvent.VK_LEFT) {
            dx = vdxl;
        }
        if (codigo == KeyEvent.VK_RIGHT) {
            dx = vdxr;
        }
    }

    public void keyReleased(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();
        if (codigo == KeyEvent.VK_UP) {
            dy = 0;
        }
        if (codigo == KeyEvent.VK_DOWN) {
            dy = 0;
        }
        if (codigo == KeyEvent.VK_LEFT) {
            dx = 0;
        }
        if (codigo == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, largura, altura);
    }

    @Override
    public boolean isVisivel() {
        return visible;
    }

    @Override
    public void setVisivel(boolean visible) {
        this.visible = visible;
    }

    public List<Disparo> getDisparo() {
        return disparo;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public Image getImagem() {
        return imagem;
    }

    @Override
    public int getAltura() {
        return altura;
    }

    @Override
    public int getLargura() {
        return largura;
    }
    
    public void aumentarDificuldade(int valor) {
        vdyu = -valor;
        vdyd = valor;
        vdxl = -valor;
        vdxr = valor;   
    }   
    
    public void velocidadeDisparo(int valor) {
        this.velocidade = valor;
    }
}
