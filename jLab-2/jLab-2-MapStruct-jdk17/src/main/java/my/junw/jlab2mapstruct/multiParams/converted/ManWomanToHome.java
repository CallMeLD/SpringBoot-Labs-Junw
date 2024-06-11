package my.junw.jlab2mapstruct.multiParams.converted;

import my.junw.jlab2mapstruct.lombok.vo.SourceVO;
import my.junw.jlab2mapstruct.lombok.vo.TargetVO;
import my.junw.jlab2mapstruct.multiParams.vo.BabyVO;
import my.junw.jlab2mapstruct.multiParams.vo.HomeVO;
import my.junw.jlab2mapstruct.multiParams.vo.ManVO;
import my.junw.jlab2mapstruct.multiParams.vo.WomanVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ManWomanToHome {

    ManWomanToHome INSTANCE = Mappers.getMapper( ManWomanToHome.class );

    @Mappings({
        @Mapping( source = "man.name", target = "manName" ),
        @Mapping( source = "man.age", target = "manAge" ),
        @Mapping( source = "woman.name", target = "womanName" ),
        @Mapping( source = "woman.age", target = "womanAge" ),
        // 子对象属性完全一致时，可以用.指代
        @Mapping( source = "woman.baby", target = "." )
    })
    HomeVO toHome(ManVO man, WomanVO woman);
}
