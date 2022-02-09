import java.util.Scanner;


//VO edna igra se koristat karti i sekoja karta se sostoi od tri podatoci: id na herojot od kartata, negovata mokj
//i brojot na napadi.
//za sekoja karta se presmetuva damage koja e rezultat od power*broj na napadi
//Dadeni se dve SLL listi, i sekoj igrac ima 6 karti i igrata ja igraat max 2 igraci.
//Igrata e takva sto prviot igrac ja dava svojata najdobra karta (najgolem damage) i ja predava na vtoriot igrac
//i taa karta se dodava vo sredina.


class Card {
    private int id;
    private int power;
    private int numAttacks;

    public Card(int id, int power, int numAttacks) {
        this.id = id;
        this.power = power;
        this.numAttacks = numAttacks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getNumAttacks() {
        return numAttacks;
    }

    public void setNumAttacks(int numAttacks) {
        this.numAttacks = numAttacks;
    }

    public int damage() {
        return power * numAttacks;
    }


    @Override
    public String toString() {
        return String.valueOf(id);
    }
}

class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}

class SLL<E> {
    private SLLNode<E> first;

    public SLL() {
        this.first = null;
    }

    public void deleteList() {
        first = null;
    }

    public int length() {
        int ret;
        if (first != null) {
            SLLNode<E> tmp = first;
            ret = 1;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret++;
            }
            return ret;
        } else
            return 0;

    }

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            SLLNode<E> tmp = first;
            ret += tmp;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += " " + tmp;
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public void insertFirst(E o) {
        SLLNode<E> ins = new SLLNode<E>(o, first);
        first = ins;
    }

    public void insertAfter(E o, SLLNode<E> node) {
        if (node != null) {
            SLLNode<E> ins = new SLLNode<E>(o, node.succ);
            node.succ = ins;
        } else {
            System.out.println("Dadenot jazol e null");
        }
    }

    public void insertBefore(E o, SLLNode<E> before) {
        if (first != null) {
            SLLNode<E> tmp = first;
            if (first == before) {
                this.insertFirst(o);
                return;
            }
            while (tmp.succ != before)
                tmp = tmp.succ;
            if (tmp.succ == before) {
                SLLNode<E> ins = new SLLNode<E>(o, before);
                tmp.succ = ins;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
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

    public E deleteFirst() {
        if (first != null) {
            SLLNode<E> tmp = first;
            first = first.succ;
            return tmp.element;
        } else {
            System.out.println("Listata e prazna");
            return null;
        }
    }

    public E delete(SLLNode<E> node) {
        if (first != null) {
            SLLNode<E> tmp = first;
            if (first == node) {
                return this.deleteFirst();
            }
            while (tmp.succ != node && tmp.succ.succ != null)
                tmp = tmp.succ;
            if (tmp.succ == node) {
                tmp.succ = tmp.succ.succ;
                return node.element;
            } else {
                System.out.println("Elementot ne postoi vo listata");
                return null;
            }
        } else {
            System.out.println("Listata e prazna");
            return null;
        }
    }

    public SLLNode<E> getFirst() {
        return first;
    }

    public SLLNode<E> find(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (tmp.element != o && tmp.succ != null)
                tmp = tmp.succ;
            if (tmp.element == o) {
                return tmp;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
        return first;
    }
}

class Heroes {
    public static void main(String args[]) {
        //lista i karti za prviot igrac
        SLL<Card> listaPrvIgrac = new SLL<Card>();
        listaPrvIgrac.insertLast(new Card(1, 5, 4));
        listaPrvIgrac.insertLast(new Card(2, 10, 5));
        listaPrvIgrac.insertLast(new Card(3, 4, 7));
        listaPrvIgrac.insertLast(new Card(4, 25, 3));
        listaPrvIgrac.insertLast(new Card(5, 3, 9));
        listaPrvIgrac.insertLast(new Card(6, 7, 1));

        SLL<Card> listaVtorIgrac = new SLL<Card>();
        listaVtorIgrac.insertLast(new Card(1, 4, 10));
        listaVtorIgrac.insertLast(new Card(2, 30, 1));
        listaVtorIgrac.insertLast(new Card(3, 6, 8));
        listaVtorIgrac.insertLast(new Card(4, 11, 3));
        listaVtorIgrac.insertLast(new Card(5, 8, 13));
        listaVtorIgrac.insertLast(new Card(6, 9, 2));


        System.out.println("Prv igrac karti: ");
        System.out.println(listaPrvIgrac.toString());
        System.out.println("Vtor igrac karti: ");
        System.out.println(listaVtorIgrac.toString());




        startHeroesGame(listaPrvIgrac, listaVtorIgrac);
    }

    private static void startHeroesGame(SLL<Card> listaPrvIgrac, SLL<Card> listaVtorIgrac) {
        //prviot igrac ja predava svojata najdobra karta na vtoriot igrac
        //koga ke se predade kartata se brise od prvata lista i se dodava na sredina od vtorata lista
        //najdobra karta e ona so najdobar damage

        SLLNode<Card> tmp = listaPrvIgrac.getFirst();
        SLLNode<Card> max_damage = listaPrvIgrac.getFirst();
        while (tmp != null) {
            //najdi ja najdobrata karta so card.damage
            if (tmp.element.damage() > max_damage.element.damage()) {
                max_damage = tmp;
            }
            tmp = tmp.succ;

        }
        System.out.println("Najgolemata karta koja se brise: " + max_damage.toString());
        listaPrvIgrac.delete(max_damage);
        System.out.println("Listata od prv igrac posle brisenje :");
        System.out.println(listaPrvIgrac.toString());
        //sega dodadi ja na sredina

      //  SLLNode<Card> tmpVtora = listaPrvIgrac.getFirst();

        SLLNode<Card> slow_ptr = listaVtorIgrac.getFirst();
        SLLNode<Card> fast_ptr = listaVtorIgrac.getFirst();

        while (fast_ptr != null && fast_ptr.succ != null) {
            fast_ptr = fast_ptr.succ.succ;//fast ptr skoka za 2, primer ako e na prviot element ke skokne na
                                            // tretiot
            slow_ptr = slow_ptr.succ;   //slow ptr ke skoka za 1
        }
        System.out.println("Kartata vo sredina od vtorata lista e: "+ slow_ptr.toString());
        listaVtorIgrac.insertBefore(max_damage.element,slow_ptr);
        System.out.println("Vtorata lista posle vnesuvanje na kartata vo sredina: "+listaVtorIgrac.toString());
    }


}
