package br.trabalho1.backend;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Classe responsável por analisar o texto inserido pelo usuário e discernir
 * quais tipos de palavras estão contidos no mesmo.
 */
public class WordAnalyser {

    /**
     * Map responsável por armazenar a quantidade de ocorrências de cada tipo de
     * palavra no texto que está sendo analisado.
     */
    private static final Map<WordType, Integer> WORD_COUNT_MAP = new HashMap<>();

    /**
     * Analisa o texto informado, retornando em um <code>Map</code> a quantidade
     * de ocorrências dos respectivos tipos de palavras (@see TipoPalavra).
     *
     * @param text Texto a ser analisado.
     * @return Um Map contendo a quantidade de ocorrências dos respectivos tipos
     * de palavras no texto informado.
     */
    public static Map<WordType, Integer> analyseText(String text) {
        initializeWordCountMap();
        int numLine = 1;

        for (String line : text.split("\n|\n\r")) {
            for (String word : line.split("\\s")) {
                if (word == null || word.trim().isEmpty()) {
                    continue;
                }

                WordType wordType = getWordType(word);
                if (wordType == null) {
                    handleInvalidWord(word, numLine);
                } else {
                    populateMap(wordType);
                }
            }

            numLine++;
        }

        return WORD_COUNT_MAP;
    }

    private static WordType getWordType(String palavra) {
        // Motor
        Pattern p = Pattern.compile("^[1-9]{1}\\.[0-9]{1}$");
        if (p.matcher(palavra).matches()) {
            return WordType.MOTOR;
        }

        // Ano
        p = Pattern.compile("^[0-9]{4}$");
        if (p.matcher(palavra).matches()) {
            return WordType.ANO;
        }

        // KM
        p = Pattern.compile("^(0|[1-9]{1}[0-9]{0,2}\\.[0-9]{3}|[1-9]{1}[0-9]{0,2})$");
        if (p.matcher(palavra).matches() && Integer.parseInt(palavra.replace(".", "")) < 200000) {
            return WordType.KM;
        }

        // Valor
        p = Pattern.compile("^(^R\\$)(0\\,[0-9]{2}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{3}\\,[0-9]{2}|\\,[0-9]{2}))$");
        final String rawValue = palavra.replaceAll(",", ".").replaceFirst("\\.", "");
        if (p.matcher(palavra).matches() && Double.parseDouble(rawValue.substring(2, rawValue.length())) <= Double.parseDouble("999999.99")) {
            return WordType.VALOR;
        }

        // Combustível
        p = Pattern.compile("^(?:Álcool|Bicombustível|Diesel|Gasolina)$");
        if (p.matcher(palavra).matches()) {
            return WordType.COMBUSTIVEL;
        }

        return null;
    }

    private static void handleInvalidWord(String palavraInvalida, int line) {
        String palavrasPossiveis = "NULL";

        char primeiroDigito = palavraInvalida.charAt(0);
        if (Character.isDigit(primeiroDigito)) {
            palavrasPossiveis = "motor, ano ou KM";
        } else if (primeiroDigito == 'R') {
            palavrasPossiveis = "valor";
        } else if (primeiroDigito == 'Á' || primeiroDigito == 'B' || primeiroDigito == 'D' || primeiroDigito == 'G') {
            palavrasPossiveis = "combustível";
        } else if (primeiroDigito != 'R' || primeiroDigito != 'Á' || primeiroDigito != 'B' || primeiroDigito != 'D' || primeiroDigito != 'G') {
            palavrasPossiveis = "símbolo(s)";
        }

        throw new IllegalArgumentException("Erro na linha " + line + " - " + palavrasPossiveis + " inválido: " + palavraInvalida);
    }

    private static void initializeWordCountMap() {
        WORD_COUNT_MAP.put(WordType.ANO, 0);
        WORD_COUNT_MAP.put(WordType.COMBUSTIVEL, 0);
        WORD_COUNT_MAP.put(WordType.KM, 0);
        WORD_COUNT_MAP.put(WordType.MOTOR, 0);
        WORD_COUNT_MAP.put(WordType.VALOR, 0);
    }

    private static void populateMap(WordType tipoPalavra) {
        Integer count = WORD_COUNT_MAP.get(tipoPalavra);
        WORD_COUNT_MAP.put(tipoPalavra, count + 1);
    }
}
