<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator"%>

<!DOCTYPE html>
<html>
<head>
    <title><sitemesh:title /></title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta http-equiv="Expires" content="0">
    <meta http-equiv="Pragma" content="No-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css"
          href="/static/css/bootstrap/2.3.2/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css"
          href="/static/css/bootstrap/2.3.2/bootstrap-responsive.min.css" />
    <script type="text/javascript" src="/static/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="/static/js/jquery-validation/1.12/jquery.validate.js"></script>
    <script type="text/javascript" src="/static/js/jquery-validation/1.12/messages_zh.js"></script>
    <script type="text/javascript" src="/static/js/jquery-ui-1.11.4.custom/jquery-ui.js"></script>
    <sitemesh:head />
</head>
<body>
<style> @media Print { .Noprn { DISPLAY: none }}
                                </style>
<div class="Noprn">
<!-- top navbar -->
<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container-fluid">
            <a class="btn btn-navbar" data-toggle="collapse"
               data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="#">
                <strong><em><font color="blue">拇指金融</font></em></strong>
                <strong><font color="black">后台管理系统</font></strong>
            </a>
            <div class="nav-collapse pull-right">
                <ul class="nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="icon-envelope"></i>
                            <span class="label label-info">100</span> <b
                                class="caret"></b> </a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="#">最新消息</a>
                            </li>
                            <li>
                                <a href="#">未读消息</a>
                            </li>
                            <li>
                                <a href="#">所有消息</a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#">已读消息...</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
            <div class="nav-collapse">
                <ul class="nav">
                    <li class="active"><a id="0" class="activeMenu" href="#">首页</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle activeMenu" data-toggle="dropdown">
                            后台系统管理
                        <b class="caret"></b>
                          </a>
                        <ul class="dropdown-menu">
                            <li><a href="/sysLog/query">后台系统日志管理</a></li>
                            <li><a href="/admin/resource/file/query" > 文件管理 </a></li>
                            <li><a href="/admin/resource/method/query" > 方法管理 </a></li>
                            <li><a href="/admin/resource/operation/query" > 操作管理 </a></li>
                            <li><a href="/admin/resource/pageElement/query" > 页面元素管理 </a></li>
                            <li><a href="/auth/checkPassword" > 验证密码 </a></li>
                            <li><a href="/admin/resource/menu/query" >菜单管理 </a></li>
                            <li><a href="/admin/role/query" >角色管理 </a></li>
                            <li><a href="/admin/user/query" >后台登陆用户管理 </a></li>
                            <li><a href="/admin/userGroup/query">后台用户组管理 </a></li>
                            <li><a href="/admin/resource/menu/import" >文件上传 </a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <div class="nav-collapse">
                <ul class="nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle activeMenu" data-toggle="dropdown">
                           用户管理
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="/user/internetUser/query">前台注册用户管理</a></li>
                            <li><a href="/user/userinfo/query" > 用户基本信息管理 </a></li>
                            <li><a href="/user/userprivilege/query" >用户特权管理 </a></li>
                            <li><a href="/user/userrepayment/query" >用户收益管理</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <div class="nav-collapse">
                <ul class="nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle activeMenu" data-toggle="dropdown">
                           BANK中心
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="/user/useraccount/query">个人账户管理 </a></li>
                             <li><a href="/user/useraccountrecord/query" >银行流水记录管理 </a></li>
                             <li><a href="/accountRecharge/query" >账户充值记录管理 </a></li>
                            <li><a href="/accountCash/query" >账户提现记录管理 </a></li>
                            <li><a href="/bank/query" >银行信息管理 </a></li>
                            <li><a href="/bankCard/query">银行用户账户关系管理</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <div class="nav-collapse">
                <ul class="nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle activeMenu" data-toggle="dropdown">
                           投资中心
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                             <li><a href="/order_info/query" > 订单信息管理 </a></li>
                             <li><a href="/transaction/query" >交易信息管理 </a></li>
                             <li><a href="/repayment_plan/query" >计划收益管理 </a></li>
                             <li><a href="/actualRepaymentPlan/query" >实际收益管理 </a></li>
                             <li><a href="/user/investrecord/query" >用户投资记录管理 </a></li>
                        </ul>
                    </li>
                </ul>
            </div>

            <div class="nav-collapse">
                <ul class="nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle activeMenu" data-toggle="dropdown">
                           征信管理中心
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="/riskinfo/query" >风控信息管理 </a></li>
                            <li><a href="/contract/query" >合同信息管理 </a></li>
                            <li><a href="/creditInfo/query" >信用档案信息管理 </a></li>

                        </ul>
                    </li>
                </ul>
            </div>
             <div class="nav-collapse">
                            <ul class="nav">
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle activeMenu" data-toggle="dropdown">
                                       标的中心
                                        <b class="caret"></b>
                                    </a>
                                    <ul class="dropdown-menu">
                                       <li><a href="/product/queryList" > 未满标标的管理 </a></li>
                                       <li><a href="/product/queryMBList" > 已满标标的管理 </a></li>
                                        <li><a href="/product/query" > 标的管理 </a></li>
                                        <li><a href="/productType/query" >标的种类信息管理 </a></li>
                                         <li><a href="/agent/query" > 借款人信息管理 </a></li>
                                         <li><a href="/ensureType/query" >保障方式信息管理 </a></li>
                                         <li><a href="#" > U计划 </a></li>
                                    </ul>
                                </li>
                            </ul>
              </div>

             <div class="nav-collapse">
                            <ul class="nav">
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle activeMenu" data-toggle="dropdown">
                                       借款中心
                                        <b class="caret"></b>
                                    </a>
                                    <ul class="dropdown-menu">
                                        <li><a href="/borrow/query" > 借款审核列表 </a></li>
                                        <li><a href="/borrowOrderInfo/query" > 借款订单管理 </a></li>
                                        <li><a href="/borrowTran/query" >借款交易管理 </a></li>
                                        <li><a href="/borrowStat/query" > 借款统计管理 </a></li>
                                        <li><a href="/boRepaymentPlan/query" >计划还款信息 </a></li>
                                        <li><a href="/actualRepayment/query" >实际还款信息 </a></li>
                                        <li><a href="/period/query" >借款期限信息管理 </a></li>
                                         <li><a href="/borrowRate/query" >借款费率管理 </a></li>
                                    </ul>
                                </li>
                            </ul>
              </div>
             <div class="nav-collapse">
                            <ul class="nav">
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle activeMenu" data-toggle="dropdown">
                                       统计
                                        <b class="caret"></b>
                                    </a>
                                    <ul class="dropdown-menu">
                                        <li><a href="/user/userinfo/queryList"> 用户信息统计 </a></li>
                                        <li><a href="/user/investrecord/queryList" > 投资统计 </a></li>
                                        <li><a href="/repaymentPlan/queryList" > 收益计划统计 </a></li>
                                        <li><a href="/actualRepaymentPlan/queryList" >实际收益统计 </a></li>
                                       <!-- <li><a href="/boRepaymentPlan/queryList" > 计划还款统计 </a></li>
                                        <li><a href="/actualRepayment/queryList" >实际还款统计 </a></li>-->
                                    </ul>
                                </li>
                            </ul>
              </div>
             <div class="nav-collapse">
                                        <ul class="nav">
                                            <li class="dropdown">
                                                <a href="#" class="dropdown-toggle activeMenu" data-toggle="dropdown">
                                                   财务中心
                                                    <b class="caret"></b>
                                                </a>
                                                <ul class="dropdown-menu">
                                                  <li><a href="/respParameter/query">第三方接口返回参数</a></li>
                                                  <li><a href="http://p2p.yeepay.com/bha-merchant/login.do" target="_blank">商户登录地址</a></li>
                                                </ul>
                                            </li>
                                        </ul>
               </div>
            <div class="btn-group pull-right">
                <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="icon-user"></i>
                    <currentUser:userName />
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                    <li>
                        <a class="activeMenu" href="#">个人信息</a>
                    </li>
                    <authorize:authorize resource="/admin/user/query">
                    </authorize:authorize>
                    <li>
                        <a class="activeMenu" href="#">帮助</a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a class="activeMenu" href="/logout">退出系统</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
</div>
<!-- container -->
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <sitemesh:body />
        </div>
    </div>
</div>
<style> @media Print { .Noprn { DISPLAY: none }}
                                </style>
<div class="Noprn">
<!-- footer -->
<div class="navbar navbar-fixed-bottom">
    <div class="navbar-inner">
        <div class="container">
            <a class="brand" href="http://www.ssgxjt.com"><font color="blue"><small>盛世国祥</small></font></a>
            <ul class="nav">
                <li><a href="#">© Copyright 2015. All Rights Reserved 地址：北京市丰台区芳古路金城中心18层  邮编：100010</a></li>
            </ul>
        </div>
    </div>
</div>
</div>

<!-- le js -->
<script type="text/javascript" src="/static/js/bootstrap/2.3.2/bootstrap.min.js"></script>
<script type="text/javascript">
</script>
</body>
</html>