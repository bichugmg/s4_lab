line_c=0
char_C_c=0
char_S_c=0
char_N_c=0
char_SP_c=0
alpha_c=0
word_cont=0
while read p; do
  for (( i=0; i<${#p}; i++ )); do
	  if [[ "${p:$i:1}" = [a-z] ]]
	  then
		if [[ "${p:$i:1}" != [A-Z] ]]
		  then
			char_S_c=$((char_S_c+1))
		  fi
	  fi
	if [[ "${p:$i:1}" = [A-Z] ]]
	  then
		char_C_c=$((char_C_c+1))
	  fi
	if [[ "${p:$i:1}" = [0-9] ]]
	  then
		char_N_c=$((char_N_c+1))
	  fi
	if [[ "${p:$i:1}" = *['!'@#\$%^\&*()_+.,';'' ']* ]]
	  then
		char_SP_c=$((char_SP_c+1))
	  fi

	if [[ "${p:$i:1}" = " " ]]
	  then
		if [[ "${p:$i+1:1}" != " " ]]
		  then
			word_cont=$((word_cont+1))
		  fi
	  fi
	   char_c=$((char_c+1))
  done
	if [[ ${#p} != 0 ]]
	 then
	    word_cont=$((word_cont+1))
	fi

 line_c=$((line_c+1))
done <t

echo "line count $line_c"
echo "char Small count $char_S_c"
echo "char Capital count $char_C_c"
echo "char numarical count $char_N_c"
echo "char Special count $char_SP_c"
echo "char Word count $word_cont"

echo "alpha count $char_c"
