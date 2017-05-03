package dietxchange

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "/grails"(view:"/grails")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
