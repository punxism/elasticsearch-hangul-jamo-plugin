curl -XDELETE '127.0.0.1:9222/test_chosung'
curl -XPUT '127.0.0.1:9222/test_chosung' -d '{
  "settings" : {
    "analysis": {
      "tokenizer" : {
        "ngram_tokenizer" : {
          "type" : "edgeNGram",
          "min_gram" : "1",
          "max_gram" : "30",
          "token_chars": ["letter", "digit"]
        }
      },
      "filter" : {
        "hangul-chosung-filter" : {
          "type" : "hangul_chosung",
          "name": "chosung"
        }
      },
      "analyzer": {
        "hangul_chosung_analyzer": {
          "type": "custom",
          "filter": ["hangul_chosung"],
          "tokenizer": "ngram_tokenizer"
        }
      }
    }
  }
}'
curl '127.0.0.1:9222/test_chosung/_analyze?pretty=1&analyzer=hangul_chosung_analyzer' -d '아버지가 방에 들어가신다. 태권-V'