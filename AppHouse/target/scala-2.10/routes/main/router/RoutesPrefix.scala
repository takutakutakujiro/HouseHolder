
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/nishida-takuro/git/HouseHolder/AppHouse/conf/routes
// @DATE:Thu May 04 02:21:02 JST 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
