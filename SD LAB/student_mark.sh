#awk -F ","  'total=$4+$5+$6+$7+$8+$9 , mean=total/7 { print $1 "," $2 "," $3 "," $4 "," $5 "," $6 "," $7 "," $8 "," $9 "," $10 "," total "," mean }' student_mark.csv

mean=0
gtotal=0


#to find total
while IFS="," read -r roll admno roll sub1 sub2 sub3 sub4 sub5 sub6 sub7 total mean; do 

gtotal=$((gtotal+$total))
	
done < t.csv 
suma=0

meana=$((gtotal/2))

#to find Standard diviation
while IFS="," read -r roll admno roll sub1 sub2 sub3 sub4 sub5 sub6 sub7 total mean; do 

suma=$((suma+($total-meana)*($total-meana)))
	
done < t.csv 
var=$((suma/2))
sd=$(bc <<< "scale=2; sqrt($var)")

echo $sd 
echo $var 
echo $meana
echo $gtotal


#to find grade
while IFS="," read -r roll admno roll sub1 sub2 sub3 sub4 sub5 sub6 sub7 total mean; do 

ga=$((meana+2*sd))
gb=$((meana+sd))
gc=$((meana))
gd=$((meana+2*sd))
ge=$((meana+2*sd))


if [[  ]]
	
done < t.csv 


