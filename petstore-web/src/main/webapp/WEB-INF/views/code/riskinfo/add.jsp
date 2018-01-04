<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
    <title>风控信息</title>
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
    <link href="/static/css/bootstrap/2.3.2/jquery-ui-timepicker-addon.css" type="text/css" />
    <link type="text/css" href="http://code.jquery.com/ui/1.9.1/themes/smoothness/jquery-ui.css" rel="stylesheet" />
    <link href="/static/css/bootstrap/2.3.2/jquery-ui-timepicker-addon.css" type="text/css" />
    <link href="/static/css/bootstrap/2.3.2/demos.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container-fluid">
		<form:form cssClass="form-horizontal" modelAttribute="RiskinfoModel"
			method="POST" action="/riskinfo/add">
			<form:input path="Id" value="${Id}"  />
			<fieldset>
				<legend>
					新增风控信息
				</legend>
				<form:errors cssStyle="color:red" path="*" />

         <table><tr><td>
				<div class="control-group">
					<label class="control-label">
						最高学历:
					</label>
					<div class="controls">
						<form:select path="education" >
                          <form:option value="博士">博士</form:option>
                          <form:option value="本科">本科</form:option>
                          <form:option value="专科">专科</form:option>
						</form:select>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">
						籍贯:
					</label>
					<div class="controls">
						<form:input path="hometown"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" >
						户口所在地:
					</label>
					<div class="controls">
						<form:input path="hkszd"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">
						居住地址:
					</label>
					<div class="controls">
						<form:input path="jzdz"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" >
						居住地邮编:
					</label>
					<div class="controls">
						<form:input path="jzdyb"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" >
						居住地电话:
					</label>
					<div class="controls">
						<form:input path="jzddh"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" >
						婚姻状况:
					</label>
					<div class="controls">
						<form:select path="hyzk">
						   <form:option value="">---请选择---</form:option>
						   <form:option value="1">已婚</form:option>
						   <form:option value="2">未婚</form:option>
						   <form:option value="3">离异</form:option>
						   <form:option value="4">丧偶</form:option>
						</form:select>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" >
						有无子女:
					</label>
					<div class="controls">
						<form:select path="ywzn">
						   <form:option value="1">有</form:option>
						   <form:option value="2">无</form:option>
						</form:select>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">
						直系亲属姓名:
					</label>
					<div class="controls">
						<form:input path="zxqsxm"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">
						直系亲属关系:
					</label>
					<div class="controls">
						<form:input path="zxqsgx"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" >
						直系亲属手机:
					</label>
					<div class="controls">
						<form:input path="zxqssj"  />
					</div>
				</div></td><td>
				<div class="control-group">
					<label class="control-label">
						其他联系人姓名:
					</label>
					<div class="controls">
						<form:input path="qtlxrxm"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" >
						其他联系人关系:
					</label>
					<div class="controls">
						<form:input path="qtlxrgx"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" >
						其他联系人手机:
					</label>
					<div class="controls">
						<form:input path="qtlxrsj"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">
						职业状态:
					</label>
					<div class="controls">
						<form:input path="zyzt"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">
						单位名称:
					</label>
					<div class="controls">
						<form:input path="dwmc"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" >
						职位:
					</label>
					<div class="controls">
						<form:input path="zw"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">
						月收入:
					</label>
					<div class="controls">
						<form:input path="ysr"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" >
						工作邮箱:
					</label>
					<div class="controls">
						<form:input path="gzyx"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" >
						工作城市:
					</label>
					<div class="controls">
						<form:input path="gzcs"  />
					</div>
				</div></td><td>
				<div class="control-group">
					<label class="control-label" >
						公司地址:
					</label>
					<div class="controls">
						<form:input path="gsdz"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" >
						公司类别:
					</label>
					<div class="controls">
						<form:select path="gslb">
						   <form:option value="">---请选择---</form:option>
                           <form:option value="国家机关">国家机关</form:option>
						  <form:option value="事业单位">事业单位</form:option>
						  <form:option value="央企（包括下级单位）">央企（包括下级单位）</form:option>
						  <form:option value="地方国资委直属企业">地方国资委直属企业</form:option>
						  <form:option value="世界500强（包括合资企业及下级单位）">世界500强（包括合资企业及下级单位）</form:option>
						  <form:option value="外资企业（包括合资企业）">外资企业（包括合资企业）</form:option>
						  <form:option value="一般上市公司（包括国外上市）">一般上市公司（包括国外上市）</form:option>
						  <form:option value="个体经营者">个体经营者</form:option>
						  <form:option value="一般民营企业">一般民营企业</form:option>
						  <form:option value="其他">其他</form:option>
						</form:select>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" >
						公司行业:
					</label>
					<div class="controls">
						<form:select path="gshy">
						   <form:option value="">---请选择---</form:option>
							<form:option value="制造业">制造业</form:option>
							<form:option value="政府机关">政府机关</form:option>
							<form:option value="媒体/广告">媒体/广告</form:option>
							<form:option value="零售/批发">零售/批发</form:option>
							<form:option value="教育/培训">教育/培训</form:option>
							<form:option value="公共事业">公共事业</form:option>
							<form:option value="交通运输业"> 交通运输业</form:option>
							<form:option value="房地产业">房地产业</form:option>
							<form:option value="能源业">能源业</form:option>
							<form:option value="金融/法律">金融/法律</form:option>
							<form:option value="餐饮/旅馆业"> 餐饮/旅馆业</form:option>
							<form:option value="医疗/卫生/保健">医疗/卫生/保健</form:option>
							<form:option value="建筑工程">建筑工程</form:option>
							<form:option value="农业">农业</form:option>
							<form:option value="娱乐服务业"> 娱乐服务业</form:option>
							<form:option value="体育/艺术"> 体育/艺术</form:option>
							<form:option value="公益组织"> 公益组织</form:option>
							<form:option value="其它">其它</form:option>
						</form:select>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" >
						公司规模:
					</label>
					<div class="controls">
						<form:input path="gsgm"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" >
						在现单位工作年限:
					</label>
					<div class="controls">
						<form:select path="zxdwgznx">
						    <form:option value="">---请选择---</form:option>
                            <form:option value="1">  1年（含）以下</form:option>
                            <form:option value="1-3">    1-3年（含）</form:option>
                            <form:option value="3-5">   3-5年（含）</form:option>
                            <form:option value="5">5年以上</form:option>
						</form:select>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" >
						公司电话:
					</label>
					<div class="controls">
						<form:input path="gsdh"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" >
						是否有房:
					</label>
				　　<div class="controls">
						<form:select path="sfyf">
						   <form:option value="1">有</form:option>
						   <form:option value="2">无</form:option>
						</form:select>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" >
						有无房贷:
					</label>
				　　<div class="controls">
						<form:select path="ywfd">
						   <form:option value="1">有</form:option>
						   <form:option value="2">无</form:option>
						</form:select>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" >
						是否有车:
					</label>
				　　<div class="controls">
						<form:select path="sfyc">
						   <form:option value="1">有</form:option>
						   <form:option value="2">无</form:option>
						</form:select>
					</div>
				</div></td>
			</table>
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
        <script src="http://code.jquery.com/jquery-1.8.2.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="http://code.jquery.com/ui/1.9.1/jquery-ui.min.js"></script>
        <script src="/static/js/bootstrap/2.3.2/jquery-ui-timepicker-addon.js" type="text/javascript"></script>
        <script src="/static/js/bootstrap/2.3.2/jquery.ui.datepicker-zh-CN.js.js" type="text/javascript" ></script>
        <script src="/static/js/bootstrap/2.3.2/jquery-ui-timepicker-zh-CN.js" type="text/javascript"></script>
	<script type="text/javascript">
	</script>


</body>