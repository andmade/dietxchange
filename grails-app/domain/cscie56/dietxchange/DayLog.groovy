package cscie56.dietxchange

class DayLog {

    static belongsTo = [dieter:Dieter]

    Meal breakfast = null
    Meal lunch = null
    Meal dinner = null
    Meal snack = null

    Integer starchCount = 0
    Integer fruitCount = 0
    Integer milkCount = 0
    Integer veggieCount = 0
    Integer proteinCount = 0
    Integer fatCount = 0

    Date date

    static mappedBy = [ breakfast: "none",lunch:"none",dinner:"none",snack:"none" ]

    static constraints = {
        starchCount(min:0)
        fruitCount(min:0)
        milkCount(min:0)
        veggieCount(min:0)
        proteinCount(min:0)
        fatCount(min:0)
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

    void addToCounts(Food food) {
        switch (food.category) {
            case 'starch':
                starchCount++
                break
            case 'fruit':
                fruitCount++
                break
            case 'veggies':
                veggieCount++
                break
            case 'milk':
                milkCount++
                break
            case 'protein':
                proteinCount++
                break
            default:
                fatCount++
                break
        }
    }
    void removeFromCounts(Food food) {
        switch(food.category) {
            case 'starch':
                starchCount--
                break
            case 'fruit':
                fruitCount--
                break
            case 'veggies':
                veggieCount--
                break
            case 'milk':
                milkCount--
                break
            case 'protein':
                proteinCount--
                break
            default:
                fatCount--
                break
        }
    }

    Integer getStarchRemainder() {
        if((dieter.starchCount - starchCount) < 0) {
            return 0
        } else{
            return dieter.starchCount - starchCount
        }
    }

    Integer getMilkRemainder() {
        if((dieter.milkCount - milkCount) < 0) {
            return 0
        } else{
            return dieter.milkCount - milkCount
        }
    }

    Integer getFruitRemainder() {
        if((dieter.fruitCount - fruitCount) < 0) {
            return 0
        } else{
            return dieter.fruitCount - fruitCount
        }
    }

    Integer getProteinRemainder() {
        if((dieter.proteinCount - proteinCount) < 0) {
            return 0
        } else{
            return dieter.proteinCount - proteinCount
        }
    }

    Integer getVeggieRemainder() {
        if((dieter.veggieCount - veggieCount) < 0) {
            return 0
        } else{
            return dieter.veggieCount - veggieCount
        }
    }

    Integer getFatRemainder() {
        if((dieter.fatCount - fatCount) < 0) {
            return 0
        } else{
            return dieter.fatCount - fatCount
        }
    }
}
