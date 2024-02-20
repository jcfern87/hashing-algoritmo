package Main;

public class HashingEncadeamentoAberto implements EstruturaDeDados{

    private static final int size = 1011;
    private int[] lista;

    public HashingEncadeamentoAberto() {
        lista = new int[size];
    }

    private int identidade(int chave) {
        return chave % size;
    }

    @Override
    public void insert(int chave) {
        int pos = identidade(chave);
        if (lista[pos] == 0) {
            lista[pos] = chave;
        } else {
            for (int i = pos; i < size; i++) {
                if (lista[i] == 0) {
                    lista[i] = chave;
                    break;
                }
            }
        }
    }

    @Override
    public void delete(int chave) {
        int pos = identidade(chave);
        if (lista[pos] == chave) {
            lista[pos] = 0;
        } else {
            for (int i = pos; i < size; i++) {
                if (lista[i] == chave) {
                    lista[i] = 0;
                    break;
                }
            }
        }
    }

    @Override
    public boolean search(int chave) {
        int pos = identidade(chave);
        if (lista[pos] == chave) {
            return true;
        } else {
            for (int i = pos; i < size; i++) {
                if (lista[i] == chave) {
                    return true;
                }
            }
        }
        return false;
    }
    
}