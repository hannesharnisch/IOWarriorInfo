#############
set title "Spannungsabfall eines Kondensators"
set xlabel "Zeit in ms"
set ylabel "Spannung in mV"
set style line 1 lc rgb '#0060ad' lt 1 lw 2 pt 7 ps 2   
set style line 2 lc rgb '#dd181f' lt 1 lw 2 pt 7 ps 1
set terminal png size 2000,1600 enhanced
set output 'KondensatorimAbweichungsbereich.png'
g(x)= 1396.484375*exp(-(x/10000))
f(x)= a*exp(-(x/b))
a=1400
b=10000
fit f(x) "Kondensatorabfall.txt" via a,b
plot "Kondensatorabfall.txt" using 1:2:(1396.484375*exp(-(($1)/12600))):((1396.484375*exp(-(($1)/7600)))) title "Messwerte mit Max- und Min-Abweichung" w yerrorbars ls 2, f(x) title "Fitting Funktion: f(x)= a*exp(-(x/b))" ls 1

#############