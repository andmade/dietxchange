package dietxchange

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "/diary"(controller: "dayLog", action: "diary")
        "/grails"(view:"/grails")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
