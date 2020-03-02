
package outerspace;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Meteoro  extends Movel {
    
    private static final int LARGURA_TELA = 730;
    private int VELOCIDADE = 1;
    private static int contador = 0;

    public Meteoro(int x, int y, int velocidade) {
        this.x = x;
        this.y = y;
        VELOCIDADE = velocidade;
        ImageIcon referencia;
        if (contador++ % 3 == 0) {
            referencia = new ImageIcon(OuterSpace.class.getResource("/outerspace/imagem/Meteoro1.png"));
        } else {
            referencia = new ImageIcon(OuterSpace.class.getResource("/outerspace/imagem/Inimigo.png"));
        }      
        imagem = referencia.getImage();
        this.largura = imagem.getWidth(null);
        this.altura = imagem.getHeight(null);
        visible = true;
    }

    public void mexer() {
        if (this.x < 0) {
            this.x = LARGURA_TELA;
        } else {
            this.x -= VELOCIDADE;
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
        this.visible = visivel;
    }
}
