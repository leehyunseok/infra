<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="jqGrid/css/jquery-ui-1.10.4.custom.min.css">
<link rel="stylesheet" type="text/css" href="jqGrid/css/ui.jqgrid.css"> 
<script type="text/javascript" src="jqGrid/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="jqGrid/js/i18n/grid.locale-kr.js"></script>
<script type="text/javascript" src="jqGrid/js/jquery.jqGrid.min.js"></script>
<script>
		
$(window.document).ready( function() {
	
	$('#list').jqGrid( {
		url:'http://localhost:8080/infra/jsonViewObject.infra',
		datatype:'json',
		mtype:'get',
		colNames:["언어","부서"],
		colModel:[
		          {name:'name',index:'name'},
		          {name:'depat',index:'depat'}
		          ],
		caption:'타이틀',
		autowidth:true,
		jsonReader: {
			repeatitems:false,
			id   : "rank",
			root : function(obj) {return obj.grid ; },
			page : function(obj) { return 1 ;},
			total : function(obj) {return 1 ;},
			records : function(obj) {return obj.grid.length ;}
			
		}
	});
	
}
		
) ;		
		


</script>
</head>

<body>

	<table id="list"></table>
	</br>
	</br>
	<a href="http://localhost:8080/infra/jsonViewObject.infra">jsonData</a> </br>
	<a href="http://apis.daum.net/socialpick/search?output=json">다음소셜픽</a> </br>
	<a href="http://localhost:8080/infra/jqGrid.infra?type=jsonp">소셜픽그리드</a> </br>

</body>
