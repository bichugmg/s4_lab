line_c=0
char_c=0
alpha_c=0
while read p; do
  for (( i=0; i<${#p}; i++ )); do
	  if [[ "${p:$i:1}" = [a-z] ]]
	  then
		alpha_c=$((alpha_c+1))
	  fi
	   char_c=$((char_c+1))
  done
 line_c=$((line_c+1))
done <t
echo "line count $line_c"
echo "char count $char_c"
echo "alpha count $alpha_c"
