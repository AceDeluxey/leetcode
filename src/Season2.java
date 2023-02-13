public final class Season2 {
    public static final Season2 Spring = new Season2(1);
    public static final Season2 Summer = new Season2(2);
    public static final Season2 Autumn = new Season2(3);
    public static final Season2 Winter = new Season2(4);

    private int code;

    private  Season2(){

    }
    private int getCode(){
        return this.code;
    }
    private Season2(int code) {
        this.code = code;
    }
}
