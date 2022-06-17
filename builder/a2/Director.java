public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.makeTitle("demo");
        builder.makeString("demo");
        builder.makeItems(new String[]{
                "How are you?",
                "Hello",
                "Hi",
        });
        builder.makeString("demo");
        builder.makeItems(new String[]{
                "Good morning",
                "Good afternoon",
                "Good evening",
        });
        builder.close();
    }
}