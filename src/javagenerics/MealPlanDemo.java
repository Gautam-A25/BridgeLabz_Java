package javagenerics;
/*
 ============================================================
  PERSONALIZED MEAL PLAN GENERATOR
 ============================================================
*/

// MealPlan interface
interface MealPlan {
    void prepare();
}

// Meal implementations
class VegetarianMeal implements MealPlan {
    public void prepare() {
        System.out.println("Preparing Vegetarian Meal");
    }
}

class VeganMeal implements MealPlan {
    public void prepare() {
        System.out.println("Preparing Vegan Meal");
    }
}

class KetoMeal implements MealPlan {
    public void prepare() {
        System.out.println("Preparing Keto Meal");
    }
}

/*
 * Generic Meal class
 */
class Meal<T extends MealPlan> {

    private T meal;

    public Meal(T meal) {
        this.meal = meal;
    }

    public T getMeal() {
        return meal;
    }
}

/*
 * Utility with generic method
 */
class MealGenerator {

    public static <T extends MealPlan> void generateMeal(T meal) {
        meal.prepare();
    }
}

/*
 * Main class
 */
public class MealPlanDemo {
    public static void main(String[] args) {

        Meal<VegetarianMeal> vegMeal = new Meal<>(new VegetarianMeal());
        MealGenerator.generateMeal(vegMeal.getMeal());

        Meal<KetoMeal> ketoMeal = new Meal<>(new KetoMeal());
        MealGenerator.generateMeal(ketoMeal.getMeal());
    }
}
