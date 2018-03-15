#############
set title "Spannungsabfall eines Kondensators"
set xlabel "Zeit in ms"
set ylabel "Spannung in mV"
set terminal png size 2000,1600 enhanced
set output 'Kondensator.png'
f(x)= a*exp(-(x/b))
a=1400
b=10000
fit f(x) "Kondensatorabfall.txt" via a,b
plot "Kondensatorabfall.txt" with linespoints title "Kondensatorspannungsabfall", f(x) title "Fitting Funktion: f(x)= a*exp(-(x/b))"
#############