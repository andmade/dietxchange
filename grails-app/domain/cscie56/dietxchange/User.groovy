package cscie56.dietxchange

import grails.plugin.springsecurity.SpringSecurityService
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class User implements Serializable {

	private static final long serialVersionUID = 1

	SpringSecurityService springSecurityService


	Integer starchCount
	Integer fruitCount
	Integer milkCount
	Integer veggieCount
	Integer proteinCount
	Integer fatCount
	Integer targetCalories

	String username
	String password
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	Set<Role> getAuthorities() {
		(UserRole.findAllByUser(this) as List<UserRole>)*.role as Set<Role>
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}

	static transients = ['springSecurityService', 'favoriteFoods', 'dayLogs']

	static constraints = {
		password blank: false, password: true
		username blank: false, unique: true
		starchCount(min:1)
		fruitCount(min:1)
		milkCount(min:1)
		veggieCount(min:1)
		proteinCount(min:1)
		fatCount(min:1)
		targetCalories(min:1200)
	}

	static mapping = {
		password column: '`password`'
	}


}
