# pocviacep


https://viacep.com.br/


Faça um clone deste projeto e deste https://github.com/Ratkovski/pocviacepconsumer para que ambos se comuniquem:

Esta aplicação tem por finalidade fazer uma consulta no viacep pegar as informações de determinado cep e publicá-las com o amazon sqs em filas de mensagens que armazenam mensagens esperando processamento. 

E a aplicação https://github.com/Ratkovski/pocviacepconsumer terá como objetivo escutar e consumir estes dados gravando no banco.

Dentro do projeto pocviacep rode o comando do docker para subir as configuraçoes do localstack:
```
docker-compose up  
```

Baixe e instale a aws cli: \
https://docs.aws.amazon.com/pt_br/cli/latest/userguide/install-cliv1.html

Verifique se esta funcionando com:
```
aws --version
```
Comandos para configurar a aws. Como vamos usar o localstack pode colocar um valor fictício nas configurações. \
Localstack: https://github.com/localstack/localstack

```
aws configure
AWS Access Key ID [None]: teste
AWS Secret Access Key [None]: teste
Default region name [None]: us-east
Default output format [None]: json
```
Criando uma fila: 

```
aws --endpoint-url=http://localhost:4566 sqs create-queue --queue-name fila_enderecos
```

Criando uma stack: Pode ser mudado a region --region us-east-1 

```
 aws cloudformation create-stack --stack-name viacepstack --template-body file://resource.yml --region sa-east-1 --endpoint-url http://localhost:4566
````
Listando as tabelas:

```
 aws dynamodb list-tables --endpoint-url http://localhost:4566
```

Deleta table:
```
aws dynamodb delete-table --table-name viacepstack-DynamoDBTable-19fb3da6 --endpoint-url http://localhost:4566
```

Listando os dados do banco:
```
aws dynamodb scan --table-name enderecos --endpoint-url http://localhost:4566
```



Exempo de requisição:
POST:http://localhost:8085/cep 
```
{
	"cep": "01001-000"
}
```

