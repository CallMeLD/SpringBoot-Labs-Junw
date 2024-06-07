package my.junw.jlab2mapstructjdk8.lombok;

import my.junw.jlab2mapstructjdk8.lombok.converted.SourceToTarget;
import my.junw.jlab2mapstructjdk8.lombok.vo.SourceVO;
import my.junw.jlab2mapstructjdk8.lombok.vo.TargetVO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SourceTargetMapperTest {

    @Test
    public void SourceToTargetTest() {
        SourceVO s = new SourceVO();
        s.setTest( "5" );

        TargetVO t = SourceToTarget.INSTANCE.toTarget( s );
        assertEquals( 5, (long) t.getTesting() );
    }



}
