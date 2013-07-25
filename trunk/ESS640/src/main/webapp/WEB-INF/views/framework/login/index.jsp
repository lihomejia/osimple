<%@ page language="java" pageEncoding="UTF-8" %>
<%@include  file="/core/taglibs.jsp"%>
<html>
	<head>
		<base href="<%=basePath%>">
		<title>ESS640</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>core/css/login.css">
		<script type="text/javascript" src="scripts/framework/login/login.js"></script>
	</head>
	<body style="background:#d5edf6;" onload="onWindowLoad();">
		<div class="content">
			<div class="logo"></div>
		  	<div class="main"> 
		  		<div class="right">
		        	<div class="login">
		          		<div class="login_main">
			          		<form action="<%=basePath%>framework/login/doLogin" method="post">
			           				<table width="100%"  border="0" cellpadding="0" cellspacing="0"  class="table_login">
			              				<tr>
			                				<td><span class="font_blue">sign in</span></td>
			              				</tr>
										<tr>
							            	<td>
							              		<input type="text" placeholder="User ID" name="userid" id="userid" class="textfield" title="User ID" value="admin"></input>
							              	</td>
										</tr>
			              				<tr>
			              					<td>
			              						<input type="password" placeholder="Password" name="userpwd" id="userpwd" class="textfield" title="Password" value="admin"></input>
			              					</td>
			              				</tr>
			              				<tr>
			                				<td>
			                					<input type="button" value="sign in" class="button2" onclick="doLogin()" />
			                				</td>
			              				</tr>
									</table>
								</form>
							</div>
						</div>
					</div>
					<div class="left">
		         		<div class="left_top">
		         			Build up an efficient and agile organization with Norming Employee Self Service Portal for PSA.
		         		</div>
		         		<div class="left_bottom">
		         			<a href="javascript:showForgetPwdWindow();" style="color:#646161;text-decoration: none;">
		         				I forgot my password, please send it to me.&nbsp;<img src="core/images/login/icon.png" width="16" height="18" border="0" align="absmiddle" />
		         			</a>
		         		</div>
		         	<div class="left_img"></div>
				</div>
		  	</div>
			<div class="footer">
		   		<table>
		   			<tr>
		   				<td width="565px;" style="text-align:left">Norming Software International Ltd</td>
		   				<td width="565px;" style="text-align:right">Copyright &copy; 2013 Norming Software International Ltd. All Rights Reserved. Version 6.4.0</td>
		   			</tr>
		   		</table>
		   </div>
		</div>
	</body>
</html>