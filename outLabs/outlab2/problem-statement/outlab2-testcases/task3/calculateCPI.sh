#!/bin/bash

awk '
BEGIN {
	FS=",";
	RS="\r\n";
	CRED_Sum=0;
	WEI_Sum=0;
}
{
	if(NR == FNR) {
		gradeToScore[$1]=$2;
		next;
	} else {
		CRED_Sum += $5;
		WEI_Sum += ($5 * gradeToScore[$7]);
	}
} 
END {
	printf("%.4f\n",(WEI_Sum / CRED_Sum));
}
' $2 $1
