package cscie56.dietxchange

class Food {

    String category
    Meal meal
    User user
    Boolean favorite
    String name
    BigDecimal portionSize
    String portionUnit
    static constraints = {
        category(inList: ['starch','fruit','milk','vegetable','protein','fat'])
        portionUnit(inList: ['ounce','cup','teaspoon','tablespoon','piece','slice'])
    }
}
