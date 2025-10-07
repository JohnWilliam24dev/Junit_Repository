import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

import com.example.teste1.Calculadora;

public class CalculadoraTest {
private Calculadora calculadora;
    @BeforeEach
    public void setup(){
        calculadora=new Calculadora();
    }
    @Test
    public void deveSomarDoisValores(){
        double ValorA=2;
        double ValorB=2;
        assertEquals(4, calculadora.soma(ValorA,ValorB));
    }
    @Test
    public void deveSubtrairDoisValores(){
        double ValorA=2;
        double ValorB=2;
        assertEquals(0, calculadora.subtracao(ValorA,ValorB));
    }
    @Test
    public void deveMultiplicarDoisValores(){
        double ValorA=2;
        double ValorB=2;
        assertEquals(4, calculadora.multiplicacao(ValorA, ValorB));
    }
    @Test
    public void deveDividirDoisValores(){
        double ValorA=2;
        double ValorB=2;
        assertEquals(4, calculadora.divisao(ValorA,ValorB));
    }


}
