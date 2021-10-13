package Lab1;

public enum ProductType {
    telephone,
    tv,
    dvd,
    radio;

    public static ProductType getType(int a){
        switch (a){
            case 0:
                return telephone;
            case 1:
                return tv;
            case 2:
                return dvd;
            case 3:
                return radio;
            default:break;
        }
        return null;
    }
}
