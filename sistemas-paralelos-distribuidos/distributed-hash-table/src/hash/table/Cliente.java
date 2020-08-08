package hash.table;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class Cliente {

	private Comm comm;
	private ArrayList<Integer> servidores = new ArrayList<>();
	HashMap<Integer, GetReply> respostas;

	public Cliente(ArrayList<Integer> servidores, Comm comm) {
		this.comm = comm;
		this.servidores = servidores;
	}

	public void run() throws IOException {

		put("SC", new ValueHash("Floripa"));

		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>1" + get("SC").getVersao());

		put("SC", new ValueHash("Floripa2"));

		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>2" + get("SC").getVersao());

		
		put("PR", new ValueHash("Curitiba"));

		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>2" + get("PR").getVersao());
		quit();

	}

	public void put(String key, ValueHash item) throws IOException {
		Integer servidorescolhido;
		Random escolheservidor = new Random();
		GetReply greply;
		ValueHash valorNoServidor = null;
		ValueHash consulta;
		Integer idServidor;
		PutMsg put_msg = new PutMsg(key, item);

		consulta = get(key);

		int maiorVersao = -1;
		Iterator<?> it = respostas.entrySet().iterator();
		while (it.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry resposta = (Map.Entry) it.next();
			greply = (GetReply) resposta.getValue();
			valorNoServidor = greply.getItem();

			if (maiorVersao < valorNoServidor.getVersao())
				maiorVersao = valorNoServidor.getVersao();

		}

		put_msg.getItem().setVersao(maiorVersao + 1);

		servidorescolhido = servidores.get(escolheservidor.nextInt(servidores.size()));
		comm.sendTo(servidorescolhido, put_msg);
		System.out.println("Adicionado nova linha no HashMap do Servidor Escolhido");

		Iterator<?> it2 = respostas.entrySet().iterator();
		while (it2.hasNext()) {
			@SuppressWarnings("rawtypes")

			Map.Entry resposta = (Map.Entry) it2.next();
			idServidor = (Integer) resposta.getKey();

			comm.sendTo(idServidor, put_msg);
			System.out.println("Versão atualizada no servidor " + idServidor);
			it2.remove();
		}
	}

	public ValueHash get(String key) throws IOException {
		GetMsg get_msg = new GetMsg(key);
		Object msg = null;
		ValueHash item = null;
		GetReply getReply = null;
		respostas = new HashMap<>();
		int controle = 0;

		for (Integer servidor : servidores) {
			comm.sendTo(servidor, get_msg);

			msg = comm.recvFrom(servidor);

			getReply = (GetReply) msg;

			if (getReply.getItem() != null) {
				item = getReply.getItem();
				respostas.put(servidor, getReply);
			} else {
				controle++;
			}

			if (controle == 0)
				System.out.println("Valor não encontrado no HashMap");

		}
		return item;
	}

	private void quit() {
		QuitMsg quit_msg = new QuitMsg();
		for (Integer servidor : servidores) {

			try {
				comm.sendTo(servidor, quit_msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Finalizado!");
	}

}
