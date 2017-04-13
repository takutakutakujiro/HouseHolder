echo ""
echo "==== scraping　start!! ===="

#プロジェクトトップに移動
cd ..

#プロジェクトスタート
sbt run

echo ""
echo "==== scraping end!! ===="

echo ""
echo "==== ElasticSearch POST commit ===="

echo ""
echo "---データの削除---"
#データの削除
curl -XDELETE 'http://localhost:9200/*'

echo ""
echo "---jsonフォルダに移動---"
#jsonフォルダに移動
cd json

echo ""
echo "---jsonの挿入---"
#jsonの挿入
curl -XPOST 'http://localhost:9200/site/test/_bulk?pretty' --data-binary @output_sumo.json

echo ""
echo "==== ElasticSearch end ===="

echo ""