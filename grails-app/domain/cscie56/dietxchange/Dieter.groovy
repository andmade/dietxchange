package cscie56.dietxchange

class Dieter {

    Integer starchCount
    Integer fruitCount
    Integer milkCount
    Integer veggieCount
    Integer proteinCount
    Integer fatCount
    Integer targetCalories
    List<Food> favoriteFoods = []

    static constraints = {
        starchCount(min:1)
        fruitCount(min:1)
        milkCount(min:1)
        veggieCount(min:1)
        proteinCount(min:1)
        fatCount(min:1)
        targetCalories(min:1200)
    }

    List<DayLog> getDayLogs() {
        return DayLog.findAllByDieter(this)
    }

    List<Food> getBreakfastFaves() {
        favoriteFoods.findAll{it.meal.type == 'breakfast'}
    }
    List<Food> getLunchFaves() {
        favoriteFoods.findAll{it.meal.type == 'lunch'}

    }
    List<Food> getDinnerFaves() {
        favoriteFoods.findAll { it.meal.type == 'dinner' }
    }

    List<Food> getSnackFaves() {
        favoriteFoods.findAll{it.meal.type == 'snack'}

    }
}
