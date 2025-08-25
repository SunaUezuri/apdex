# 📊 Projeto Apdex - Application Performance Index

## 🎯 Visão Geral

Este projeto implementa e testa o cálculo do **APDEX (Application Performance Index)**, uma métrica fundamental para medir a satisfação do usuário com base no tempo de resposta de aplicações.

## 📚 O que é APDEX?

**APDEX** é um padrão da indústria que converte múltiplas medidas de performance em uma única pontuação de 0 a 1, representando a satisfação do usuário.

### 🏷️ Categorias de Usuários

| Categoria | Descrição | Impacto no Score |
|-----------|-----------|------------------|
| **Satisfeitos** | Resposta rápida (dentro do tempo esperado) | Conta como 1.0 |
| **Tolerados** | Resposta lenta (acima do esperado, mas aceitável) | Conta como 0.5 |
| **Frustrados** | Resposta muito lenta (inaceitável) | Conta como 0.0 |

### 🧮 Fórmula do APDEX

```
APDEX = (Satisfeitos + Tolerados/2) / Total
```

**Exemplo:**
- Total de usuários: 100
- Satisfeitos: 80
- Tolerados: 15
- Frustrados: 5

```
APDEX = (80 + 15/2) / 100 = (80 + 7.5) / 100 = 87.5 / 100 = 0.875
```

## 🏗️ Estrutura do Projeto

```
apdex/
├── pom.xml                          # Configuração Maven
├── src/
│   ├── main/java/org/example/
│   │   ├── Apdex.java              # Classe principal com lógica de cálculo
│   │   └── Main.java               # Classe principal da aplicação
│   └── test/java/org/example/
│       └── ApdexTest.java          # Testes unitários completos
└── README.md                        # Este arquivo
```

## 🔧 Tecnologias Utilizadas

- **Java 8+** - Linguagem de programação
- **JUnit 5 (Jupiter)** - Framework de testes
- **Maven** - Gerenciamento de dependências
- **JUnit Jupiter API** - Anotações e asserts

## 📋 Pré-requisitos

- Java 8 ou superior
- Maven 3.6+
- IDE com suporte a Java (IntelliJ IDEA, Eclipse, VS Code)

## 🚀 Como Executar

### 1. Clone o Repositório
```bash
git clone <url-do-repositorio>
cd apdex
```

### 2. Compile o Projeto
```bash
mvn clean compile
```

### 3. Execute os Testes
```bash
mvn test
```

## 🧪 Testes Unitários

### 📖 Conceitos de JUnit 5

#### **Anotações Principais:**

| Anotação | Descrição | Uso |
|----------|-----------|-----|
| `@Test` | Marca um método como teste unitário | Em cada método de teste |
| `@BeforeAll` | Executa UMA VEZ antes de todos os testes | Para configurações globais |
| `@BeforeEach` | Executa ANTES de CADA teste individual | Para setup repetitivo |

#### **Diferenças Importantes:**

- **`@BeforeAll`**: 
  - Executa apenas uma vez
  - Deve ser `static`
  - Ideal para configurações caras/reutilizáveis
  
- **`@BeforeEach`**:
  - Executa antes de cada teste
  - Pode ser não-estático
  - Ideal para setup que precisa ser repetido

### 🏗️ Estrutura dos Testes (Padrão AAA)

Cada teste segue o padrão **AAA (Arrange-Act-Assert)**:

1. **Arrange**: Preparação dos dados de entrada
2. **Act**: Execução do método sendo testado
3. **Assert**: Verificação do resultado esperado

### 📊 Testes Implementados

#### **1. Teste Básico - Apdex 90%**
```java
@Test
public void calcularApdex() {
    // ARRANGE
    int satisfeitos = 502239; // 90% de 558043
    int tolerados = 0;
    
    // ACT
    double apdexBom = apdex.calcularApdex(satisfeitos, tolerados, TOTAL_AMOSTRAS);
    
    // ASSERT
    assertEquals(0.9, apdexBom, 0.01);
}
```

