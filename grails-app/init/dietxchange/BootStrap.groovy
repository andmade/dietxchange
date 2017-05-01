package dietxchange

import springsecurity.dietxchange.Role
import springsecurity.dietxchange.User
import springsecurity.dietxchange.UserRole

class BootStrap {

    def init = { servletContext ->
        createUsersAndRoles()
    }
    def destroy = {
    }

    def createUsersAndRoles() {

        User admin = new User(username: 'admin', password: 'superuser')
        User dieter = new User(username: 'andmade', password: 'user')
        admin.save()
        dieter.save()

        Role adminRole = new Role(authority: Role.ROLE_ADMIN)
        Role dieterRole = new Role(authority: Role.ROLE_DIETER)
        adminRole.save()
        dieterRole.save()

        UserRole.create(admin,adminRole)
        UserRole.create(dieter,dieterRole)

    }
}
