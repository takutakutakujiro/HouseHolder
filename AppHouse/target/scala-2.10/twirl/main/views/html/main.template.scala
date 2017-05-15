
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object main_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.32*/("""
"""),format.raw/*2.1*/("""<!DOCTYPE html>
<html>
 <head>
  	<title>title</title>
    <meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- BootstrapのCSS読み込み -->
	<link href=""""),_display_(/*10.15*/routes/*10.21*/.Assets.versioned("css/bootstrap.min.css")),format.raw/*10.63*/("""" rel="stylesheet">
	<!-- jQuery読み込み -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- BootstrapのJS読み込み -->
	<script src=""""),_display_(/*14.16*/routes/*14.22*/.Assets.versioned("js/bootstrap.min.js")),format.raw/*14.62*/(""""></script>
	<!-- CSS読み込み -->
	<link href=""""),_display_(/*16.15*/routes/*16.21*/.Assets.versioned("css/style.css")),format.raw/*16.55*/("""" rel="stylesheet">
 </head>
 	<body>
  		"""),_display_(/*19.6*/content),format.raw/*19.13*/("""
 	"""),format.raw/*20.3*/("""</body>
</html>
"""))
      }
    }
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}


}

/**/
object main extends main_Scope0.main
              /*
                  -- GENERATED --
                  DATE: Sun May 14 22:11:19 JST 2017
                  SOURCE: /Users/nishida-takuro/git/HouseHolder/AppHouse/app/views/main.scala.html
                  HASH: 9a82e40e5d6eb8b76bef258bdf206f7457089d7f
                  MATRIX: 530->1|655->31|682->32|958->281|973->287|1036->329|1237->503|1252->509|1313->549|1384->593|1399->599|1454->633|1523->676|1551->683|1581->686
                  LINES: 20->1|25->1|26->2|34->10|34->10|34->10|38->14|38->14|38->14|40->16|40->16|40->16|43->19|43->19|44->20
                  -- GENERATED --
              */
          