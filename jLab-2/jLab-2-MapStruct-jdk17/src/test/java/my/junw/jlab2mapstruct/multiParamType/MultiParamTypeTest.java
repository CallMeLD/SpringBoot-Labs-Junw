package my.junw.jlab2mapstruct.multiParamType;

import my.junw.jlab2mapstruct.multiParamType.converted.EntityMapper;
import my.junw.jlab2mapstruct.multiParamType.vo.ChildVO;
import my.junw.jlab2mapstruct.multiParamType.vo.MyEnum;
import my.junw.jlab2mapstruct.multiParamType.vo.SourceEntity;
import my.junw.jlab2mapstruct.multiParamType.vo.TargetEntity;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class MultiParamTypeTest {

    /**
     * 多参数源
     */
    @Test
    public void multiParamTypeTest() {
        // 创建源实体对象
        SourceEntity sourceEntity = new SourceEntity();
        sourceEntity.setIntValue(10);
        sourceEntity.setIntegerValue(12);
        sourceEntity.setLocalDateTimeValue(LocalDateTime.now());
        sourceEntity.setBigDecimalValue(new BigDecimal("123.456"));
        sourceEntity.setDateValue(new Date());
        sourceEntity.setEnumValue(MyEnum.VALUE_1);
        sourceEntity.setTimestampValue(new Timestamp(System.currentTimeMillis()));
        // sourceEntity.setStringValue("Hello");
        sourceEntity.setIgnore("ignore");
        ChildVO babyVO = new ChildVO("baby",1);
        sourceEntity.setBaby(babyVO);

        // 调用映射方法，将源实体映射为目标实体
        TargetEntity targetEntity = EntityMapper.INSTANCE.mapToTarget(sourceEntity);

        System.out.println(targetEntity.toString());
        // 验证映射结果
        assert "10".equals(targetEntity.getIntValueStr());
        assert  targetEntity.getIntValue() == 12;
        assert targetEntity.getStringValue().equals("Hello");
        assert targetEntity.getFormattedBigDecimal().equals("123.46"); // 根据规则，保留两位小数
        // 验证日期格式化
        // 在此为了简化，这里不验证具体格式，只验证是否为非空字符串
        assert targetEntity.getFormattedDate() != null && !targetEntity.getFormattedDate().isEmpty();
        assert targetEntity.getEnumValueAsString().equals(MyEnum.VALUE_1.toString());
        assert targetEntity.getTimestampAsDate() != null;
    }


}
