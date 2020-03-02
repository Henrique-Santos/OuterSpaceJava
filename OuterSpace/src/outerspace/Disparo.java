
package outerspace;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Disparo extends Movel {
    
    private static final int LARGURA_TELA = 730;
    private int VELOCIDADE = 10;

    public Disparo (int x, int y, int velocidade) {
        this.x = x;
        this.y = y;
        VELOCIDADE = velocidade;
        ImageIcon referencia = new ImageIcon(OuterSpace.class.getResource("/outerspace/imagem/Disparo.png"));
        imagem = referencia.getImage();
        this.largura = imagem.getWidth(null);
        this.altura = imagem.getHeight(null);
        visible = true;
    }

    public void mexer() {
        this.x += VELOCIDADE;
        if (this.x > LARGURA_TELA) {
            visible = false;
        }
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, largura, altura);
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public Image getImagem() {
        return imagem;
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
    public int getAltura() {
        return altura;
    }

    @Override
    public int getLargura() {
        return largura;
    }

    @Override
    public boolean isVisivel() {
        return visible;
    }

    @Override
    public void setVisivel(boolean visivel) {
        visible = visivel;
    }
    
    public void velocidadeDisparo() {
        
    }
}
