import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CuentasUsuarios {

	public static void main(String[] args) {

		Cliente cl1 = new Cliente("Antonio Banderas", "00001", 200000);
		Cliente cl2 = new Cliente("Rafael Nadal", "00002", 250000);
		Cliente cl3 = new Cliente("Penelope Cruz", "00003", 300000);
		Cliente cl4 = new Cliente("Julio Iglesias", "00004", 500000);
		Cliente cl5 = new Cliente("Antonio Banderas", "00001", 200000);

		Set<Cliente> clientesBanco = new HashSet<Cliente>();
		
		clientesBanco.add(cl1);
		clientesBanco.add(cl2);
		clientesBanco.add(cl3);
		clientesBanco.add(cl4);
		clientesBanco.add(cl5);

//		for (Cliente cliente : clientesBanco) {
//			
//			if (cliente.getNombre().equals("Julio Iglesias")) {
//				
//				if (clientesBanco.remove(cliente)) {
//					System.out.println("Eliminado.");
//				}
//			}
//		}
		
		Iterator<Cliente> it = clientesBanco.iterator();
		
		while (it.hasNext()) {
			
			Cliente client = it.next();
			
			if (client.getNombre().equals("Julio Iglesias")) {
				it.remove();
				continue;
			}
			
			System.out.println(client.getNombre()+" "+client.getN_cuenta()+" "+client.getSaldo());
		}
		
//		for (Cliente cliente : clientesBanco) {
//			
//			System.out.println(cliente.getNombre()+" "+cliente.getN_cuenta()+" "+cliente.getSaldo());
//			
//		}
		
//		Iterator<Cliente> it = clientesBanco.iterator(); //Devuelve un iterador para recorrer la colección clientesBanco
		
//		while (it.hasNext()) {
//			
//			Cliente client = it.next();
//			
//			String nombre_cliente = client.getNombre();
//			String n_cuenta = client.getN_cuenta();
//			
//			System.out.println(nombre_cliente+", "+n_cuenta);		
////			System.out.println(n_cuenta);
//			
//		}
		
		
	}

}
