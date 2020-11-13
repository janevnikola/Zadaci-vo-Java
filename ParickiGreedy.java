/*
Дадени се парички со одредена вредност (постојат парички од 50, 10, 5, 2 и 1 денар), и притоа бројот на парички од
секоја вредност е неограничен. За дадена сума да се определи најмалиот број на парички кои се потребни да се формира таа сума

*/
public class NajmalBrojParicki_BruteForce{

static void sortiranjeParicki(int paricki[], int n){
    int temp;
    for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){//sortiranje
if(paricki[i]<paricki[j]){
    temp=paricki[i];    //vo temp se stava na primer 6
    paricki[i]=paricki[j]; //vo paricki [i] se stava paricki[j]na primer 7
    paricki[j]=temp; //7 ke se stavi vo paricki [i]
}
        }
    }

}

    static int najmal_brojParickiGreedy(int paricki[], int n, int suma, int broj_paricki[]){
sortiranjeParicki(paricki,n); //pravime sortiranje
int vkupno_paricki=0;
int i=0; //brojac
while(broj_paricki[i] >n){
    broj_paricki[i]=suma/paricki[i];//broj_paricki[j] ke se stavi sumata / paricki [i]
    suma-=broj_paricki[i]*paricki[i];
    vkupno_paricki+=broj_paricki[i];
    i++;
}
while(i<n){
    broj_paricki[i]=0;
    i++;
}

return vkupno_paricki;
    }
public static void main(String args[]){
    int paricki[]={1,2,5,10,50};
    int broj_paricki[]={0,0,0,0,0};
    int n=5;
int suma=79;
    System.out.println("Najmaliot broj na paricki so Greeddy e: "+najmal_brojParickiGreedy(paricki,n,suma,broj_paricki));
}
}
