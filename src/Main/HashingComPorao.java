package Main;

public class HashingComPorao implements EstruturaDeDados{

    private  final int size = 1011;
    private  final int porao = 100;

    private int[] lista;
    private int[] poraoLista;
    private int poraoIndex;

    public HashingComPorao() {
        lista = new int[size];
        poraoLista = new int[porao];
        poraoIndex = 0;
    }

    private int hash(int chave) {
        return chave % size;
    }

    @Override
    public void insert(int chave) {
        int indice = hash(chave);
        if (lista[indice] == 0) {
            lista[indice] = chave;
        } else {
            if (poraoIndex >= porao) {
                for (int i = indice; i < size; i++) {
                    if (lista[i] == 0) {
                        lista[i] = chave;
                        break;
                    }
                }
            } else {
                poraoLista[poraoIndex] = chave;
                poraoIndex++;
            }
            
        }
    }

    @Override
    public void delete(int chave) {
        int pos = hash(chave);
        if (lista[pos] == chave) {
            lista[pos] = 0;
        } else {
            for (int i = 0; i < poraoIndex; i++){
                if (poraoLista[i] == chave) {
                    for (int j = i; j < poraoIndex; j++){
                        poraoLista[j] = poraoLista[j+1];
                    }
                    poraoIndex--;
                }
            } 
            if (poraoIndex >= porao) {
                for (int i = pos; i < size; i++) {
                    if (lista[i] == chave) {
                        lista[i] = 0;
                        break;
                    }
                }
            }
        }        
    }

    @Override
    public boolean search(int chave) {
        int pos = hash(chave);
        if (lista[pos] == chave) {
            return true;
        } else {
            for (int i = 0; i < poraoIndex; i++){
                if (poraoLista[i] == chave) {
                    return true;
                }
            }
            if (poraoIndex >= porao) {
                for (int i = pos; i < size; i++) {
                    if (lista[i] == chave) {
                        return true;
                    }
                }
            }
                
        }
        return false;
    }
    
}