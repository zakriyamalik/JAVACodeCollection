package DesignPatterns.FactoryDesginPattern;


public class Main {
    public static void main(String[] args) {
        // Order a pizza using the PizzaFactory
        DishFactory pizzaFactory = new PizzaFactory();
        Dish pizza = pizzaFactory.createDish();
        pizza.prepare();
        pizza.serve();

        // Order sushi using the SushiFactory
        DishFactory sushiFactory = new SushiFactory();
        Dish sushi = sushiFactory.createDish();
        sushi.prepare();
        sushi.serve();
    }
}
