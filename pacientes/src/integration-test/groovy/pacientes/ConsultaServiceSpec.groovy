package pacientes

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ConsultaServiceSpec extends Specification {

    ConsultaService consultaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Consulta(...).save(flush: true, failOnError: true)
        //new Consulta(...).save(flush: true, failOnError: true)
        //Consulta consulta = new Consulta(...).save(flush: true, failOnError: true)
        //new Consulta(...).save(flush: true, failOnError: true)
        //new Consulta(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //consulta.id
    }

    void "test get"() {
        setupData()

        expect:
        consultaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Consulta> consultaList = consultaService.list(max: 2, offset: 2)

        then:
        consultaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        consultaService.count() == 5
    }

    void "test delete"() {
        Long consultaId = setupData()

        expect:
        consultaService.count() == 5

        when:
        consultaService.delete(consultaId)
        sessionFactory.currentSession.flush()

        then:
        consultaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Consulta consulta = new Consulta()
        consultaService.save(consulta)

        then:
        consulta.id != null
    }
}
