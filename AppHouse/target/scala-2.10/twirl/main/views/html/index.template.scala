
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

class index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[List[Map[String, String]],List[Map[String, String]],Int,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(elaListMap: List[Map[String, String]], viewListMap: List[Map[String, String]], pageNo: Int):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*9.2*/navi/*9.6*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*9.10*/("""
    """),format.raw/*10.5*/("""<nav class="navbar navbar-inverse navbar-fixed-top">
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
""")))};def /*53.2*/list/*53.6*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*53.10*/("""
	"""),format.raw/*54.2*/("""<div class="property_unit-content" style="margin-top: 100px">

	"""),_display_(/*56.3*/for( map <- viewListMap) yield /*56.27*/{_display_(Seq[Any](format.raw/*56.28*/("""
		"""),format.raw/*57.3*/("""<div class="container">
			<a href=""""),_display_(/*58.14*/map("detail_url")),format.raw/*58.31*/("""" target="_blank">
				<div class="col-xs-12"><h4>"""),_display_(/*59.33*/map("title")),format.raw/*59.45*/("""</h4></div>
				<div class="col-xs-4"><img src=""""),_display_(/*60.38*/map("img")),format.raw/*60.48*/("""" rel="" alt="" width="192" height="144"></div>
			</a>
			<div class="col-xs-2 item">販売価格</div>
			<div class="col-xs-6 item">
				"""),_display_(/*64.6*/if(map("minPrice") == map("maxPrice"))/*64.44*/{_display_(Seq[Any](format.raw/*64.45*/("""
					"""),_display_(/*65.7*/map("minPrice")),format.raw/*65.22*/("""
				""")))}/*66.7*/else/*66.12*/{_display_(Seq[Any](format.raw/*66.13*/("""
					"""),_display_(/*67.7*/map("minPrice")),format.raw/*67.22*/(""" """),format.raw/*67.23*/("""~ """),_display_(/*67.26*/map("maxPrice")),format.raw/*67.41*/("""
				""")))}),format.raw/*68.6*/("""
			"""),format.raw/*69.4*/("""</div>
			<div class="col-xs-2 item">所在地</div>
			<div class="col-xs-6 item">"""),_display_(/*71.32*/map("address")),format.raw/*71.46*/("""</div>	
			<div class="col-xs-2 item">沿線・駅</div>
			<div class="col-xs-6 item">"""),_display_(/*73.32*/map("station")),format.raw/*73.46*/("""</div>											
			<div class="col-xs-2 item">土地面積</div>
			<div class="col-xs-6 item">
				"""),_display_(/*76.6*/if(map("minSpace") == map("maxSpace"))/*76.44*/{_display_(Seq[Any](format.raw/*76.45*/("""
					"""),_display_(/*77.7*/map("minSpace")),format.raw/*77.22*/("""
				""")))}/*78.7*/else/*78.12*/{_display_(Seq[Any](format.raw/*78.13*/("""
					"""),_display_(/*79.7*/map("minSpace")),format.raw/*79.22*/(""" """),format.raw/*79.23*/("""~ """),_display_(/*79.26*/map("maxSpace")),format.raw/*79.41*/("""
				""")))}),format.raw/*80.6*/("""
				"""),format.raw/*81.5*/("""m<sup>2</sup>
			</div>
			<div class="col-xs-2 item">間取り</div>
			<div class="col-xs-6 item">"""),_display_(/*84.32*/map("roomLayout")),format.raw/*84.49*/("""</div>
		</div>
	""")))}),format.raw/*86.3*/("""
	"""),format.raw/*87.2*/("""</div>
""")))};def /*90.2*/page/*90.6*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*90.10*/("""
	"""),format.raw/*91.2*/("""<nav class="pagecontent" aria-label="Page navigation example">
	  <ul class="pagination">
	    <li class="page-item">
	      """),_display_(/*94.9*/if(pageNo == 1)/*94.24*/{_display_(Seq[Any](format.raw/*94.25*/("""
            """),format.raw/*95.13*/("""<a class="page-link" href="#" aria-label="Previous">
	      """)))}/*96.10*/else/*96.15*/{_display_(Seq[Any](format.raw/*96.16*/("""
	      	"""),format.raw/*97.9*/("""<a class="page-link" href=""""),_display_(/*97.37*/{url}),_display_(/*97.43*/{pageNo-1}),format.raw/*97.53*/("""" aria-label="Previous">
	      """)))}),format.raw/*98.9*/("""
	        """),format.raw/*99.10*/("""<span aria-hidden="true">&laquo;</span>
	        <span class="sr-only">Previous</span>
	      </a>
	    </li>
	    """),_display_(/*103.7*/if(pageNo == 1 || pageNo == 2)/*103.37*/{_display_(Seq[Any](format.raw/*103.38*/("""
			"""),format.raw/*104.4*/("""<li class="page-item"><a class="page-link" href=""""),_display_(/*104.54*/{url}),format.raw/*104.59*/("""1">1</a></li>
	    	<li class="page-item"><a class="page-link" href=""""),_display_(/*105.57*/{url}),format.raw/*105.62*/("""2">2</a></li>
	    	<li class="page-item"><a class="page-link" href=""""),_display_(/*106.57*/{url}),format.raw/*106.62*/("""3">3</a></li>
	    	<li class="page-item"><a class="page-link" href=""""),_display_(/*107.57*/{url}),format.raw/*107.62*/("""4">4</a></li>
	    	<li class="page-item"><a class="page-link" href=""""),_display_(/*108.57*/{url}),format.raw/*108.62*/("""5">5</a></li>
	    """)))}/*109.8*/else/*109.13*/{_display_(Seq[Any](format.raw/*109.14*/("""
	    	"""),format.raw/*110.7*/("""<li class="page-item"><a class="page-link" href=""""),_display_(/*110.57*/{url}),_display_(/*110.63*/{pageNo-2}),format.raw/*110.73*/("""">"""),_display_(/*110.76*/{pageNo - 2}),format.raw/*110.88*/("""</a></li>	    
	    	<li class="page-item"><a class="page-link" href=""""),_display_(/*111.57*/{url}),_display_(/*111.63*/{pageNo-1}),format.raw/*111.73*/("""">"""),_display_(/*111.76*/{pageNo - 1}),format.raw/*111.88*/("""</a></li>
		    <li class="page-item"><a class="page-link" href=""""),_display_(/*112.57*/{url}),_display_(/*112.63*/{pageNo}),format.raw/*112.71*/("""">"""),_display_(/*112.74*/pageNo),format.raw/*112.80*/("""</a></li>
		    <li class="page-item"><a class="page-link" href=""""),_display_(/*113.57*/{url}),_display_(/*113.63*/{pageNo+1}),format.raw/*113.73*/("""">"""),_display_(/*113.76*/{pageNo + 1}),format.raw/*113.88*/("""</a></li>
	    	<li class="page-item"><a class="page-link" href=""""),_display_(/*114.57*/{url}),_display_(/*114.63*/{pageNo+2}),format.raw/*114.73*/("""">"""),_display_(/*114.76*/{pageNo + 2}),format.raw/*114.88*/("""</a></li>		    
	    """)))}),format.raw/*115.7*/("""
	    
	    """),format.raw/*117.6*/("""<li class="page-item">
	      """),_display_(/*118.9*/if(pageNo == 1)/*118.24*/{_display_(Seq[Any](format.raw/*118.25*/("""
            """),format.raw/*119.13*/("""<a class="page-link" href="#" aria-label="Next">
	      """)))}/*120.10*/else/*120.15*/{_display_(Seq[Any](format.raw/*120.16*/("""
	      	"""),format.raw/*121.9*/("""<a class="page-link" href=""""),_display_(/*121.37*/{url}),_display_(/*121.43*/{pageNo+1}),format.raw/*121.53*/("""" aria-label="Next">
	      """)))}),format.raw/*122.9*/("""
	        """),format.raw/*123.10*/("""<span aria-hidden="true">&raquo;</span>
	        <span class="sr-only">Next</span>
	      </a>
	    </li>
	  </ul>
	</nav>
""")))};def /*2.2*/url/*2.5*/ = {{"http://localhost:9000/page/"}};
Seq[Any](format.raw/*1.94*/("""
"""),format.raw/*2.40*/("""

"""),_display_(/*4.2*/main("HouseHolder")/*4.21*/{_display_(Seq[Any](format.raw/*4.22*/("""
	"""),_display_(/*5.3*/navi),format.raw/*5.7*/("""
	"""),_display_(/*6.3*/list),format.raw/*6.7*/("""
	"""),_display_(/*7.3*/page),format.raw/*7.7*/("""
""")))}),format.raw/*8.2*/("""
"""),format.raw/*51.2*/("""

"""),format.raw/*88.2*/("""

"""))
      }
    }
  }

  def render(elaListMap:List[Map[String, String]],viewListMap:List[Map[String, String]],pageNo:Int): play.twirl.api.HtmlFormat.Appendable = apply(elaListMap,viewListMap,pageNo)

  def f:((List[Map[String, String]],List[Map[String, String]],Int) => play.twirl.api.HtmlFormat.Appendable) = (elaListMap,viewListMap,pageNo) => apply(elaListMap,viewListMap,pageNo)

  def ref: this.type = this

}


}

