/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.29
 * Generated at: 2018-07-30 13:02:01 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.system.role;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class role_005fbutton_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/lib/standard-1.1.2.jar", Long.valueOf(1499840265437L));
    _jspx_dependants.put("jar:file:/D:/workspace_softqin/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/softqin-admin/WEB-INF/lib/standard-1.1.2.jar!/META-INF/c.tld", Long.valueOf(1098682290000L));
    _jspx_dependants.put("jar:file:/D:/workspace_softqin/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/softqin-admin/WEB-INF/lib/standard-1.1.2.jar!/META-INF/fmt.tld", Long.valueOf(1098682290000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("<meta charset=\"utf-8\" />\r\n");
      out.write("<title></title>\r\n");
      out.write("<link href=\"static/css/bootstrap.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"static/css/font-awesome.min.css\" />\r\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\" href=\"plugins/zTree/2.6/zTreeStyle.css\"/>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"static/css/ace.min.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"static/css/ace-responsive.min.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"static/css/ace-skins.min.css\" />\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("footer{height:50px;position:fixed;bottom:0px;left:0px;width:100%;text-align: center;}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"zhongxin\">\r\n");
      out.write("\t\t<ul id=\"tree\" class=\"tree\" style=\"overflow:auto;\"></ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"zhongxin2\" class=\"center\" style=\"display:none\"><br/><br/><br/><br/><img src=\"static/images/jiazai.gif\" /><br/><h4 class=\"lighter block green\"></h4></div>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"static/js/jquery-1.5.1.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"plugins//zTree/2.6/jquery.ztree-2.6.min.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\ttop.hangge();\r\n");
      out.write("\tvar zTree;\r\n");
      out.write("\t$(document).ready(function(){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar setting = {\r\n");
      out.write("\t\t\t    showLine: true,\r\n");
      out.write("\t\t\t    checkable: true,\r\n");
      out.write("\t\t\t    showIcon :false\r\n");
      out.write("\t\t\t};\r\n");
      out.write("\t\t\tvar zn = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${zTreeNodes}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("';\r\n");
      out.write("\t\t\tvar zTreeNodes = eval(zn);\r\n");
      out.write("\t\t\tzTree = $(\"#tree\").zTree(setting, zTreeNodes);\r\n");
      out.write("\t\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\r\n");
      out.write("\t\t function save(){\r\n");
      out.write("\t\t\t   \r\n");
      out.write("\t\t\t\tvar nodes = zTree.getCheckedNodes();\r\n");
      out.write("\t\t\t\tvar tmpNode;\r\n");
      out.write("\t\t\t\tvar ids = \"\";\r\n");
      out.write("\t\t\t\tfor(var i=0; i<nodes.length; i++){\r\n");
      out.write("\t\t\t\t\ttmpNode = nodes[i];\r\n");
      out.write("\t\t\t\t\tif(i!=nodes.length-1){\r\n");
      out.write("\t\t\t\t\t\tids += tmpNode.id+\",\";\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\tids += tmpNode.id;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tvar roleId = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${roleId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("\t\t\t\tvar msg = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msg}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("\t\t\t\tvar url = \"");
      out.print(basePath);
      out.write("role/roleButton/save.do\";\r\n");
      out.write("\t\t\t\tvar postData;\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tpostData = {\"ROLE_ID\":roleId,\"menuIds\":ids,\"msg\":msg};\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t$(\"#zhongxin\").hide();\r\n");
      out.write("\t\t\t\t$(\"#zhongxin2\").show();\r\n");
      out.write("\t\t\t\t$.post(url,postData,function(data){\r\n");
      out.write("\t\t\t\t\t//if(data && data==\"success\"){\r\n");
      out.write("\t\t\t\t\t\ttop.Dialog.close();\r\n");
      out.write("\t\t\t\t\t//}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t }\r\n");
      out.write("\t\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<footer>\r\n");
      out.write("\t<div style=\"width: 100%;\" class=\"center\">\r\n");
      out.write("\t\t<a class=\"btn btn-mini btn-primary\" onclick=\"save();\">保存</a>\r\n");
      out.write("\t\t<a class=\"btn btn-mini btn-danger\" onclick=\"top.Dialog.close();\">取消</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</footer>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
