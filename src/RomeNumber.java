public enum RomeNumber {
    Zero(0,"0"),I(1,"I"), II(2,"II"), III(3,"III"), IV(4,"IV"), V(5,"V"),
    VI(6,"VI"), VII(7,"VII"), VIII(8,"VIII"), IX(9,"IX"), X(10,"X"),
    XI(11,"XI"),XII(12,"XII"), XIII(13,"XIII"),XIV(14,"XIV"),XV(15,"XV"),
    XVI(16,"XVI"),XVII(17,"XVII"),XVIII(18,"XVIII"),XIX(19,"XIX"),XX(20,"XX");
   private int num;
   private String name;
    RomeNumber(int num, String name){
        this.num = num;
        this.name = name;
    }
    public Integer getNumber(){
        return num;
    }
    public String getName() {
        return name;
       }
}
