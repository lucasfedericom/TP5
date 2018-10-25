package pacientes

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PracticaController {

    PracticaService practicaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond practicaService.list(params), model:[practicaCount: practicaService.count()]
    }

    def show(Long id) {
        respond practicaService.get(id)
    }

    def create() {
        respond new Practica(params)
    }

    def save(Practica practica) {
        if (practica == null) {
            notFound()
            return
        }

        try {
            practicaService.save(practica)
        } catch (ValidationException e) {
            respond practica.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'practica.label', default: 'Practica'), practica.id])
                redirect practica
            }
            '*' { respond practica, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond practicaService.get(id)
    }

    def update(Practica practica) {
        if (practica == null) {
            notFound()
            return
        }

        try {
            practicaService.save(practica)
        } catch (ValidationException e) {
            respond practica.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'practica.label', default: 'Practica'), practica.id])
                redirect practica
            }
            '*'{ respond practica, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        practicaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'practica.label', default: 'Practica'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'practica.label', default: 'Practica'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
