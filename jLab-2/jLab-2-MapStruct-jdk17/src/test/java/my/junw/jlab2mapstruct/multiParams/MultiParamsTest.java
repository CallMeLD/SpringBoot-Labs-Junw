package my.junw.jlab2mapstruct.multiParams;

import my.junw.jlab2mapstruct.lombok.converted.SourceToSource;
import my.junw.jlab2mapstruct.lombok.converted.SourceToTarget;
import my.junw.jlab2mapstruct.lombok.vo.SourceVO;
import my.junw.jlab2mapstruct.lombok.vo.TargetVO;
import my.junw.jlab2mapstruct.multiParams.converted.ManWomanToHome;
import my.junw.jlab2mapstruct.multiParams.vo.HomeVO;
import my.junw.jlab2mapstruct.multiParams.vo.ManVO;
import my.junw.jlab2mapstruct.multiParams.vo.WomanVO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiParamsTest {

    /**
     * 多参数源
     */
    @Test
    public void multiParamsTest() {
        ManVO man = new ManVO("小帅",24);
        WomanVO woman = new WomanVO("小美",21);

        HomeVO home = ManWomanToHome.INSTANCE.toHome( man, woman);
        assertEquals( "HomeVO(manName=小帅, womanName=小美, manAge=24, womanAge=21)", home.toString() );
    }


}
