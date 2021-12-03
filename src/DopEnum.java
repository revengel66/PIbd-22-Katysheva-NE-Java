public enum DopEnum {
    FOUR,
    FIVE,
    SIX;
    public static DopEnum setEnumNumber(int number){
        switch (number){
            case 0:
                return DopEnum.FOUR;
            case 1:
                return DopEnum.FIVE;
            case 2:
                return DopEnum.SIX;
        }
        return null;
    }
}
