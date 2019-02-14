read a
read b
c=$((b-a+1))

tail -n +$a t | head -$c
