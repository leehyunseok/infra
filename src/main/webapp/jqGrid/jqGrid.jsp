<head>

<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.4.custom.min.css">
<link rel="stylesheet" type="text/css" href="css/ui.jqgrid.css"> 
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/i18n/grid.locale-kr.js"></script>
<script type="text/javascript" src="js/jquery.jqGrid.min.js"></script>
<script>
		
$(window.document).ready( function() {
	
	$('#list').jqGrid( {
		url:'http://apis.daum.net/socialpick/search?output=json',
		datatype:'jsonp',
		mtype:'get',
		colNames:["순위","링크","키워드"],
		colModel:[
		          {name:'rank',index:'rank'},
		          {name:'link',index:'link'},
		          {name:'keyword',index:'keyword'}
		          ],
		caption:'íì¤í¸',
		autowidth:true,
		jsonReader: {
			repeatitems:false,
			id   : "rank",
			root : function(obj) {return obj.socialpick.item ; },
			page : function(obj) { return 1 ;},
			total : function(obj) {return 1 ;},
			records : function(obj) {return obj.socialpick.item.length ;}
			
		}
	});
	
}
		
) ;		
		


</script>
</head>

<body>

	<table id="list"></table>

</body>
