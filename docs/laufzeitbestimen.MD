<H1>Laufzeitbestimmung</H1>
<H2>Einfache Bestimmung</H2>
<table class="tg">
  <tr>
    <th class="tg-zlqz">Laufzeit</th>
    <th class="tg-zlqz">Code</th>
    <th class="tg-zlqz">Bezeichnung</th>
    <th class="tg-n60d">Bemerkung</th>
  </tr>
  <tr>
    <td class="tg-0pky">O(1)<br></td>
    <td class="tg-0pky">Zuweißungen:<br>int a = 4;<br>int b = 4;<br>int c = b;<br>Primitive Operationen:<br>int d = a+b;<br>int e = a-b;<br>int f = a*b;<br>int g = a/b;<br>int h = a%b;<br>…</td>
    <td class="tg-0pky">Konstante Laufzeit</td>
    <td class="tg-de2y">Primitive Operationen:( +, −, *, /, mod, div, &lt;, &gt;, ==, !=, &lt;=, &gt;=, etc.)</td>
  </tr>
  <tr>
    <td class="tg-0pky">O(n)<br></td>
    <td class="tg-0pky">for(int i = 0; i &lt; n; i++ ) for(int i = n; i &gt;= 0; i - - )</td>
    <td class="tg-0pky">Lineare Laufzeit</td>
    <td class="tg-de2y"></td>
  </tr>
  <tr>
    <td class="tg-0pky">O(n^2)<br></td>
    <td class="tg-0pky">for(int i = 0; i &lt; n; i++ ) {for(int i = n; i &gt;= 0; i - - )}</td>
    <td class="tg-0pky">Quadratische Laufzeit</td>
    <td class="tg-de2y">Verschachtelte Schleifen die jeweils von 0 bis n laufen</td>
  </tr>
  <tr>
    <td class="tg-0lax">O(log n)</td>
    <td class="tg-0lax">for(int i = 0; i &lt; n; i*=2) for(int i = n; i &gt;=; i/=2) </td>
    <td class="tg-0lax">Logaritmische Laufzeit</td>
    <td class="tg-de2y"></td>
  </tr>
  <tr>
    <td class="tg-0lax">O(n log n)</td>
    <td class="tg-0lax">for(int i = 0; i &lt; n; i*=2){for(int i = n; i &gt;= 0; i - - )}</td>
    <td class="tg-0lax">Logaritmische Laufzeit</td>
    <td class="tg-de2y">Verschachtelte Schleifen die jeweils von 0 bis n laufen</td>
  </tr>
  <tr>
    <td class="tg-0lax">O(n^x)</td>
    <td class="tg-0lax"></td>
    <td class="tg-0lax">Potenzielle Laufzeit<br></td>
    <td class="tg-de2y"><br>n^3 --&gt; 3 verschachtelte Schleifen die alle von 0 bin n laufen</td>
  </tr>
  <tr>
    <td class="tg-0lax"><br>O(2^n)</td>
    <td class="tg-0lax"></td>
    <td class="tg-0lax">Expotentielle Laufzeit</td>
    <td class="tg-de2y">Algorithmus kommt in der Praxis meist nicht in Frage.</td>
  </tr>
  <tr>
    <td class="tg-0lax">O(n!)</td>
    <td class="tg-0lax"></td>
    <td class="tg-0lax">Laufzeit von der Fakultät von n</td>
    <td class="tg-de2y">Sollte in der Praxis aufjedenfall vermieden werden</td>
  </tr>
</table>
<H2>Mastertheorem</H2>
Wird verwendet um die Laufzeit bei Teile und Herrsche Algotithmen zu bestimmen
<H3>Formel:</H3>
<p>T(n) = a * T(n/b) +f(n)</p>
<lable for="bsp_javacode1">Beispiel Java Code:</lable>
<pre id="bsp_javacode1">
//Binäre Suche
public int suche(int[] array, int links, int rechts, int element) { 
		if (rechts-links < 0) return -1;
		int mitte = (links + rechts)/2;
		if (element == array[mitte]) return mitte;
		if (element < array[mitte]) return suche(array, links, mitte-1, element); 
		else	return suche(array, mitte+1, rechts, element);
}
</pre>
<p>Hier ist die Laufzeit O(log n). Warum ist das so?</p>
<p>Wenn man sich die Formel anschaut, kann hat man 2 Variablen erkennen, dass sind <strong>a</strong> und <strong>b</strong>. Weiter gibt es noch die Funktion <strong>f(n)</strong>, dies sind die wichtigsten Indikatoren für die Laufzeit bei der Rekursion.</p>
<p>Dabei ist <strong>a</strong> der Rekursive Aufruf, pro Aufruf der Methode.</p>
<p><strong>b</strong> ist die Menge der Zerlegung des Problems in Teilprobleme</p>
<p>Die Funktion <strong>f(n)</strong> ist die Laufzeit die wärend eines Methodenaufrufs benötigt wird.</p>
<br>
<p>Variablen in diesem Beispiel:</p>
<br>
<p> a=1 --> da maximal einmal wieder die Methode <strong>suche()</strong> aufgerufen wird.</p>
<p> b=2 --> da int mitte = (links+rechts)/<strong>2</strong></p>
<p> f(n)=1 --> da keine Schleifen verwendet werden und maximal eine Zuweißung gemacht wird</p>
