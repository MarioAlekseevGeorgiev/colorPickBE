package app.pickcolorbe;

import app.pickcolorbe.beans.PickColor;
import app.pickcolorbe.beans.PickColorRGB;
import app.pickcolorbe.colorRBG.PickColorRBGComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pickColor")
public class PickColorController {

    @MessageMapping("/colorPicker")
    @SendTo("/rgb")
    public PickColor getPickColorRGB(PickColorRGB pickColorRGB) {
                return PickColor.builder()
                        .pickColor(pickColorRBGComponent.createHexColor(PickColorRGB.builder()
                           .redComponent(pickColorRGB.getRedComponent())
                           .blueComponent(pickColorRGB.getBlueComponent())
                           .greenComponent(pickColorRGB.getGreenComponent()).build()))

            .pickColorText(pickColorRBGComponent.createHexColorContrast(PickColorRGB.builder()
                        .redComponent(pickColorRGB.getRedComponent())
                        .blueComponent(pickColorRGB.getBlueComponent())
                        .greenComponent(pickColorRGB.getGreenComponent()).build()))
            .build();
    }

    private final PickColorRBGComponent pickColorRBGComponent;

    @Autowired
    public PickColorController(PickColorRBGComponent pickColorRBGComponent) {
        this.pickColorRBGComponent = pickColorRBGComponent;
    }

    @GetMapping("rgb")
    public PickColor getPickColorRGB(@RequestParam(name = "redComponent")   int redComponent
                                   , @RequestParam(name = "blueComponent")  int blueComponent
                                   , @RequestParam(name = "greenComponent") int greenComponent)
    {
                return PickColor.builder()
                   .pickColor(pickColorRBGComponent.createHexColor(PickColorRGB.builder()
                           .redComponent(redComponent)
                           .blueComponent(blueComponent)
                           .greenComponent(greenComponent).build()))

                   .pickColorText(pickColorRBGComponent.createHexColorContrast(PickColorRGB.builder()
                           .redComponent(redComponent)
                           .blueComponent(blueComponent)
                           .greenComponent(greenComponent).build()))
                .build();
    }


}
