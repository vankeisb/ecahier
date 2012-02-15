package com.rvkb.ecahier.utils

import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import java.awt.Image

class ImageUtils {

    static void rescaleImage(InputStream imageBytes, int size, OutputStream out) throws IOException {
        BufferedImage image = ImageIO.read(imageBytes)
        Image scaledImage = image.getScaledInstance(size, size, BufferedImage.SCALE_SMOOTH)
        image = new BufferedImage(130, 130, BufferedImage.TYPE_INT_RGB)
        image.getGraphics().drawImage(scaledImage, 0, 0, null)
        ImageIO.write(image, "JPG", out)
    }

}
