package pacientes

class Paciente {

    BigInteger nroDocumento
    String apellido
    String sexo
    Date fechaNacimiento
    String telefono
    String email

    static hasMany = [consultas: Consulta,
                      practicas: Practica]

    static constraints = {
        nroDocumento (blank: false, unique: true)
        apellido (blank: false, maxSize: 100)
        sexo(blank: false, inList:['F','M'])
        fechaNacimiento(blank: false)
        telefono(blank: true, matches: "[0-9]{3}-[0-9]{6}")
        email(blank: true, email:true)
    }

}
