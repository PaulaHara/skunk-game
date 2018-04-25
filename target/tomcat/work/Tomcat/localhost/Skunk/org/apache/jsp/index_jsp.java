/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-04-18 22:19:46 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>AngularJS $http Example</title>\n");
      out.write("        <style>\n");
      out.write("            .playername.ng-valid {\n");
      out.write("              background-color: lightgreen;\n");
      out.write("            }\n");
      out.write("            .playername.ng-dirty.ng-invalid-required {\n");
      out.write("              background-color: red;\n");
      out.write("            }\n");
      out.write("            .playername.ng-dirty.ng-invalid-minlength {\n");
      out.write("              background-color: yellow;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\">\n");
      out.write("        <link href=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\" rel=\"stylesheet\"></link>\n");
      out.write("\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js\"></script>\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-route.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body ng-app=\"myApp\" class=\"ng-cloak\">\n");
      out.write("        <div class=\"generic-container col-md-11\" ng-controller=\"PlayerController as ctrl\">\n");
      out.write("            <div class=\"titleBox\">\n");
      out.write("                <img class=\"imgSkunkFlip\" ng-src=\"static/img/skunk.png\" alt=\"Skunk image\" />\n");
      out.write("                <span class=\"title\">Skunk Game</span>\n");
      out.write("                <img class=\"imgSkunk\" ng-src=\"static/img/skunk.png\" alt=\"Skunk image\" />\n");
      out.write("            </div>\n");
      out.write("            <div ng-hide=\"ctrl.hasStarted\">\n");
      out.write("                <div class=\"panel panel-default\">\n");
      out.write("                    <div class=\"panel-heading\"><span class=\"lead\">Player Registration Form </span></div>\n");
      out.write("                    <div class=\"formcontainer\">\n");
      out.write("                        <form ng-submit=\"ctrl.submit()\" name=\"myForm\" class=\"form-horizontal\">\n");
      out.write("                            <input type=\"hidden\" ng-model=\"ctrl.player.id\" />\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"form-group col-md-12\">\n");
      out.write("                                    <label class=\"col-md-2 control-lable\" for=\"file\">Name</label>\n");
      out.write("                                    <div class=\"col-md-7\">\n");
      out.write("                                        <input type=\"text\" ng-model=\"ctrl.player.name\" name=\"pname\" class=\"playername form-control input-sm\" placeholder=\"Enter player name\" required ng-minlength=\"3\"/>\n");
      out.write("                                        <div class=\"has-error\" ng-show=\"myForm.$dirty\">\n");
      out.write("                                            <span ng-show=\"myForm.pname.$error.required\">This is a required field</span>\n");
      out.write("                                            <span ng-show=\"myForm.pname.$error.minlength\">Minimum length required is 3</span>\n");
      out.write("                                            <span ng-show=\"myForm.pname.$invalid\">This field is invalid </span>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <div class=\"form-actions floatRight\">\n");
      out.write("                                        <input type=\"submit\"  value=\"{{!ctrl.player.id ? 'Add' : 'Update'}}\" class=\"btn btn-primary btn-sm\" ng-disabled=\"myForm.$invalid\">\n");
      out.write("                                        <button type=\"button\" ng-click=\"ctrl.reset()\" class=\"btn btn-warning btn-sm\" ng-disabled=\"myForm.$pristine\">Reset Form</button>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"panel panel-default\">\n");
      out.write("                    <div class=\"panel-heading\"><span class=\"lead\">Players</span></div>\n");
      out.write("                    <div class=\"tablecontainer\">\n");
      out.write("                        <table class=\"table table-hover playerTable\">\n");
      out.write("                            <thead class=\"playersHead\">\n");
      out.write("                                <tr>\n");
      out.write("                                    <th ng-show=\"false\">ID.</th>\n");
      out.write("                                    <th>Name</th>\n");
      out.write("                                    <th>Score</th>\n");
      out.write("                                    <th>Is Standing</th>\n");
      out.write("                                    <th></th>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody class=\"playerBody\">\n");
      out.write("                                <tr ng-repeat=\"u in ctrl.players\">\n");
      out.write("                                    <td ng-show=\"false\"><span ng-bind=\"u.id\"></span></td>\n");
      out.write("                                    <td><span ng-bind=\"u.name\"></span></td>\n");
      out.write("                                    <td><span ng-bind=\"u.score\"></span></td>\n");
      out.write("                                    <td><span ng-bind=\"u.stand\"></span></td>\n");
      out.write("                                    <td>\n");
      out.write("                                        <button type=\"button\" ng-click=\"ctrl.edit(u.id)\" class=\"btn btn-success defaultBtnWidth\">Edit</button>\n");
      out.write("                                        <button type=\"button\" ng-click=\"ctrl.remove(u.id)\" class=\"btn btn-danger defaultBtnWidth\">Remove</button>\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                            </tbody>\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"playBtn\">\n");
      out.write("                    <button type=\"button\" ng-click=\"ctrl.start()\" class=\"btn btn-success playBtnWidth\" ng-disabled=\"ctrl.players.length < 2\">Play!</button>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div ng-show=\"ctrl.hasStarted\">\n");
      out.write("                <div class=\"col-md-8\">\n");
      out.write("                    <div ng-show=\"!ctrl.gameEnded\" class=\"dices\">\n");
      out.write("                        <div class=\"diceImages\">\n");
      out.write("                            <img class=\"imgDice\" ng-src=\"{{ctrl.diceImg1}}\" alt=\"{{ctrl.diceImg1}}\" />\n");
      out.write("                            <img class=\"imgDice\" ng-src=\"{{ctrl.diceImg2}}\" alt=\"{{ctrl.diceImg2}}\" />\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <button type=\"button\" ng-click=\"ctrl.roll()\" class=\"btn btn-primary\">Roll Dices</button>\n");
      out.write("                    </div>\n");
      out.write("                    <div ng-show=\"ctrl.gameEnded\" class=\"winner\">\n");
      out.write("                        <p>{{ctrl.player.name}} win!!!</p>\n");
      out.write("                        <p>Score: {{ctrl.player.score}}</p>\n");
      out.write("                        <button type=\"button\" ng-click=\"ctrl.restart()\" class=\"btn btn-success\">Restart</button>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"panel panel-default\">\n");
      out.write("                        <div class=\"panel-heading\"><span class=\"lead\">Players</span></div>\n");
      out.write("                        <table class=\"table table-hover\">\n");
      out.write("                            <thead class=\"playersHead\">\n");
      out.write("                                <tr>\n");
      out.write("                                    <th>Name</th>\n");
      out.write("                                    <th>Score</th>\n");
      out.write("                                    <th>Is Standing</th>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody class=\"playerBody\">\n");
      out.write("                                <tr ng-repeat=\"player in ctrl.players\">\n");
      out.write("                                    <td ng-show=\"false\"><span ng-bind=\"player.id\"></span></td>\n");
      out.write("                                    <td><span ng-bind=\"player.name\"></span></td>\n");
      out.write("                                    <td><span ng-bind=\"player.score\"></span></td>\n");
      out.write("                                    <td><span ng-show=\"false\" ng-bind=\"player.stand\"></span>\n");
      out.write("                                        <button type=\"button\" ng-click=\"ctrl.sit(player.id)\" class=\"btn btn-info defaultBtnWidth\"\n");
      out.write("                                        ng-disabled=\"!player.stand || ctrl.gameEnded || ctrl.results.length == 0\">\n");
      out.write("                                            {{player.stand && !ctrl.gameEnded ? 'Stand' : 'Seated'}}\n");
      out.write("                                        </button>\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                            </tbody>\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-2\">\n");
      out.write("                    <div class=\"panel panel-default\">\n");
      out.write("                        <div class=\"panel-heading\"><span class=\"lead\">{{ctrl.actualRound}}</span></div>\n");
      out.write("                        <table class=\"table table-hover\">\n");
      out.write("                            <thead class=\"diceHead\">\n");
      out.write("                                <tr>\n");
      out.write("                                    <th>Dice Results</th>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody id=\"diceResultsBody\" class=\"diceBody\">\n");
      out.write("                                <tr ng-repeat=\"diceResult in ctrl.results | orderBy:'$index':true\">\n");
      out.write("                                    <td><span ng-bind=\"diceResult.result\"></span></td>\n");
      out.write("                                </tr>\n");
      out.write("                            </tbody>\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"col-md-12 endGameBtn\">\n");
      out.write("                    <button type=\"button\" ng-click=\"ctrl.endGame()\" class=\"btn btn-danger\" ng-disabled=\"ctrl.gameEnded\">End Game</button>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script src=\"");
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write("\"></script>\n");
      out.write("        <script src=\"");
      if (_jspx_meth_c_005furl_005f2(_jspx_page_context))
        return;
      out.write("\"></script>\n");
      out.write("        <script src=\"");
      if (_jspx_meth_c_005furl_005f3(_jspx_page_context))
        return;
      out.write("\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005furl_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f0.setParent(null);
    // /index.jsp(18,20) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/static/css/app.css");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f1.setParent(null);
    // /index.jsp(156,21) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f1.setValue("/static/js/app.js");
    int _jspx_eval_c_005furl_005f1 = _jspx_th_c_005furl_005f1.doStartTag();
    if (_jspx_th_c_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f2 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f2.setParent(null);
    // /index.jsp(157,21) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f2.setValue("/static/js/service/player_service.js");
    int _jspx_eval_c_005furl_005f2 = _jspx_th_c_005furl_005f2.doStartTag();
    if (_jspx_th_c_005furl_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f3 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f3.setParent(null);
    // /index.jsp(158,21) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f3.setValue("/static/js/controller/player_controller.js");
    int _jspx_eval_c_005furl_005f3 = _jspx_th_c_005furl_005f3.doStartTag();
    if (_jspx_th_c_005furl_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f3);
    return false;
  }
}