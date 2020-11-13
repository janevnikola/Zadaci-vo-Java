/*
Da se napise programa so Brute Force algoritam 
na kolku nacini dve kralici se napagjaat.
Dve kralici se napagjaat ako se na isti red, ista kolona, ista dijagonal
vo sahovska tabla
*/



public class KraliciBruteForce {
    static int daliSeNapagjaat(int i1, int i2, int j1, int j2){
        if(i1==j2){
            return 1;
        }
        else if(j1==j2){
            return 1;
        }
        else if(Math.abs(i1-i2)==Math.abs(j1-j2)){//dijagonala
            return 1;
        }
        else
            return 0;
    }
    static int kolkuNacini(){
        int i1,i2,j1,j2;
        int rezultat=0;
        for(i1=0;i1<8;i1++){
            for(i2=0;i2<8;i2++){
                for(j1=0;j1<8;j1++){
                    for(j2=0;j2<8;j2++){
                        if(daliSeNapagjaat(i1,j2,j1,j2)==0){
                            rezultat++;
                        }
                    }
                }
            }
        }
        return rezultat;
    }

public static void main(String args[]){
        daliSeNapagjaat(2,3,2,5);
        System.out.println("Dve kralici se napgjaat na: "+kolkuNacini());

}




}
