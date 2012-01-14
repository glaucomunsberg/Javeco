/** ColetorDeLixo
 * 		para testar como funciona a coleta de lixo.
 * @author glaucoroberto
 *
 */
public class ColetorDeLixo
{
	public static void main( String args[])
	{
		System.out.printf("Criando seres humanos...\n");
		//Criando objetos para serem coletados depois
		
		Lixo maria = new Lixo("Maria","dos Santos");
		maria.descricao();
		Lixo bruno = new Lixo("Bruna","da Silva");
		bruno.descricao();
		Lixo marta = new Lixo("Marta", "silveira");
		marta.descricao();
		Lixo tiago = new Lixo("Tiago", "molina");
		tiago.descricao();
		
		//Objetos estão são anulados para que hava a coleta
		// posteriormente
		System.out.printf("Matando as pessoas....\n");
		maria = null;
		bruno = null;
		marta = null;
		tiago = null;
		
		//Agora é chamdo System.gc que em teoria deveria deletar
		//	da memória os resíduos da memória. Porém isso não é
		//	garantido e pode ser que o coletor "passe" apenas depois
		//	de um tempo.
		//Ao executar várias vezes é fácil ver que o resultado depois
		//	da corrocinha passar varia. Isso pq não tem como obrigar
		//	o coletar a pegar naquele exato momento.
		System.out.printf("Chamando a Srª morte...\n");
		System.gc(); 
		
		System.out.printf("Depois da carrochinha ficou %d almas perdidas ainda!", Lixo.getCont());
		
	}
	
}
