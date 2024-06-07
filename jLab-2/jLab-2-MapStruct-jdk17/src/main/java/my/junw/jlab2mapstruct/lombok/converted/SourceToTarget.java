package my.junw.jlab2mapstruct.lombok.converted;

import my.junw.jlab2mapstruct.lombok.vo.SourceVO;
import my.junw.jlab2mapstruct.lombok.vo.TargetVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SourceToTarget {

    SourceToTarget INSTANCE = Mappers.getMapper( SourceToTarget.class );

    @Mapping( source = "test", target = "testing" )
    TargetVO toTarget(SourceVO s );
}
