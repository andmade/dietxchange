package cscie56.dietxchange

class DayLog {

    static belongsTo = [dieter:Dieter]

    Meal breakfast = null
    Meal lunch = null
    Meal dinner = null
    Meal snack = null

    Integer starchCount
    Integer fruitCount
    Integer milkCount
    Integer veggieCount
    Integer proteinCount
    Integer fatCount

    Date date

    static constraints = {
        starchCount(min:1)
        fruitCount(min:1)
        milkCount(min:1)
        veggieCount(min:1)
        proteinCount(min:1)
        fatCount(min:1)
        breakfast(nullable: true, validator: {val, obj, errors ->
                if(!(val == null || val?.type == 'breakfast')) {
                    errors.rejectValue('breakfast', "Meal is not a breakfast")
            }
        })
        lunch(nullable: true, validator: {val, obj, errors ->
                if(!(val == null || val?.type == 'lunch')) {
                    errors.rejectValue('lunch', "Meal is not a lunch")
            }
        })
        dinner(nullable: true, validator: {val, obj, errors ->
                if(!(val == null || val?.type == 'dinner')) {
                    errors.rejectValue('dinner', "Meal is not a dinner")
            }
        })
        snack(nullable: true, validator: {val, obj, errors ->
                if(!(val == null || val?.type == 'snack')) {
                    errors.rejectValue('snack', "Meal is not a snack")
            }
        })
    }

    Integer getStarchRemainder() {
        if((starchCount - dieter.starchCount) < 0) {
            return 0
        } else{
            return starchCount - dieter.starchCount
        }
    }

    Integer getMilkRemainder() {
        if((milkCount - dieter.milkCount) < 0) {
            return 0
        } else{
            return milkCount - dieter.milkCount
        }
    }

    Integer getFruitRemainder() {
        if((fruitCount - dieter.fruitCount) < 0) {
            return 0
        } else{
            return fruitCount - dieter.fruitCount
        }
    }

    Integer getProteinRemainder() {
        if((proteinCount - dieter.proteinCount) < 0) {
            return 0
        } else{
            return proteinCount - dieter.proteinCount
        }
    }

    Integer getVeggieRemainder() {
        if((veggieCount - dieter.veggieCount) < 0) {
            return 0
        } else{
            return veggieCount - dieter.veggieCount
        }
    }

    Integer getFatRemainder() {
        if((fatCount - dieter.fatCount) < 0) {
            return 0
        } else{
            return fatCount - dieter.fatCount
        }
    }
}
