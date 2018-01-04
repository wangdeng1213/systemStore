<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
    <title>标的种类信息</title>
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
    <link href="/static/css/bootstrap/2.3.2/jquery-ui-timepicker-addon.css" type="text/css" />
    <link type="text/css" href="http://code.jquery.com/ui/1.9.1/themes/smoothness/jquery-ui.css" rel="stylesheet" />
    <link href="/static/css/bootstrap/2.3.2/jquery-ui-timepicker-addon.css" type="text/css" />
    <link href="/static/css/bootstrap/2.3.2/demos.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container-fluid">
		<form:form cssClass="form-horizontal" modelAttribute="productTypeModel"
			method="POST" action="/productType/add" id="productTForm">
			<form:input path="id" value="${id}"  />
			<fieldset>
				<legend>
					新增标的种类信息
				</legend>
				<form:errors cssStyle="color:red" path="*" />

				<div class="control-group">
					<label class="control-label" >
						标的种类编号:
					</label>
					<div class="controls">
						<form:input path="product_type_code" placeholder="英文字母如:Z"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">
						标的种类名称:
					</label>
					<div class="controls">
						<form:input path="product_type_name" placeholder="标的种类名称:债权"/>
						 <div id="msgchChooseId"></div>
						<button type="button" class="btn btn-primary" onclick="chooseMsg()">
                            							请选择
                            						</button>
					</div>
				</div>

				<div class="control-group">
					<label class="control-label"></label>
					<div class="controls">
						<button type="submit" class="btn btn-primary">
							提交
						</button>
						<button type="button" class="btn btn-primary" onclick="history.go(-1)">返回</button>
					</div>
				</div>
			</fieldset>
		</form:form>
	</div>

	<script type="text/javascript">
        $(document).ready(function(){
            $("#productTForm").validate({
               rules:{
               product_type_code: "required",
               product_type_name: "required"
               },
               messages:{
               product_type_code: "请您输入标的种类编号",
               product_type_name: "请您输入标的种类名称"
               }

            });
         });
         	function chooseMsg(){
         	   var chooseMsgDialog = null;
         	    jQuery("#msgchChooseId").html("<iframe id='sumIFrame' src='/productType/add' height='80%' width='100%' frameborder='0' style='padding: 0px;margin: 0px' ></iframe>");

         		if(chooseMsgDialog==null){
         			chooseMsgDialog = jQuery("#msgchChooseId").dialog({
                        autoOpen : false,
         				title : "信息",
         				width : 720,
         				height : 500,
         				resizable : true,
         				position : "center",
         				modal : false

         			});
         		}
         		chooseMsgDialog.dialog("open");
         		jQuery("#msgchChooseId").css({
         			height : "470px"
         	    });
         	}

	</script>


</body>