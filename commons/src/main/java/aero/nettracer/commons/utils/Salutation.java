package aero.nettracer.commons.utils;

public enum Salutation {

    DR("Dr.", 1),
    DR_NODOT("Dr", 1),
    MR("Mr.", 2),
    MR_NODOT("Mr", 2),
    MS("Ms.", 3),
    MS_NODOT("Ms", 3),
    MISS("Miss.", 4),
    MISS_NODOT("Miss", 4),
    MRS("Mrs.", 5),
    MRS_NODOT("Mrs", 5),
    OTHER("Other", 6);

    private final String salutationString;
    private final int salutaionValue;

    Salutation(String salutationString, int salutaionValue) {
        this.salutationString = salutationString;
        this.salutaionValue = salutaionValue;
    }

    public static int getSalutaionValue(String salutationString) {
        int salutationValue = 0;
        Salutation[] values = values();
        for(Salutation salutation : values) {
            if(salutation.getSalutationString().equals(salutationString)) {
                salutationValue = salutation.salutaionValue;
                break;
            }
        }
        return salutationValue;
    }

    public static String getSalutaionString(int salutationValue) {
        String salutationString = "Please Select";
        Salutation[] values = values();
        for(Salutation salutation : values) {
            if(!salutation.name().endsWith("DOT")) {
                if(salutation.getSalutaionValue() == salutationValue) {
                    salutationString = salutation.salutationString;
                    break;
                }
            }
        }
        return salutationString;
    }

    public String getSalutationString() {
        return salutationString;
    }

    public int getSalutaionValue() {
        return salutaionValue;
    }
}