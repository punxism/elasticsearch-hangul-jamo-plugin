curl -XDELETE '127.0.0.1:9222/test_jamo'
curl -XPUT '127.0.0.1:9222/test_jamo' -d '{
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
        "hangul-jamo-filter" : {
          "type" : "hangul_jamo",
          "name": "jamo"
        }
      },
      "analyzer": {
        "hangul_jamo_analyzer": {
          "type": "custom",
          "filter": ["hangul_jamo"],
          "tokenizer": "ngram_tokenizer"
        }
      }
    }
  }
}'

curl '127.0.0.1:9222/test_jamo/_analyze?pretty=1&analyzer=hangul_jamo_analyzer' -d '아버지가 방에 들어가신다. 태권-V'