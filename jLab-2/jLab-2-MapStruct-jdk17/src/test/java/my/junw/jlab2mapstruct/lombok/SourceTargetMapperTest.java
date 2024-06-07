package my.junw.jlab2mapstruct.lombok;

import my.junw.jlab2mapstruct.lombok.converted.SourceToTarget;
import my.junw.jlab2mapstruct.lombok.vo.SourceVO;
import my.junw.jlab2mapstruct.lombok.vo.TargetVO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SourceTargetMapperTest {

    @Test
    public void testMapping() {
        SourceVO s = new SourceVO();
        s.setTest( "5" );

        TargetVO t = SourceToTarget.INSTANCE.toTarget( s );
        assertEquals( 5, (long) t.getTesting() );
    }
}
