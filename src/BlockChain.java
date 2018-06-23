
import com.sun.xml.internal.ws.util.StringUtils;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class BlockChain extends Thread {

    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    private static int porta = 8080;
    private static ServerSocket ss;
    private Socket s;

    public BlockChain(Socket s) {
        this.s = s;
    }

    

    public static Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;

        //loop through blockchain to check hashes:
        for (int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);
            //compare registered hash and calculated hash:
            if (!currentBlock.hash.equals(currentBlock.calculateHash(currentBlock))) {
                System.out.println("Current Hashes not equal");
                return false;
            }
            //compare previous hash and registered previous hash
            if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                System.out.println("Previous Hashes not equal");
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Block blocoGenesis = new Block("0");
        String diretorio = "C:\\xampp\\htdocs\\Site\\docs";
        /* Inicialmente */
            // Se houver algum nó na rede
                //copiar o estado atual da blockchain e atualizar o nó atual
             
            //senão
                // iniciar a blockchain e criar o bloco genesis

        // Iniciar API IPFS //
        String nomearq ;
        
        while(true){
            File file = new File(diretorio);
            
            // olhar na pasta e atualizar os indices
            if(file.list().length>0){            
                // adicionar no ipfs, guardar a PK e apagar arquivos da pasta
                nomearq = Arrays.toString(file.list());
                String s = nomearq;
                s = s.replace("[", "");
                s = s.replace("]", "");
                //blocoAtual.dadosbloco.add(s);
                //ipfs.add(s);
                

                // ja foi adicionado no ipfs e na BK, apagar.
                for(File files: new java.io.File(diretorio).listFiles()){ 
                    files.delete();
                    System.out.println("Excluindo Arquivo");                          
                }
            }
        }
    }
        /* Enquanto a semana de upload não terminar */
            //Pegar o doc e chave publica via GET HTTP - ok (independente)
            
            //Armazenar a chave publica do doc em um indice vago do bloco
            //Armazenar o doc no IPFS
        
}
