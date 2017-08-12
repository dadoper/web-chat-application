
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
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel='stylesheet' href='"""),_display_(/*9.39*/routes/*9.45*/.Assets.at("lib/bootstrap/css/bootstrap.css")),format.raw/*9.90*/("""'>
        <link rel='stylesheet' href='"""),_display_(/*10.39*/routes/*10.45*/.Assets.at("lib/bootstrap/css/bootstrap-theme.css")),format.raw/*10.96*/("""'>
        <link rel="stylesheet" media="screen" href=""""),_display_(/*11.54*/routes/*11.60*/.Assets.at("stylesheets/main.css")),format.raw/*11.94*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*12.59*/routes/*12.65*/.Assets.at("images/favicon.png")),format.raw/*12.97*/("""">
        <title>Chat Room</title>

    </head>

    <body>
        <div class="wrap">
            <div class="container-fluid">
                <div>
                    <h1 class="">Chat Room</h1>
                </div>

                <div class="row">
                    <div class="col-lg-12">
                        <ul id="messages" class="list-unstyled">
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
                      class="form-control input-lg" />
                </div>

                <div class="col-xs-4 col-sm-3">
                    <button id="send" type="submit" class="btn btn-primary btn-lg btn-block">Send</button>
                </div>
            </div>
        </div>

        <script type='text/javascript' src='"""),_display_(/*48.46*/routes/*48.52*/.Assets.at("lib/jquery/jquery.js")),format.raw/*48.86*/("""'></script>
        <script type='text/javascript' src='"""),_display_(/*49.46*/routes/*49.52*/.Assets.at("lib/flot/jquery.flot.js")),format.raw/*49.89*/("""'></script>

        <script language="javascript">
                var $messages = $("#messages"),
                        $send = $("#send"),
                        $message = $("#message"),
                        connection = new WebSocket(""""),_display_(/*55.54*/url),format.raw/*55.57*/("""");

                $send.prop("disabled", true);

                var send = function () """),format.raw/*59.40*/("""{"""),format.raw/*59.41*/("""
                    """),format.raw/*60.21*/("""var text = $message.val();
                    $message.val("");
                    connection.send(text);
                """),format.raw/*63.17*/("""}"""),format.raw/*63.18*/(""";

                connection.onopen = function () """),format.raw/*65.49*/("""{"""),format.raw/*65.50*/("""
                    """),format.raw/*66.21*/("""$send.prop("disabled", false);
                    $messages.prepend($("<li class='bg-info' style='font-size: 1.5em'>Connected</li>"));
                    $send.on('click', send);
                    $message.keypress(function(event)"""),format.raw/*69.54*/("""{"""),format.raw/*69.55*/("""
                        """),format.raw/*70.25*/("""var keycode = (event.keyCode ? event.keyCode : event.which);
                        if(keycode == '13')"""),format.raw/*71.44*/("""{"""),format.raw/*71.45*/("""
                            """),format.raw/*72.29*/("""send();
                        """),format.raw/*73.25*/("""}"""),format.raw/*73.26*/("""
                    """),format.raw/*74.21*/("""}"""),format.raw/*74.22*/(""");
                """),format.raw/*75.17*/("""}"""),format.raw/*75.18*/(""";
                connection.onerror = function (error) """),format.raw/*76.55*/("""{"""),format.raw/*76.56*/("""
                    """),format.raw/*77.21*/("""console.log('WebSocket Error ', error);
                """),format.raw/*78.17*/("""}"""),format.raw/*78.18*/(""";
                connection.onmessage = function (event) """),format.raw/*79.57*/("""{"""),format.raw/*79.58*/("""
                    """),format.raw/*80.21*/("""$messages.append($("<li style='font-size: 1.5em'>" + event.data + "</li>"))
                """),format.raw/*81.17*/("""}"""),format.raw/*81.18*/("""
        """),format.raw/*82.9*/("""</script>
    </body>

</html>"""))
      }
    }
  }

  def render(url:String): play.twirl.api.HtmlFormat.Appendable = apply(url)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (url) => apply(url)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sat Aug 12 15:12:00 ICT 2017
                  SOURCE: /Users/sqle/Desktop/CS/WebChatApplication/app/views/index.scala.html
                  HASH: 6400551777f93471012df69b16fd9848827eea03
                  MATRIX: 948->1|1056->14|1083->15|1362->268|1376->274|1441->319|1509->360|1524->366|1596->417|1679->473|1694->479|1749->513|1837->574|1852->580|1905->612|3064->1744|3079->1750|3134->1784|3218->1841|3233->1847|3291->1884|3565->2131|3589->2134|3708->2225|3737->2226|3786->2247|3938->2371|3967->2372|4046->2423|4075->2424|4124->2445|4386->2679|4415->2680|4468->2705|4600->2809|4629->2810|4686->2839|4746->2871|4775->2872|4824->2893|4853->2894|4900->2913|4929->2914|5013->2970|5042->2971|5091->2992|5175->3048|5204->3049|5290->3107|5319->3108|5368->3129|5488->3221|5517->3222|5553->3231
                  LINES: 28->1|33->1|34->2|41->9|41->9|41->9|42->10|42->10|42->10|43->11|43->11|43->11|44->12|44->12|44->12|80->48|80->48|80->48|81->49|81->49|81->49|87->55|87->55|91->59|91->59|92->60|95->63|95->63|97->65|97->65|98->66|101->69|101->69|102->70|103->71|103->71|104->72|105->73|105->73|106->74|106->74|107->75|107->75|108->76|108->76|109->77|110->78|110->78|111->79|111->79|112->80|113->81|113->81|114->82
                  -- GENERATED --
              */
          