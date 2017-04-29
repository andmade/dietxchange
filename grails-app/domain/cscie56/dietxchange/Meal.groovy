package cscie56.dietxchange

class Meal {

    static hasMany = [foods:Food]
    String type
    DayLog daylog
    Dieter dieter


    static constraints = {
        type(inList: ['breakfast','lunch','dinner','snack'])

    }

}
