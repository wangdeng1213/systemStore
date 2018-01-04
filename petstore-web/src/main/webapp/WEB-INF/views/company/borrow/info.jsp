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
              <table> <tr><td>
				<div class="control-group">
					<label class="control-label">
						借款订单编号:XXXXX
					</label>
				</div></td><td>
				<div class="control-group">
					<label class="control-label">
						借款人编号:XXXXX
					</label>
				</div></td></tr>
				<tr><td>
				<div class="control-group">
					<label class="control-label">
						借款标题:XXXXX
					</label>
				</div></td><td>
				<div class="control-group">
					<label class="control-label">
						借款金额:XXXXX
					</label>
				</div></td></tr>
                <tr><td>
				<div class="control-group">
					<label class="control-label" >
						借款描述:XXXXX
					</label>
				</div></td><td>
				<div class="control-group">
                    <label class="control-label" >
                         借款时间:XXXXX
                    </label>
                </div></td></tr>
               <tr><td>
				<div class="control-group">
                    <label class="control-label" >
                         借款期限:XXXXX
                    </label>
                </div></td><td>
				<div class="control-group">
                    <label class="control-label" >
                         剩余还款额:XXXXX
                    </label>
                </div></td></tr>
                 <tr><td>
 				<div class="control-group">
                     <label class="control-label" >
                          借款状态:XXXXX
                     </label>
                 </div></td><td>
				<div class="control-group">
                	<label class="control-label" >
                		客户端IP:XXXXX
                	</label>
                </div></td></tr>
               <tr><td>
				<div class="control-group">
                	<label class="control-label" >
                		借款期限ID:XXXXX
                	</label>
                </div></td><td>
				<div class="control-group">
					<label class="control-label"  >
						借款人真实姓名:XXXXX
					</label>
				</div>
				</td></tr>
                 <tr><td>
				<div class="control-group">
                	<label class="control-label"  >
                		年龄:XXXXX
                	</label>
                </div></td><td>
                <div class="control-group">
 					<label class="control-label">
 						手机号:XXXXX
 					</label>
 				</div>
                </td></tr>

			</table>
				<div class="sqzl">
                  <table>
                    <tr>
                      <td align="right">身份证号:</td>
                      <td>14355662222222222222</td>
                      <td align="right">审核意见:XXXXX</td>
                      <td> &nbsp; &nbsp;通过</td>

                    </tr>
                       <tr>
                      <td align="right">收入证明:</td>
                      <td>图片格式</td>
                      <td align="right">审核意见:XXXXX</td>
                       <td> &nbsp; &nbsp;通过</td>
                      </tr>
                      <tr>
                      <td align="right">房贷证明:</td>
                      <td>房贷图片</td>
                       <td align="right">审核意见:XXXXX</td>
                                                                <td> &nbsp; &nbsp;通过</td>
                  	  </tr>  <tr>
                      <td align="right">车贷证明:</td>
                      <td></td>
                      <td align="right">审核意见:XXXXX</td>
                                                               <td> &nbsp; &nbsp;通过</td>
                    </tr>
                    <tr>
                      <td align="right">信用报告:</td>
                      <td></td>
                    <td align="right">审核意见:XXXXX</td>
                                                             <td> &nbsp; &nbsp;通过</td>
                      </tr>

                      <tr>
                               <td>
                                 						<font size="5">上一步操作人:王麻子风控委员会</font>
                                 </div></td>
                    </tr>

                  </table>
                </div>

  				<div class="control-group">
  					<label class="control-label">
  					  审核意见:<textarea rows="3"></textarea>
  					</label>

  					<div class="controls">
  						<button type="submit" class="btn btn-primary">
  							通过
  						</button>
  						<button type="submit" class="btn btn-primary">
                          							驳回
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