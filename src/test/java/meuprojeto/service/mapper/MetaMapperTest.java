package meuprojeto.service.mapper;

import static meuprojeto.domain.MetaAsserts.*;
import static meuprojeto.domain.MetaTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MetaMapperTest {

    private MetaMapper metaMapper;

    @BeforeEach
    void setUp() {
        metaMapper = new MetaMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getMetaSample1();
        var actual = metaMapper.toEntity(metaMapper.toDto(expected));
        assertMetaAllPropertiesEquals(expected, actual);
    }
}
