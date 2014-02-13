package test.telas;

import java.awt.Image;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

class HoverImage {

    HoverImage(Image img1, Image img2) {
        JButton b = new JButton(new ImageIcon(img1));
        b.setRolloverIcon(new ImageIcon(img2));

        b.setBorderPainted(false);
        b.setContentAreaFilled(false);

        JOptionPane.showMessageDialog(null, b);
    }

    public static void main(String[] args) throws Exception {
        URL url1 = new URL("http://pscode.org/media/citymorn1.jpg");
        URL url2 = new URL("http://pscode.org/media/citymorn2.jpg");
        final Image img1 = ImageIO.read(url1);
        final Image img2 = ImageIO.read(url2);
        //Create the frame on the event dispatching thread
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                new HoverImage(img1, img2);
            }
        });
    }
}
