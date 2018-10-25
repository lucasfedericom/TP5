package pacientes

import grails.gorm.services.Service

@Service(Practica)
interface PracticaService {

    Practica get(Serializable id)

    List<Practica> list(Map args)

    Long count()

    void delete(Serializable id)

    Practica save(Practica practica)

}