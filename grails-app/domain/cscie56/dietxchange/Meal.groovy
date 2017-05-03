package cscie56.dietxchange

class Meal {

    static hasMany = [foods:Food]
    static belongsTo = [dayLog:DayLog]
    String type
    Dieter dieter

    static constraints = {
        type(inList: ['breakfast','lunch','dinner','snack'])

    }

}
