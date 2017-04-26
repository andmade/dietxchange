package cscie56.dietxchange

class Meal {

    String type
    DayLog daylog
    User user

    static transients = ['foods']

    static constraints = {
        type(inList: ['breakfast','lunch','dinner','snack'])

    }

    List<Food> getFoods() {
        return Food.findAllByMeal(this)
    }
}
