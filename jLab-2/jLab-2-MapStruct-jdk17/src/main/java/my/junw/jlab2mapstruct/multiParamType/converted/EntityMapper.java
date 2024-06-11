package my.junw.jlab2mapstruct.multiParamType.converted;

import my.junw.jlab2mapstruct.multiParamType.utils.StringBOUtils;
import my.junw.jlab2mapstruct.multiParamType.vo.SourceEntity;
import my.junw.jlab2mapstruct.multiParamType.vo.TargetEntity;
import my.junw.jlab2mapstruct.multiParams.converted.ManWomanToHome;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.Date;

// 使用MapStruct的@Mapper注解定义一个映射器接口
@Mapper(imports = {StringBOUtils.class})
public interface EntityMapper {

    EntityMapper INSTANCE = Mappers.getMapper(EntityMapper.class );

    // 定义映射方法，指定映射规则
    @Mappings({
            // 基本类型 --> String
            @Mapping(source = "intValue", target = "intValueStr"),
            // 基本类型包装类 --> 基本类型
            @Mapping(source = "integerValue", target = "intValue"),
            // LocalDateTime --> String
            @Mapping(source = "localDateTimeValue", target = "localDateTimeValueStr"),
            // BigDecimal --> String  保留两位小数
            @Mapping(source = "bigDecimalValue", target = "formattedBigDecimal", numberFormat = "#.00"),
            // Date --> String  指定时间格式 yyyy-MM-dd HH:mm:ss
            @Mapping(source = "dateValue", target = "formattedDate", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            // 枚举类 --> String
            @Mapping(source = "enumValue", target = "enumValueAsString"),
            // Timestamp --> Date
            @Mapping(source = "timestampValue", target = "timestampAsDate"),
            // defaultValue 设置默认值，来源为null时，目标为默认值。
            @Mapping(source = "stringValue", target = "stringValue",defaultValue = "Hello"),
            // 目标值指定为常量
            @Mapping(target = "constantStr",constant = "我是常量"),
            // ignore = true 忽略属性，不拷贝
            @Mapping(target = "ignoreStr",ignore = true),
            // expression 表达式：常量
            @Mapping(target = "expression_str",expression = "java(\"Jaws\")"),
            // expression 表达式：一段代码
            @Mapping(target = "expression_date",expression = "java(\"表达式 --> 时间：\" + new java.util.Date())"),
            // expression 表达式：方法调用-当前类
            @Mapping(target = "expression_method",expression = "java(EntityMapper.getLastRunTime(sourceEntity))"),
            // expression 表达式：方法调用-外部工具类
            @Mapping(target = "expression_util", expression = "java(StringBOUtils.toBOString(sourceEntity.getIgnore()))")
    })
    TargetEntity mapToTarget(SourceEntity sourceEntity);

    static String getLastRunTime(SourceEntity sourceEntity){
        return "lastRunTime --> " + sourceEntity.getDateValue();
    }
}
