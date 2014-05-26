package br.unicesumar.escoladeti.controller;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import org.junit.Before;
import org.junit.Test;
import br.unicesumar.escoladeti.entity.Uf;
import br.unicesumar.escoladeti.service.UfService;

public class UfControllerTest {

	/*private UfService ufServiceServiceMock;
	private UfController ufControllerSpy;

	@Before
	public void setUp() {
		ufServiceServiceMock = mock(UfService.class);
		ufControllerSpy = spy(new UfController());
		
		doReturn(ufServiceServiceMock).when(ufControllerSpy).getService();
	}
	
	@Test
	public void testSalvar() {
                Uf uf =  mock(Uf.class);
                uf.setId(123L);
                uf.setNome("Rio Grande Do Sul");
                uf.setSigla("RS");
                uf.setCodigoIbge(43);                
		
		assertThat(ufControllerSpy.salvar(uf)).isEqualTo("OK");
		verify(ufServiceServiceMock).salvar(uf);
	}*/
	
}
