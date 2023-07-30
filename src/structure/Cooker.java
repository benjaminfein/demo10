package structure;

import java.util.ArrayList;

public class Cooker {
    private String name;
    private ArrayList<String> dishesCanCook;

    public Cooker(String name, ArrayList<String> dishesCanCook) {
        this.name = name;
        this.dishesCanCook = dishesCanCook;
    }
}
