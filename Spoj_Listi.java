import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
Дадени се две еднострано поврзани листи чии јазли содржат по еден природен број. 
Листите се сортирани во растечки редослед. Треба да се спојат двете листи во една така што резултантната листа да е сортирана. 
Сортирањето е подредување со слевање. Јазлите кои се јавуваат како дупликати (од иста листа или од различна) да се отстранат.

Во првиот ред од влезот е даден бројот на јазли во првата листа, потоа во вториот ред се дадени броевите од кои се составени јазлите по 
редослед во првата листа, па во третиот ред е даден бројот на јазли во втората листа, и на крај во четвртиот ред броевите од кои се составени 
јазлите по редослед во втората листа. На излез треба да се испечатат јазлите по редослед во резултантната споена листа.

Име на класата (Java): SLLJoinLists

Забелешка: Да се креира податочна структура еднострано поврзана листа и истата да се искористи во задачата
input
3
2 3 5
1
3
output 2 3 5
*/


class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }
}

     class SLL<E> {
         private SLLNode<E> first;

         public SLL() {
             this.first = null;
         }

         public void insertFirst(E o) {
             SLLNode<E> ins = new SLLNode<E>(o, first);
             first = ins;
         }

         public SLLNode<E> getFirst() {
             return first;
         }

         public Iterator<E> iterator() {
             // Return an iterator that visits all elements of this list, in left-to-right order.
             return new LRIterator<E>();
         }

         public void insertLast(E o) {
             if (first != null) {
                 SLLNode<E> tmp = first;
                 while (tmp.succ != null)
                     tmp = tmp.succ;
                 SLLNode<E> ins = new SLLNode<E>(o, null);
                 tmp.succ = ins;
             } else {
                 insertFirst(o);
             }
         }

         private class LRIterator<E> implements Iterator<E> {
             private SLLNode<E> place, prev, curr;

             private LRIterator() {
                 place = (SLLNode<E>) first;
                 curr = prev = null;
             }

             public boolean hasNext() {
                 return (place != null);
             }

             public E next() {
                 if (place == null)
                     throw new NoSuchElementException();
                 E nextElem = place.element;
                 prev = curr;
                 curr = place;
                 place = place.succ;
                 return nextElem;
             }

             public void remove() {//Not implemented}}
             }


         }
     }


class JoinSortedLists<E extends Comparable<E>> {
    public SLL<E> joinLists(SLL<E> list1, SLL<E> list2) {
        SLL<E> rezultat = new SLL<E>();
        SLLNode<E> jazol1 = list1.getFirst(), jazol2 = list2.getFirst();
        SLLNode<E> rightJazol;
        if (jazol1.element.compareTo(jazol2.element) < 0) {
            rightJazol = jazol2;
        } else {
            rightJazol = jazol1;
        }
        int k = 0;
        while (jazol1 != null && jazol2 != null) {
            if (jazol1.element.compareTo(jazol2.element) < 0) {
                if (k == 0) {
                    rezultat.insertLast(jazol1.element);
                    rightJazol = jazol1;
                    k++;
                } else if (jazol1.element.compareTo(rightJazol.element) != 0) {
                    rezultat.insertLast(jazol1.element);
                    rightJazol = jazol1;
                }
                jazol1 = jazol1.succ;
            } else {
                if (k == 0) {
                    rezultat.insertLast(jazol2.element);
                    rightJazol = jazol2;
                    k++;
                } else if (jazol2.element.compareTo(rightJazol.element) != 0) {
                    rezultat.insertLast(jazol2.element);
                    rightJazol = jazol2;
                }
                jazol2 = jazol2.succ;
            }

        }
        if (jazol1 != null) {
            while (jazol1 != null) {
                if (jazol1.element.compareTo(rightJazol.element) != 0) {
                    rezultat.insertLast(jazol1.element);
                    rightJazol = jazol1;
                }
                jazol1 = jazol1.succ;
            }
        }
        if (jazol2 != null) {
            while (jazol2 != null) {
                if (jazol2.element.compareTo(rightJazol.element) != 0) {
                    rezultat.insertLast(jazol2.element);
                    rightJazol = jazol2;
                }
                jazol2 = jazol2.succ;
            }
        }
        return rezultat;
    }




    }


    public class SLLJoinLists {
        public static void main(String[] args) throws IOException {
            SLL<Integer> lista1=new<Integer>SLL();
            SLL<Integer>lista2=new<Integer>SLL();

            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
            String s = stdin.readLine();
            int N = Integer.parseInt(s);
            s = stdin.readLine();
            String[] pomniza = s.split(" ");
            for (int i = 0; i < N; i++) {
                lista1.insertLast(Integer.parseInt(pomniza[i]));
            }

            s = stdin.readLine();
            N = Integer.parseInt(s);
            s = stdin.readLine();
            pomniza = s.split(" ");
            for (int i = 0; i < N; i++) {
                lista2.insertLast(Integer.parseInt(pomniza[i]));
            }

            JoinSortedLists<Integer>j =new JoinSortedLists<Integer>();

            SLL<Integer> spoeni;

            spoeni=j.joinLists(lista1,lista2);
            // spoeni = lista1.joinLists(lista2);
            Iterator<Integer> it = spoeni.iterator();
            while (it.hasNext()) {
                System.out.print(it.next());
                if (it.hasNext())
                    System.out.print(" ");
            }
            System.out.println();
        }
    }


