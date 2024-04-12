 $(window).load(function(){$(".loading").fadeOut()})  
$(function () {

echarts_2()
echarts_3()


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


})



		
		
		


		









