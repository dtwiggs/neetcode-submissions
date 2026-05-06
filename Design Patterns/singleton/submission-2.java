static class Singleton {
    private static Singleton uniqueInstance = null;
    private String val = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (uniqueInstance == null){
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

    public String getValue() {
        return val;
    }

    public void setValue(String value) {
        this.val = value;
    }
    
}
