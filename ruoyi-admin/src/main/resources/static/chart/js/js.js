 $(window).load(function(){$(".loading").fadeOut()})  
$(function () {
//#3a87a6
echarts_2()
echarts_3()
    echarts_4()
    echarts_5()
    echarts_6()

    function echarts_2() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('echart2'));

        // 发起 jQuery Ajax 请求获取数据
        $.ajax({
            type: "GET",
            url: "/echart2",
            dataType: "json",
            success: function(response) {
                // 请求成功后更新数据
                console.log(response)
                var data = response.data;
                var titlename = response.titlename;

                option = {
                    grid: {
                        left: '0',
                        top: '0',
                        right: '0',
                        bottom: '0%',
                        containLabel: true
                    },
                    xAxis: {
                        show: false
                    },
                    yAxis: [{
                        show: true,
                        data: titlename,
                        inverse: true,
                        axisLine: { show: false },
                        splitLine: { show: false },
                        axisTick: { show: false },
                        axisLabel: {
                            textStyle: {
                                color: '#fff'
                            },
                        },
                    }, {
                        show: false,
                        inverse: true,
                        data: data,
                        axisLabel: { textStyle: { color: '#fff' } },
                        axisLine: { show: false },
                        splitLine: { show: false },
                        axisTick: { show: false },
                    }],
                    series: [{
                        name: '条',
                        type: 'bar',
                        yAxisIndex: 0,
                        data: data,
                        barWidth: 15,
                        itemStyle: {
                            normal: {
                                barBorderRadius: 50,
                                color: '#1089E7',
                            }
                        },
                        label: {
                            normal: {
                                show: true,
                                position: 'right',
                                formatter: '{c}',
                                textStyle: { color: 'rgba(255,255,255,.5)' }
                            }
                        },
                    }]
                };
                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);
                window.addEventListener("resize", function() {
                    myChart.resize();
                });
            },
            error: function(xhr, status, error) {
                console.error("Error occurred while fetching data:", error);
            }
        });
    }
    function echarts_3() {
        var myChart = echarts.init(document.getElementById('echart3'));
        // 初始化echarts实例

        // 发起ajax请求获取数据
        $.ajax({
            url: '/echart3', // 替换成你的后端接口地址
            method: 'GET',
            success: function(response) {
                // 成功获取数据后的处理逻辑
                // 更新echarts图表的数据
                console.log(response)
                myChart.setOption({
                    xAxis: [{
                        data: response.months // 假设后端返回数据中有一个名为months的属性，包含月份数据
                    }],
                    series: [{
                        data: response.orderCounts // 假设后端返回数据中有一个名为orderCounts的属性，包含订单数数据
                    }]
                });
            },
            error: function(xhr, status, error) {
                // 请求失败的处理逻辑
                console.error('Failed to fetch data:', error);
            }
        });

        // 其他配置项和数据
        var option = {
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    lineStyle: {
                        color: '#dddc6b'
                    }
                }
            },
            grid: {
                left: '10',
                top: '20',
                right: '30',
                bottom: '10',
                containLabel: true
            },
            xAxis: [{
                type: 'category',
                boundaryGap: false,
                axisLabel: {
                    textStyle: {
                        color: "rgba(255,255,255,.6)",
                        fontSize: 14,
                    },
                },
                axisLine: {
                    lineStyle: {
                        color: 'rgba(255,255,255,.2)'
                    }
                },
                data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月']
            }, {
                axisPointer: { show: false },
                axisLine: { show: false },
                position: 'bottom',
                offset: 20,
            }],
            yAxis: [{
                type: 'value',
                axisTick: { show: false },
                splitNumber: 4,
                axisLine: {
                    lineStyle: {
                        color: 'rgba(255,255,255,.1)'
                    }
                },
                axisLabel: {
                    textStyle: {
                        color: "rgba(255,255,255,.6)",
                        fontSize: 16,
                    },
                },
                splitLine: {
                    lineStyle: {
                        color: 'rgba(255,255,255,.1)',
                        type: 'dotted',
                    }
                }
            }],
            series: [{
                name: '订单数量',
                type: 'line',
                smooth: true,
                symbol: 'circle',
                symbolSize: 5,
                showSymbol: false,
                lineStyle: {
                    normal: {
                        color: 'rgba(31, 174, 234, 1)',
                        width: 2
                    }
                },
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: 'rgba(31, 174, 234, 0.4)'
                        }, {
                            offset: 0.8,
                            color: 'rgba(31, 174, 234, 0.1)'
                        }], false),
                        shadowColor: 'rgba(0, 0, 0, 0.1)',
                    }
                },
                itemStyle: {
                    normal: {
                        color: '#1f7eea',
                        borderColor: 'rgba(31, 174, 234, .1)',
                        borderWidth: 5
                    }
                },
                data: [3, 6, 3, 6, 3, 9, 3, 12, 6, 8, 3, 5, 9, 3]
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);

        // 监听窗口大小变化事件，动态调整图表尺寸
        window.addEventListener("resize", function() {
            myChart.resize();
        });
    }

    function echarts_4() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('echart4'));

        // 发起 AJAX 请求获取后端数据
        $.ajax({
            type: "GET",
            url: "/echart5", // 后端接口地址
            success: function(response) {
                // 后端返回的数据
                var data1 = response.data1; // 日期数据
                var data2 = response.data2; // 登录次数数据

                // 配置项
                var option = {
                    grid: {
                        left: '0',
                        top: '30',
                        right: '0',
                        bottom: '10',
                        containLabel: true
                    },
                    legend: {
                        top: 0,
                        textStyle: {
                            color: "#fff",
                        },
                        itemWidth: 10,
                        itemHeight: 10,
                    },
                    tooltip: {
                        trigger: 'axis',
                        axisPointer: {
                            type: 'shadow'
                        }
                    },
                    xAxis: {
                        type: 'category',
                        data: data1, // 使用从后端获取的日期数据
                        axisTick: {
                            show: true,
                        },
                        axisLine: {
                            show: true,
                            lineStyle: {
                                color: 'rgba(255,255,255,.1)',
                                width: 1,
                                type: 'dotted',
                            },
                        },
                        axisLabel: {
                            textStyle: {
                                fontSize: 12,
                                color: '#fff'
                            },
                        },
                    },
                    yAxis: {
                        type: 'value',
                        splitLine: {
                            show: true,
                            lineStyle: {
                                color: 'rgba(255,255,255,.1)',
                                width: 1,
                                type: 'dotted'
                            }
                        },
                        axisLabel: {
                            formatter: '{value}',
                            textStyle: {
                                fontSize: 12,
                                color: '#fff'
                            },
                        },
                        axisLine: {
                            show: false,
                        },
                    },
                    series: [{
                        type: 'bar',
                        data: data2, // 使用从后端获取的登录次数数据
                        barWidth: 15,
                        barGap: 1,
                        itemStyle: {
                            normal: {
                                barBorderRadius: 50,
                                color: "#446ACF",
                            }
                        },
                    }]
                };

                // 使用配置项和数据显示图表
                myChart.setOption(option);
                window.addEventListener("resize",function(){
                    myChart.resize();
                });
            },
            error: function(xhr, status, error) {
                console.error("AJAX请求失败: " + status + ", " + error);
            }
        });
    }
    function echarts_5() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('echart5'));
        option = {
            legend: {
                orient: 'vertical',
                itemWidth: 10,
                itemHeight: 10,
                textStyle:{
                    color:'rgba(255,255,255,.5)'
                },
                top:'20%',
                right:30,
                data:['蔬果类','冷冻类','生鲜类','速食类','其他']
            },
            color: ['#37a2da','#32c5e9','#9fe6b8','#ffdb5c','#ff9f7f','#fb7293','#e7bcf3','#8378ea'],
            tooltip : {
                trigger: 'item',
                formatter: "{b} : {c} ({d}%)"
            },

            calculable : true,
            series : [
                {

                    type:'pie',
                    radius : [20, 70],
                    center: ["35%", "50%"],
                    roseType : 'area',
                    data:[
                        {value:300, name:'蔬果类'},
                        {value:200, name:'冷冻类'},
                        {value:205, name:'生鲜类'},
                        {value:205, name:'速食类'},

                        {value:180, name:'其他'},

                    ],
                    label: {
                        normal: {
                            formatter: function(param) {
                                return param.name +':\n' + param.value +'\n';
                            }

                        }
                    },
                    labelLine: {
                        normal: {
                            length:5,
                            length2:15,
                            lineStyle: { width: 1}
                        }
                    },

                    itemStyle: {
                        normal: {
                            shadowBlur: 30,
                            shadowColor: 'rgba(0, 0, 0, 0.4)'
                        }

                    },
                }
            ]
        };
        myChart.setOption(option);
        window.addEventListener("resize",function(){
            myChart.resize();
        });
    }
    function echarts_6() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('echart6'));
        const data = [
            [5000, 10000, 6785.71],
            [4000, 10000, 6825],
            [3000, 6500, 4463.33],
            [2500, 5600, 3793.83],
            [2000, 4000, 3060],
            [2000, 4000, 3222.33],
            [2500, 4000, 3133.33],
            [1800, 4000, 3100],
            [2000, 3500, 2750],
            [2000, 3000, 2500],
            [1800, 3000, 2433.33],
            [2000, 2700, 2375],
            [1500, 2800, 2150],
            [1500, 2300, 2100],
            [1600, 3500, 2057.14],
            [1500, 2600, 2037.5],
            [1500, 2417.54, 1905.85],
            [1500, 2000, 1775],
            [1500, 1800, 1650]
        ];
