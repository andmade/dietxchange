package cscie56.dietxchange

class Food {

    static belongsTo = Meal
    static hasMany = [meals:Meal]

    String category
    String name
    BigDecimal portionSize
    String portionUnit
    static constraints = {
        category(inList: ['starch','fruit','milk','vegetable','protein','fat'])
        portionUnit(inList: ['ounce','cup','teaspoon','tablespoon','piece','slice','serving','package'])
    }
}
