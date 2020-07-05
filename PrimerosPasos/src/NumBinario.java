import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumBinario {
	
	private String convierteBinario(int num) {
		
		final byte dos = 2;
		int residuo = 0;
		int cociente = 0;
		List<Integer> lBin = new ArrayList<Integer>();
		String cadenaBin = "";
		
		do {
			residuo = num % 2;
			cociente = num / 2;
			lBin.add(residuo);
			num = cociente;
			
		} while (cociente >= dos);
		
		lBin.add(cociente);
		
		Collections.reverse(lBin);
		
		for (Integer element : lBin) {
			cadenaBin += String.valueOf(element)+" ";
		}
		
		return cadenaBin;
	}

	public static void main(String[] args) {

		System.out.println(new NumBinario().convierteBinario(28));
		
	}

}
