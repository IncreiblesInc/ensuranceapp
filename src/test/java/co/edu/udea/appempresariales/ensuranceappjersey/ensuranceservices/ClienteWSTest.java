package co.edu.udea.appempresariales.ensuranceappjersey.ensuranceservices;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;

import co.edu.udea.appempresariales.ensuranceappjersey.entities.Cliente;

public class ClienteWSTest {

	private Client client;
	private WebTarget target;
	
	@Before
	public void setUp() {
		client = ClientBuilder.newClient();
		target = client.target("http://localhost:8080/EnsuranceApp/ensuranceservices");
	}

	@Test
	public void testGetCliente() {
		
		target=target.path("clientes/123");
		Invocation invocation = target.request(MediaType.APPLICATION_JSON)
				.buildGet();
		Response respuesta = invocation.invoke();
		Cliente cliente = respuesta.readEntity(Cliente.class);
		assertEquals(respuesta.getStatus(), 200);
		assertEquals("Paso", cliente.getCedula(), "123");
	}

	@Test
	public void testGetClienteNoEncontrado() {
		target= target.path("clientes/12345");
		Invocation invocation= target.request(MediaType.APPLICATION_JSON)
				.buildGet();
		Response respuesta= invocation.invoke();
		assertEquals(respuesta.getStatus(),404);
	}
	
	@Test
	public void testGetClienteMalaPeticion() {
		target= target.path("clientes/ ");
		Invocation invocation= target.request(MediaType.APPLICATION_JSON)
				.buildGet();
		Response respuesta= invocation.invoke();
		assertEquals(respuesta.getStatus(),404);
	}

}
