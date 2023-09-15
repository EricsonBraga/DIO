# desafio-dio-DynamoDB
Comandos de banco de dados NoSQL do DynamoDB

<h3>Comandos</h3>
<ul>
<li> Criar uma tabela</li>
            
            aws dynamodb create-table \
              --table-name Music \
              --attribute-definitions \
                  AttributeName=Artist,AttributeType=S \
                  AttributeName=SongTitle,AttributeType=S \
              --key-schema \
                  AttributeName=Artist,KeyType=HASH \
                  AttributeName=SongTitle,KeyType=RANGE \
              --provisioned-throughput \
                  ReadCapacityUnits=10,WriteCapacityUnits=5
				  
				  
<li>Inserir item</li>

			aws dynamodb put-item \
    			--table-name Music \
    			--item file://itemmusic.json \
				
<li>Inserir vários itens</li>

			aws dynamodb batch-write-item \
   			 --request-items file://batchmusic.json
	
<li>Criar um index global secundário baseado no título do álbum</li>

			aws dynamodb update-table \
				 --table-name Music \
				 --attribute-definitions AttributeName=AlbumTitle,AttributeType=S \
				 --global-secondary-index-updates \
				 "[{\"Create\":{\"IndexName\": \"AlbumTitle-index\",\"KeySchema\":[{\"AttributeName\":\"AlbumTitle\",\"KeyType\":\"HASH\"}], \
				 \"ProvisionedThroughput\": {\"ReadCapacityUnits\": 10, \"WriteCapacityUnits\": 5      },\"Projection\":{\"ProjectionType\":\"ALL\"}}}]"
			
<li>Criar um index global secundário baseado no nome do artista e no título do álbum</li>

			aws dynamodb update-table \
    			--table-name Music \
				--attribute-definitions\
				AttributeName=Artist,AttributeType=S \
				AttributeName=AlbumTitle,AttributeType=S \
				--global-secondary-index-updates \
				"[{\"Create\":{\"IndexName\": \"ArtistAlbumTitle-index\",\"KeySchema\":[{\"AttributeName\":\"Artist\",\"KeyType\":\"HASH\"},
				\"AttributeName\":\"AlbumTitle\",\"KeyType\":\"RANGE\"}], \
				\"ProvisionedThroughput\": {\"ReadCapacityUnits\": 10, \"WriteCapacityUnits\": 5      },\"Projection\":{\"ProjectionType\":\"ALL\"}}}]"

<li>Criar um index global secundário baseado no título da música e no ano</li>

			aws dynamodb update-table \
    			--table-name Music \
				--attribute-definitions\
				AttributeName=SongTitle,AttributeType=S \
				AttributeName=SongYear,AttributeType=S \
				--global-secondary-index-updates \
				"[{\"Create\":{\"IndexName\": \"SongTitleYear-index\",\"KeySchema\":[{\"AttributeName\":\"SongTitle\",\"KeyType\":\"HASH\"},
				\"AttributeName\":\"SongYear\",\"KeyType\":\"RANGE\"}], \
				\"ProvisionedThroughput\": {\"ReadCapacityUnits\": 10, \"WriteCapacityUnits\": 5      },\"Projection\":{\"ProjectionType\":\"ALL\"}}}]"

<li>Pesquisar item por artista</li>

			aws dynamodb query \
				--table-name Music \
				--key-condition-expression "Artist = :artist" \
				--expression-attribute-values  '{":artist":{"S":"Iron Maiden"}}'

<li>Pesquisar item por artista e título da música</li>

			aws dynamodb query \
				--table-name Music \
				--key-condition-expression "Artist = :artist and SongTitle = :title" \
				--expression-attribute-values file://keyconditions.json

<li>Pesquisa pelo index secundário baseado no título do álbum</li>

			aws dynamodb query \
				--table-name Music \
				--index-name AlbumTitle-index \
				--key-condition-expression "AlbumTitle = :name" \
				--expression-attribute-values  '{":name":{"S":"Fear of the Dark"}}'

<li>Pesquisa pelo index secundário baseado no nome do artista e no título do álbum</li>

			aws dynamodb query \
				--table-name Music \
				--index-name ArtistAlbumTitle-index \
				--key-condition-expression "Artist = :v_artist and AlbumTitle = :v_title" \
				--expression-attribute-values  '{":v_artist":{"S":"Iron Maiden"},":v_title":{"S":"Fear of the Dark"} }'

<li>Pesquisa pelo index secundário baseado no título da música e no ano</li>

			aws dynamodb query \
				--table-name Music \
				--index-name SongTitleYear-index \
				--key-condition-expression "SongTitle = :v_song and SongYear = :v_year" \
				--expression-attribute-values  '{":v_song":{"S":"Wasting Love"},":v_year":{"S":"1992"} }'

</ul>