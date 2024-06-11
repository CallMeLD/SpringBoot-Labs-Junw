package my.junw.jlab2mapstruct.multiParamType.vo;

public enum MyEnum {

    VALUE_1(0, "正常"),
    VALUE_2(1, "已删除");

    private int value;
    private String label;

    private MyEnum(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public int getValue() {
        return this.value;
    }

    public String getLabel() {
        return this.label;
    }
}
