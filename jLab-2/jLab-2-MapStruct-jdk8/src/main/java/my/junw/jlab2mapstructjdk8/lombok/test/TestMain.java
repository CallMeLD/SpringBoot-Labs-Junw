package my.junw.jlab2mapstructjdk8.lombok.test;


import my.junw.jlab2mapstructjdk8.lombok.converted.SourceToTarget;
import my.junw.jlab2mapstructjdk8.lombok.vo.SourceVO;
import my.junw.jlab2mapstructjdk8.lombok.vo.TargetVO;

public class TestMain {

    public static void main( String[] args ) {
        SourceVO s = new SourceVO();
        s.setTest( "5" );

        TargetVO t = SourceToTarget.INSTANCE.toTarget( s );
        System.out.println( t.getTesting() );
    }

}
