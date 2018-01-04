    $(document).ready(function(){
        $('#repaymentDate').datepicker({
        format:'yyyy-mm-dd',
        minDate: 0
        });
        $('#profitTime').datetimepicker({
        timeFormat: "HH:mm:00",
        dateFormat: "yy-mm-dd",
        minDate: 0
        });
        $('#preTime').datetimepicker({
        timeFormat: "HH:mm:00",
        dateFormat: "yy-mm-dd",
        minDate: 0
        });
        $('#startTime').datetimepicker({
        timeFormat: "HH:mm:00",
        dateFormat: "yy-mm-dd",
        minDate: 0
        });
        $('#endTime').datetimepicker({
        timeFormat: "HH:mm:00",
        dateFormat: "yy-mm-dd",
        minDate: 0
        });
        $('#borrower_rep_time').datepicker({
         dateFormat: "yy-mm-dd",
         minDate: 0
        });
        $('#borrower_bor_time').datepicker({
         dateFormat: "yy-mm-dd",
         maxDate: 0
        });
        $("#verifyTime").datetimepicker({
        timeFormat: "HH:mm:ss",
        dateFormat: "yy-mm-dd",
        minDate: 0
        });
        showCont();
        $("input[type=radio]").click(function(){
        showCont();
        });
        //当最小投资金额失去焦点时
        $("#t1").blur(function(){
           var minMoney = $("#t1").val();
           if(minMoney== null|| minMoney == ''){
              alert("请您输入最小投资金额！");
           }else{
             //匹配正整数
              var pat =  /^[0-9]*[1-9][0-9]*$/;
              if(!pat.test(minMoney)){
                alert("最小投资金额必须为整数，请您重新输入！");
                $("t1").focus();
                return false;
              }
           }
        });
        //投资开始时间失去焦点时
        $("#startTime").blur(function(){
           //投资开始时间
           var startTime = $("#startTime").val();
           //预发布时间
           var preTime = $("#preTime").val();
           if(preTime > startTime){
               alert("预发布时间必须要小于投标开始时间，请您重新输入");
               return false;
           }
        });
        //投资结束时间失去焦点时
        $("#endTime").blur(function(){
           //投资开始时间
           var startTime = $("#startTime").val();
           //投资结束时间
           var endTime = $("#endTime").val();
           if(startTime > endTime){
               alert("投标开始时间必须要小于投标结束时间，请您重新输入");
               return false;
           }
          var day = daysAnd(endTime,30);
          jQuery("#profitTime").val(day);
        });
        //锁标结束时间
        $("#overTime").focus(function(){
        var endTime = jQuery("#endTime").val();
        if(endTime == ''|| endTime == null){
           alert("请您输入投资结束时间");
            $("#endTime").focus();
            return false;
        }
        var overTerm = jQuery("#overTerm").val();
        if(overTerm=='' || overTerm == null){
          alert("请您输入锁标期");
          $("#overTerm").focus();
          return false;
        }else{
          //匹配正整数
         var pat =  /^[0-9]*[1-9][0-9]*$/;
         var overTerm = jQuery("#overTerm").val();
         if(!pat.test(overTerm/15)){
          alert("锁标期不能少于30天，并且必须为15的整数倍，请您重新输入");
          $("#overTerm").focus();
           return false;
         }
         var day = daysAnd(endTime,overTerm);
         jQuery("#overTime").val(day);
        }
        });
        //每份价值
        $("#p2").blur(function(){
        var ze = $("#to").val();
        var mf = $("#p2").val();
            if(ze==null||ze==''){
                           alert("请您输入标的总额");
                           $("#to").focus();
                           return false;
              }
            if(mf==null||mf==''){
                           alert("请您输入每份价值");
                           $("#p2").focus();
                           return false;
              }
        //匹配正整数
        var pat =  /^[1-9]*[1-9][0-9]*$/;
        var pt = ze/mf ;
        if(!pat.test(pt)){
         alert("请您重新输入每份价值，每份价值必须被标的总额整除！");
         $("#p2").focus();
         return false;
        }
         jQuery("#pt").val(pt);

        });
        //当得到焦点时
        $("#loanTerm").focus(function(){
         var date1 = $("#borrower_rep_time").val();
         var date2 = $("#borrower_bor_time").val();
         if(date2==null||date2==''){
           alert("请您选择借款人借款时间");
           $("#borrower_bor_time").focus();
           return false;
         }
         if(date1==null||date1==''){
           alert("请您选择借款人还款时间");
           $("#borrower_rep_time").focus();
           return false;
         }
         var days = daysBetween(date1,date2);
         jQuery("#loanTerm").val(days);
        });
        //锁标期失去焦点的时候
        jQuery("#overTerm").blur(function(){
              //得到标的总额的值 （标的总额*年华收益率）/12*锁标期
              var tm = jQuery("#to").val();
              //得到年化收益率的值
              var nh = jQuery("#yearRate").val();
              //得到锁标期的值
              var sbq = jQuery("#overTerm").val();
             //判断标的总额
               var paten = /^[1-9]*[1-9][0-9]*$/;
                if(!paten.test(tm)){
                  alert("请您重新输入标的总额，标的总额应为整数");
                  jQuery("#to").focus();
                  return false;
                }

              //收益总额公式
             var syze = (tm*(nh/100))/12*(sbq/30) ;
             //给收益总额赋值
             jQuery("#profitMoney").val(syze);
          });

        //当待还本息获得焦点时
        $("#tpay").focus(function(){
        //得到收益总额的值
        var profitMoney = $("#profitMoney").val();
        var bdze;
        //得到标的总额的值
         bdze = $("#to").val();

        //管理费
        var tfee = $("#tfee").val();
        if(tfee == null || tfee == ''){
          tfee == 0;
        }
        //手续费
        var mfee = $("#mfee").val();
        if(mfee == null || mfee == ''){
          mfee == 0;
        }
        //违约金
        var odd = $("#odd").val();
        if(odd == null || odd == ''){
          odd == 0;
        }
        //待还本息的值
        var tpay = profitMoney + bdze + tfee + mfee + odd;
        jQuery("tpay").val(tpay);
        });

        });

        function showCont(){
        switch($("input[type=radio]:checked").attr("id")){
        case "buy_type1":
            $("#total1").hide();
            $("#total2").hide();
            $("#product1").show();
            $("#product2").show();
            break;
        case "buy_type2":
            $("#product1").hide();
            $("#product2").hide();
            $("#total1").show();
            $("#total2").show();
            break;
        default:
            break;
        }
    }

    function vali(){
        if($('#productName').val()==null||$('#productName').val()==''){
        alert("标的名称不能为空，请您输入标的名称！");
        $('#productName').focus();
        return false;
        }
        if($('#repaymentDate').val()==null||$('#repaymentDate').val()==''){
        alert("还款日期不能为空，请您输入还款日期！");
        $('#repaymentDate').focus();
        return false;
        }

        if($('#profitTime').val()==null||$('#profitTime').val()==''){
        alert("应付收益时间不能为空，请您输入应付收益时间！");
        $('#profitTime').focus();
        return false;
        }
        if($('#preTime').val()==null||$('#preTime').val()==''){
        alert("预发布时间不能为空，请您输入预发布时间！");
        $('#preTime').focus();
        return false;
        }
        //投资开始时间
        if($('#startTime').val()==null||$('#startTime').val()==''){
        alert("投标开始时间不能为空，请您输入投标开始时间！");
        $('#startTime').focus();
        return false;
        }
        //投资结束时间
        if($('#endTime').val()==null||$('#endTime').val()==''){
        alert("投标结束时间不能为空，请您输入投标结束时间！");
        $('#endTime').focus();
        return false;
        }else {
        var startNumber = parseInt($('#startTime').val().replace(/-/g, ''), 10);
        var endNumber = parseInt($('#endTime').val().replace(/-/g, ''), 10 );
        if(startNumber > endNumber){
        alert("投标结束时间必须要大于投标开始时间，请重新输入投标结束时间！");
        $('#endTime').focus();
        return false;
        }
        }

        //年利率
        var yearRate = $.trim($("#yearRate").val());
        if(yearRate==null || yearRate==''||yearRate<=0 || yearRate>100){
          $("#s_msg").show();
          $("#yearRate").focus();
          return false;
        }else{
           $("#s_msg").hide();
        }
        if($("#buy_type1").attr("checked")==true && ($('#to').val()==null||$('#to').val()=='')){
        alert("标的总额不能为空，请您输入标的总额！");
        $('#to').focus();
        return false;

        }

        if($("#buy_type1").attr("checked")==true && ($('#p2').val()==null||$('#p2').val()=='')){
        alert("每份价值不能为空，请您输入每份价值！");
        alert($("#buy_type2").attr("checked"));
        alert();
        $('#p2').focus();
        return false;
        }

        if($("#buy_type2").attr("checked")==true && ($('#t2').val()==null||$('#t2').val()=='')){
        alert("最小投资金额不能为空，请您输入最小投资金额！");
        $('#t2').focus();
        return false;
        }


        if($('#borrower_bor_time').val()==null||$('#borrower_bor_time').val()==''){
        alert("借款人借款时间不能为空，请您输入借款人借款时间！");
        $('#borrower_bor_time').focus();
        return false;
        }
        if($('#borrower_rep_time').val()==null||$('#borrower_rep_time').val()==''){
        alert("借款人还款时间不能为空，请您输入借款人还款时间！");
        $('#borrower_rep_time').focus();
        return false;
        }else{
        var startNumber1 = parseInt($('#borrower_bor_time').val().replace(/-/g, ''), 10);
        var endNumber1 = parseInt($('#borrower_rep_time').val().replace(/-/g, ''), 10 );
        if(startNumber1 > endNumber1){
        alert("借款人还款时间必须要大于借款人借款时间，请重新输入借款人还款时间！");
        $('#borrower_rep_time').focus();
        return false;
        }
        }
        return true;
    }

        //获取两个时间的天数差
    function daysBetween(DateOne,DateTwo){
        var OneMonth = DateOne.substring(5,DateOne.lastIndexOf ('-'));
        var OneDay = DateOne.substring(DateOne.length,DateOne.lastIndexOf ('-')+1);
        var OneYear = DateOne.substring(0,DateOne.indexOf ('-'));

        var TwoMonth = DateTwo.substring(5,DateTwo.lastIndexOf ('-'));
        var TwoDay = DateTwo.substring(DateTwo.length,DateTwo.lastIndexOf ('-')+1);
        var TwoYear = DateTwo.substring(0,DateTwo.indexOf ('-'));
        var cha=((Date.parse(OneMonth+'/'+OneDay+'/'+OneYear)- Date.parse(TwoMonth+'/'+TwoDay+'/'+TwoYear))/86400000);
        return Math.abs(cha);
    }
        //获取两个时间之和
    function daysAnd(endDate,day){
        var endDate = endDate.split("-");
        var nDate = new Date(endDate[0] + '-' + endDate[1] + '-' + endDate[2]); //转换为MM-DD-YYYY格式
        var millSeconds = Math.abs(nDate) + (day * 24 * 60 * 60 * 1000);
        var rDate = new Date(millSeconds);
        var year = rDate.getFullYear();
        var month = rDate.getMonth() + 1;
        if (month < 10) month = "0" + month;
        var date = rDate.getDate();
        if (date < 10) date = "0" + date;
        var hh = rDate.getHours();
        if (hh < 10) hh = "0"+ hh;
        var mm = rDate.getMinutes();
        if (mm < 10) mm = "0"+ mm;
        var ss = rDate.getSeconds();
        if(ss < 10) ss = "0"　+　ss;
        return (year + "-" + month + "-" + date + " " +hh +":"+mm+":"+ss);
    }
