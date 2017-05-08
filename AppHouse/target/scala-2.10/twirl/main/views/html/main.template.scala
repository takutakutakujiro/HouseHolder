
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
 </head>
 	<body>
  		"""),_display_(/*17.6*/content),format.raw/*17.13*/("""
 	"""),format.raw/*18.3*/("""</body>
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
                  DATE: Thu May 04 23:44:54 JST 2017
                  SOURCE: /Users/nishida-takuro/git/HouseHolder/AppHouse/app/views/main.scala.html
                  HASH: b9ed0ed5cc55f27b59d8f75cb8eb7da41b6b85d8
                  MATRIX: 530->1|655->31|682->32|958->281|973->287|1036->329|1237->503|1252->509|1313->549|1374->584|1402->591|1432->594
                  LINES: 20->1|25->1|26->2|34->10|34->10|34->10|38->14|38->14|38->14|41->17|41->17|42->18
                  -- GENERATED --
              */
          