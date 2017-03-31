package model

class houseInfo {
  //建物の種類
  var buildingType: String = _
  //賃貸名
  var buildingName: String = _
  //画像URL
  var picture: String = _
  //住所
  var address: String = _
  //最寄駅１
  var nearestStation1: String = _
  //最寄駅２
  var nearestStation2: String = _
  //最寄駅３
  var nearestStation3: String = _
  //駅からの交通手段１
  var transportation1: String = _
  //駅からの交通手段２
  var transportation2: String = _
  //駅からの交通手段３
  var transportation3: String = _
  //駅からの時間１
  var transportationTime1: String = _
  //駅からの時間２
  var transportationTime2: String = _
  //駅からの時間３
  var transportationTime3: String = _
  //築年数
  var buildingAge: String = _
  //建物構造
  var buildingConstruction: String = _
  //条件詳細１
  var detailHouseInfo1: detailHouseInfo = null
  //条件詳細２
  var detailHouseInfo2: detailHouseInfo = null
  //条件詳細３
  var detailHouseInfo3: detailHouseInfo = null
}