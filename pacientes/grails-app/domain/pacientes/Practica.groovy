package pacientes

class Practica {

    Date fechaPrescripcion
    Date fechaRealizacion
    String resultado

    TipoPractica tipopractica
    static belongsTo = [paciente: Paciente, consulta: Consulta]

    static constraints = {

        fechaPrescripcion(blank: false)
        fechaRealizacion(blank: false,
          validator: { val, obj ->
          if(val<obj.fechaPrescripcion) return ["fechaIncorrecta"]
          })

        resultado(maxSize: 500)


    }
}
