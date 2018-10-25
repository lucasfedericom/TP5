package pacientes

class TipoPractica {

    BigInteger codigo
    String nombre

    static constraints = {

        codigo(blank: false, unique: true, matches: "[0-9]{6}")
        nombre(blank: false, maxSize: 100 )

    }
}
