package cscie56.dietxchange

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(DayLog)
@Mock([Dieter, Meal])
class DayLogSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    @Unroll
    void "Test Meal Constraints"() {
        when:
            def dieter = new Dieter()
            DayLog dL = new DayLog(date: new Date(), dieter: dieter)
            def breakfast = new Meal(type: bType,dieter:dieter, dayLog: dL)
            def lunch = new Meal(type: lType,dieter:dieter, dayLog: dL)
            def dinner = new Meal(type: dType,dieter:dieter, dayLog: dL)
            def snack = new Meal(type: sType,dieter:dieter, dayLog: dL)

            dL.breakfast = breakfast
            dL.lunch = lunch
            dL.dinner = dinner
            dL.snack = snack
            dL.validate()

        then:
            dL.hasErrors() != result

        where:
            bType           |   lType   |   dType       |   sType   |   result
            null            |   'lunch' |   'dinner'    |   'snack' |   false
            'breakfast'     |   null    |   'dinner'    |   'snack' |   false
            'breakfast'     |   'lunch' |   null        |   'snack' |   false
            'breakfast'     |   'lunch' |   'dinner'    |   null    |   false
            'lunch'         |   'lunch' |   'dinner'    |   'snack' |   false
            'breakfast'     |   'dinner'|   'dinner'    |   'snack' |   false
            'breakfast'     |   'lunch' |   'lunch'     |   'snack' |   false
            'breakfast'     |   'lunch' |   'dinner'    |   'lunch' |   false
            'breakfast'     |   'lunch' |   'dinner'    |   'snack' |   true
    }

    void "Test getStarchRemainder"() {
        when:
        def dieter = new Dieter(starchCount: 3)
        DayLog dL = new DayLog(starchCount: 4, fruitCount: 1, milkCount: 1, veggieCount: 1,
                proteinCount: 1, fatCount: 1, date: new Date(), dieter: dieter)
        then:
        assert dL.getStarchRemainder() == 0

        when:
        dieter = new Dieter(starchCount: 2)
        dL = new DayLog(starchCount: 1, fruitCount: 1, milkCount: 1, veggieCount: 1,
                proteinCount: 1, fatCount: 1, date: new Date(), dieter: dieter)
        then:
        assert dL.getStarchRemainder() == 1
    }

    void "Test getMilkRemainder"() {
        when:
        def dieter = new Dieter(milkCount: 3)
        DayLog dL = new DayLog(starchCount: 1, fruitCount: 1, milkCount: 4, veggieCount: 1,
                proteinCount: 1, fatCount: 1, date: new Date(), dieter: dieter)
        then:
        assert dL.getMilkRemainder() == 0

        when:
        dieter = new Dieter(milkCount: 2)
        dL = new DayLog(starchCount: 1, fruitCount: 1, milkCount: 1, veggieCount: 1,
                proteinCount: 1, fatCount: 1, date: new Date(), dieter: dieter)
        then:
        assert dL.getMilkRemainder() == 1
    }

    void "Test getFruitRemainder"() {
        when:
        def dieter = new Dieter(fruitCount: 3)
        DayLog dL = new DayLog(starchCount: 1, fruitCount: 4, milkCount: 1, veggieCount: 1,
                proteinCount: 1, fatCount: 1, date: new Date(), dieter: dieter)
        then:
        assert dL.getFruitRemainder() == 0

        when:
        dieter = new Dieter(fruitCount: 2)
        dL = new DayLog(starchCount: 1, fruitCount: 1, milkCount: 1, veggieCount: 1,
                proteinCount: 1, fatCount: 1, date: new Date(), dieter: dieter)
        then:
        assert dL.getFruitRemainder() == 1
    }

    void "Test getProteinRemainder"() {
        when:
        def dieter = new Dieter(proteinCount: 3)
        DayLog dL = new DayLog(starchCount: 1, fruitCount: 1, milkCount: 1, veggieCount: 1,
                proteinCount: 4, fatCount: 1, date: new Date(), dieter: dieter)
        then:
        assert dL.getProteinRemainder() == 0

        when:
        dieter = new Dieter(proteinCount: 2)
        dL = new DayLog(starchCount: 1, fruitCount: 1, milkCount: 1, veggieCount: 1,
                proteinCount: 1, fatCount: 1, date: new Date(), dieter: dieter)
        then:
        assert dL.getProteinRemainder() == 1
    }

    void "Test getVeggieRemainder"() {
        when:
        def dieter = new Dieter(veggieCount: 3)
        DayLog dL = new DayLog(starchCount: 1, fruitCount: 1, milkCount: 1, veggieCount: 4,
                proteinCount: 1, fatCount: 1, date: new Date(), dieter: dieter)
        then:
        assert dL.getVeggieRemainder() == 0

        when:
        dieter = new Dieter(veggieCount: 2)
        dL = new DayLog(starchCount: 1, fruitCount: 1, milkCount: 1, veggieCount: 1,
                proteinCount: 1, fatCount: 1, date: new Date(), dieter: dieter)
        then:
        assert dL.getVeggieRemainder() == 1
    }

    void "Test getFatRemainder"() {
        when:
        def dieter = new Dieter(fatCount: 3)
        DayLog dL = new DayLog(starchCount: 1, fruitCount: 1, milkCount: 1, veggieCount: 1,
                proteinCount: 1, fatCount: 4, date: new Date(), dieter: dieter)
        then:
        assert dL.getFatRemainder() == 0

        when:
        dieter = new Dieter(fatCount: 2)
        dL = new DayLog(starchCount: 1, fruitCount: 1, milkCount: 1, veggieCount: 1,
                proteinCount: 1, fatCount: 1, date: new Date(), dieter: dieter)
        then:
        assert dL.getFatRemainder() == 1
    }

}


