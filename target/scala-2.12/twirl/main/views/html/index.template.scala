
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

            <!--<link rel='stylesheet' href='"""),_display_(/*10.47*/routes/*10.53*/.Assets.at("lib/bootstrap/css/bootstrap.css")),format.raw/*10.98*/("""'>-->
            <!--<link rel='stylesheet' href='"""),_display_(/*11.47*/routes/*11.53*/.Assets.at("lib/bootstrap/css/bootstrap-theme.css")),format.raw/*11.104*/("""'>-->
            <!--<link rel="stylesheet" media="screen" href=""""),_display_(/*12.62*/routes/*12.68*/.Assets.at("stylesheets/main.css")),format.raw/*12.102*/("""">-->
            <!--<link rel="shortcut icon" type="image/png" href=""""),_display_(/*13.67*/routes/*13.73*/.Assets.at("images/favicon.png")),format.raw/*13.105*/("""">-->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Chat Application</title>

            <!-- Bootstrap core CSS -->
        <link href='"""),_display_(/*22.22*/routes/*22.28*/.Assets.at("vendor/bootstrap/css/bootstrap.min.css")),format.raw/*22.80*/("""' rel="stylesheet">

            <!-- Custom styles for this template -->
        <link href='"""),_display_(/*25.22*/routes/*25.28*/.Assets.at("css/simple-sidebar.css")),format.raw/*25.64*/("""' rel="stylesheet">

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
                            <ul id="messages" class="list-unstyled" ; style="overflow: scroll;
                                height: 400px;">
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
        <script src='"""),_display_(/*88.23*/routes/*88.29*/.Assets.at("vendor/jquery/jquery.min.js")),format.raw/*88.70*/("""'></script>
        <script src='"""),_display_(/*89.23*/routes/*89.29*/.Assets.at("vendor/popper/popper.min.js")),format.raw/*89.70*/("""'></script>
        <script src='"""),_display_(/*90.23*/routes/*90.29*/.Assets.at("vendor/bootstrap/js/bootstrap.min.js")),format.raw/*90.79*/("""'></script>

            <!-- Menu Toggle Script -->
        <script language="javascript">
                function getQueryVariable(variable)
                """),format.raw/*95.17*/("""{"""),format.raw/*95.18*/("""
                    """),format.raw/*96.21*/("""var query = window.location.search.substring(1);
                    var vars = query.split("&");
                    for (var i=0;i<vars.length;i++) """),format.raw/*98.53*/("""{"""),format.raw/*98.54*/("""
                        """),format.raw/*99.25*/("""var pair = vars[i].split("=");
                        if(pair[0] == variable)"""),format.raw/*100.48*/("""{"""),format.raw/*100.49*/("""return pair[1];"""),format.raw/*100.64*/("""}"""),format.raw/*100.65*/("""
                    """),format.raw/*101.21*/("""}"""),format.raw/*101.22*/("""
                    """),format.raw/*102.21*/("""return(false);
                """),format.raw/*103.17*/("""}"""),format.raw/*103.18*/("""

                """),format.raw/*105.17*/("""//TODO: here hardcode channel id for test, need to update
                var channelIdDefault = 100;

                var userId = getQueryVariable("userId");

                //TODO: check if userId is a number
                if(userId == null || userId == "" ) """),format.raw/*111.53*/("""{"""),format.raw/*111.54*/("""
                    """),format.raw/*112.21*/("""alert("You are not part of the s¥stem!")
                """),format.raw/*113.17*/("""}"""),format.raw/*113.18*/(""" """),format.raw/*113.19*/("""else """),format.raw/*113.24*/("""{"""),format.raw/*113.25*/("""
                    """),format.raw/*114.21*/("""var $messages = $("#messages");
                    var $send = $("#send");
                    var $message = $("#message");
                    var connection = new WebSocket(""""),_display_(/*117.54*/url),format.raw/*117.57*/("""" + "?userId=" + userId);

                    $send.prop("disabled", true);

                    var send = function () """),format.raw/*121.44*/("""{"""),format.raw/*121.45*/("""
                        """),format.raw/*122.25*/("""//TODO: combine current channelId + content with |

                        var text = $message.val();
                        $message.val("");
                        var messageRaw = channelIdDefault + "|" + text;
                        connection.send(messageRaw);
                    """),format.raw/*128.21*/("""}"""),format.raw/*128.22*/(""";

                    connection.onopen = function () """),format.raw/*130.53*/("""{"""),format.raw/*130.54*/("""
                        """),format.raw/*131.25*/("""$send.prop("disabled", false);
                        $messages.prepend($("<li class='bg-info' style='font-size: 1.5em'>Connected</li>"));
                        $send.on('click', send);
                        $message.keypress(function (event) """),format.raw/*134.60*/("""{"""),format.raw/*134.61*/("""
                            """),format.raw/*135.29*/("""var keycode = (event.keyCode ? event.keyCode : event.which);
                            if (keycode == '13') """),format.raw/*136.50*/("""{"""),format.raw/*136.51*/("""
                                """),format.raw/*137.33*/("""send();
                            """),format.raw/*138.29*/("""}"""),format.raw/*138.30*/("""
                        """),format.raw/*139.25*/("""}"""),format.raw/*139.26*/(""");
                    """),format.raw/*140.21*/("""}"""),format.raw/*140.22*/(""";
                    connection.onerror = function (error) """),format.raw/*141.59*/("""{"""),format.raw/*141.60*/("""
                        """),format.raw/*142.25*/("""console.log('WebSocket Error ', error);
                    """),format.raw/*143.21*/("""}"""),format.raw/*143.22*/(""";
                    connection.onmessage = function (event) """),format.raw/*144.61*/("""{"""),format.raw/*144.62*/("""
                        """),format.raw/*145.25*/("""//TODO: parse & get channelId, after that put message to right channel (UI)
                        $messages.append($("<li style='font-size: 1.5em'>" + event.data + "</li>"))
                    """),format.raw/*147.21*/("""}"""),format.raw/*147.22*/("""
                """),format.raw/*148.17*/("""}"""),format.raw/*148.18*/("""
        """),format.raw/*149.9*/("""</script>

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
                  DATE: Sun Aug 20 10:15:05 ICT 2017
                  SOURCE: /Users/sqle/academic/cs/summer-java/web-chat-application/app/views/index.scala.html
                  HASH: edbd6fa542019180f5d8d013bd8fc954702312f2
                  MATRIX: 948->1|1056->14|1083->15|1405->310|1420->316|1486->361|1565->413|1580->419|1653->470|1747->537|1762->543|1818->577|1917->649|1932->655|1986->687|2333->1007|2348->1013|2421->1065|2543->1160|2558->1166|2615->1202|4625->3185|4640->3191|4702->3232|4763->3266|4778->3272|4840->3313|4901->3347|4916->3353|4987->3403|5175->3563|5204->3564|5253->3585|5431->3735|5460->3736|5513->3761|5620->3839|5650->3840|5694->3855|5724->3856|5774->3877|5804->3878|5854->3899|5914->3930|5944->3931|5991->3949|6285->4214|6315->4215|6365->4236|6451->4293|6481->4294|6511->4295|6545->4300|6575->4301|6625->4322|6832->4501|6857->4504|7007->4625|7037->4626|7091->4651|7410->4941|7440->4942|7524->4997|7554->4998|7608->5023|7885->5271|7915->5272|7973->5301|8112->5411|8142->5412|8204->5445|8269->5481|8299->5482|8353->5507|8383->5508|8435->5531|8465->5532|8554->5592|8584->5593|8638->5618|8727->5678|8757->5679|8848->5741|8878->5742|8932->5767|9157->5963|9187->5964|9233->5981|9263->5982|9300->5991
                  LINES: 28->1|33->1|34->2|42->10|42->10|42->10|43->11|43->11|43->11|44->12|44->12|44->12|45->13|45->13|45->13|54->22|54->22|54->22|57->25|57->25|57->25|120->88|120->88|120->88|121->89|121->89|121->89|122->90|122->90|122->90|127->95|127->95|128->96|130->98|130->98|131->99|132->100|132->100|132->100|132->100|133->101|133->101|134->102|135->103|135->103|137->105|143->111|143->111|144->112|145->113|145->113|145->113|145->113|145->113|146->114|149->117|149->117|153->121|153->121|154->122|160->128|160->128|162->130|162->130|163->131|166->134|166->134|167->135|168->136|168->136|169->137|170->138|170->138|171->139|171->139|172->140|172->140|173->141|173->141|174->142|175->143|175->143|176->144|176->144|177->145|179->147|179->147|180->148|180->148|181->149
                  -- GENERATED --
              */
          