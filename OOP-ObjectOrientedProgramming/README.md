## Appunti/Quiz POO
> [!TIP]
> ♨️ [Sito Quiz](http://dotto.dia.uniroma3.it:8080/quiz/student_start.do)
<details>
<summary><h3>Lista Quiz</h3></summary>

|Quiz|Da fare|
|:--|:--:|
|Introduzione al Sistema Quiz|X|
|POO-02-paradigma-OO|X|
|POO-03-oggetti-riferimenti|X|
|POO-04-gestione-memoria|X|
|POO-05-costruttori-string-array|X|
|POO-09-polimorfismo-interfacce|X|
|POO-12-polimorfismo-interface-estensione-object|X|
|POO-13-estensione-protected|X|
|POO-15-collezioni-liste-generiche|X|
|POO-16-collezioni-insiemi-generici|X|
|POO-17-collezioni-mappe-generiche|X|
|POO-18-classi-astratte-enum|X|
|Compito Preparazione Prima Prova Intermedia||
|Compito Preparazione Seconda Prova Intermedia||
|Simulazione di PI2||
|Compito Preparazione Terza Prova Intermedia|X|
|Esercizio Completo - Progetto||
|Esercizio Completo - Magazzino||
|Esercizio Completo - Disegno||
|Esercizio Completo - Consorzio||
|Esercizio Completo - Consorzio||
|Esercizio Completo - Directory||
</details>
<details>
<summary><h3>Lista Esami</h3></summary>
  
|Esami|Status|
|:--|:--:|
|war - settembre 2023|[X - Hard](./war-online)|
|sim - giugno 2022||
|prop - settembre 2020||
|bici - febbraio 2019||
|ant - giugno 2017|[X - Hard](./ant)|
|ama - febbraio 2017||
|battlefield - giugno 2016|[Soluzione](./battlefield)|
|doc - luglio 2012||
</details>

***


<details>
<summary><h3>POO-15-collezioni-liste-generiche</h3></summary>

> Scrivere il corpo del seguente metodo affinché tutti i test abbiano successo: `int Calcolatore.prodottoScalare(List v1, List v2)`
>
> Questo calcola il prodotto scalare di due vettori di Integer, ovvero la somma dei prodotti di elementi di pari indice nei due vettori che riceve come parametri
>
> Lancia le seguenti eccezioni:
> - se uno dei due vettori è vuoto `NoSuchElementException`
> - se i due vettori possiedono dimensione diversa `IllegalArgumentException`
```java
import java.util.List;
import java.util.NoSuchElementException;

public class Calcolatore {
    
    /**
     * Calcola il prodotto scalare di due vettori di {@link Integer}, ovvero
     * la somma dei prodotti di elementi di pari indice nei due vettori
     * @param v1 - il primo vettor2 di {@link Integer} 
     * @param v2 - il secondo vettore di {@link Integer}
     * @return il prodotto scalare
     * @throws {@link NoSuchElementException} - se uno dei due vettori è vuoto
     * @throws {@link IllegalArgumentException} - se i due vettori possiedono dimensione diversa
     */
    public static int prodottoScalare(List<Integer> v1, List<Integer> v2) {
        // COMPLETARE IL SEGUENTE METODO
        return 0;
    }
}
```
```java
import org.junit.Test;
// This class tests the Calculator
public class CalculatorTest {

    // Test if the scalar product throws an exception with empty lists
    @Test(expected = NoSuchElementException.class)
    public void testScalarProduct_emptyLists() {
        Calculator.scalarProduct(list(),list());
    }

    // Test if the scalar product throws an exception with different sized lists
    @Test(expected = IllegalArgumentException.class)
    public void testScalarProduct_differentSize() {
        Calculator.scalarProduct(list(1),list(1,2));
    }

    // Test scalar product with list of size 1
    @Test
    public void testScalarProduct_size1() {
        assertEquals(1, Calculator.scalarProduct(list(1),list(1)));
    }

    // Test scalar product with list of size 2
    @Test
    public void testScalarProduct_size2() {
        assertEquals(2, Calculator.scalarProduct(list(1,-1),list(1,-1)));
    }

    // Test scalar product with list of size 3
    @Test
    public void testScalarProduct_size3() {
        assertEquals(8, Calculator.scalarProduct(list(1,3,0),list(-1,3,1)));
    }

    // This method creates a list from given integers
    private List<Integer> list(Integer... e) {
        return Arrays.asList(e);
    }
}
```
<details>
<summary><h3>Soluzione</h3></summary>

```java
public static int prodottoScalare(List<Integer> v1, List<Integer> v2) {
        // COMPLETARE IL SEGUENTE METODO
        if(v1.size()==0 || v2.size()==0 )
            throw new NoSuchElementException();
        if(v1.size() != v2.size())
            throw new IllegalArgumentException();
            
        int sum = 0;
        for(int i = 0; i < v1.size(); i++)
            sum += v1.get(i) * v2.get(i);
        return sum;
    }
```
</details>
</details>
<details>
<summary><h3>POO-17-collezioni-mappe-generiche</h3></summary>

<details>
<summary><h3>Es 1</h3></summary>

> Write the method `autore2libri()` of the `RaggruppatoreLibriPerAutore` class. This method returns a map whose keys are the names of book authors. The map associates each name with a value, which is the list of all `Libro` objects written by that author.
```java
import java.util.*;

class Libro {

    private String titolo;

    private String autore;

    public Libro(String titolo, String autore) {
        this.titolo = titolo;
        this.autore = autore;
    }

    public String getAutore() {
        return this.autore;
    }

    public String getTitolo() {
        return this.titolo;
    }

}

public class RaggruppatoreLibriPerAutore {

    private List<Libro> elencoLibri;

    public RaggruppatoreLibriPerAutore(){
        this.elencoLibri = new ArrayList<Libro>();
    }

    public void aggiungiLibro(Libro libro) {
        this.elencoLibri.add(libro);
    }

    public Map<String, List<Libro>> autore2libri() {
        Map<String, List<Libro>> autore2libri = new HashMap<String, List<Libro>>();
        // completare questo metodo
        return autore2libri;
    }
}
```
<details>
<summary><h3>Soluzione</h3></summary>

```java
import java.util.*;

class Libro {

    private String titolo;

    private String autore;

    public Libro(String titolo, String autore) {
        this.titolo = titolo;
        this.autore = autore;
    }

    public String getAutore() {
        return this.autore;
    }

    public String getTitolo() {
        return this.titolo;
    }
}

public class RaggruppatoreLibriPerAutore {

    private List<Libro> elencoLibri;

    public RaggruppatoreLibriPerAutore(){
        this.elencoLibri = new ArrayList<Libro>();
    }

    public void aggiungiLibro(Libro libro) {
        this.elencoLibri.add(libro);
    }

    public Map<String, List<Libro>> autore2libri() {
        Map<String, List<Libro>> autore2libri = new HashMap<String, List<Libro>>();
        // completare questo metodo
        for(Libro a : elencoLibri){
            if(autore2libri.get(a.getAutore()) == null){
                autore2libri.put(a.getAutore(), new ArrayList<Libro>() );
            }
        }
        for(Libro a : elencoLibri){
            String autore = a.getAutore();
            List<Libro> b = autore2libri.get(autore);
            b.add(a);
        }
        return autore2libri;
    }
}
```
</details>
</details>
<details>
<summary><h3>Es 4</h3></summary>

> Completare il metodo inverti che data una mappa la "inverte", ovvero restituisce una nuova mappa in cui quelli che prima erano i valori figurano come chiavi associate all'insieme di quelle che prima erano le chiavi e che ora figurano come (insieme di) valori
```java
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Invertitore {

    public static <K,V> Map<V, Set<K>> inverti(Map<K,V> input) {
        // COMPLETARE QUESTO METODO
        return null;
    }
}
```

<details>
<summary><h3>Soluzione</h3></summary>
  
```java
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;


public class Invertitore {

    public static <K,V> Map<V, Set<K>> inverti(Map<K,V> input) {
        // COMPLETARE QUESTO METODO
        Map<V, Set<K>> map = new HashMap<>();
        //Set<V> v = new LinkedHashSet<>(input.values());
        //Set<K> k =  new LinkedHashSet<>(input.keySet());
        for(K a : input.keySet()){
            if(map.get(input.get(a)) == null )
                map.put(input.get(a), new LinkedHashSet<K>());
        }
        for(K b : input.keySet()){
            Set<K> f = map.get(input.get(b));
            f.add(b);
        }
        return map;
    }
}
```
</details>
</details>
</details>

***
> [!NOTE]
> ***Random codes that i saved for reasons***

### class<?>
```java
package p;
public class NameSolver {
    private static final String RNS_R = "p/r.txt";
    private static final String ABS_R = "/p/r.txt";
    private static final String REL_R = "r.txt";

    Class<?> clazz = this.getClass();
    ClassLoader loader = clazz.getClassLoader();

    System.out.println("ClassLoader.getResource(\\""+ABS_R+"\\")=\\t"+ loader.getResource(ABS_R));
}
```

### TreeSet Comparable<Persona> - ordine alfabetico contrario
```java
class Persona implements Comparable<Persona> {
    private String cognome;

    public Persona(String cognome) {
        this.cognome = cognome;
    }

    public String getCognome() { return this.cognome; }  

    public static TreeSet<Persona> getInsiemeOrdinato(List<Persona> listaPersone) {
            //DA COMPLETARE
            TreeSet<Persona> s = new TreeSet<Persona>();
            s.addAll(listaPersone);

            return s;
    }
    
    public int compareTo(Persona that){
        return -this.cognome.compareTo(that.cognome);
    }
}
```

### Enum
```java
enum Mese {
    GENNAIO, FEBBRAIO, MARZO, 
    APRILE, MAGGIO, GIUGNO, 
    LUGLIO, AGOSTO, SETTEMBRE, 
    OTTOBRE, NOVEMBRE, DICEMBRE;

    public Mese corrispondenzaStagionale() {
        //  COMPLETARE QUESTO METODO
        return Mese.values()[(this.ordinal()+6)%12];
    }
}
```

