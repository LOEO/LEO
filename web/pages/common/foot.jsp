<%--
  Created by IntelliJ IDEA.
  User: LT
  Date: 14-3-20
  Time: 下午7:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="${ctx}/rs/jquery/jquery.min.js"></script>
<script type="text/javascript">
    if("ontouchend" in document) document.write("<script src='${ctx}/rs/ace/assets/js/jquery.mobile.custom.min.js'>"+"<"+"script>");
</script>
<script src="${ctx}/rs/ace/assets/js/bootstrap.min.js"></script>
<script src="${ctx}/rs/ace/assets/js/typeahead-bs2.min.js"></script>

<!-- page specific plugin scripts -->

<!--[if lte IE 8]>
<script src="${ctx}/rs/ace/assets/js/excanvas.min.js"></script>
<![endif]-->

<script src="${ctx}/rs/ace/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
<script src="${ctx}/rs/ace/assets/js/jquery.ui.touch-punch.min.js"></script>
<script src="${ctx}/rs/ace/assets/js/jquery.gritter.min.js"></script>
<script src="${ctx}/rs/ace/assets/js/bootbox.min.js"></script>
<script src="${ctx}/rs/ace/assets/js/jquery.slimscroll.min.js"></script>
<script src="${ctx}/rs/ace/assets/js/jquery.easy-pie-chart.min.js"></script>
<script src="${ctx}/rs/ace/assets/js/jquery.hotkeys.min.js"></script>
<script src="${ctx}/rs/ace/assets/js/bootstrap-wysiwyg.min.js"></script>
<script src="${ctx}/rs/ace/assets/js/select2.min.js"></script>
<script src="${ctx}/rs/ace/assets/js/date-time/bootstrap-datepicker.min.js"></script>
<script src="${ctx}/rs/ace/assets/js/fuelux/fuelux.spinner.min.js"></script>
<script src="${ctx}/rs/ace/assets/js/x-editable/bootstrap-editable.min.js"></script>
<script src="${ctx}/rs/ace/assets/js/x-editable/ace-editable.min.js"></script>
<script src="${ctx}/rs/ace/assets/js/jquery.maskedinput.min.js"></script>
<script src="${ctx}/rs/ace/assets/js/jquery.sparkline.min.js"></script>
<script src="${ctx}/rs/ace/assets/js/flot/jquery.flot.min.js"></script>
<script src="${ctx}/rs/ace/assets/js/flot/jquery.flot.pie.min.js"></script>
<script src="${ctx}/rs/ace/assets/js/flot/jquery.flot.resize.min.js"></script>

<!-- ace scripts -->

<script src="${ctx}/rs/ace/assets/js/ace-elements.min.js"></script>
<script src="${ctx}/rs/ace/assets/js/ace.min.js"></script>
<script src="${ctx}/rs/ace/assets/js/bootbox.min.js"></script>
<script>
    $("#logout").on("click", function() {
        debugger;
        bootbox.confirm("你确定要退出吗？", function(result) {
            if(result) {
                location.href="${ctx}/pages/logout.jsp"
            }
        });
    });
</script>