import br.com.alura.modelos.Endereco;
import br.com.alura.utils.RequestUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        int contador = 0;

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        List listaEndereco = new ArrayList<>();

        String json;
        while (contador < 3) {

            System.out.println("Digite um cep na qual deseja consultar");

            var cep = scanner.nextLine();

            String url = "https://viacep.com.br/ws/" + cep + "/json/";

            json = RequestUtils.getJson(url);

            Endereco endereco = gson.fromJson(json, Endereco.class);
            listaEndereco.add(endereco);

            contador++;
        }

        try {
            FileWriter fileWriter = new FileWriter("endereco.json");
            fileWriter.write(gson.toJson(listaEndereco));
            fileWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

