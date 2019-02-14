read a
read b
file1=`cat $a`
file2=`cat $b`
if [ "$file1" == "$file2" ]
then
cat $b | rev &>> rev

else
tr a-z A-Z < $a &>> capital
fi
