#############
set title "Spannungsabfall eines Kondensators"
set xlabel "Zeit in ms"
set ylabel "Spannung in mV"
#set terminal png size 2000,1600 enhanced
#set output 'Kondensator.png'
f(x)= a*exp(-(x/b))
a=1400
b=10000
fit f(x) "Kondensatorabfall.txt" via a,b
g(x)= 1358.2*exp(-(x/7600))
h(x)= 1358.2*exp(-(x/12600))
plot "Kondensatorabfall.txt" title "Ungenauigkeit" with linespoints, f(x) title "Fitting Funktion: f(x)= a*exp(-(x/b))" , g(x) title "Min Abweichung" , h(x) title "Max Abweichung"
#############