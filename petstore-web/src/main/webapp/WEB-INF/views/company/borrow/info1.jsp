<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <title>借款认证详情</title>
    <link rel="stylesheet" href="/static/css/bootstrap/2.3.2/datepicker.css" />
</head>
<body>
	<div class="container-fluid">
        <form>
			<fieldset>
				<legend>
					借款详情
				</legend>
                   <h2>借款详情</h2>
				<div class="control-group">
					<label class="control-label">
						借款订单编号:
					</label>
				</div>
				<div class="control-group">
					<label class="control-label">
						借款人编号:
					</label>
				</div>
				<div class="control-group">
					<label class="control-label">
						借款标题:
					</label>
				</div>
				<div class="control-group">
					<label class="control-label">
						借款金额:
					</label>
				</div>
				<div class="control-group">
					<label class="control-label" >
						借款描述:
					</label>
				</div>
				<div class="control-group">
                    <label class="control-label" >
                         借款时间:
                    </label>
                </div>
				<div class="control-group">
                    <label class="control-label" >
                         借款期限:
                    </label>
                </div>
				<div class="control-group">
                    <label class="control-label" >
                         剩余还款额:
                    </label>
                </div>
 				<div class="control-group">
                     <label class="control-label" >
                          借款状态:
                     </label>
                 </div>
				<div class="control-group">
                	<label class="control-label" >
                		客户端IP:
                	</label>
                </div>
				<div class="control-group">
                	<label class="control-label" >
                		借款期限ID:
                	</label>
                </div>
				<div class="control-group">
					<label class="control-label"  >
						借款人真实姓名:
					</label>
				</div>
				<div class="control-group">
                	<label class="control-label"  >
                		年龄:
                	</label>
                </div>
                <div class="control-group">
 					<label class="control-label">
 						手机号:
 					</label>
 				</div>

				<div class="control-group">
					<label class="control-label" >
						邮箱:
					</label>
				</div>
				<div class="sqzl">
                  <h2>申请资料</h2>
                  <table>
                    <tr>
                      <td align="right">身份证:</td>
                      <td>14355662222222222222</td>
                      <td align="right">审核意见:</td>
                       <td><input type="text"  /></td>
                      <td><input type="radio" name="radioSf"  value="" id="" />通过 </td>
                      <td><input type="radio" name="radioSf"  value="" id="" />不通过</td>
                    </tr>
                       <tr>
                      <td align="right">收入证明:</td>
                      <td>图片格式</td>
                      <td align="right">审核意见:</td>
                      <td><input type="text"  /></td>
                      <td><input type="radio" name="radioSr"  value="" id="" />通过 </td>
                      <td><input type="radio" name="radioSr"  value="" id="" />不通过</td>
                      </tr>
                      <tr>
                      <td align="right">房贷证明:</td>
                      <td>房贷图片</td>
                       <td align="right">审核意见:</td>
                      <td><input type="text"  /></td>
                      <td><input type="radio" name="radioFd"  value="" id="" />通过 </td>
                      <td><input type="radio" name="radioFd"  value="" id="" />不通过</td>
                  	  </tr>  <tr>
                      <td align="right">车贷证明:</td>
                      <td></td>
                      <td align="right">审核意见:</td>
                                           <td><input type="text"  /></td>
                                           <td><input type="radio" name="radioFd"  value="" id="" />通过 </td>
                                           <td><input type="radio" name="radioFd"  value="" id="" />不通过</td>
                    </tr>
                    <tr>
                      <td align="right">信用报告:</td>
                      <td></td>
                    <td align="right">审核意见:</td>
                                <td><input type="text"  /></td>
                                <td><input type="radio" name="radioFd"  value="" id="" />通过 </td>
                                <td><input type="radio" name="radioFd"  value="" id="" />不通过</td>
                      </tr>
                                          <tr>
                                 <td><input type="radio" name="radioFd"  value="" id="" />通过 </td>
                                 <td><input type="radio" name="radioFd"  value="" id="" />不通过</td>
                    </tr>
                  </table>
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
       </form>

			</fieldset>
	</div>
    <script src="/static/js/bootstrap/2.3.2/bootstrap-datepicker.js"></script>
	<script type="text/javascript">

	</script>
</body>