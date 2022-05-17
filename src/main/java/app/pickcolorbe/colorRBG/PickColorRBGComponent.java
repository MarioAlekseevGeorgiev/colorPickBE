package app.pickcolorbe.colorRBG;

import app.pickcolorbe.beans.PickColorRGB;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@Component
public class PickColorRBGComponent {

    public String createHexColor(PickColorRGB pickColorRGB)
    {
        Color  color  = new Color(convertRGB(pickColorRGB.getRedComponent()), convertRGB(pickColorRGB.getBlueComponent()), convertRGB(pickColorRGB.getGreenComponent()));
        String buf    = Integer.toHexString(color.getRGB());

        return "#" + buf.substring(buf.length()-6);
    }

    private int convertRGB(int rgb) {
        return Math.min(rgb, 255);
    }

    public String createHexColorContrast(PickColorRGB pickColorRGB)
    {
        int red     = convertRGB(pickColorRGB.getRedComponent());
        int green   = convertRGB(pickColorRGB.getGreenComponent());
        int blue    = convertRGB(pickColorRGB.getBlueComponent());
        int average = (red + green + blue) / 3;

        Color  color = makeColor(average);
        String buf   = Integer.toHexString(color.getRGB());

        return "#" + buf.substring(buf.length()-6);
    }

    private Color makeColor(int average) {
        return average >= 128 ? Color.BLACK : Color.WHITE;
    }
}
