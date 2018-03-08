

# IOWarrior Projekt

## How to run project

1. download the i4k file and the Code
2. export projekt as a jar file
3. execute the following commands on the Command line:

```
export LD_LIBRARY_PATH=/home/student/:$LD_LIBRARY_PATH
```

run projekt with:

```
/usr/lib/jvm/java-1.8.0-openjdk-amd64/bin/java -jar test.jar
```

or:

```
/usr/lib/jvm/java-1.8.0-openjdk-amd64/bin/java -jar test.jar > Kondensatorabfall.txt
```

Do this command to plot the graph with gnuplot.
Open Gnuplot and load the script


## Beweis Tau (RC) hat Einheit Sekunden

U(t) = U0 * e ^ -t/RC

Tau = R * C
R = 1 Ohm = 1V/A = 1 kg*m²/A²*s³
C = 1 F = 1 A²*s⁴/kg*m²

---
Tau = 1 kg*m²*A²*s⁴/A²*s³*kg*m² = 1 s


## Liegt Graph innerhalb der Abweichungsgrenzen?

- 20% abweichung am Kondensator
- 5% am Wiederstand
---
Todo: min, max ausrechnen und mit richtigem Wert verwenden

