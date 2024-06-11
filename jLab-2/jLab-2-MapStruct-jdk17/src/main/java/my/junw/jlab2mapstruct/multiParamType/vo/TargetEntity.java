package my.junw.jlab2mapstruct.multiParamType.vo;


import lombok.Data;

import java.util.Date;

// 定义一个目标实体类TargetEntity
@Data
public class TargetEntity {

    private String intValueStr;
    private int intValue;
    private String formattedBigDecimal;
    private String localDateTimeValueStr;
    private String formattedDate;
    private String enumValueAsString;
    private Date timestampAsDate;
    private String stringValue;
    private String constantStr;
    private String expression_str;
    private String expression_date;
    private String expression_method;
    private String ignoreStr;
    private String expression_util;
    private BabyEO baby;

}
