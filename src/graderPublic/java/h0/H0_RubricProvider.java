package h0;

import org.sourcegrade.jagr.api.rubric.Rubric;
import org.sourcegrade.jagr.api.rubric.RubricProvider;

public class H0_RubricProvider implements RubricProvider {

    public static final Rubric RUBRIC = Rubric.builder()
        .title("H0")
        .build();

    @Override
    public Rubric getRubric() {
        return RUBRIC;
    }
}
