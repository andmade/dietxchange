package dietxchange

import cscie56.dietxchange.DayLog
import cscie56.dietxchange.Dieter
import springsecurity.dietxchange.Role
import springsecurity.dietxchange.User
import springsecurity.dietxchange.UserRole

class BootStrap {

    def init = { servletContext ->
        createUsersAndRoles()
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
        dieter_user.dieterID = dieter.id
        dieter_user.save()

    }

    def createInitDayLogs() {
        def day1 = new DayLog(date:new Date(), starchCount: 0,fruitCount: 0,milkCount: 0,
                veggieCount: 0,proteinCount: 0,fatCount: 0,dieter:Dieter.get(1))
        day1.save()


    }
}
