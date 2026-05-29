# medical-registry

Criar endpoint que possa cumprir os seguintes pré-requisitos:
1. Calcular como ficariam todas as opções de frete
2. Selecionar apenas um dos fretes e retornar o cálculo
3. Calcular apenas 2 tipos de fretes

Futuramente, seria interessante implementar uma nova opção de frete sem que o contrato com a interface seja alterada, mantendo assim o Princípio da Responsabilidade Única
O motivo é para lembrar de duas coisas:
1. sempre ao criar Strategy, passar por parâmetro um objeto com os parâmetros de forma que, caso algum dia precise acrescentar mais atributos para trabalhar em outro tipo de frete, não tenha alteração no contrato da interface
2. caso seja um sistema que já esteja em produção, verificar que há outras duas opções de colocar atributos sem precisar alterar o contrato do método existente
