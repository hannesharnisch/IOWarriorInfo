#############
set title "Spannungsabfall eines Kondensators"
set xlabel "Zeit in ms"
set ylabel "Spannung in mV"
f(x)= a*exp(-(x/b))
a=1400
b=10000
fit f(x) "Kondensatorabfall2.txt" via a,b
plot "Kondensatorabfall2.txt" title "Kondensatorspannungsabfall", f(x) title "Fitting Funktion: f(x)= a*exp(-(x/b))"
#############