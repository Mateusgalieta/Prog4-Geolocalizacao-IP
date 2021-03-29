# Trabalho da Discplina Programação4 - 6° Período - Sistemas de Informação - UEMG - Universidade do Estado de Minas Gerais.

Aluno: Mateus Augusto Galieta Cruz

--------------------------------------------------------

Aplicativo para busca de geolocalização de IP usando a API https://ip-api.com/docs/api:json

Tomei como referencia, o vídeo https://www.youtube.com/watch?v=MytQfkDv5eM e algumas adaptações.

A API é bem completa e traz várias informações sobre o IP Público. Inclusive dados do nome o ISP e o nome do seu Provedor de internet.

Exemplo de JSON retornado em uma consulta:

{
  "query": "138.255.192.6",
  "status": "success",
  "country": "Brazil",
  "countryCode": "BR",
  "region": "MG",
  "regionName": "Minas Gerais",
  "city": "Monte Santo de Minas",
  "zip": "37958",
  "lat": -21.2075,
  "lon": -46.9567,
  "timezone": "America/Sao_Paulo",
  "isp": "FaleMais ComunicaÔÔes LTDA",
  "org": "FaleMais Comunicações LTDA",
  "as": "AS263971 FaleMais Comunicações LTDA"
}

Código da API está documentado na Classe APIGeolocalizacao.java
