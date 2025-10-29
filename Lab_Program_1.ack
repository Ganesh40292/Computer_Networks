BEGIN{
		count=0;
	}
{
	event=$1;
	if(event == "d"){count++;}
}

END{
	printf("\nNumber of packet dropped is:%d \n",count);
}
