package app.pickcolorbe.beans;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Builder(toBuilder = true)
public class PickColor {

    private String pickColor;
    private String pickColorText;
}
