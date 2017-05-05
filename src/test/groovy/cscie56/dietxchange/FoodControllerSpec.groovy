package cscie56.dietxchange

import grails.test.mixin.*
import spock.lang.*

@TestFor(FoodController)
@Mock(Food)
class FoodControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null

        params['category'] = 'starch'
        params['subcategory'] = 'cereals_grains'
        params['name'] = "Barley, couscous, millet, pasta, polenta, quinoa, rice (cooked)"
        params['portionSize'] = '1/3'
        params['portionUnit'] = 'cup'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.foodList
            model.foodCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.food!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def food = new Food()
            food.validate()
            controller.save(food)

        then:"The create view is rendered again with the correct model"
            model.food!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            food = new Food(params)

            controller.save(food)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/food/show/1'
            controller.flash.message != null
            Food.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def food = new Food(params)
            controller.show(food)

        then:"A model is populated containing the domain instance"
            model.food == food
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def food = new Food(params)
            controller.edit(food)

        then:"A model is populated containing the domain instance"
            model.food == food
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/food/index'
            flash.message != null

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def food = new Food()
            food.validate()
            controller.update(food)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.food == food

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            food = new Food(params).save(flush: true)
            controller.update(food)

        then:"A redirect is issued to the show action"
            food != null
            response.redirectedUrl == "/food/show/$food.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/food/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def food = new Food(params).save(flush: true)

        then:"It exists"
            Food.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(food)

        then:"The instance is deleted"
            Food.count() == 0
            response.redirectedUrl == '/food/index'
            flash.message != null
    }
}
