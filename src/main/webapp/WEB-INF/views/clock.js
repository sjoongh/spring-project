	const clock = document.getElementById("clock");

	function getClock() {
	    const date = new Date();
	    clock.innerText = 'Today Date : '+date.getFullYear()+'년'+
	    (date.getMonth()+1)+'월'+date.getDate()+'일';
	}
	getClock();
	setInterval(getClock, 1000);