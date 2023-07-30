package service;

import java.util.ArrayList;

public interface CurrentlyWorkingCooker {
    public static void currentlyWorkingCooker(ArrayList<String> food, ArrayList<String> dishesMaxCanCook) {
        for (int i = 0; i < food.size(); i++) {
            String dish = food.get(i).substring(2);
            if (dishesMaxCanCook.contains(dish)) {
                System.out.println("Start cooking " + dish + ". This dish is cooking by Max");
            } else {
                System.out.println("Start cooking " + dish + ". This dish is cooking by Pedro");
            }
        }
    }
}
