package pacientes

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TipoPracticaServiceSpec extends Specification {

    TipoPracticaService tipoPracticaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new TipoPractica(...).save(flush: true, failOnError: true)
        //new TipoPractica(...).save(flush: true, failOnError: true)
        //TipoPractica tipoPractica = new TipoPractica(...).save(flush: true, failOnError: true)
        //new TipoPractica(...).save(flush: true, failOnError: true)
        //new TipoPractica(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //tipoPractica.id
    }

    void "test get"() {
        setupData()

        expect:
        tipoPracticaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<TipoPractica> tipoPracticaList = tipoPracticaService.list(max: 2, offset: 2)

        then:
        tipoPracticaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        tipoPracticaService.count() == 5
    }

    void "test delete"() {
        Long tipoPracticaId = setupData()

        expect:
        tipoPracticaService.count() == 5

        when:
        tipoPracticaService.delete(tipoPracticaId)
        sessionFactory.currentSession.flush()

        then:
        tipoPracticaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        TipoPractica tipoPractica = new TipoPractica()
        tipoPracticaService.save(tipoPractica)

        then:
        tipoPractica.id != null
    }
}
