---
layout: default
---
<button><a href="#">Button Text</a></button>
<a class="button" src="https://gemohr.github.io/Algorithmen/">Zurück</a>
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
<p> b=2 --> da int mitte = (links+rechts)/<strong>2</strong>, dies bedeutet n wird immer halbiert n/2</p>
<p> f(n)=10 --> da keine Schleifen verwendet werden und maximal eine Zuweißung und primitive Operationen gemacht werden</p>
<p>Nun kann man die die Variablen a,b und die Funktion f(n) in die, in der Tabelle unten 
 befindlichen Formeln einsetzen</p>
 
 <p><math xmlns="http://www.w3.org/1998/Math/MathML"><msub><mi>log</mi><mn>2</mn></msub><mn>1</mn><mo>&#xA0;</mo><mo>=</mo><mo>&#xA0;</mo><mo>&#xA0;</mo><mn>0</mn></math></p>
 
 <p>Fall 1:</p>
 <p><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>1</mn><mo>&#xA0;</mo><mo>=</mo><mo>&#xA0;</mo><msup><mi>n</mi><mrow><msub><mi>log</mi><mn>2</mn></msub><mn>1</mn><mo>-</mo><mi>&#x3B5;</mi></mrow></msup></math></p>
<p><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>1</mn><mo>&#xA0;</mo><mo>=</mo><mo>&#xA0;</mo><msup><mi>n</mi><mrow><mn>0</mn><mo>-</mo><mi>&#x3B5;</mi></mrow></msup><mo>&#xA0;</mo><mo>(</mo><mi>d</mi><mi>a</mi><mo>&#xA0;</mo><msup><mi>n</mi><mn>0</mn></msup><mo>=</mo><mo>&#xA0;</mo><mn>1</mn><mo>&#xA0;</mo><mi>k</mi><mi>a</mi><mi>n</mi><mi>n</mi><mo>&#xA0;</mo><mi>e</mi><mi>s</mi><mo>&#xA0;</mo><mi>k</mi><mi>e</mi><mi>i</mi><mi>n</mi><mo>&#xA0;</mo><mi>&#x3B5;</mi><mo>&gt;</mo><mn>0</mn><mo>&#xA0;</mo><mi>g</mi><mi>e</mi><mi>b</mi><mi>e</mi><mi>n</mi><mo>,</mo><mo>&#xA0;</mo><mi>d</mi><mi>a</mi><mi>s</mi><mo>&#xA0;</mo><mi>d</mi><mi>i</mi><mi>e</mi><mo>&#xA0;</mo><mi>G</mi><mi>l</mi><mi>e</mi><mi>i</mi><mi>c</mi><mi>h</mi><mi>u</mi><mi>n</mi><mi>g</mi><mo>&#xA0;</mo><mi>l</mi><mi>&#xF6;</mi><mi>s</mi><mi>t</mi><mo>)</mo></math></p>
<p>Fall 2:</p>
<p><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>1</mn><mo>&#xA0;</mo><mo>=</mo><mo>&#xA0;</mo><msup><mi>n</mi><mrow><msub><mi>log</mi><mn>2</mn></msub><mn>1</mn></mrow></msup></math></p> 
<p><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>1</mn><mo>&#xA0;</mo><mo>=</mo><mo>&#xA0;</mo><msup><mi>n</mi><mn>0</mn></msup></math></p>
<p><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>1</mn><mo>=</mo><mn>1</mn><mo>&#xA0;</mo><mo>-</mo><mo>&gt;</mo><mi mathcolor="#00FF00">O</mi><mi mathcolor="#00FF00">K</mi></math></p>

