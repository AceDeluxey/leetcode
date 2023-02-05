public enum Season {
    Spring(1),
    Summer(2),
    Autumn(3),
    Winter(4);
    private int code;

    Season(){

    }
    public int getCode(){
        return this.code;
    }

    Season(int code) {
        this.code = code;
    }
}
