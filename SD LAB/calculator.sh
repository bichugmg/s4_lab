
RED='\033[0;32m'
NC='\033[0m' # No Color
printf "\033[1;32m CALCULATOR${NC}\n"
printf "\033[0;32m 1 : add${NC}\n"

printf "\033[0;33m 2 : sub${NC}\n"
printf "\033[0;34m 3 : div${NC}\n"
printf "\033[0;35m 4 : mul${NC}\n"
printf "\033[0;36m q : quit${NC}\n"
printf "\033[1;31mchoose your choice${NC}\n"
read c


while [ $c != "q" ]
do
echo "enter two number"
read a
read b

case $c in
"1")
sum=$((a+b))
printf "${RED}result="$sum"${NC} "
;;
"2")
sum=$((a-b))
printf "${RED}result="$sum"${NC} "
;;
"3")
sum=$((a*b))
printf "${RED}result="$sum"${NC} "
;;
"4")
sum=`bc <<< 'scale=2; '$a'/'$b`
printf "${RED}result="$sum"${NC} "
;;
"q")
break
;;
*)
echo "invalid input"
;;
esac
echo -e ""
printf "\033[0;32m 1 : add${NC}\n"

printf "\033[0;33m 2 : sub${NC}\n"
printf "\033[0;34m 3 : div${NC}\n"
printf "\033[0;35m 4 : mul${NC}\n"
printf "\033[0;36m q : quit${NC}\n"
printf "\033[1;31mchoose your choice${NC}\n"
read c
done
