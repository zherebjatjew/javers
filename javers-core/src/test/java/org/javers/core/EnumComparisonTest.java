package org.javers.core;

import static org.junit.Assert.assertNotNull;

import org.javers.core.diff.Diff;
import org.junit.jupiter.api.Test;

public class EnumComparisonTest {

    @Test
    public void shouldCompareEnumsReferencedByInterface() {
        C2 one = new C2();
        one.i = TrickyEnum.VAL1;
        C2 two = new C2();
        two.i = TrickyEnum.VAL2;
        Javers javers = JaversBuilder.javers().build();

        Diff diff = javers.compare(one, two);

        assertNotNull(diff);
        System.out.println(diff.toString());
    }

    private interface BaseEnum {
    }

    private enum TrickyEnum implements BaseEnum {
        VAL1,
        VAL2
    }

    private static class C2 {
        public BaseEnum i;
    }
}
