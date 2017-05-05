package cscie56.dietxchange

class Food {

    static belongsTo = Meal
    static hasMany = [meals:Meal]

    String category
    String subcategory
    String name
    String portionSize
    String portionUnit
    static constraints = {
        portionUnit(inList: ['ounce','cup','teaspoon','tablespoon','piece','slice','serving','package'])
        category(inList: ['starch','fruit','milk','vegetable','protein','fat'])
        subcategory(inList:['bread','cereals_grains','starchy_veggies','crackers_snacks',
                            'fruit','juices','milk_yogurt','nonstarchy_veggies','lean_meat',
                            'medium_meat','high_meat','plant_protein','unsat_mono','polyunsat',
                            'saturated'])
    }
}
