
import java.util.Date;  
import java.util.Vector;

public final class Block {
        public int index; // índice do bloco
	public String hash; // hash do bloco atual
	public String previousHash; // hash  do bloc anterior
	private Vector dadosBloco; // armazena todas chaves públicas que assinaram documentos
        public long timeStamp; // horário de criação do bloco
        private String linkDoc;
        
        /* Block Constructor */  
	public Block(String previousHash) {
            this.dadosBloco = new Vector();
            this.previousHash = previousHash;
            this.timeStamp = new Date().getTime();
            this.hash = calculateHash(this); //Making sure we do this after we set the other values.
	}
	
        public Vector getDadosBloco() {
            return this.dadosBloco;
        }

        public void adicionaDados(String chavePublica){
            this.dadosBloco.add(chavePublica);
        }
        
        public String dadosToString(Vector dadosBloco){
            String dados = "";
            for(int i = 0; i < dadosBloco.size(); i++){ 
                dados = dados + dadosBloco.get(i);
            }
            return dados;
        }
        
	//Calculate new hash based on blocks contents
	public String calculateHash(Block dados) {
            String auxiliar = dados.dadosToString(dadosBloco);
            String calculatedhash = StringUtil.applySha256(previousHash + auxiliar + Long.toString(timeStamp));
            return calculatedhash;
	}

}

