package dietxchange

import cscie56.dietxchange.DayLog
import cscie56.dietxchange.Dieter
import cscie56.dietxchange.Food
import cscie56.dietxchange.Meal
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

        day1.dinner = new Meal(type: 'dinner', dieter: Dieter.get(1), dayLog: day1)
        day1.dinner.addToFoods(Food.get(1))
        day1.dinner.save(flush:true)
        day1.addToCounts(Food.get(1))
        day1.save()

        def dieter = Dieter.get(1)
        dieter.favoriteFoods.add(Food.get(1))
        dieter.favoriteFoods.add(Food.get(5))

    }

    def createSeederFoods() {
        def foodList = [
                    new Food(category: "starch",subcategory:"bread",portionSize: "1",portionUnit: "slice",
                        name:"Bread, whole / white / rye / pumpernickel / raisin"),
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
                    new Food(category: "starch", subcategory: "crackers_snacks", portionSize: "8", portionUnit: "pieces",
                        name:"Animal crackers"),
                    new Food(category: "starch", subcategory: "crackers_snacks", portionSize: "3", portionUnit: "cups",
                        name:"Popcorn, popped, no added fat"),
                    new Food(category: "fruit", subcategory: "fruit", portionSize: "4", portionUnit: "oz",
                        name:"Apple, small, unpeeled"),
                    new Food(category: "fruit", subcategory: "fruit", portionSize: "1 1/4", portionUnit: "cups",
                        name:"Strawberries, whole"),
                    new Food(category: "fruit", subcategory: "juices", portionSize: "1/2", portionUnit: "cup",
                        name:"Apple cider, juice"),
                    new Food(category: "fruit", subcategory: "juices", portionSize: "1/3", portionUnit: "cup",
                        name:"Fruit juice blends, 100% juice"),
                    new Food(category: "milk", subcategory: "milk_yogurt", portionSize: "6", portionUnit: "oz",
                        name:"Yogurt, plain or artificially sweetened"),
                    new Food(category: "milk", subcategory: "milk_yogurt", portionSize: "1", portionUnit: "cup",
                        name:"Fat free (skim) or low fat (1%) milk"),
                    new Food(category: "veggies", subcategory: "nonstarchy_veggies", portionSize: "1/2", portionUnit: "cup",
                        name:"Cooking greens, cooked (collard, kale, turnip)"),
                    new Food(category: "veggies", subcategory: "nonstarchy_veggies", portionSize: "1/2", portionUnit: "cup",
                        name:"Green beans, cooked"),
                    new Food(category: "protein", subcategory: "lean_meat", portionSize: "1", portionUnit: "oz",
                        name:"Beef: ground, round, roast, sirloin, steak"),
                    new Food(category: "protein", subcategory: "lean_meat", portionSize: "1/4", portionUnit: "cup",
                        name:"Egg substitutes, plain"),
                    new Food(category: "protein", subcategory: "medium_meat", portionSize: "1", portionUnit: "unit",
                        name:"Egg, whole"),
                    new Food(category: "protein", subcategory: "medium_meat", portionSize: "1", portionUnit: "unit",
                        name:"Poultry: ground turkey, chicken w/skin"),
                    new Food(category: "protein", subcategory: "high_meat", portionSize: "2", portionUnit: "slices",
                        name:"Bacon, pork"),
                    new Food(category: "protein", subcategory: "high_meat", portionSize: "1", portionUnit: "oz",
                        name:"Cheese, regular"),
                    new Food(category: "protein", subcategory: "plant_protein", portionSize: "4", portionUnit: "oz",
                        name:"Tofu"),
                    new Food(category: "protein", subcategory: "plant_protein", portionSize: "1", portionUnit: "tablespoon",
                        name:"Peanut Butter"),
                    new Food(category: "fats", subcategory: "unsat_mono", portionSize: "2", portionUnit: "tablespoon",
                        name:"Avocado"),
                    new Food(category: "fats", subcategory: "unsat_mono", portionSize: "1", portionUnit: "teaspoon",
                        name:"Oil: canola, olive, peanut"),
                    new Food(category: "fats", subcategory: "polyunsat", portionSize: "4", portionUnit: "halves",
                        name:"Walnuts"),
                    new Food(category: "fats", subcategory: "polyunsat", portionSize: "1", portionUnit: "tablespoon",
                        name:"Salad dressing, regular"),
                    new Food(category: "fats", subcategory: "saturated", portionSize: "1", portionUnit: "teaspoon",
                        name:"Butter, stick"),
                    new Food(category: "fats", subcategory: "saturated", portionSize: "2", portionUnit: "tablespoons",
                        name:"Cream, half and half")]


        foodList.each {it.save()}
    }
}
