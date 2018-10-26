package pacientes

class BootStrap {

    def init = { servletContext ->

      // Punto 1.4.1

      def paciente1 = new Paciente(fechaNacimiento:Date.parse('yyyy-MM-dd','1992-08-25'), nombre: 'Federico',
      nroDocumento: '37089452', apellido: 'Martinez', sexo: 'M', telefono: '383-427638', email: 'federico.martinez_@hotmail.com')

      if(!paciente1.save(flush:true)){
          paciente1.errors.allErrors.each{
              println it
          }

      }


      // def paciente2 = new Paciente(fechaNacimiento:Date.parse('yyyy-MM-dd','1995-08-22'), nombre: 'Facundo',
      // nroDocumento: '37089452', apellido: 'Martinelli', sexo: 'M', telefono: '383-489755', email: 'facundo.martinelli@hotmail.com')
      //
      // if(!paciente2.save(flush:true)){
      //
      //     paciente2.errors.allErrors.each{
      //         println it
      //     }
      //
      // }

      // CORREGIR, NO LISTA LOS PACIENTES

      def fecha1 = Date.parse('yyyy-MM-dd','1991-01-01')
      def fecha2 = Date.parse('yyyy-MM-dd','1993-01-01')

      def listaPacientes = Paciente.findAll("from Paciente as p where p.fechaNacimiento>=? and p.fechaNacimiento<=?",
                                            [fecha1,fecha2])
      println listaPacientes

      // Punto 1.4.2

      def consulta1 = new Consulta(paciente: paciente1, fecha: Date.parse('yyyy-MM-dd','2018-08-22'), hora:'15:00',
                                     motivo:'Dolor en la espalda', diagnostico:'Espalda chueca', tratamiento: 'Tome actron y no moleste').save()
      paciente1.save()


      def consulta2 = new Consulta(paciente: paciente1, fecha: Date.parse('yyyy-MM-dd','2018-08-05'), hora:'19:00',
                                     motivo:'Dolor en la nuca', diagnostico:'Nuca doblada', tratamiento: 'Cese el nuqueo y no moleste').save()
      paciente1.save()

      // Punto 1.4.3

      def tipo1 = new TipoPractica(codigo: '231265', nombre: 'Analisis Sangre').save()
      def tipo2 = new TipoPractica(codigo: '231266', nombre: 'Analisis Orina').save()

      // Punto 1.4.4

      def practica1 = new Practica(paciente: paciente1, tipopractica: tipo1, consulta: consulta1,
                                   fechaPrescripcion: Date.parse('yyyy-MM-dd','2018-08-05'),
                                   fechaRealizacion: Date.parse('yyyy-MM-dd','2018-09-05'),
                                   resultado: 'Positivo')
                                   if(!practica1.save(flush:true)){
                                       practica1.errors.allErrors.each{
                                           println it
                                       }
                                   }

      def practica2 = new Practica(paciente: paciente1, tipopractica: tipo1, consulta: consulta1,
                                   fechaPrescripcion: Date.parse('yyyy-MM-dd','2018-09-05'),
                                   fechaRealizacion: Date.parse('yyyy-MM-dd','2018-10-05'),
                                   resultado: 'Negativo')
                                   if(!practica2.save(flush:true)){
                                       practica2.errors.allErrors.each{
                                           println it
                                       }
                                   }

      def practica3 = new Practica(paciente: paciente1, tipopractica: tipo2, consulta: consulta2,
                                   fechaPrescripcion: Date.parse('yyyy-MM-dd','2018-10-05'),
                                   fechaRealizacion: Date.parse('yyyy-MM-dd','2018-11-05'),
                                   resultado: 'Positivo')
                                   if(!practica3.save(flush:true)){
                                       practica3.errors.allErrors.each{
                                           println it
                                       }
                                   }

      // Punto 1.4.5

      def fecha3 = Date.parse('yyyy-MM-dd','2018-05-01')
      def fecha4 = Date.parse('yyyy-MM-dd','2018-12-31')

      def listaConsultas = Consulta.findAll("from Consulta as c where c.fecha>=? and c.fecha<=?",
                                            [fecha3,fecha4])
      println listaConsultas

      // Punto 1.4.6

      // NO FUNCIONA. HAY QUE REVEERLO

      // def codPractica = 231265
      // def idPaciente = 1
      // def listaPracticas = Practica.findAll("from Practica where tipo_practica_id=? and paciente_id=?",
      //                                       [idPractica, idPaciente])

      /////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    }
    def destroy = {
    }
}
