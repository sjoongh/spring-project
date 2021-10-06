<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
		<div id="footer">
			<p>(c)opyright <span id="clock">00:00:00</span></p>
		</div>
<script>
const clock = document.getElementById("clock");

function getClock() {
    const date = new Date();
    clock.innerText = date.getFullYear()+'년'+
    (date.getMonth()+1)+'월'+date.getDate()+'일';
}
getClock();
setInterval(getClock, 1000);
</script>