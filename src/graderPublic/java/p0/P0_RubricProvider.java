package p0;

import org.sourcegrade.jagr.api.rubric.Rubric;
import org.sourcegrade.jagr.api.rubric.RubricProvider;

public class P0_RubricProvider implements RubricProvider {

    public static final Rubric RUBRIC = Rubric.builder()
        .title("P0")
        .build();

    @Override
    public Rubric getRubric() {
        return RUBRIC;
    }
}
