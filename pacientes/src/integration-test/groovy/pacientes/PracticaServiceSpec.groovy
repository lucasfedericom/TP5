package pacientes

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PracticaServiceSpec extends Specification {

    PracticaService practicaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Practica(...).save(flush: true, failOnError: true)
        //new Practica(...).save(flush: true, failOnError: true)
        //Practica practica = new Practica(...).save(flush: true, failOnError: true)
        //new Practica(...).save(flush: true, failOnError: true)
        //new Practica(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //practica.id
    }

    void "test get"() {
        setupData()

        expect:
        practicaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Practica> practicaList = practicaService.list(max: 2, offset: 2)

        then:
        practicaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        practicaService.count() == 5
    }

    void "test delete"() {
        Long practicaId = setupData()

        expect:
        practicaService.count() == 5

        when:
        practicaService.delete(practicaId)
        sessionFactory.currentSession.flush()

        then:
        practicaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Practica practica = new Practica()
        practicaService.save(practica)

        then:
        practica.id != null
    }
}
