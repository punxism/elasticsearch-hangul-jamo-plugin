# Elasticsearch Hangul Jamo & Chosung Analyzer Plugin
* Hangul(Korean) Jamo, Chosung filter for an Elasticsearch

## Supported version
Below elasticsearch versions are tested
<br>
5.2.2

## Getting Started

### How to build
```
mvn clean package
```

### Installing
```
${elasticsearch.home}/bin/elasticsearch-plugin install file://${project.basedir}/target/releases/elasticsearch-hangul-jamo-analyzer-{version}.zip
```

### Test
Chosung Analyzer
```
curl -XPUT '127.0.0.1:9200/test_chosung' -d '{
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

curl '127.0.0.1:9200/test_chosung/_analyze?pretty=1&analyzer=hangul_chosung_analyzer' -d '아버지가 방에 들어가신다. 태권-V'
{
  "tokens" : [
    {
      "token" : "ㅇ",
      "start_offset" : 0,
      "end_offset" : 1,
      "type" : "word",
      "position" : 0
    },
    {
      "token" : "ㅇㅂ",
      "start_offset" : 0,
      "end_offset" : 2,
      "type" : "word",
      "position" : 1
    },
    {
      "token" : "ㅇㅂㅈ",
      "start_offset" : 0,
      "end_offset" : 3,
      "type" : "word",
      "position" : 2
    },
    {
      "token" : "ㅇㅂㅈㄱ",
      "start_offset" : 0,
      "end_offset" : 4,
      "type" : "word",
      "position" : 3
    },
    {
      "token" : "ㅂ",
      "start_offset" : 5,
      "end_offset" : 6,
      "type" : "word",
      "position" : 4
    },
    {
      "token" : "ㅂㅇ",
      "start_offset" : 5,
      "end_offset" : 7,
      "type" : "word",
      "position" : 5
    },
    {
      "token" : "ㄷ",
      "start_offset" : 8,
      "end_offset" : 9,
      "type" : "word",
      "position" : 6
    },
    {
      "token" : "ㄷㅇ",
      "start_offset" : 8,
      "end_offset" : 10,
      "type" : "word",
      "position" : 7
    },
    {
      "token" : "ㄷㅇㄱ",
      "start_offset" : 8,
      "end_offset" : 11,
      "type" : "word",
      "position" : 8
    },
    {
      "token" : "ㄷㅇㄱㅅ",
      "start_offset" : 8,
      "end_offset" : 12,
      "type" : "word",
      "position" : 9
    },
    {
      "token" : "ㄷㅇㄱㅅㄷ",
      "start_offset" : 8,
      "end_offset" : 13,
      "type" : "word",
      "position" : 10
    },
    {
      "token" : "ㅌ",
      "start_offset" : 15,
      "end_offset" : 16,
      "type" : "word",
      "position" : 11
    },
    {
      "token" : "ㅌㄱ",
      "start_offset" : 15,
      "end_offset" : 17,
      "type" : "word",
      "position" : 12
    },
    {
      "token" : "V",
      "start_offset" : 18,
      "end_offset" : 19,
      "type" : "word",
      "position" : 13
    }
  ]
}

```

Jamo Analyzer

```
curl -XPUT '127.0.0.1:9200/test_jamo' -d '{
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

curl '127.0.0.1:9200/test_jamo/_analyze?pretty=1&analyzer=hangul_jamo_analyzer' -d '아버지가 방에 들어가신다. 태권-V'
{
  "tokens" : [
    {
      "token" : "ㅇㅏ",
      "start_offset" : 0,
      "end_offset" : 1,
      "type" : "word",
      "position" : 0
    },
    {
      "token" : "ㅇㅏㅂㅓ",
      "start_offset" : 0,
      "end_offset" : 2,
      "type" : "word",
      "position" : 1
    },
    {
      "token" : "ㅇㅏㅂㅓㅈㅣ",
      "start_offset" : 0,
      "end_offset" : 3,
      "type" : "word",
      "position" : 2
    },
    {
      "token" : "ㅇㅏㅂㅓㅈㅣㄱㅏ",
      "start_offset" : 0,
      "end_offset" : 4,
      "type" : "word",
      "position" : 3
    },
    {
      "token" : "ㅂㅏㅇ",
      "start_offset" : 5,
      "end_offset" : 6,
      "type" : "word",
      "position" : 4
    },
    {
      "token" : "ㅂㅏㅇㅇㅔ",
      "start_offset" : 5,
      "end_offset" : 7,
      "type" : "word",
      "position" : 5
    },
    {
      "token" : "ㄷㅡㄹ",
      "start_offset" : 8,
      "end_offset" : 9,
      "type" : "word",
      "position" : 6
    },
    {
      "token" : "ㄷㅡㄹㅇㅓ",
      "start_offset" : 8,
      "end_offset" : 10,
      "type" : "word",
      "position" : 7
    },
    {
      "token" : "ㄷㅡㄹㅇㅓㄱㅏ",
      "start_offset" : 8,
      "end_offset" : 11,
      "type" : "word",
      "position" : 8
    },
    {
      "token" : "ㄷㅡㄹㅇㅓㄱㅏㅅㅣㄴ",
      "start_offset" : 8,
      "end_offset" : 12,
      "type" : "word",
      "position" : 9
    },
    {
      "token" : "ㄷㅡㄹㅇㅓㄱㅏㅅㅣㄴㄷㅏ",
      "start_offset" : 8,
      "end_offset" : 13,
      "type" : "word",
      "position" : 10
    },
    {
      "token" : "ㅌㅐ",
      "start_offset" : 15,
      "end_offset" : 16,
      "type" : "word",
      "position" : 11
    },
    {
      "token" : "ㅌㅐㄱㅝㄴ",
      "start_offset" : 15,
      "end_offset" : 17,
      "type" : "word",
      "position" : 12
    },
    {
      "token" : "V",
      "start_offset" : 18,
      "end_offset" : 19,
      "type" : "word",
      "position" : 13
    }
  ]
}
```

## License
This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
## Reference (Special Thanks To)
- http://stackoverflow.com/questions/27220705/how-can-i-use-prefix-query-on-korean-word-in-elasticsearch/28337913#28337913
- http://blog.naver.com/PostView.nhn?blogId=tmondev&logNo=220918935030&redirect=Dlog&widgetTypeCall=true