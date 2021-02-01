import java.io.IOException;
import java.util.Scanner;
public class Principal {
    private  static long start;
    private  static  long finalCount;

    public static void main(String[] args) throws IOException {
        Scanner read = new Scanner(System.in);
        ManipuladorArq manipuladorArq = new ManipuladorArq();
        Ordenadora ordenadora = new Ordenadora();
        QuickSort quickSort = new QuickSort();
        MergeSort mergeSort = new MergeSort();
        ShellSort shellSort = new ShellSort();
        HeapSort heapSort = new HeapSort();
        int optionSort;
        String arqLink;
        String arqLinkOrdena = "";
        String arq;
        String dadoEscrita = "[";
        System.out.println("Informe o arquivo: ");
        arqLink = read.next();
        long numMov = 0;
        String timeResul;
        String tipoOrdena = "";

        arq = manipuladorArq.leitor(arqLink);
        arq = arq.replace("Dados Aleatorios", "");
        arq = arq.replace("[", "");
        arq = arq.replace("]", "");

        System.out.println(arq);
        String[] vetorArq = arq.split(", ");
        int[] vetorArqInt = new int[vetorArq.length];

        for(int i = 0; i < vetorArq.length; i++){
            vetorArqInt[i] = Integer.parseInt(vetorArq[i]);
        }
        System.out.println("Deseja ordenar utilizando que tipo de ordenação?\n1) Insertion Sort.\n2) Selection Sort.\n3) Bubble Sort.\n4) Combo Sort\n5) Quick Sort\n6) Merge Sort\n7) Shell Sort\n8)HeapSort");
        optionSort = Integer.parseInt(read.next());

        switch (optionSort){
            case(1):
                start = System.currentTimeMillis();
                ordenadora.insertionSort(vetorArqInt);
                finalCount  = System.currentTimeMillis() - start;

                break;

            case(2):
                start = System.currentTimeMillis();
                ordenadora.selectionSort(vetorArqInt);
                finalCount  = System.currentTimeMillis() - start;

                break;

            case(3):
                start = System.currentTimeMillis();
                ordenadora.bubbleSort(vetorArqInt);
                finalCount  = System.currentTimeMillis() - start;

                break;

            case(4):
                start = System.currentTimeMillis();
                ordenadora.comboSort(vetorArqInt);
                finalCount  = System.currentTimeMillis() - start;

                break;
            case(5):
                start = System.currentTimeMillis();
                quickSort.quickSort(vetorArqInt, 0, vetorArqInt.length - 1);
                finalCount  = System.currentTimeMillis() - start;
                numMov = quickSort.returnNum();
                break;
            case(6):
                start = System.currentTimeMillis();
                mergeSort.mergeSort(vetorArqInt, 0, vetorArqInt.length - 1);
                finalCount  = System.currentTimeMillis() - start;
                numMov = mergeSort.returnNum();
                break;
            case(7):
                start = System.currentTimeMillis();
                shellSort.shellSort(vetorArqInt);
                finalCount  = System.currentTimeMillis() - start;
                numMov = shellSort.returnNum();
                break;
            case(8):
                start = System.currentTimeMillis();
                heapSort.sort(vetorArqInt);
                finalCount  = System.currentTimeMillis() - start;
                numMov = heapSort.retornaNumMov();
                break;
            default:
                System.out.println("Opção inválida! Tente novamente...");
                break;
        }

        for(int i = 0; i < vetorArqInt.length; i++){
            dadoEscrita += vetorArqInt[i] + ", ";
        }
        dadoEscrita += "]";
        dadoEscrita = dadoEscrita.replace(", ]", "]");

        timeResul = String.format("%dhrs : %dmin : %dseg : %dmilseg", Integer.parseInt(String.valueOf((finalCount/3600000))), Integer.parseInt(String.valueOf((finalCount/60000) %60)), Integer.parseInt(String.valueOf((finalCount/1000) % 60)), Integer.parseInt(String.valueOf((finalCount/100) % 60)));

        if(optionSort == 1){
            tipoOrdena = "INSERTION SORT";
            arqLink = arqLink.replace(".txt", "");
            arqLinkOrdena = arqLink + tipoOrdena + ".txt";
        }else if (optionSort == 2){
            tipoOrdena = "SELECTION SORT";
            arqLink = arqLink.replace(".txt", "");
            arqLinkOrdena = arqLink + tipoOrdena + ".txt";
        }else if (optionSort == 3){
            tipoOrdena = "BUBBLE SORT";
            arqLink = arqLink.replace(".txt", "");
            arqLinkOrdena = arqLink + tipoOrdena + ".txt";
        }else if (optionSort == 4){
            tipoOrdena = "COMB SORT";
            arqLink = arqLink.replace(".txt", "");
            arqLinkOrdena = arqLink + tipoOrdena + ".txt";
        }else if(optionSort == 5){
            tipoOrdena = "QUICK SORT";
            arqLink = arqLink.replace(".txt", "");
            arqLinkOrdena = arqLink + tipoOrdena + ".txt";
        }else if(optionSort == 6){
            tipoOrdena = "MERGE SORT";
            arqLink = arqLink.replace(".txt", "");
            arqLinkOrdena = arqLink + tipoOrdena + ".txt";
        }else if(optionSort == 7){
            tipoOrdena = "SHELL SORT";
            arqLink = arqLink.replace(".txt", "");
            arqLinkOrdena = arqLink + tipoOrdena + ".txt";
        }else if(optionSort == 8){
            tipoOrdena = "HEAP SORT";
            arqLink = arqLink.replace(".txt", "");
            arqLinkOrdena = arqLink + tipoOrdena + ".txt";
        }
        manipuladorArq.escritor(arqLinkOrdena, dadoEscrita, tipoOrdena, timeResul, numMov);
        System.out.println("Tempo gasto: " + timeResul + "\nNumero de movimentos: " + numMov);
    }
}
