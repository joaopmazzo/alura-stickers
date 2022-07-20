import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StickerGenerator {

    public void create() throws IOException {

        // leitura da imagem
        BufferedImage originalImage = ImageIO.read(new File("inputImage/film.jpg"));

        // cria nova imagem em memória com transparência e com tamanho novo
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        int newHeight = height + 200;

        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        // copiar a imagem original pra nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(originalImage, 0, 0, null);

        // escrever uma frase na nova imagem

        // verifica se existe o diretório, caso não cria o mesmo
        File outputDirectory = new File("outputImage");
        if (!outputDirectory.exists()) {
            outputDirectory.mkdir();
        }

        // escrever a imagem nova em um arquivo
         ImageIO.write(newImage, "png", new File(outputDirectory+"/sticker.png"));
    }

    public static void main(String[] args) {
        StickerGenerator generator = new StickerGenerator();
        try {
            generator.create();
        } catch (IOException e) {
            System.out.println("Error to generate sticker "+e);
            throw new RuntimeException(e);
        }
    }

}
