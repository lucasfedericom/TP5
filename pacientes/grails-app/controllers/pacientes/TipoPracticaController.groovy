package pacientes

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TipoPracticaController {

    TipoPracticaService tipoPracticaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond tipoPracticaService.list(params), model:[tipoPracticaCount: tipoPracticaService.count()]
    }

    def show(Long id) {
        respond tipoPracticaService.get(id)
    }

    def create() {
        respond new TipoPractica(params)
    }

    def save(TipoPractica tipoPractica) {
        if (tipoPractica == null) {
            notFound()
            return
        }

        try {
            tipoPracticaService.save(tipoPractica)
        } catch (ValidationException e) {
            respond tipoPractica.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tipoPractica.label', default: 'TipoPractica'), tipoPractica.id])
                redirect tipoPractica
            }
            '*' { respond tipoPractica, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond tipoPracticaService.get(id)
    }

    def update(TipoPractica tipoPractica) {
        if (tipoPractica == null) {
            notFound()
            return
        }

        try {
            tipoPracticaService.save(tipoPractica)
        } catch (ValidationException e) {
            respond tipoPractica.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'tipoPractica.label', default: 'TipoPractica'), tipoPractica.id])
                redirect tipoPractica
            }
            '*'{ respond tipoPractica, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        tipoPracticaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'tipoPractica.label', default: 'TipoPractica'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoPractica.label', default: 'TipoPractica'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
