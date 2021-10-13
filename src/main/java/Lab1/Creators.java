package Lab1;

public enum Creators {
    samsung,
    lg,
    sony,
    apple;

    public static Creators getCreator(int a){
        switch (a){
            case 0:
                return samsung;
            case 1:
                return lg;
            case 2:
                return sony;
            case 3:
                return apple;
            default:break;
        }
        return null;
    }
}
