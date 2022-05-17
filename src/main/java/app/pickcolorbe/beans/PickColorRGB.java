package app.pickcolorbe.beans;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Builder(toBuilder = true)
public class PickColorRGB {
    private int redComponent;
    private int blueComponent;
    private int greenComponent;
}
