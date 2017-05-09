
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object index_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[List[Map[String, String]],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(houseMap: List[Map[String, String]]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*7.2*/navi/*7.6*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*7.10*/("""
    """),format.raw/*8.5*/("""<nav class="navbar navbar-inverse navbar-fixed-top">
    	 <div class="navbar-header">
    	 
    	  	<a class="navbar-brand" href="#">LOGO</a>
    	 
    	  	<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#nav-content2">
      			<span class="icon-bar"></span>
      			<span class="icon-bar"></span>
      			<span class="icon-bar"></span>
    		</button>
    	  </div>
		  <div id="nav-content" class="collapse navbar-collapse">
		    <!--リンクのリスト メニューリスト-->
		    <ul class="nav navbar-nav">
		      <li><a href="">Link1</a></li>
		      <li><a href="">Link1</a></li>
		      <li><a href="">Link1</a></li>
		      <!--ドロップダウン化するliタグ-->
		      <li class="dropdown">
		        <a href="#" class="dropdown-toggle" data-toggle="dropdown" href="">Drop  <b class="caret"></b></a>
		        <ul class="dropdown-menu">
		          <li><a href="#">Link1</a></li>
		          <li><a href="#">Link2</a></li>
		          <li><a href="#">Link3</a></li>
		          <li class="divider"></li>
		          <li><a href="#">Link A</a></li>
		          <li class="divider"></li>
		          <li><a href="#">LInk B</a></li>
		        </ul>
		      </li>
		    </ul>

		    <!--検索フォーム-->
		    <form class="navbar-form navbar-right" role="search">
		      <div class="form-group">
		        <input type="text" class="form-control" placeholder="Search">
		      </div>
		      <button type="submit" class="btn btn-default">Submit</button>
		    </form>
		  </div>
    </nav>
""")))};def /*51.2*/list/*51.6*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*51.10*/("""
	"""),format.raw/*52.2*/("""<div style="margin-top: 100px">
		<ul>
			"""),_display_(/*54.5*/for( m <- houseMap) yield /*54.24*/{_display_(Seq[Any](format.raw/*54.25*/("""
				"""),format.raw/*55.5*/("""<li>"""),_display_(/*55.10*/m("title")),format.raw/*55.20*/("""</li>
				<li>"""),_display_(/*56.10*/m("minPrice")),format.raw/*56.23*/("""</li>
			""")))}),format.raw/*57.5*/("""
		"""),format.raw/*58.3*/("""</ul>
	<div>
""")))};
Seq[Any](format.raw/*1.39*/("""

"""),_display_(/*3.2*/main("HouseHolder")/*3.21*/{_display_(Seq[Any](format.raw/*3.22*/("""
	"""),_display_(/*4.3*/navi),format.raw/*4.7*/("""
	"""),_display_(/*5.3*/list),format.raw/*5.7*/("""
""")))}),format.raw/*6.2*/("""
"""),format.raw/*49.2*/("""

"""),format.raw/*60.2*/("""


"""))
      }
    }
  }

  def render(houseMap:List[Map[String, String]]): play.twirl.api.HtmlFormat.Appendable = apply(houseMap)

  def f:((List[Map[String, String]]) => play.twirl.api.HtmlFormat.Appendable) = (houseMap) => apply(houseMap)

  def ref: this.type = this

}


}

/**/
object index extends index_Scope0.index
              /*
                  -- GENERATED --
                  DATE: Wed May 10 02:13:28 JST 2017
                  SOURCE: /Users/nishida-takuro/git/HouseHolder/AppHouse/app/views/index.scala.html
                  HASH: 8b0b02c261c59baa336d848479e4c909d5b96c24
                  MATRIX: 546->1|661->79|672->83|752->87|783->92|2297->1586|2309->1590|2390->1594|2419->1596|2488->1639|2523->1658|2562->1659|2594->1664|2626->1669|2657->1679|2699->1694|2733->1707|2773->1717|2803->1720|2856->38|2884->41|2911->60|2949->61|2977->64|3000->68|3028->71|3051->75|3082->77|3110->1583|3139->1734
                  LINES: 20->1|24->7|24->7|26->7|27->8|68->51|68->51|70->51|71->52|73->54|73->54|73->54|74->55|74->55|74->55|75->56|75->56|76->57|77->58|80->1|82->3|82->3|82->3|83->4|83->4|84->5|84->5|85->6|86->49|88->60
                  -- GENERATED --
              */
          