**Cálculo:** `502239 / 558043 = 0.90`

#### **2. Teste Excelente - Apdex 96%**
```java
@Test
public void validarApdexExcelente() {
    // ARRANGE
    int satisfeitos = 530000;
    int tolerados = 16741;
    
    // ACT
    double valor = apdex.calcularApdex(satisfeitos, tolerados, TOTAL_AMOSTRAS);
    
    // ASSERT
    assertEquals(0.96, valor, 0.01);
}
```

**Cálculo:** `(530000 + 16741/2) / 558043 = 538370.5 / 558043 = 0.96`

#### **3. Teste Bom - Apdex 85%**
```java
@Test
public void validarApdexBom() {
    // ARRANGE
    int satisfeitos = 474339; // 85% de 558043
    int tolerados = 0;
    
    // ACT
    double valor = apdex.calcularApdex(satisfeitos, tolerados, TOTAL_AMOSTRAS);
    
    // ASSERT
    assertEquals(0.85, valor, 0.01);
}
```

**Cálculo:** `474339 / 558043 = 0.85`

#### **4. Teste Regular - Apdex 70%**
```java
@Test
public void validarApdexRegular() {
    // ARRANGE
    int satisfeitos = 390630; // 70% de 558043
    int tolerados = 0;
    
    // ACT
    double valor = apdex.calcularApdex(satisfeitos, tolerados, TOTAL_AMOSTRAS);
    
    // ASSERT
    assertEquals(0.70, valor, 0.01);
}
```

**Cálculo:** `390630 / 558043 = 0.70`

#### **5. Teste Ruim - Apdex 60%**
```java
@Test
public void validarApdexRuim() {
    // ARRANGE
    int satisfeitos = 334826; // 60% de 558043
    int tolerados = 0;
    
    // ACT
    double valor = apdex.calcularApdex(satisfeitos, tolerados, TOTAL_AMOSTRAS);
    
    // ASSERT
    assertEquals(0.60, valor, 0.01);
}
```

**Cálculo:** `334826 / 558043 = 0.60`

#### **6. Teste Inaceitável - Apdex 23%**
```java
@Test
public void validarApdexInaceitavel() {
    // ARRANGE
    int satisfeitos = 128350; // 23% de 558043
    int tolerados = 0;
    
    // ACT
    double valor = apdex.calcularApdex(satisfeitos, tolerados, TOTAL_AMOSTRAS);
    
    // ASSERT
    assertEquals(0.23, valor, 0.01);
}
```

**Cálculo:** `128350 / 558043 = 0.23`

## 📈 Saídas Esperadas dos Testes

### **Execução Completa:**
```bash
[INFO] Running org.example.ApdexTest
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0
[INFO] Results:
[INFO] 
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] BUILD SUCCESS
```

### **Detalhamento de Cada Teste:**

| Teste | Status | Tempo | Score Apdex | Usuários Satisfeitos | Usuários Tolerados |
|-------|--------|-------|-------------|---------------------|-------------------|
| `calcularApdex` | ✅ PASS | ~5ms | 0.90 | 502,239 | 0 |
| `validarApdexExcelente` | ✅ PASS | ~3ms | 0.96 | 530,000 | 16,741 |
| `validarApdexBom` | ✅ PASS | ~2ms | 0.85 | 474,339 | 0 |
| `validarApdexRegular` | ✅ PASS | ~2ms | 0.70 | 390,630 | 0 |
| `validarApdexRuim` | ✅ PASS | ~2ms | 0.60 | 334,826 | 0 |
| `validarApdexInaceitavel` | ✅ PASS | ~2ms | 0.23 | 128,350 | 0 |

## 🎓 Material de Estudo

### **Conceitos Fundamentais:**

