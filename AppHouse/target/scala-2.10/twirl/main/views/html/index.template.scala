
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
	"""),format.raw/*57.2*/("""<blockquote>
		<div class="container">
			<a href=""""),_display_(/*59.14*/map("detail_url")),format.raw/*59.31*/("""" target="_blank">
				<div class="col-xs-12"><h4>"""),_display_(/*60.33*/map("title")),format.raw/*60.45*/("""</h4></div>
				<div class="col-xs-4"><img src=""""),_display_(/*61.38*/map("img")),format.raw/*61.48*/("""" rel="" alt="" width="192" height="144"></div>
			</a>
			<div class="col-xs-2 item">販売価格</div>
			<div class="col-xs-6 item">
				"""),_display_(/*65.6*/if(map("minPrice") == map("maxPrice"))/*65.44*/{_display_(Seq[Any](format.raw/*65.45*/("""
					"""),_display_(/*66.7*/map("minPrice")),format.raw/*66.22*/("""
				""")))}/*67.7*/else/*67.12*/{_display_(Seq[Any](format.raw/*67.13*/("""
					"""),_display_(/*68.7*/map("minPrice")),format.raw/*68.22*/(""" """),format.raw/*68.23*/("""~ """),_display_(/*68.26*/map("maxPrice")),format.raw/*68.41*/("""
				""")))}),format.raw/*69.6*/("""
			"""),format.raw/*70.4*/("""</div>
			<div class="col-xs-2 item">所在地</div>
			<div class="col-xs-6 item">"""),_display_(/*72.32*/map("address")),format.raw/*72.46*/("""</div>	
			<div class="col-xs-2 item">沿線・駅</div>
			<div class="col-xs-6 item">"""),_display_(/*74.32*/map("station")),format.raw/*74.46*/("""</div>											
			<div class="col-xs-2 item">土地面積</div>
			<div class="col-xs-6 item">
				"""),_display_(/*77.6*/if(map("minSpace") == map("maxSpace"))/*77.44*/{_display_(Seq[Any](format.raw/*77.45*/("""
					"""),_display_(/*78.7*/map("minSpace")),format.raw/*78.22*/("""
				""")))}/*79.7*/else/*79.12*/{_display_(Seq[Any](format.raw/*79.13*/("""
					"""),_display_(/*80.7*/map("minSpace")),format.raw/*80.22*/(""" """),format.raw/*80.23*/("""~ """),_display_(/*80.26*/map("maxSpace")),format.raw/*80.41*/("""
				""")))}),format.raw/*81.6*/("""
				"""),format.raw/*82.5*/("""m<sup>2</sup>
			</div>
			<div class="col-xs-2 item">間取り</div>
			<div class="col-xs-6 item">"""),_display_(/*85.32*/map("roomLayout")),format.raw/*85.49*/("""</div>
		</div>
	</blockquote>
	""")))}),format.raw/*88.3*/("""
	"""),format.raw/*89.2*/("""</div>
