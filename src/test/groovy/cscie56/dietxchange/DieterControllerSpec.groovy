package cscie56.dietxchange

import grails.test.mixin.*
import spock.lang.*
import springsecurity.dietxchange.User

@TestFor(DieterController)
@Mock([Dieter,User])
class DieterControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null

        params["starchCount"] = 1
        params["fruitCount"] = 1
        params["milkCount"] = 1
        params["veggieCount"] = 1
        params["proteinCount"] = 1
        params["fatCount"] = 1
        params["targetCalories"] = 1200
        params["user"] = new User()

    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.dieterList
            model.dieterCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.dieter!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def dieter = new Dieter()
            dieter.validate()
            controller.save(dieter)

        then:"The create view is rendered again with the correct model"
            model.dieter!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            dieter = new Dieter(params)

            controller.save(dieter)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/dieter/show/1'
            controller.flash.message != null
            Dieter.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def dieter = new Dieter(params)
            controller.show(dieter)

        then:"A model is populated containing the domain instance"
            model.dieter == dieter
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def dieter = new Dieter(params)
            controller.edit(dieter)

        then:"A model is populated containing the domain instance"
            model.dieter == dieter
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/dieter/index'
            flash.message != null

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def dieter = new Dieter()
            dieter.validate()
            controller.update(dieter)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.dieter == dieter

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            dieter = new Dieter(params).save(flush: true)
            controller.update(dieter)

        then:"A redirect is issued to the show action"
            dieter != null
            response.redirectedUrl == "/dieter/show/$dieter.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/dieter/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def dieter = new Dieter(params).save(flush: true)

        then:"It exists"
            Dieter.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(dieter)

        then:"The instance is deleted"
            Dieter.count() == 0
            response.redirectedUrl == '/dieter/index'
            flash.message != null
    }
}
