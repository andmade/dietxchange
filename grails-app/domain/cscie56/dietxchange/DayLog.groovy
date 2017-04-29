package cscie56.dietxchange

class DayLog {

    Meal breakfast = null
    Meal lunch = null
    Meal dinner = null
    Meal snack = null
    Dieter dieter

    Integer starchCount
    Integer fruitCount
    Integer milkCount
    Integer veggieCount
    Integer proteinCount
    Integer fatCount

    Date date

    static constraints = {
        breakfast(validator: { val ->
            val.type == 'breakfast'
        })
        lunch(validator: { val ->
            val.type == 'lunch'
        })
        dinner(validator: { val ->
            val.type == 'dinner'
        })
        snack(validator: { val ->
            val.type == 'snack'
        })
        starchCount(min:1)
        fruitCount(min:1)
        milkCount(min:1)
        veggieCount(min:1)
        proteinCount(min:1)
        fatCount(min:1)
    }

    Integer getStarchRemainder() {
        if((this.starchCount - dieter.starchCount) < 0) {
            return 0
        } else{
            return this.starchCount - dieter.starchCount
        }
    }

    Integer getMilkRemainder() {
        if((this.milkCount - dieter.milkCount) < 0) {
            return 0
        } else{
            return this.milkCount - dieter.milkCount
        }
    }

    Integer getFruitRemainder() {
        if((this.fruitCount - dieter.fruitCount) < 0) {
            return 0
        } else{
            return this.fruitCount - dieter.fruitCount
        }
    }

    Integer getProteinRemainder() {
        if((this.proteinCount - dieter.proteinCount) < 0) {
            return 0
        } else{
            return this.proteinCount - dieter.proteinCount
        }
    }

    Integer getVeggieRemainder() {
        if((this.veggieCount - dieter.veggieCount) < 0) {
            return 0
        } else{
            return this.veggieCount - dieter.veggieCount
        }
    }

    Integer getFatRemainder() {
        if((this.fatCount - dieter.fatCount) < 0) {
            return 0
        } else{
            return this.fatCount - dieter.fatCount
        }
    }
}