""")))};def /*92.2*/page/*92.6*/:play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*92.10*/("""
	"""),format.raw/*93.2*/("""<nav class="pagecontent" aria-label="Page navigation example">
	  <ul class="pagination">
	    <li class="page-item">
	      """),_display_(/*96.9*/if(pageNo == 1)/*96.24*/{_display_(Seq[Any](format.raw/*96.25*/("""
            """),format.raw/*97.13*/("""<a class="page-link" href="#" aria-label="Previous">
	      """)))}/*98.10*/else/*98.15*/{_display_(Seq[Any](format.raw/*98.16*/("""
	      	"""),format.raw/*99.9*/("""<a class="page-link" href=""""),_display_(/*99.37*/{url}),_display_(/*99.43*/{pageNo-1}),format.raw/*99.53*/("""" aria-label="Previous">
	      """)))}),format.raw/*100.9*/("""
	        """),format.raw/*101.10*/("""<span aria-hidden="true">&laquo;</span>
	        <span class="sr-only">Previous</span>
	      </a>
	    </li>
	    """),_display_(/*105.7*/if(pageNo == 1 || pageNo == 2)/*105.37*/{_display_(Seq[Any](format.raw/*105.38*/("""
			"""),format.raw/*106.4*/("""<li class="page-item"><a class="page-link" href=""""),_display_(/*106.54*/{url}),format.raw/*106.59*/("""1">1</a></li>
	    	<li class="page-item"><a class="page-link" href=""""),_display_(/*107.57*/{url}),format.raw/*107.62*/("""2">2</a></li>
	    	<li class="page-item"><a class="page-link" href=""""),_display_(/*108.57*/{url}),format.raw/*108.62*/("""3">3</a></li>
	    	<li class="page-item"><a class="page-link" href=""""),_display_(/*109.57*/{url}),format.raw/*109.62*/("""4">4</a></li>
	    	<li class="page-item"><a class="page-link" href=""""),_display_(/*110.57*/{url}),format.raw/*110.62*/("""5">5</a></li>
	    """)))}/*111.8*/else/*111.13*/{_display_(Seq[Any](format.raw/*111.14*/("""
	    	"""),format.raw/*112.7*/("""<li class="page-item"><a class="page-link" href=""""),_display_(/*112.57*/{url}),_display_(/*112.63*/{pageNo-2}),format.raw/*112.73*/("""">"""),_display_(/*112.76*/{pageNo - 2}),format.raw/*112.88*/("""</a></li>	    
	    	<li class="page-item"><a class="page-link" href=""""),_display_(/*113.57*/{url}),_display_(/*113.63*/{pageNo-1}),format.raw/*113.73*/("""">"""),_display_(/*113.76*/{pageNo - 1}),format.raw/*113.88*/("""</a></li>
		    <li class="page-item"><a class="page-link" href=""""),_display_(/*114.57*/{url}),_display_(/*114.63*/{pageNo}),format.raw/*114.71*/("""">"""),_display_(/*114.74*/pageNo),format.raw/*114.80*/("""</a></li>
		    <li class="page-item"><a class="page-link" href=""""),_display_(/*115.57*/{url}),_display_(/*115.63*/{pageNo+1}),format.raw/*115.73*/("""">"""),_display_(/*115.76*/{pageNo + 1}),format.raw/*115.88*/("""</a></li>
	    	<li class="page-item"><a class="page-link" href=""""),_display_(/*116.57*/{url}),_display_(/*116.63*/{pageNo+2}),format.raw/*116.73*/("""">"""),_display_(/*116.76*/{pageNo + 2}),format.raw/*116.88*/("""</a></li>		    
	    """)))}),format.raw/*117.7*/("""
	    
	    """),format.raw/*119.6*/("""<li class="page-item">
	      """),_display_(/*120.9*/if(pageNo == 1)/*120.24*/{_display_(Seq[Any](format.raw/*120.25*/("""
            """),format.raw/*121.13*/("""<a class="page-link" href="#" aria-label="Next">
	      """)))}/*122.10*/else/*122.15*/{_display_(Seq[Any](format.raw/*122.16*/("""
	      	"""),format.raw/*123.9*/("""<a class="page-link" href=""""),_display_(/*123.37*/{url}),_display_(/*123.43*/{pageNo+1}),format.raw/*123.53*/("""" aria-label="Next">
	      """)))}),format.raw/*124.9*/("""
	        """),format.raw/*125.10*/("""<span aria-hidden="true">&raquo;</span>
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

"""),format.raw/*90.2*/("""

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
                  DATE: Mon May 15 23:32:26 JST 2017
                  SOURCE: /Users/nishida-takuro/git/HouseHolder/AppHouse/app/views/index.scala.html
                  HASH: 48f64df033f4f82bc3703fc699ecaafe45cbeeda
                  MATRIX: 576->1|746->181|757->185|837->189|869->194|2383->1688|2395->1692|2476->1696|2505->1698|2596->1763|2636->1787|2675->1788|2704->1790|2783->1842|2821->1859|2899->1910|2932->1922|3008->1971|3039->1981|3198->2114|3245->2152|3284->2153|3317->2160|3353->2175|3377->2182|3390->2187|3429->2188|3462->2195|3498->2210|3527->2211|3557->2214|3593->2229|3629->2235|3660->2239|3765->2317|3800->2331|3907->2411|3942->2425|4063->2520|4110->2558|4149->2559|4182->2566|4218->2581|4242->2588|4255->2593|4294->2594|4327->2601|4363->2616|4392->2617|4422->2620|4458->2635|4494->2641|4526->2646|4648->2741|4686->2758|4749->2791|4778->2793|4809->2804|4821->2808|4902->2812|4931->2814|5083->2940|5107->2955|5146->2956|5187->2969|5267->3031|5280->3036|5319->3037|5355->3046|5410->3074|5436->3080|5467->3090|5531->3123|5570->3133|5713->3249|5753->3279|5793->3280|5825->3284|5903->3334|5930->3339|6028->3409|6055->3414|6153->3484|6180->3489|6278->3559|6305->3564|6403->3634|6430->3639|6469->3660|6483->3665|6523->3666|6558->3673|6636->3723|6663->3729|6695->3739|6726->3742|6760->3754|6859->3825|6886->3831|6918->3841|6949->3844|6983->3856|7077->3922|7104->3928|7134->3936|7165->3939|7193->3945|7287->4011|7314->4017|7346->4027|7377->4030|7411->4042|7505->4108|7532->4114|7564->4124|7595->4127|7629->4139|7682->4161|7722->4173|7780->4204|7805->4219|7845->4220|7887->4233|7964->4291|7978->4296|8018->4297|8055->4306|8111->4334|8138->4340|8170->4350|8230->4379|8269->4389|8415->95|8425->98|8490->93|8518->133|8546->136|8573->155|8611->156|8639->159|8662->163|8690->166|8713->170|8741->173|8764->177|8795->179|8823->1685|8852->2801
                  LINES: 20->1|24->9|24->9|26->9|27->10|68->53|68->53|70->53|71->54|73->56|73->56|73->56|74->57|76->59|76->59|77->60|77->60|78->61|78->61|82->65|82->65|82->65|83->66|83->66|84->67|84->67|84->67|85->68|85->68|85->68|85->68|85->68|86->69|87->70|89->72|89->72|91->74|91->74|94->77|94->77|94->77|95->78|95->78|96->79|96->79|96->79|97->80|97->80|97->80|97->80|97->80|98->81|99->82|102->85|102->85|105->88|106->89|107->92|107->92|109->92|110->93|113->96|113->96|113->96|114->97|115->98|115->98|115->98|116->99|116->99|116->99|116->99|117->100|118->101|122->105|122->105|122->105|123->106|123->106|123->106|124->107|124->107|125->108|125->108|126->109|126->109|127->110|127->110|128->111|128->111|128->111|129->112|129->112|129->112|129->112|129->112|129->112|130->113|130->113|130->113|130->113|130->113|131->114|131->114|131->114|131->114|131->114|132->115|132->115|132->115|132->115|132->115|133->116|133->116|133->116|133->116|133->116|134->117|136->119|137->120|137->120|137->120|138->121|139->122|139->122|139->122|140->123|140->123|140->123|140->123|141->124|142->125|148->2|148->2|149->1|150->2|152->4|152->4|152->4|153->5|153->5|154->6|154->6|155->7|155->7|156->8|157->51|159->90
                  -- GENERATED --
              */
          