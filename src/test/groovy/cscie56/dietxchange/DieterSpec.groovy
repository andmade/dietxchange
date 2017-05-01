package cscie56.dietxchange

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll
import springsecurity.dietxchange.User

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Dieter)
@Mock([User,Food,DayLog])
class DieterSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    @Unroll
    void "Test Category Minimums"() {
        expect:
        Dieter d = new Dieter(
                starchCount: sC,
                fruitCount: frC,
                milkCount: mC,
                veggieCount: vC,
                proteinCount: pC,
                fatCount: faC,
                targetCalories: tC,
                user: Mock(User)
        )

        d.validate() == result

        where:
        sC | frC | mC | vC | pC | faC | tC   | result
        0  | 1   | 1  | 1  | 1  | 1   | 1200 | false
        1  | 0   | 1  | 1  | 1  | 1   | 1200 | false
        1  | 1   | 0  | 1  | 1  | 1   | 1200 | false
        1  | 1   | 1  | 0  | 1  | 1   | 1200 | false
        1  | 1   | 1  | 1  | 0  | 1   | 1200 | false
        1  | 1   | 1  | 1  | 1  | 0   | 1200 | false
        1  | 1   | 1  | 1  | 1  | 1   | 1100 | false
        1  | 1   | 1  | 1  | 1  | 1   | 1200 | true

    }

    void "Test Food Methods"() {
        when:
        Dieter d = new Dieter(starchCount: 1, fruitCount: 1, milkCount: 1, veggieCount: 1, proteinCount: 1,
                fatCount: 1, targetCalories: 1200, user: Mock(User))

        Food breakfast = Mock(Food)
        Food lunch = Mock(Food)
        Food dinner = Mock(Food)
        Food snack = Mock(Food)

        d.favoriteFoods[breakfast] = 'breakfast'
        d.favoriteFoods[lunch] = 'lunch'
        d.favoriteFoods[dinner] = 'dinner'
        d.favoriteFoods[snack] = 'snack'

        then:

        assert d.favoriteFoods.size() == 4
        assert d.getBreakfastFaves() == [(breakfast): 'breakfast']
        assert d.getLunchFaves() == [(lunch): 'lunch']
        assert d.getDinnerFaves() == [(dinner): 'dinner']
        assert d.getSnackFaves() == [(snack): 'snack']

    }

    void "Test getDayLog"() {
        when:
        Dieter d = new Dieter(starchCount: 1, fruitCount: 1, milkCount: 1, veggieCount: 1, proteinCount: 1,
                fatCount: 1, targetCalories: 1200, user: Mock(User))

        DayLog dL1 = Mock(DayLog)
        DayLog dL2 = Mock(DayLog)

        d.dayLogs = [dL1,dL2]

        then:
        assert d.dayLogs.size() == 2
    }
}

