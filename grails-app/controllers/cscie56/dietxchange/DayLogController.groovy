package cscie56.dietxchange

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class DayLogController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond DayLog.list(params), model:[dayLogCount: DayLog.count()]
    }

    def show(DayLog dayLog) {
        respond dayLog
    }

    def create() {
        respond new DayLog(params)
    }

    @Transactional
    def save(DayLog dayLog) {
        if (dayLog == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (dayLog.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond dayLog.errors, view:'create'
            return
        }

        dayLog.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'dayLog.label', default: 'DayLog'), dayLog.id])
                redirect dayLog
            }
            '*' { respond dayLog, [status: CREATED] }
        }
    }

    def edit(DayLog dayLog) {
        respond dayLog
    }

    @Transactional
    def update(DayLog dayLog) {
        if (dayLog == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (dayLog.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond dayLog.errors, view:'edit'
            return
        }

        dayLog.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'dayLog.label', default: 'DayLog'), dayLog.id])
                redirect dayLog
            }
            '*'{ respond dayLog, [status: OK] }
        }
    }

    @Transactional
    def delete(DayLog dayLog) {

        if (dayLog == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        dayLog.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'dayLog.label', default: 'DayLog'), dayLog.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'dayLog.label', default: 'DayLog'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
