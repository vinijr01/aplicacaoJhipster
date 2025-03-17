package meuprojeto.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class MetaTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    public static Meta getMetaSample1() {
        return new Meta().id(1L).area("area1").notaEsperada(1);
    }

    public static Meta getMetaSample2() {
        return new Meta().id(2L).area("area2").notaEsperada(2);
    }

    public static Meta getMetaRandomSampleGenerator() {
        return new Meta().id(longCount.incrementAndGet()).area(UUID.randomUUID().toString()).notaEsperada(intCount.incrementAndGet());
    }
}
