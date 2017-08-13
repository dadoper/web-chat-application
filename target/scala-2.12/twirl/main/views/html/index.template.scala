
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(url: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.15*/("""
"""),format.raw/*2.1*/("""<!DOCTYPE html>
<html lang="en">

<head>
    <!--<meta charset="utf-8">-->
    <!--<meta http-equiv="X-UA-Compatible" content="IE=edge">-->
    <!--<meta name="viewport" content="width=device-width, initial-scale=1">-->

    <!--<link rel='stylesheet' href='"""),_display_(/*10.39*/routes/*10.45*/.Assets.at("lib/bootstrap/css/bootstrap.css")),format.raw/*10.90*/("""'>-->
    <!--<link rel='stylesheet' href='"""),_display_(/*11.39*/routes/*11.45*/.Assets.at("lib/bootstrap/css/bootstrap-theme.css")),format.raw/*11.96*/("""'>-->
    <!--<link rel="stylesheet" media="screen" href=""""),_display_(/*12.54*/routes/*12.60*/.Assets.at("stylesheets/main.css")),format.raw/*12.94*/("""">-->
    <!--<link rel="shortcut icon" type="image/png" href=""""),_display_(/*13.59*/routes/*13.65*/.Assets.at("images/favicon.png")),format.raw/*13.97*/("""">-->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Chat Application</title>

    <!-- Bootstrap core CSS -->
    <link href='"""),_display_(/*22.18*/routes/*22.24*/.Assets.at("vendor/bootstrap/css/bootstrap.min.css")),format.raw/*22.76*/("""' rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href='"""),_display_(/*25.18*/routes/*25.24*/.Assets.at("css/simple-sidebar.css")),format.raw/*25.60*/("""' rel="stylesheet">

</head>

<body>

<div id="wrapper" class="toggled">

    <!-- Sidebar -->
    <div id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <li class="sidebar-brand">
                <a href="#">
                    ChatApplication
                </a>
            </li>
            <li>
                <a href="#">Room</a>
            </li>

        </ul>
    </div>
    <!-- /#sidebar-wrapper -->

    <!-- Page Content -->
    <div id="page-content-wrapper">

        <div class="container-fluid">
            <div>
                <h1 class="">Chat Room</h1>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <ul id="messages" class="list-unstyled"; style="overflow: scroll; height: 400px;">
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <div class="footer navbar-fixed-bottom">
        <div class="row">
            <div class="col-xs-8 col-sm-9">
                <input id="message" placeholder="Type Here" type="text"
                       autofocus
                       autocomplete="off" spellcheck="false" autocorrect="off"
                       class="form-control input-lg"/>
            </div>

            <div class="col-xs-4 col-sm-3">
                <button id="send" type="submit" class="btn btn-primary btn-lg btn-block">Send</button>
            </div>
        </div>
    </div>

    <!-- /#page-content-wrapper -->

</div>
<!-- /#wrapper -->

<!-- Bootstrap core JavaScript -->
<script src='"""),_display_(/*87.15*/routes/*87.21*/.Assets.at("vendor/jquery/jquery.min.js")),format.raw/*87.62*/("""'></script>
<script src='"""),_display_(/*88.15*/routes/*88.21*/.Assets.at("vendor/popper/popper.min.js")),format.raw/*88.62*/("""'></script>
<script src='"""),_display_(/*89.15*/routes/*89.21*/.Assets.at("vendor/bootstrap/js/bootstrap.min.js")),format.raw/*89.71*/("""'></script>

<!-- Menu Toggle Script -->
<script language="javascript">
                var $messages = $("#messages"),
                        $send = $("#send"),
                        $message = $("#message"),
                        connection = new WebSocket(""""),_display_(/*96.54*/url),format.raw/*96.57*/("""");

                $send.prop("disabled", true);

                var send = function () """),format.raw/*100.40*/("""{"""),format.raw/*100.41*/("""
                    """),format.raw/*101.21*/("""var text = $message.val();
                    $message.val("");
                    connection.send(text);
                """),format.raw/*104.17*/("""}"""),format.raw/*104.18*/(""";

                connection.onopen = function () """),format.raw/*106.49*/("""{"""),format.raw/*106.50*/("""
                    """),format.raw/*107.21*/("""$send.prop("disabled", false);
                    $messages.prepend($("<li class='bg-info' style='font-size: 1.5em'>Connected</li>"));
                    $send.on('click', send);
                    $message.keypress(function(event)"""),format.raw/*110.54*/("""{"""),format.raw/*110.55*/("""
                        """),format.raw/*111.25*/("""var keycode = (event.keyCode ? event.keyCode : event.which);
                        if(keycode == '13')"""),format.raw/*112.44*/("""{"""),format.raw/*112.45*/("""
                            """),format.raw/*113.29*/("""send();
                        """),format.raw/*114.25*/("""}"""),format.raw/*114.26*/("""
                    """),format.raw/*115.21*/("""}"""),format.raw/*115.22*/(""");
                """),format.raw/*116.17*/("""}"""),format.raw/*116.18*/(""";
                connection.onerror = function (error) """),format.raw/*117.55*/("""{"""),format.raw/*117.56*/("""
                    """),format.raw/*118.21*/("""console.log('WebSocket Error ', error);
                """),format.raw/*119.17*/("""}"""),format.raw/*119.18*/(""";
                connection.onmessage = function (event) """),format.raw/*120.57*/("""{"""),format.raw/*120.58*/("""
                    """),format.raw/*121.21*/("""$messages.append($("<li style='font-size: 1.5em'>" + event.data + "</li>"))
                """),format.raw/*122.17*/("""}"""),format.raw/*122.18*/("""
        """),format.raw/*123.9*/("""</script>

</body>
</html>
"""))
      }
    }
  }

  def render(url:String): play.twirl.api.HtmlFormat.Appendable = apply(url)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (url) => apply(url)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sun Aug 13 15:53:02 ICT 2017
                  SOURCE: /Users/sqle/Desktop/CS/Web-Chat-Application/app/views/index.scala.html
                  HASH: 3ec303a8c67d95c53f8df9e0d5c5af1c4e9d1c7c
                  MATRIX: 948->1|1056->14|1083->15|1369->274|1384->280|1450->325|1521->369|1536->375|1608->426|1694->485|1709->491|1764->525|1855->589|1870->595|1923->627|2238->915|2253->921|2326->973|2436->1056|2451->1062|2508->1098|4098->2661|4113->2667|4175->2708|4228->2734|4243->2740|4305->2781|4358->2807|4373->2813|4444->2863|4738->3130|4762->3133|4882->3224|4912->3225|4962->3246|5115->3370|5145->3371|5225->3422|5255->3423|5305->3444|5568->3678|5598->3679|5652->3704|5785->3808|5815->3809|5873->3838|5934->3870|5964->3871|6014->3892|6044->3893|6092->3912|6122->3913|6207->3969|6237->3970|6287->3991|6372->4047|6402->4048|6489->4106|6519->4107|6569->4128|6690->4220|6720->4221|6757->4230
                  LINES: 28->1|33->1|34->2|42->10|42->10|42->10|43->11|43->11|43->11|44->12|44->12|44->12|45->13|45->13|45->13|54->22|54->22|54->22|57->25|57->25|57->25|119->87|119->87|119->87|120->88|120->88|120->88|121->89|121->89|121->89|128->96|128->96|132->100|132->100|133->101|136->104|136->104|138->106|138->106|139->107|142->110|142->110|143->111|144->112|144->112|145->113|146->114|146->114|147->115|147->115|148->116|148->116|149->117|149->117|150->118|151->119|151->119|152->120|152->120|153->121|154->122|154->122|155->123
                  -- GENERATED --
              */
          