// prettier-ignore
        const cities = ['北京', '上海', '深圳', '广州', '苏州', '杭州', '南京', '福州', '青岛', '济南', '长春', '大连', '温州', '郑州', '武汉', '成都', '东莞', '沈阳', '烟台'];
        const barHeight = 50;
        option = {
            title: {
                text: 'How expensive is it to rent an apartment in China?',
                subtext: 'Data from https://www.numbeo.com'
            },
            legend: {
                show: true,
                top: 'bottom',
                data: ['Range', 'Average']
            },
            grid: {
                top: 100
            },
            angleAxis: {
                type: 'category',
                data: cities
            },
            tooltip: {
                show: true,
                formatter: function (params) {
                    const id = params.dataIndex;
                    return (
                        cities[id] +
                        '<br>Lowest：' +
                        data[id][0] +
                        '<br>Highest：' +
                        data[id][1] +
                        '<br>Average：' +
                        data[id][2]
                    );
                }
            },
            radiusAxis: {},
            polar: {},
            series: [
                {
                    type: 'bar',
                    itemStyle: {
                        color: 'transparent'
                    },
                    data: data.map(function (d) {
                        return d[0];
                    }),
                    coordinateSystem: 'polar',
                    stack: 'Min Max',
                    silent: true
                },
                {
                    type: 'bar',
                    data: data.map(function (d) {
                        return d[1] - d[0];
                    }),
                    coordinateSystem: 'polar',
                    name: 'Range',
                    stack: 'Min Max'
                },
                {
                    type: 'bar',
                    itemStyle: {
                        color: 'transparent'
                    },
                    data: data.map(function (d) {
                        return d[2] - barHeight;
                    }),
                    coordinateSystem: 'polar',
                    stack: 'Average',
                    silent: true,
                    z: 10
                },
                {
                    type: 'bar',
                    data: data.map(function (d) {
                        return barHeight * 2;
                    }),
                    coordinateSystem: 'polar',
                    name: 'Average',
                    stack: 'Average',
                    barGap: '-100%',
                    z: 10
                }
            ]
        };
        myChart.setOption(option);
        window.addEventListener("resize",function(){
            myChart.resize();
        });
    }
})



		
		
		


		









