package pacientes

import grails.gorm.services.Service

@Service(TipoPractica)
interface TipoPracticaService {

    TipoPractica get(Serializable id)

    List<TipoPractica> list(Map args)

    Long count()

    void delete(Serializable id)

    TipoPractica save(TipoPractica tipoPractica)

}