1. **Testes Unitários**: Testam uma unidade específica de código de forma isolada
2. **JUnit 5**: Framework moderno para testes em Java
3. **Anotações**: Marcam métodos com comportamentos específicos
4. **Asserts**: Verificam se os resultados são os esperados
5. **Setup/Teardown**: Preparação e limpeza antes/depois dos testes

### **Boas Práticas Aplicadas:**

✅ **Isolamento**: Cada teste tem sua própria instância  
✅ **Independência**: Testes não interferem entre si  
✅ **Legibilidade**: Estrutura clara com comentários explicativos  
✅ **Manutenibilidade**: Constantes compartilhadas para valores comuns  
✅ **Padrão AAA**: Organização clara dos testes  

### **Padrões de Nomenclatura:**

- **Classes de teste**: `NomeDaClasseTest`
- **Métodos de teste**: `testarFuncionalidadeEspecifica`
- **Variáveis**: Nomes descritivos e em português
- **Comentários**: Explicações detalhadas para estudo

## 🔍 Análise do Código

### **Classe Apdex.java:**
```java
public class Apdex {
    public double calcularApdex(int s, int to, int ta) {
        if (ta == 0) return 0;
        return (s + (to / 2.0)) / ta;
    }
}
```

**Características:**
- Método simples e direto
- Validação de divisão por zero
- Cálculo preciso da fórmula APDEX

### **Classe ApdexTest.java:**
- **6 testes** cobrindo diferentes cenários
- **Configuração global** com `@BeforeAll`
- **Setup individual** com `@BeforeEach`
- **Documentação completa** para estudo

### **Tolerância nos Asserts:**
```java
assertEquals(0.9, apdexBom, 0.01);
```
- **Delta 0.01**: Permite pequenas variações de ponto flutuante
- **Precisão**: Garante que testes passem com valores calculados

## 📊 Métricas de Performance

### **Tempo de Execução:**
- **Setup**: ~1ms (configuração global)
- **Testes individuais**: ~2-5ms cada
- **Total**: ~20-30ms para todos os testes

### **Cobertura de Testes:**
- **Métodos testados**: 100%
- **Linhas de código**: 100%
- **Cenários cobertos**: 6 diferentes scores de APDEX

## 🔧 Configuração Maven

### **pom.xml:**
```xml
<dependencies>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.9.2</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## 🌟 Casos de Uso Reais

### **Monitoramento de Aplicações Web:**
- **E-commerce**: Tempo de carregamento de páginas
- **API REST**: Latência de endpoints
- **Mobile Apps**: Performance de funcionalidades

### **SLA (Service Level Agreement):**
- **99.9% uptime**: APDEX > 0.95
- **Performance aceitável**: APDEX > 0.80
- **Crítico**: APDEX < 0.50

## 📚 Recursos Adicionais

### **Documentação Oficial:**
- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
- [APDEX Alliance](https://apdex.org/)
- [Maven Documentation](https://maven.apache.org/guides/)

### **Conceitos Relacionados:**
- **TDD (Test-Driven Development)**
- **BDD (Behavior-Driven Development)**
- **Continuous Integration/Deployment**
- **Performance Testing**

## 🤝 Contribuição

Para contribuir com o projeto:

1. Fork o repositório
2. Crie uma branch para sua feature
3. Implemente as mudanças
4. Adicione testes
5. Execute `mvn test` para verificar
6. Faça commit e push
7. Abra um Pull Request

## 👨‍💻 Autor

- **Wesley Sena** | RM: 558043

Desenvolvido como material de estudo para conceitos de:
- Testes unitários em Java
- Framework JUnit 5
- Métricas de performance (APDEX)
- Boas práticas de desenvolvimento

---

## 🎯 Resumo Executivo

Este projeto demonstra a implementação completa de:
- ✅ **Cálculo de APDEX** com validação matemática
- ✅ **Testes unitários** seguindo padrões JUnit 5
- ✅ **Boas práticas** de desenvolvimento e testes
- ✅ **Documentação completa** para fins educacionais
- ✅ **Cobertura total** de cenários de teste
