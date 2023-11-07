# System aukcyjny

## Wprowadzenie

Specyfikacja wymagań funkcjonalnych w ramach informatyzacji procesu sprzedaży produktów w oparciu o mechanizm aukcyjny. 

## Procesy biznesowe

---
<a id="bc1"></a>
### BC1: Sprzedaż aukcyjna 

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Opis:** Proces biznesowy opisujący sprzedaż za pomocą mechanizmu aukcyjnego. |

**Scenariusz główny:**
1. [Sprzedający](#ac1) wystawia produkt na aukcję. ([UC1](#uc1))
2. [Kupujący](#ac2) oferuje kwotę za produkt wyższą od aktualnie najwyższej oferty. ([BR1](#br1))
3. [Kupujący](#ac2) wygrywa aukcję ([BR2](#br2))
4. [Kupujący](#ac2) przekazuje należność Sprzedającemu.
5. [Sprzedający](#ac1) przekazuje produkt Kupującemu.

**Scenariusze alternatywne:** 

2.A. Oferta Kupującego została przebita, a [Kupujący](#ac2) pragnie przebić aktualnie najwyższą ofertę.
* 2.A.1. Przejdź do kroku 2.

3.A. Czas aukcji upłynął i [Kupujący](#ac2) przegrał aukcję. ([BR2](#br2))
* 3.A.1. Koniec przypadku użycia.

---

## Aktorzy

<a id="ac1"></a>
### AC1: Sprzedający

Osoba oferująca towar na aukcji.

<a id="ac2"></a>
### AC2: Kupujący

Osoba chcąca zakupić produkt na aukcji.


## Przypadki użycia poziomu użytkownika

### Aktorzy i ich cele

[Sprzedający](#ac1):
* [UC1](#uc1): Wystawienie produktu na aukcję
* [UC2](#uc2): Otrzymanie pieniędzy i informacji od zwycięzcy aukcji
* [UC3](#uc3): Wysłanie produktu

[Kupujący](#ac2):
* [UC4](#uc4): Znalezienie produktu
* [UC5](#uc5): Wygranie licytacji
* [UC6](#uc6): Przekazanie należności sprzedającemu
* [UC7](#uc7): Otrzymanie produktu


---
<a id="uc1"></a>
### UC1: Wystawienie produktu na aukcję



**Aktorzy:** [Sprzedający](#ac1)

**Scenariusz główny:**
1. [Sprzedający](#ac1) zgłasza do systemu chęć wystawienia produktu na aukcję.
2. System prosi o podanie danych produktu i ceny wywoławczej.
3. [Sprzedający](#ac1) podaje dane produktu oraz cenę wywoławczą.
4. System weryfikuje poprawność danych.
5. System informuje o pomyślnym wystawieniu produktu na aukcję.

**Scenariusze alternatywne:** 

4.A. Podano niepoprawne lub niekompletne dane produktu.
* 4.A.1. System informuje o błędnie podanych danych.
* 4.A.2. Przejdź do kroku 2.

---

<a id="uc2"></a>
### UC2: Otrzymanie pieniędzy i informacji od zwycięzcy aukcji

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**
1. System informuje o zakończeniu aukcji
2. [Sprzedający](#ac1) sprawdza szczegóły zakończonej aukcji
3. System informuje o statusie transakcji i danych [Kupującego](#ac2)
4. [Sprzedający](#ac1) czeka na otrzymanie należności
5. [Sprzedający](#ac1) otrzymuje należność

**Scenariusze alternatywne:** 

4.A. Należność nie dotarła
* 4.A.1. Od zakończenia aukcji minął odpowiednio długi czas
* 4.A.1.1 Skontaktuj się z supportem
* 4.A.2 Od zakończenia aukcji nie minął odpowiednio długi czas
* 4.A.2.1 Przejdź do punktu 4

---
<a id="uc3"></a>
### UC3: Wysłanie produktu

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**
1. System zwraca dane [Kupującego](#ac2)
2. [Sprzedający](#ac1) wysyła produkt na podany adres

---
<a id="uc4"></a>
### UC4: Znalezienie produktu

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**
1. [Kupujący](#ac2) wyszukuje [produkt](#bo2)
2. System zwraca listę [produktów](#bo2)
3. [Kupujący](#ac2) przegląda listę i wybiera [produkt](#bo2)
4. System zwraca informację o [produkcie](#bo2) i [sprzedawcy](#ac1)
5. [Kupujący](#ac2) podejmuje decyzję o uczestnictwie w aukcji

---
<a id="uc5"></a>
### UC5: Wygranie licytacji

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**
1. System zwraca aktualną cenę aukcji
2. [Kupujący](#ac2) przebija cenę aukcji
3. System aktualizuje cenę aukcji
4. System informuje [Kupującego](#ac2) o wygraniu licytacji i zakończeniu aukcji

**Scenariusze alternatywne:** 

2.A Ktoś przebija cenę wystawioną przez [kupującego](#ac2)
* 2.A.1 Wróć do punktu 2

2.B [Kupujący](#ac2) nie ma wystarczająco pieniędzy by przebić cenę aukcji
* 2.B.A [Kupujący](#ac2) rezygnuje z aukcji
* 2.B.B [Kupujący](#ac2) doładowuje konto

---

<a id="uc6"></a>
### UC6: Przekazanie należności sprzedającemu

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**
1. System informuje [Kupującego](#ac2) o konieczności przekazania należności i sprawdzenia poprawności danych do wysyłki
2. [Kupujący](#ac2) sprawdza poprawność danych
3. [Kupujący](#ac2) wysyła środki do [Sprzedającego](#ac1)
4. System przekazuje [sprzedającemu](#ac1) i [kupującemu](#ac2) potwierdzenie wysłania środków
5. System pobiera środki z konta [kupującego](#ac2) i wpłaca na konto [sprzedającego](#ac1)

**Scenariusze alternatywne:** 

2.A Dane nie są poprawne
* 2.A.1 [Kupujący](#ac2) wprowadza do systemu poprawne dane
* 2.A.2 Wróć do punktu 2

---
<a id="uc7"></a>
### UC7: Otrzymanie produktu

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**
1. [Kupujący](#ac2) sprawdza zgodność [produktu](#bo2) z informacjami podanymi w aukcji

**Scenariusze alternatywne:** 

1.A [Produkt](#bo2) nie zgadza się z opisem w aukcji
* 1.A.1 Skontaktuj się z supportem i sprzedającym

---

## Obiekty biznesowe (inaczje obiekty dziedzinowe lub informatycjne)

### BO1: Aukcja

Aukcja jest formą zawierania transakcji kupna-sprzedaży, w której Sprzedający określa cenę wywoławczą produktu, natomiast Kupujący mogą oferować własną ofertę zakupu każdorazowo proponując kwotę wyższą od aktualnie oferowanej kwoty. Aukcja kończy się po upływie określonego czasu. Jeśli złożona została co najmniej jedna oferta zakupy produkt nabywa ten Kupujący, który zaproponował najwyższą kwotę. 

### BO2: Produkt

Fizyczny lub cyfrowy obiekt, który ma zostać sprzedany w ramach aukcji.

## Reguły biznesowe

<a id="br1"></a>
### BR1: Złożenie oferty

Złożenie oferty wymaga zaproponowania kwoty wyższej niż aktualnie oferowana o minimum 1,00 PLN.


<a id="br2"></a>
### BR2: Rozstrzygnięcie aukcji

Aukcję wygrywa ten z [Kupujący](#ac2)ch, który w momencie jej zakończenia (upłynięcia czasu) złożył najwyższą ofertę.

## Macierz CRUDL


| Przypadek użycia                                  | Aukcja | Produkt | ... |
| ------------------------------------------------- | ------ | ------- | --- |
| UC1: Wystawienia produktu na aukcję               |    C   |    C    | ... |
| ???                                               |  ...   |  ...    | ... |


