package br.trabalho1.backend;

/**
 * Possíveis tipos de palavras a serem encontradas no programa.
 */
public enum WordType {

    /**
     * É qualquer palavra composta por um dígito (entre 1 e 9), seguido de um
     * ponto, seguido de um dígito (entre 0 e 9).
     */
    MOTOR,
    
    /**
     * É qualquer palavra composta por quatro dígitos.
     */
    ANO,
    
    /**
     * É qualquer palavra composta por um valor v, tal que v ≥ 0 e v ≤ 200.000,
     * sendo que para agrupamento de dígitos deve ser usado o ponto, isto é,
     * para separar centenas e milhares deve ser usado o ponto. Além disso, não
     * podem existir 0S desnecessários à esquerda.
     */
    KM,
    
    /**
     * É qualquer palavra composta por R$, seguido por um valor v com duas casas
     * decimais após a vírgula, tal que v ≥ 0,00 e v ≤ 999.999,99, sendo que
     * para agrupamento de dígitos deve ser usado o ponto, isto é, para separar
     * centenas e milhares deve ser usado o ponto. Além disso, não podem existir
     * 0S desnecessários à esquerda.
     */
    VALOR,
    
    /**
     * Pode ser Álcool, Bicombustível, Diesel, Gasolina.
     */
    COMBUSTIVEL;
}
