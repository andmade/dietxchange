package cscie56.dietxchange

class Dieter {

    static hasMany = [dayLogs:DayLog]
    Integer starchCount
    Integer fruitCount
    Integer milkCount
    Integer veggieCount
    Integer proteinCount
    Integer fatCount
    Integer targetCalories
    Map<Food,String> favoriteFoods = [:]


    static constraints = {
        starchCount(min:1)
        fruitCount(min:1)
        milkCount(min:1)
        veggieCount(min:1)
        proteinCount(min:1)
        fatCount(min:1)
        targetCalories(min:1200)
    }

    Map<Food,String> getBreakfastFaves() {
        favoriteFoods.findAll{it.value == 'breakfast'}
    }
    Map<Food,String> getLunchFaves() {
        favoriteFoods.findAll{it.value == 'lunch'}

    }
    Map<Food,String> getDinnerFaves() {
        favoriteFoods.findAll { it.value == 'dinner' }
    }

    Map<Food,String> getSnackFaves() {
        favoriteFoods.findAll{it.value == 'snack'}

    }
}
