{
			  data : {
			    datasets : [ {
			      label : "activeUsers",
			      borderColor : "rgba(54, 162, 235, 1.0)",
			      fill : "false",
			      data : [ {
			        x : "2018-01-01",
			        y : 10
			      }, {
			        x : "2018-01-02",
			        y : 1
			      }, {
			        x : "2018-01-03",
			        y : 5
			      }, {
			        x : "2018-01-04",
			        y : 15
			      }, {
			        x : "2018-01-05",
			        y : 21
			      }, {
			        x : "2018-01-06",
			        y : 28
			      }, {
			        x : "2018-01-07",
			        y : 3
			      }, {
			        x : "2018-01-08",
			        y : 7
			      }, {
			        x : "2018-01-09",
			        y : 11
			      }, {
			        x : "2018-01-10",
			        y : 17
			      }, {
			        x : "2018-01-11",
			        y : 27
			      }, {
			        x : "2018-01-12",
			        y : 30
			      }, {
			        x : "2018-01-13",
			        y : 8
			      }, {
			        x : "2018-01-14",
			        y : 23
			      }, {
			        x : "2018-01-15",
			        y : 19
			      }, {
			        x : "2018-01-16",
			        y : 18
			      }, {
			        x : "2018-01-17",
			        y : 25
			      }, {
			        x : "2018-01-18",
			        y : 4
			      } ]
			    } ]
			  },
			  options : {
			    responsive : true,
			    tooltips : {
			      mode : "index",
			      intersect : false
			    },
			    hover : {
			      mode : "nearest",
			      intersect : true
			    },
			    scales : {
			      xAxes : [ {
			        display : true,
			        scaleLabel : {
			          display : true,
			          labelString : "days"
			        },
			        ticks : {
			          min : "2018-01-01"
			        },
			        position : "bottom",
			        type : "time"
			      } ],
			      yAxes : [ {
			        display : true,
			        scaleLabel : {
			          display : true,
			          labelString : "active users"
			        },
			        ticks : { },
			        position : "left",
			        type : "linear"
			      } ]
			    }
			  },
			  type : "line"
			}