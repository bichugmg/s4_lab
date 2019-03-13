awk -F ","  'total=$4+$5+$6+$7+$8+$9 , mean=total/7 { print $1 "," $2 "," $3 "," $4 "," $5 "," $6 "," $7 "," $8 "," $9 "," $10 "," total "," mean }' student_mark.csv > t.csv

mean=0
gtotal=0
a=0
b=0
c=0
d=0
e=0
f=0

#to find total
while IFS="," read -r roll admno roll sub1 sub2 sub3 sub4 sub5 sub6 sub7 total mean; do 

gtotal=$((gtotal+$total))
	
done < t.csv 
suma=0

meana=$((gtotal/28))

#to find Standard diviation
while IFS="," read -r roll admno roll sub1 sub2 sub3 sub4 sub5 sub6 sub7 total mean; do 

suma=$((suma+($total-meana)*($total-meana)))
	
done < t.csv 
var=$((suma/28))
sd=$(bc <<< "scale=2; sqrt($var)")

echo $meana
echo $sd



#to find grade
while IFS="," read -r roll admno roll sub1 sub2 sub3 sub4 sub5 sub6 sub7 total mean; do 

ga=$(bc <<< "scale=2; $meana+2*$sd")
gb=$(bc <<< "scale=2; $meana+$sd")
gc=$(bc <<< "scale=2; $meana")
gd=$(bc <<< "scale=2; $meana-$sd")
ge=$(bc <<< "scale=2; $meana-2*$sd")

if [[ ${total%%.*} -gt ${ga%%.*} ]]
then
a=$((a+1))

elif [[ ${total%%.*} -gt ${gb%%.*} && ${total%%.*} -lt ${ga%%.*} ]]
then
b=$((b+1))

elif [[ ${total%%.*} -gt ${gc%%.*} && ${total%%.*} -lt ${gb%%.*} ]]
then
c=$((c+1))

elif [[ ${total%%.*} -gt ${gd%%.*} && ${total%%.*} -lt ${gc%%.*} ]]
then
d=$((d+1))

elif [[ ${total%%.*} -gt ${ge%%.*} && ${total%%.*} -lt ${gd%%.*} ]]
then
e=$((e+1))

elif [[ ${total%%.*} -lt ${ge%%.*} ]]
then
f=$((f+1))

fi

done < t.csv 
grade=($a $b $c $d $e $f)
gradea=(A B C D E F)
i=0
j=0
while [ $j -lt 6 ]
do
g=${grade[j]}

i=0

printf ${gradea[j]}
printf "  |"
while [ $i -lt  $g ]
do
printf " *"

i=$((i+1))
done
j=$((j+1))
echo ""
printf "   |"
echo ""
done

