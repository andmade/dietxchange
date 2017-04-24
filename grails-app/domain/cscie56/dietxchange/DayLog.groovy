package cscie56.dietxchange

class DayLog {

    Meal breakfast = null
    Meal lunch = null
    Meal dinner = null
    Meal snack = null
    User user

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
        dinner(validator: { val ->
            val.type == 'dinner'
        })
        starchCount(min:1)
        fruitCount(min:1)
        milkCount(min:1)
        veggieCount(min:1)
        proteinCount(min:1)
        fatCount(min:1)
    }

    Integer getStarchRemainder() {
        if((this.starchCount - user.starchCount) < 0) {
            return 0
        } else{
            return this.starchCount - user.starchCount
        }
    }

    Integer getMilkRemainder() {
        if((this.milkCount - user.milkCount) < 0) {
            return 0
        } else{
            return this.milkCount - user.milkCount
        }
    }

    Integer getFruitRemainder() {
        if((this.fruitCount - user.fruitCount) < 0) {
            return 0
        } else{
            return this.fruitCount - user.fruitCount
        }
    }

    Integer getProteinRemainder() {
        if((this.proteinCount - user.proteinCount) < 0) {
            return 0
        } else{
            return this.proteinCount - user.proteinCount
        }
    }

    Integer getVeggieRemainder() {
        if((this.veggieCount - user.veggieCount) < 0) {
            return 0
        } else{
            return this.veggieCount - user.veggieCount
        }
    }

    Integer getFatRemainder() {
        if((this.fatCount - user.fatCount) < 0) {
            return 0
        } else{
            return this.fatCount - user.fatCount
        }
    }
}
