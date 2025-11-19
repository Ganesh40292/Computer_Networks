BEGIN {

    printf "%-10s %-10s %-10s %-10s\n", "Time", "Src", "Dest", "RTT(ms)"

}



$1 == "s" && $4 == "AGT" {

    key = $8 "-" $9

    send_time[key] = $2

}



$1 == "r" && $4 == "AGT" {

    key = $8 "-" $9

    if (key in send_time) {

        rtt = ($2 - send_time[key]) * 1000

        printf "%-10.3f %-10s %-10s %-10.3f\n", $2, $8, $9, rtt

        delete send_time[key]

    }

}

