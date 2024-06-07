package my.junw.jlab2mapstruct.lombok;

import my.junw.jlab2mapstruct.lombok.converted.SourceToSource;
import my.junw.jlab2mapstruct.lombok.converted.SourceToTarget;
import my.junw.jlab2mapstruct.lombok.vo.SourceVO;
import my.junw.jlab2mapstruct.lombok.vo.TargetVO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SourceTargetTest {

    /**
     * 属性相同
     */
    @Test
    public void sourceToSourceTest() {
        SourceVO s = new SourceVO();
        s.setTest( "5" );

        SourceVO newS = SourceToSource.INSTANCE.toSource( s );
        assertEquals( "5", newS.getTest() );
    }

    /**
     * 属性不同
     */
    @Test
    public void sourceToTargetTest() {
        SourceVO s = new SourceVO();
        s.setTest( "5" );

        TargetVO t = SourceToTarget.INSTANCE.toTarget( s );
        assertEquals( 5, (long) t.getTesting() );
    }



}
