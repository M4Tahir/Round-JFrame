import javax.swing.*;
import java.awt.*;

/**
 * A simple java swing application to create rounded JFrame of your own size and rounded edges.
 *
 * @author Tahir
 * @version 1.0
 */
public class MyPanel extends JPanel {
    Color RGB;
    int widthFrame;

    int heightFrame;
    int arcWidth, arcHeight;

    /**
     * @param widthFrame The width of the output frame.
     * @param heightFrame The height of the output frame.
     * @param arcWidth The amount by which you want to round the edge.
     * @param arcHeight The amount by which you want to round the edges.
     * @param RGB The color of the frame which You want.
     */
    MyPanel(int widthFrame,int heightFrame,int arcWidth,int arcHeight,Color RGB) {
        this.heightFrame = heightFrame;
        this.widthFrame = widthFrame;
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
        this.RGB = RGB;
        this.setLayout(null);
        this.setPreferredSize(new Dimension(widthFrame, heightFrame));
        this.setOpaque(false); // when set to true, then the panel is also responsible for panting the background as well so by setting it to false only the JPanel will be painted.
        this.setBackground(RGB);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g; // casting g to 2d graphics
        g2d.setColor(getBackground());
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // to make the edges smoother
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);

    }

}
/*
------------------Detail for why opacity is false------------------------------------
In Swing, components have an isOpaque() property that determines whether a component is responsible for painting its background. When a component is set to be opaque (setOpaque(true)), it is responsible for painting its entire background, which includes painting over any custom shapes or transparency you might want to achieve.
When you set a panel to be non-opaque (setOpaque(false)), you are telling Swing not to paint the background of that component, which allows you to see through it and potentially see the underlying components or the frame itself.
In the context of your rounded frame, setting the panel to be non-opaque allows the underlying frame to show through, creating the appearance of a rounded frame. If you set the panel to be opaque, it would paint its background over the frame, and you would lose the rounded effect.
When setOpaque(true) is applied to a Swing component (like a JPanel), it means that the component is responsible for painting its entire background. If you set the panel to be opaque, it will paint its background with the color specified in its setBackground() method or its look and feel settings. If this panel covers the entire frame, it will fill the whole frame with that background color, potentially covering anything beneath it.
On the other hand, when setOpaque(false) is applied to a Swing component, it means that the component is not responsible for painting its background. In this case, the component will be transparent, allowing anything behind it (such as the frame or other components) to show through. This can be useful for creating effects like rounded frames or overlapping components with different backgrounds.
So, in your original code, when you set panel.setOpaque(false);, it makes the panel transparent, and the frame's background becomes visible, creating the rounded frame appearance.
 */