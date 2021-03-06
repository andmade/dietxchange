package cscie56.dietxchange

import grails.test.mixin.*
import spock.lang.*

@TestFor(DayLogController)
@Mock([DayLog, Dieter])
class DayLogControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null

        params["starchCount"] = 1
        params["fruitCount"] = 1
        params["veggieCount"] = 1
        params["milkCount"] = 1
        params["proteinCount"] = 1
        params["fatCount"] = 1
        params["date"] = new Date()
        params["dieter"] = new Dieter()
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.dayLogList
            model.dayLogCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.dayLog!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def dayLog = new DayLog()
            dayLog.validate()
            controller.save(dayLog)

        then:"The create view is rendered again with the correct model"
            model.dayLog!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            dayLog = new DayLog(params)

            controller.save(dayLog)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/dayLog/show/1'
            controller.flash.message != null
            DayLog.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def dayLog = new DayLog(params)
            controller.show(dayLog)

        then:"A model is populated containing the domain instance"
            model.dayLog == dayLog
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def dayLog = new DayLog(params)
            controller.edit(dayLog)

        then:"A model is populated containing the domain instance"
            model.dayLog == dayLog
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/dayLog/index'
            flash.message != null

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def dayLog = new DayLog()
            dayLog.validate()
            controller.update(dayLog)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.dayLog == dayLog

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            dayLog = new DayLog(params).save(flush: true)
            controller.update(dayLog)

        then:"A redirect is issued to the show action"
            dayLog != null
            response.redirectedUrl == "/dayLog/show/$dayLog.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/dayLog/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def dayLog = new DayLog(params).save(flush: true)

        then:"It exists"
            DayLog.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(dayLog)

        then:"The instance is deleted"
            DayLog.count() == 0
            response.redirectedUrl == '/dayLog/index'
            flash.message != null
    }
}
