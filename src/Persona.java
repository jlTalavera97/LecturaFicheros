import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data @NoArgsConstructor @AllArgsConstructor
public class Persona {
    Optional<String> nombre;
    Optional<String> poblacion;
    Optional<Integer> edad;

    public Persona(String[] lineFilter) {
    }
}
