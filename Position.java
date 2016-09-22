
package appliedjavaassignment;
import java.awt.*;
public class Position {
    public static Point getPosition(int width, int height){
        Toolkit too = Toolkit.getDefaultToolkit();
        Dimension dem = too.getScreenSize();
        int x = (dem.width - width)/2;
        int y = (dem.height - height)/2;
    return new Point(x,y);}
    
}
