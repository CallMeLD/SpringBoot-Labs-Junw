package my.junw.jlab2mapstruct.lombok.converted;

import my.junw.jlab2mapstruct.lombok.vo.SourceVO;
import my.junw.jlab2mapstruct.lombok.vo.TargetVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SourceToSource {

    SourceToSource INSTANCE = Mappers.getMapper( SourceToSource.class );

    SourceVO toSource(SourceVO s );
}
