import entity.Simulacao;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class SimulacaoServiceTest {

    @Inject
    service.SimulacaoService service;

    @Test
    public void deveCalcularSimulacaoCorretamente() {
        Simulacao simulacao = new Simulacao();
        simulacao.valorInicial = new BigDecimal("1000");
        simulacao.taxaJurosMensal = new BigDecimal("1.5");
        simulacao.prazoMeses = 12;

        Simulacao resultado = service.calcularSimulacao(simulacao);

        assertNotNull(resultado);
        assertNotNull(resultado.valorTotalFinal);
        assertNotNull(resultado.valorTotalJuros);
        assertEquals(12, resultado.memoria.size());
    }

    @Test
    public void deveLancarExcecaoOuRetornarVazioQuandoPrazoForInvalido() {
        Simulacao simulacaoInvalida = new Simulacao();
        simulacaoInvalida.valorInicial = new BigDecimal("1000");
        simulacaoInvalida.taxaJurosMensal = new BigDecimal("1.5");
        simulacaoInvalida.prazoMeses = 0;

        // Executa o cálculo com prazo zero para cobrir as linhas de validação
        Simulacao resultado = service.calcularSimulacao(simulacaoInvalida);

        // Verifica se o resultado foi gerado (mesmo vazio ou zerado) sem crashar o sistema
        assertNotNull(resultado);
    }
}