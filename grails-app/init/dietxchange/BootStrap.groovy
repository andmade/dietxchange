package dietxchange

import cscie56.dietxchange.DayLog
import cscie56.dietxchange.Dieter
import cscie56.dietxchange.Food
import springsecurity.dietxchange.Role
import springsecurity.dietxchange.User
import springsecurity.dietxchange.UserRole

class BootStrap {

    def init = { servletContext ->
        createUsersAndRoles()
        createSeederFoods()
        createInitDayLogs()

    }
    def destroy = {
    }

    def createUsersAndRoles() {

        User admin = new User(username: 'admin', password: 'superuser')
        User dieter_user = new User(username: 'andmade', password: 'user')
        admin.save()
        dieter_user.save()

        Role adminRole = new Role(authority: Role.ROLE_ADMIN)
        Role dieterRole = new Role(authority: Role.ROLE_DIETER)
        adminRole.save()
        dieterRole.save()

        UserRole.create(admin,adminRole)
        UserRole.create(dieter_user,dieterRole)

        Dieter dieter = new Dieter(firstName: "Ashley", lastName: "Davis",
                starchCount: 5,milkCount: 1,fruitCount: 2,veggieCount: 4,proteinCount: 7,fatCount: 6,
                targetCalories: 1400,user: dieter_user)
        dieter.save()
        dieter_user.dieter = dieter
        dieter_user.save()

    }

    def createInitDayLogs() {
        def today = new Date().clearTime()
        def day1 = new DayLog(date:today, dieter:Dieter.get(1))
        day1.save()
        def day2 = new DayLog(date:today-1, dieter:Dieter.get(1))
        day2.save()

    }

    def createSeederFoods() {
        def foodList = [
                    new Food(category: "starch",subcategory:"bread",portionSize: "1",portionUnit: "slice",
                        name:"Bread, whole/white/rye/pumpernickel/raisin"),
                    new Food(category: "starch", subcategory: "bread" , portionSize: "1", portionUnit: "piece",
                        name: 'Pancake, 4" across, 1/4" thick'),
                    new Food(category: "starch", subcategory: "cereals_grains",portionSize: "1", portionUnit: "cup",
                        name: "Rice, couscous, pasta, quinoa (cooked)"),
                    new Food(category: "starch", subcategory: "cereals_grains", portionSize: "1/2", portionUnit: "cup",
                        name: "Oatmeal, cooked"),
                    new Food(category: "starch", subcategory: "starchy_veggies",portionSize: "1/2", portionUnit: "cup",
                        name: "Corn"),
                    new Food(category: "starch", subcategory: "starchy_veggies",portionSize: "3", portionUnit: "oz",
                        name: "Potato baked, with skin"),
                    new Food(category: "starch", subcategory: "crackers_snack", portionSize: "8", portionUnit: "pieces",
                        name:"Animal crackers")]


        foodList.each {it.save()}
    }
}
