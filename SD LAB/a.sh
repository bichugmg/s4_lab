read a
read b
replace=${b^^}
sed -i s/$b/$replace/g $a

