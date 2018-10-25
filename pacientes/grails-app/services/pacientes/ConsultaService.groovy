package pacientes

import grails.gorm.services.Service

@Service(Consulta)
interface ConsultaService {

    Consulta get(Serializable id)

    List<Consulta> list(Map args)

    Long count()

    void delete(Serializable id)

    Consulta save(Consulta consulta)

}