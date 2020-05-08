package ChunkList;

import java.util.ArrayList;
import java.util.List;

public class ChunkList {

    /**
     * Returns List of the List argument passed to this function with size =
     * chunkSize
     *
     * @param largeList input list to be portioned
     * @param chunkSize maximum size of each partition
     * @param <T> Generic type of the List
     * @return A list of Lists which is portioned from the original list
     */
    public static <T> List<List<T>> chunk(List<T> list, int chunkSize) {
        if (chunkSize != 0) {
            try {
                /*Cria lista de chunks separados*/
                List<List<T>> chunkList = new ArrayList<>(list.size() / chunkSize);

                /*Percorre a lista original pulando o número de chunks*/
                for (int i = 0; i < list.size(); i += chunkSize) {
                    chunkList.add(
                            /*
                                - Copia uma sublista
                                - Inicia na posição do i
                                - Termina no i + o tamanho do chunk, ou no tamanho maximo da lista
                            */
                            list.subList(
                                    i, i + chunkSize >= list.size() ? list.size() : i + chunkSize
                            )
                    );
                }
                return chunkList;
            } catch (Exception e) {
                System.out.println("Error on make chunk list: ");
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }
}
