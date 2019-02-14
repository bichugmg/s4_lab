
b=$1
for var in "$@"
do
if [ $b != $var ]
then
cp $b $var
fi
done
