package ithub.png.imagesquarer.routes;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class convertService {


    public static byte[] convert(MultipartFile file, int squareSize) throws IOException {
        BufferedImage image = ImageIO.read(file.getInputStream());
        int width = image.getWidth();
        int height = image.getHeight();

        int numSquaresX = width / squareSize;
        int numSquaresY = height / squareSize;

        BufferedImage outputImage = new BufferedImage(numSquaresX * squareSize, numSquaresY * squareSize, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < numSquaresY; y++) {
            for (int x = 0; x < numSquaresX; x++) {
                int avgRed = 0;
                int avgGreen = 0;
                int avgBlue = 0;

                for (int squareY = 0; squareY < squareSize; squareY++) {
                    for (int squareX = 0; squareX < squareSize; squareX++) {
                        Color color = new Color(image.getRGB(x * squareSize + squareX, y * squareSize + squareY));
                        avgRed += color.getRed();
                        avgGreen += color.getGreen();
                        avgBlue += color.getBlue();
                    }
                }

                avgRed /= (squareSize * squareSize);
                avgGreen /= (squareSize * squareSize);
                avgBlue /= (squareSize * squareSize);

                Color avgColor = new Color(avgRed, avgGreen, avgBlue);
                Graphics2D g = outputImage.createGraphics();
                g.setColor(avgColor);
                g.fillRect(x * squareSize, y * squareSize, squareSize, squareSize);
                g.dispose();
            }
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(outputImage, "png", outputStream);

        return outputStream.toByteArray();
    }

}
