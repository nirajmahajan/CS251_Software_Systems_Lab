#!/bin/bash
out_ref="./testcases/"
script_name="$1"
name_of_File="viewWithColor"
out_dir="./output/"
marks=0;
[[ -d $out_dir ]] || mkdir -p "$out_dir"
if [[ -s $script_name ]];
then
	"$script_name" ./testcases/viewWithoutColor.out ./resources/creditsRequirements.csv > "$out_dir$name_of_File.out" 2>/dev/null
	diff "$out_dir$name_of_File.out" "$out_ref$name_of_File.out" >result
	if [[ -s result ]];
	then
	:
	else
		marks=$(($marks+20));
	fi
	# rm result
	echo -n $marks
	echo -n ","
	
else
	echo -n $marks
	echo -n ","
fi