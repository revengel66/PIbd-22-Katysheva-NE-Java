public enum DopEnum {
    FOUR,
    FIVE,
    SIX;
    public static DopEnum setEnumNumber(int number){
        switch (number){
            case 4:
                return DopEnum.FOUR;
            case 5:
                return DopEnum.FIVE;
            case 6:
                return DopEnum.SIX;
        }
        return null;
    }
}
