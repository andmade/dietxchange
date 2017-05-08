package cscie56.dietxchange

import grails.plugin.springsecurity.annotation.Secured
import springsecurity.dietxchange.Role

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured([Role.ROLE_ADMIN])
class DieterController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Dieter.list(params), model:[dieterCount: Dieter.count()]
    }

    def show(Dieter dieter) {
        respond dieter
    }

    def create() {
        respond new Dieter(params)
    }

    @Transactional
    def save(Dieter dieter) {
        if (dieter == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (dieter.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond dieter.errors, view:'create'
            return
        }

        dieter.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'dieter.label', default: 'Dieter'), dieter.id])
                redirect dieter
            }
            '*' { respond dieter, [status: CREATED] }
        }
    }

    def edit(Dieter dieter) {
        respond dieter
    }

    @Transactional
    def update(Dieter dieter) {
        if (dieter == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (dieter.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond dieter.errors, view:'edit'
            return
        }

        dieter.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'dieter.label', default: 'Dieter'), dieter.id])
                redirect dieter
            }
            '*'{ respond dieter, [status: OK] }
        }
    }

    @Transactional
    def delete(Dieter dieter) {

        if (dieter == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        dieter.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'dieter.label', default: 'Dieter'), dieter.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'dieter.label', default: 'Dieter'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
