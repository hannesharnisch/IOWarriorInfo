#############
set title "Spannungsabfall eines Kondensators"
set xlabel "Zeit in ms"
set ylabel "Spannung in mV"
set style line 1 lc rgb '#0060ad' lt 1 lw 2 pt 7 ps 2   
set style line 2 lc rgb '#dd181f' lt 1 lw 2 pt 7 ps 1
set terminal png size 2200,1600 enhanced enhanced font "Arial,20"
set output 'Kondensator.png'
f(x)= a*exp(-(x/b))
a=1400
b=10000
fit f(x) "Kondensatorabfall.txt" via a,b
g(x)= 1358.2*exp(-(x/7600))
h(x)= 1358.2*exp(-(x/12600))
plot "Kondensatorabfall.txt" title "Kondensatorabfall" with linespoints ls 2, f(x) title "Fitting Funktion: f(x)= a*exp(-(x/b))" ls 1
#g(x) title "Min Abweichung" , h(x) title "Max Abweichung"
#############