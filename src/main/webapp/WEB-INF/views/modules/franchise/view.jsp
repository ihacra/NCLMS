<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>加盟合作</title>
</head>
<body>
<form:form id="inputForm" modelAttribute="franchise" action="${ctx}/franchise/save" method="post" cssClass="sui-form form-horizontal sui-validate">
    <form:hidden path="id"/>
    <div class="main-con">
        <br/>
        <sys:message content="${message}"/>
        <div class="control-group">
            <div class="controls">加盟人姓名：${franchise.name}</div>
        </div>
        <div class="control-group">
            <div class="controls">户籍所在地：${franchise.address}</div>
        </div>
        <div class="control-group">
            <div class="controls">联系方式：${franchise.mobile}</div>
        </div>
        <div class="control-group">
            <div class="controls">从业经验：${franchise.experience}</div>
        </div>
        <div class="control-group">
            <div class="controls">投资金额：${franchise.amount}(万元)</div>
        </div>
        <div class="control-group">
            <div class="controls">加盟地区：${franchise.area}</div>
        </div>
        <div class="control-group">
            <div class="controls">客户数量：${franchise.customer}</div>
        </div>
        <div class="control-group">
            <div class="controls">日均发件量：${franchise.quantity}</div>
        </div>
        <hr/>
        <div class="control-group">
            <div class="controls">
                <p class="sui-text-large"><b>加盟原则</b></p>
                1、接受营运中心统一管理，独立投资，合作经营，自负盈亏，独立对外承担责任。<br/>
                <p class="sui-text-large"><b>加盟条件</b></p>
                1、依法注册有限责任公司，经营范围应有快递服务项目，并且必须遵守各项法律规则（注册资金：50万及以上）；<br/>
                2、签约法人须具备国家邮政管理局颁发的《快递业务经营许可证》；<br/>
                3、认同企业文化及经营理念，具有开拓意识和服务理念，有团队合作精神，有责任心、有大局观；<br/>
                4、具有一定的管理水平和管理经历，有一定的经济实力，有一定的社会关系，有较强的社交能力；<br/>
                5、有适合业务需要与公司发展的从业人员,包括管理人员、业务员、客服人员及仓库管理人员等。<br/>
                <p class="sui-text-large"><b>加盟流程</b></p>
                1、提交申请：凡符合加盟条件的公司、企业或者个人，有资金投入且又具有快递经营资格，均可提出加盟申请；
                2、资质审核：网络管理中心在审核后，派人实地考察申请人在该经营地区的资质与条件，达成共识后上报网络管理中心审批；
                3、签订合同：网络管理中心代表公司同加盟人签订《加盟合同书》盖章后即生效，加盟人即成为连锁快递成员。
                <p class="sui-text-large"><b>加盟费用</b></p>
                1、经总部授权经营的加盟网点，拓展业务发展区域时签订的加盟合作协议，须经过网络管理中心的书面同意，并收取履约保证金。
            </div>
        </div>
    </div>
    <div class="express-code">
        <strong class="express-title" style="background: url(https://www.zto.com/imgs/express/code_icon.png) left center no-repeat;">单号订阅</strong>
        <div class="code-cont">
            <p>想要实时追踪此运单状态？扫码订阅，仅需一步!</p>
            <img src="${ctx}/image/sys/code.png" alt>
            <p>打开微信或支付宝扫描上方二维码即可订阅成功</p>
        </div>
    </div>
</form:form>
</body>
</html>
