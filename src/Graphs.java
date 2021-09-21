import java.util.ArrayList;

public class Graphs {
    private static ArrayList<Integer> cont;

    Graphs(){
        this.cont=new ArrayList<Integer>();
    }

    public void widthBypass(int[][]graf, int point){
        ArrayList<Integer> newList=new ArrayList<Integer>();
        ArrayList<Integer> cont=new ArrayList<Integer>();
        newList.add(point);
        cont.add(point);
        while(!newList.isEmpty()){
            System.out.println("Из вершины " +newList.get(0) + " идут ребра: ");
            for(int i=0; i<graf.length; i++){
                for(int j=0; j<graf[i].length-1; j++){
                    if(graf[i][j]==newList.get(0)){
                        if(!cont.contains(graf[i][j+1])){
                            newList.add(graf[i][j+1]);
                            cont.add(graf[i][j+1]);
                        }
                        System.out.println("(" + newList.get(0) + "," + graf[i][j+1] + ")");
                    }
                }
            }
            newList.remove(0);
        }
        System.out.println();
    }

    public void heightBypass(int[][] graf, int point){
        cont.add(point);
        boolean flag=false;
        boolean proverka=false;
        while(!flag) {
            HeightHandler(graf, point);
            for (int i = 0; i < graf.length; i++) {
                proverka=false;
                for (int j = 0; j < graf[i].length - 1; j++) {
                    for(int a: cont){
                        if(a==graf[i][j]) proverka=true;
                    }
                }
                if(!proverka){
                    cont.add(graf[i][0]);
                    HeightHandler(graf, graf[i][0]);
                }
            }
            flag=true;
        }
    }
    private void HeightHandler(int[][] graf, int top){
        for(int i=0; i<graf.length; i++){
            for(int j=0; j<graf[i].length-1; j++){
                if(graf[i][j]==top){
                    if(!cont.contains(graf[i][j+1])){
                        cont.add(graf[i][j+1]);
                        HeightHandler(graf, graf[i][j+1]);
                    }
                    System.out.println("(" + graf[i][j] + "," + graf[i][j+1] + ")");
                }
            }
        }
    }
}
