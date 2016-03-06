import java.awt.Graphics;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

class RoundPanel extends JPanel {
    //背景图片
    private ImageIcon img;
    //圆角范围
    private int arcWidth;

    private static final long serialVersionUID = 1L;
    public RoundPanel(){
    }
    public RoundPanel(String imgPath){
        img = new ImageIcon(imgPath);
    }
    public RoundPanel(String imgPath,int arcWidth){
        this(imgPath);
        this.arcWidth = arcWidth;
    }
    @Override
    protected void paintComponent(Graphics g) {
        
        RoundRectangle2D rect = new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),arcWidth,arcWidth);
        g.setClip(rect);
        if(img!=null)
            g.drawImage(img.getImage(), 0, 0, getWidth(), getHeight(), this);
    }
    
}