<p>Nun kann in die, in der 3. Spalte stehende Formel eingesetzt werden</p>
<p><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>T</mi><mo>(</mo><mi>n</mi><mo>)</mo><mo>&#xA0;</mo><mo>=</mo><mo>&#xA0;</mo><mi>&#x398;</mi><mo>(</mo><msup><mi>n</mi><mrow><msub><mi>log</mi><mn>2</mn></msub><mn>1</mn></mrow></msup><mi>log</mi><mo>&#xA0;</mo><mi>n</mi><mo>)</mo></math></p>
<p><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>T</mi><mo>(</mo><mi>n</mi><mo>)</mo><mo>&#xA0;</mo><mo>=</mo><mo>&#xA0;</mo><mi>&#x398;</mi><mo>(</mo><msup><mi>n</mi><mn>0</mn></msup><mi>log</mi><mo>&#xA0;</mo><mi>n</mi><mo>)</mo></math></p>
<p><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>T</mi><mo>(</mo><mi>n</mi><mo>)</mo><mo>&#xA0;</mo><mo>=</mo><mo>&#xA0;</mo><mi>&#x398;</mi><mo>(</mo><mn>1</mn><mi>log</mi><mo>&#xA0;</mo><mi>n</mi><mo>)</mo><mo>&#xA0;</mo><mo>=</mo><mo>&#xA0;</mo><mi>&#x398;</mi><mo>(</mo><mi>log</mi><mo>&#xA0;</mo><mi>n</mi><mo>)</mo><mo>&#xA0;</mo></math></p>

<table class="tg">
  <tr>
    <th class="tg-ipa1">Fall</th>
    <th class="tg-ipa1">gilt für a &gt;= 1 und b &gt;=1</th>
    <th class="tg-ipa1">dann ist: </th>
  </tr>
  <tr>
    <td class="tg-s268">1</td>
    <td class="tg-s268">
    <math xmlns="http://www.w3.org/1998/Math/MathML"><mi>f</mi><mo>(</mo><mi>n</mi><mo>)</mo><mo>&#xA0;</mo><mo>=</mo><mo>&#xA0;</mo><mi>O</mi><mo>(</mo><msup><mi>n</mi><mrow><msub><mi>log</mi><mi>b</mi></msub><mi>a</mi><mo>-</mo><mi>&#x3B5;</mi></mrow></msup><mo>)</mo><mo>&#xA0;</mo><mi>f</mi><mi>&#xFC;</mi><mi>r</mi><mo>&#xA0;</mo><mi>&#x3B5;</mi><mo>&gt;</mo><mn>0</mn></math></td>
    <td class="tg-s268"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>T</mi><mo>(</mo><mi>n</mi><mo>)</mo><mo>&#xA0;</mo><mo>=</mo><mo>&#xA0;</mo><mi>&#x398;</mi><mo>(</mo><msup><mi>n</mi><mrow><msub><mi>log</mi><mi>b</mi></msub><mi>a</mi></mrow></msup><mo>)</mo></math></td>
  </tr>
  <tr>
    <td class="tg-s268">2</td>
    <td class="tg-s268"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>f</mi><mo>(</mo><mi>n</mi><mo>)</mo><mo>&#xA0;</mo><mo>=</mo><mo>&#xA0;</mo><mi>&#x398;</mi><mo>(</mo><msup><mi>n</mi><mrow><msub><mi>log</mi><mi>b</mi></msub><mi>a</mi></mrow></msup><mo>)</mo></math>
</td>
    <td class="tg-s268">
    <math xmlns="http://www.w3.org/1998/Math/MathML"><mi>T</mi><mo>(</mo><mi>n</mi><mo>)</mo><mo>&#xA0;</mo><mo>=</mo><mo>&#xA0;</mo><mi>&#x398;</mi><mo>(</mo><msup><mi>n</mi><mrow><msub><mi>log</mi><mi>b</mi></msub><mi>a</mi></mrow></msup><mi>log</mi><mo>&#xA0;</mo><mi>n</mi><mo>)</mo></math>
    </td>
  </tr>
  <tr>
    <td class="tg-0lax">3</td>
    <td class="tg-0lax">
    <math xmlns="http://www.w3.org/1998/Math/MathML"><mi>f</mi><mo>(</mo><mi>n</mi><mo>)</mo><mo>&#xA0;</mo><mo>=</mo><mo>&#xA0;</mo><mi>&#x3A9;</mi><mo>(</mo><msup><mi>n</mi><mrow><msub><mi>log</mi><mi>b</mi></msub><mi>a</mi><mo>+</mo><mi>&#x3B5;</mi></mrow></msup><mo>)</mo><mo>&#xA0;</mo><mi>f</mi><mi>&#xFC;</mi><mi>r</mi><mo>&#xA0;</mo><mi>&#x3B5;</mi><mo>&gt;</mo><mn>0</mn></math></td>
    <td class="tg-0lax"></td>
  </tr>
</table>
