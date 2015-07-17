<html>
<script src="js/jquery-1.8.0.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function(){
		$.ajax({
			"url":"login/test.html",
			"dataType":"json",
			"type":"post",
			"success":function(data){
				alert(data.result);
			}
		});
	});
</script>
<body>
<h2>login Hello World!</h2>
</body>
</html>
