package org.example;

// Importações necessárias para JUnit 5 (Jupiter)
import org.junit.jupiter.api.BeforeAll;    // Executa ANTES de TODOS os testes (uma vez)
import org.junit.jupiter.api.BeforeEach;   // Executa ANTES de CADA teste individual
import org.junit.jupiter.api.Test;         // Marca um método como teste unitário
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Classe de testes para a funcionalidade de cálculo de Apdex
 * 
 * APDEX (Application Performance Index) é uma métrica que mede a satisfação
 * do usuário com base no tempo de resposta da aplicação:
 * - Satisfeitos: usuários que tiveram resposta rápida (dentro do tempo esperado)
 * - Tolerados: usuários que tiveram resposta lenta (acima do esperado, mas aceitável)
 * - Frustrados: usuários que tiveram resposta muito lenta (inaceitável)
 * 
 * Fórmula: (satisfeitos + tolerados/2) / total
 */
public class ApdexTest {

    private static int TOTAL_AMOSTRAS;

    private Apdex apdex;

    /**
     * MÉTODO ESTÁTICO executado UMA VEZ antes de todos os testes
     * 
     * @BeforeAll:
     * - Executa apenas uma vez quando a classe de teste é carregada
     * - Deve ser estático (static)
     * - Ideal para configurações caras que podem ser reutilizadas
     * - Neste caso: define o total de amostras que será usado em todos os testes
     */
    @BeforeAll
    public static void setUpClass() {
        TOTAL_AMOSTRAS = 558043; // Total de usuários/amostras para os testes
    }

    /**
     * MÉTODO executado ANTES de CADA teste individual
     * 
     * @BeforeEach:
     * - Executa antes de cada método @Test
     * - Pode ser não-estático
     * - Ideal para setup que precisa ser repetido a cada teste
     * - Neste caso: cria nova instância da classe Apdex para cada teste
     * 
     * Por que nova instância a cada teste?
     * - Garante que cada teste seja independente
     * - Evita interferência entre testes
     * - Boa prática para testes unitários
     */
    @BeforeEach
    public void setUp() {
       Apdex apdex = new Apdex(); // Nova instância limpa para cada teste
    }

    /**
     * TESTE 1: Validação do cálculo básico de Apdex
     * 
     * Estrutura AAA (Arrange-Act-Assert):
     * - Arrange: prepara os dados de entrada
     * - Act: executa a ação/método sendo testado
     * - Assert: verifica se o resultado é o esperado
     */
    @Test
    public void calcularApdex() {
        // ARRANGE: prepara os dados de entrada
        int satisfeitos = 502239; // 90% de 558043 usuários satisfeitos
        int tolerados = 0;         // Nenhum usuário tolerado neste cenário

        // ACT: executa o método sendo testado
        double apdexBom = apdex.calcularApdex(satisfeitos, tolerados, TOTAL_AMOSTRAS);

        // ASSERT: verifica se o resultado é o esperado
        // assertEquals(valorEsperado, valorReal, tolerancia)
        // Tolerância 0.01 para lidar com imprecisões de ponto flutuante
        assertEquals(0.9, apdexBom, 0.01);
    }

    /**
     * TESTE 2: Validação de Apdex Excelente (96%)
     * 
     * Este teste inclui usuários tolerados para simular cenário realista
     * Cálculo: (530000 + 16741/2) / 558043 = 0.96
     */
    @Test
    public void validarApdexExcelente() {
        // ARRANGE
        int satisfeitos = 530000;  // Usuários com resposta rápida
        int tolerados = 16741;     // Usuários com resposta lenta mas aceitável

        // ACT
        double valor = apdex.calcularApdex(satisfeitos, tolerados, TOTAL_AMOSTRAS);

        // ASSERT
        assertEquals(0.96, valor, 0.01);
    }

    /**
     * TESTE 3: Validação de Apdex Bom (85%)
     * 
     * Cálculo: 474339 / 558043 = 0.85
     * Representa 85% de usuários satisfeitos
     */
    @Test
    public void validarApdexBom() {
        // ARRANGE
        int satisfeitos = 474339; // 85% de 558043
        int tolerados = 0;        // Nenhum tolerado

        // ACT
        double valor = apdex.calcularApdex(satisfeitos, tolerados, TOTAL_AMOSTRAS);

        // ASSERT
        assertEquals(0.85, valor, 0.01);
    }

    /**
     * TESTE 4: Validação de Apdex Regular (70%)
     * 
     * Cálculo: 390630 / 558043 = 0.70
     * Representa 70% de usuários satisfeitos
     */
    @Test
    public void validarApdexRegular() {
        // ARRANGE
        int satisfeitos = 390630; // 70% de 558043
        int tolerados = 0;        // Nenhum tolerado

        // ACT
        double valor = apdex.calcularApdex(satisfeitos, tolerados, TOTAL_AMOSTRAS);

        // ASSERT
        assertEquals(0.70, valor, 0.01);
    }

    /**
     * TESTE 5: Validação de Apdex Ruim (60%)
     * 
     * Cálculo: 334826 / 558043 = 0.60
     * Representa 60% de usuários satisfeitos
     */
    @Test
    public void validarApdexRuim() {
        // ARRANGE
        int satisfeitos = 334826; // 60% de 558043
        int tolerados = 0;        // Nenhum tolerado

        // ACT
        double valor = apdex.calcularApdex(satisfeitos, tolerados, TOTAL_AMOSTRAS);

        // ASSERT
        assertEquals(0.60, valor, 0.01);
    }

    /**
     * TESTE 6: Validação de Apdex Inaceitável (23%)
     * 
     * Cálculo: 128350 / 558043 = 0.23
     * Representa apenas 23% de usuários satisfeitos
     * Este é um cenário crítico que indica problemas graves de performance
     */
    @Test
    public void validarApdexInaceitavel() {
        // ARRANGE
        int satisfeitos = 128350; // 23% de 558043
        int tolerados = 0;        // Nenhum tolerado

        // ACT
        double valor = apdex.calcularApdex(satisfeitos, tolerados, TOTAL_AMOSTRAS);

        // ASSERT
        assertEquals(0.23, valor, 0.01);
    }
}
