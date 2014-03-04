<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="application/json; charset=UTF-8" />
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
    <script src="http://code.highcharts.com/highcharts.js"></script>

</head>
<body>

<div id="container" style="width:100%; height:400px;"></div>

<script type="text/javascript">

    $(document).ready(function() {
        var options = {
            chart: {
                type: 'bar'
            },
            title: {
                text: 'Fruit Consumption'
            },
            xAxis: {
                categories: ['Apples', 'Bananas', 'Oranges']
            },
            yAxis: {
                title: {
                    text: 'Fruit eaten'
                }
            },
            series: [{},{}]
        } ;

        var url =  "http://localhost:8080/infra/jsonViewChart";

        $.getJSON(url,  function(data) {
            options.series[0].name = data.grid[0].name;
            options.series[0].data = data.grid[0].data;

            options.series[1].name = data.grid[1].name;
            options.series[1].data = data.grid[1].data;

            $('#container').highcharts(options);
        });
    });

</script>

</body>
</html>