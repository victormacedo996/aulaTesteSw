package sistemabancario;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GerenciadoraClienteTeste {
	@Test
	public void testePesquisaCliente() {
		/*criando clientes para instaciar no caso de Teste*/

		int idCliente01 = 1;
		int idCliente02 = 2;
		
		Cliente cliente01 = new Cliente(idCliente01, "Clayton", 47, "clayton@gmail.com", 1 ,true);
		Cliente cliente02 = new Cliente(idCliente02, "Maria", 10, "maria@gmail.com", 1 ,true);
		
		List <Cliente> clientes = new ArrayList();
		clientes.add(cliente01);
		clientes.add(cliente02);
		
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);
	
		Cliente cliente = gerClientes.pesquisaCliente(idCliente01);
		
		assertThat(cliente.getId(), is(idCliente01));
		assertThat(cliente.getEmail(), is("clayton@gmail.com"));
		
		Cliente cliente2 = gerClientes.pesquisaCliente(idCliente02);
		assertThat(cliente2.getId(), is(idCliente02));
		assertThat(cliente2.getEmail(), is("maria@gmail.com"));
		
				
		
	}
	
	@Test
	public void testeAdicionarCliente() {
		Cliente cliente01 = new Cliente(1, "Clayton", 47, "clayton@gmail.com", 1 ,true);
		List <Cliente> clientes = new ArrayList();
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);
		gerClientes.adicionaCliente(cliente01);
		boolean clienteAtivo = gerClientes.clienteAtivo(cliente01.getId());
		assertThat(clienteAtivo, is(true));
		
	}

	@Test
	public void testeRemoveCliente(){
		Cliente cliente01 = new Cliente(1, "Clayton", 47, "clayton@gmail.com", 1 ,true);
		List <Cliente> clientes = new ArrayList();
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);
		gerClientes.adicionaCliente(cliente01);
		assertThat(gerClientes.removeCliente(cliente01.getId()), is(true));
		assertThat(gerClientes.getClientesDoBanco(), is(java.util.Collections.emptyList()));
	}

	@Test
	public void testeClienteAtivo(){
		Cliente cliente01 = new Cliente(1, "Clayton", 47, "clayton@gmail.com", 1 ,true);
		List <Cliente> clientes = new ArrayList();
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);
		gerClientes.adicionaCliente(cliente01);
		int cliente01Id = cliente01.getId();
		assertThat(gerClientes.clienteAtivo(cliente01Id), is(true));
	}

	@Test
	public void testeLimpaBanco(){
		Cliente cliente01 = new Cliente(1, "Clayton", 47, "clayton@gmail.com", 1 ,true);
		List <Cliente> clientes = new ArrayList();
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);
		gerClientes.adicionaCliente(cliente01);
		gerClientes.limpa();
		assertThat(gerClientes.getClientesDoBanco(), is(java.util.Collections.emptyList()));
	}
}