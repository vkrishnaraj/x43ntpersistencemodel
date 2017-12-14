package aero.nettracer.persistence.util;

public enum ItemTypeDescription {

    LOST(1,"LOST_DELAY"),
    MISSING_ARTICLES(2,"MISSING_ARTICLES"),
    DAMAGE(3,"DAMAGE"),
    UNKNOWN(4,"UNKNOWN");

    private final int key;
    private final String name;

    ItemTypeDescription(int key, String name){
        this.key = key;
        this.name = name;
    }

    public int getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public static String getNameFromKey(int key){
        for(ItemTypeDescription d: ItemTypeDescription.values()){
            if(d.getKey() == key){
                return d.getName();
            }
        }
        return null;
    }

    public static int getKeyFromName(String name){
        for(ItemTypeDescription d: ItemTypeDescription.values()){
            if(d.getName().equalsIgnoreCase(name)){
                return d.getKey();
            }
        }
        return UNKNOWN.getKey();
    }
}
