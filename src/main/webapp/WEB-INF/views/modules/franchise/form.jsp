<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>加盟合作</title>
    <script type="text/javascript">
        $(document).ready(function() {
            $("#submitBtn").click(function() {
                $.confirm({
                    body: '是否确认提交加盟信息？',
                    backdrop: true,
                    bgcolor: 'none',
                    okHide: function(){
                        $("#inputForm").submit();
                    },
                    cancelHide: function(){

                    }
                })
            });
        });
    </script>
</head>
<body>
<form:form id="inputForm" modelAttribute="franchise" action="${ctx}/franchise/save" method="post" cssClass="sui-form form-horizontal sui-validate">
    <form:hidden path="id"/>
    <div class="main-con">
        <br/><br/>
        <div class="control-group">
            <label for="name" class="control-label">姓名：</label>
            <div class="controls">
                <form:input path="name" maxlength="32" placeholder="请输入姓名" data-rules="required"/>
            </div>
        </div>
        <div class="control-group">
            <label for="address" class="control-label">户籍所在地：</label>
            <div class="controls">
                <form:input path="address" maxlength="96" placeholder="请输入户籍所在地" cssClass="input-xxlarge" data-rules="required"/>
            </div>
        </div>
        <div class="control-group">
            <label for="mobile" class="control-label">联系方式：</label>
            <div class="controls">
                <form:input path="mobile" maxlength="20" placeholder="请输入联系手机号" data-rules="required|mobile"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label">从业经验：</label>
            <div class="controls">
                <form:radiobutton path="experience" value="有"/>有&nbsp;&nbsp;&nbsp;
                <form:radiobutton path="experience" value="无" checked="true"/>无
            </div>
        </div>
        <div class="control-group">
            <label for="amount" class="control-label">投资金额：</label>
            <div class="controls">
                <span class="sui-dropdown dropdown-bordered select">
                    <span class="dropdown-inner">
                        <a id="select" role="button" href="javascript:void(0);" data-toggle="dropdown" class="dropdown-toggle">
                            <form:input path="amount" data-rules="required" cssStyle="display: none"/>
                            <i class="caret"></i><span>--请选择--</span>
                        </a>
                        <ul role="menu" aria-labelledby="drop4" class="sui-dropdown-menu">
                            <li role="presentation"><a role="menuitem" tabindex="-1" href="javascript:void(0);" value="">--请选择--</a></li>
                            <li role="presentation"><a role="menuitem" tabindex="-1" href="javascript:void(0);" value="0-100">0-100</a></li>
                            <li role="presentation"><a role="menuitem" tabindex="-1" href="javascript:void(0);" value="100-300">100-300</a></li>
                            <li role="presentation"><a role="menuitem" tabindex="-1" href="javascript:void(0);" value="300-500">300-500</a></li>
                            <li role="presentation"><a role="menuitem" tabindex="-1" href="javascript:void(0);" value="500以上">500以上</a></li>
                        </ul>
                    </span>
                </span>
                <span>&nbsp;&nbsp;万元</span>
            </div>
        </div>
        <div class="control-group">
            <label for="area" class="control-label">加盟地区：</label>
            <div class="controls">
                <form:input path="area" maxlength="96" placeholder="请输入加盟地区" cssClass="input-xxlarge" data-rules="required"/>
            </div>
        </div>
        <div class="control-group">
            <label for="customer" class="control-label">客户数量：</label>
            <div class="controls">
                <form:input path="customer" maxlength="32" placeholder="请输入客户数量" data-rules="required|number"/>
            </div>
        </div>
        <div class="control-group">
            <label for="quantity" class="control-label">日均发件量：</label>
            <div class="controls">
                <span class="sui-dropdown dropdown-bordered select">
                    <span class="dropdown-inner">
                        <a id="select2" role="button" href="javascript:void(0);" data-toggle="dropdown" class="dropdown-toggle">
                            <form:input path="quantity" data-rules="required" cssStyle="display: none"/>
                            <i class="caret"></i><span>--请选择--</span>
                        </a>
                        <ul role="menu" aria-labelledby="drop4" class="sui-dropdown-menu">
                            <li role="presentation"><a role="menuitem" tabindex="-1" href="javascript:void(0);" value="">--请选择--</a></li>
                            <li role="presentation"><a role="menuitem" tabindex="-1" href="javascript:void(0);" value="0-200">0-200</a></li>
                            <li role="presentation"><a role="menuitem" tabindex="-1" href="javascript:void(0);" value="200-500">200-500</a></li>
                            <li role="presentation"><a role="menuitem" tabindex="-1" href="javascript:void(0);" value="500-1000">500-1000</a></li>
                            <li role="presentation"><a role="menuitem" tabindex="-1" href="javascript:void(0);" value="1000以上">1000以上</a></li>
                        </ul>
                    </span>
                </span>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label"></label>
            <div class="controls">
                <button id="submitBtn" type="button" class="sui-btn btn-primary">提交信息</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <button type="reset" class="sui-btn btn-primary">重置信息</button>
            </div>
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