/**/
object index extends index_Scope0.index
              /*
                  -- GENERATED --
                  DATE: Mon May 15 23:10:25 JST 2017
                  SOURCE: /Users/nishida-takuro/git/HouseHolder/AppHouse/app/views/index.scala.html
                  HASH: b61f6b005fa4f4777ebd0d3328b443a9c09090dd
                  MATRIX: 576->1|746->181|757->185|837->189|869->194|2383->1688|2395->1692|2476->1696|2505->1698|2596->1763|2636->1787|2675->1788|2705->1791|2769->1828|2807->1845|2885->1896|2918->1908|2994->1957|3025->1967|3184->2100|3231->2138|3270->2139|3303->2146|3339->2161|3363->2168|3376->2173|3415->2174|3448->2181|3484->2196|3513->2197|3543->2200|3579->2215|3615->2221|3646->2225|3751->2303|3786->2317|3893->2397|3928->2411|4049->2506|4096->2544|4135->2545|4168->2552|4204->2567|4228->2574|4241->2579|4280->2580|4313->2587|4349->2602|4378->2603|4408->2606|4444->2621|4480->2627|4512->2632|4634->2727|4672->2744|4720->2762|4749->2764|4780->2775|4792->2779|4873->2783|4902->2785|5054->2911|5078->2926|5117->2927|5158->2940|5238->3002|5251->3007|5290->3008|5326->3017|5381->3045|5407->3051|5438->3061|5501->3094|5539->3104|5682->3220|5722->3250|5762->3251|5794->3255|5872->3305|5899->3310|5997->3380|6024->3385|6122->3455|6149->3460|6247->3530|6274->3535|6372->3605|6399->3610|6438->3631|6452->3636|6492->3637|6527->3644|6605->3694|6632->3700|6664->3710|6695->3713|6729->3725|6828->3796|6855->3802|6887->3812|6918->3815|6952->3827|7046->3893|7073->3899|7103->3907|7134->3910|7162->3916|7256->3982|7283->3988|7315->3998|7346->4001|7380->4013|7474->4079|7501->4085|7533->4095|7564->4098|7598->4110|7651->4132|7691->4144|7749->4175|7774->4190|7814->4191|7856->4204|7933->4262|7947->4267|7987->4268|8024->4277|8080->4305|8107->4311|8139->4321|8199->4350|8238->4360|8384->95|8394->98|8459->93|8487->133|8515->136|8542->155|8580->156|8608->159|8631->163|8659->166|8682->170|8710->173|8733->177|8764->179|8792->1685|8821->2772
                  LINES: 20->1|24->9|24->9|26->9|27->10|68->53|68->53|70->53|71->54|73->56|73->56|73->56|74->57|75->58|75->58|76->59|76->59|77->60|77->60|81->64|81->64|81->64|82->65|82->65|83->66|83->66|83->66|84->67|84->67|84->67|84->67|84->67|85->68|86->69|88->71|88->71|90->73|90->73|93->76|93->76|93->76|94->77|94->77|95->78|95->78|95->78|96->79|96->79|96->79|96->79|96->79|97->80|98->81|101->84|101->84|103->86|104->87|105->90|105->90|107->90|108->91|111->94|111->94|111->94|112->95|113->96|113->96|113->96|114->97|114->97|114->97|114->97|115->98|116->99|120->103|120->103|120->103|121->104|121->104|121->104|122->105|122->105|123->106|123->106|124->107|124->107|125->108|125->108|126->109|126->109|126->109|127->110|127->110|127->110|127->110|127->110|127->110|128->111|128->111|128->111|128->111|128->111|129->112|129->112|129->112|129->112|129->112|130->113|130->113|130->113|130->113|130->113|131->114|131->114|131->114|131->114|131->114|132->115|134->117|135->118|135->118|135->118|136->119|137->120|137->120|137->120|138->121|138->121|138->121|138->121|139->122|140->123|146->2|146->2|147->1|148->2|150->4|150->4|150->4|151->5|151->5|152->6|152->6|153->7|153->7|154->8|155->51|157->88
                  -- GENERATED --
              */
          