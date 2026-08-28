# medical-registry

  Para evitar os exemplos clássicos de e-commerce e finanças, vamos usar dois 
  cenários diferentes: Automação Residencial (Clássico) 
  e Admissão de Funcionários (Onboarding) (Spring REST).

- a) Modelo Clássico (Automação Residencial)

  Imagine o trabalho para ligar um Home Theater.
  Sem o Facade, o cliente precisa ligar a TV, ligar o som, abaixar as luzes 
  e ligar o ar-condicionado.

- b) Modelo Spring REST (Onboarding de Funcionários)

  Em aplicações Spring, é um "code smell" ter um `@RestController` 
  injetando 5 ou 6 `@Service` diferentes. O Facade entra como um serviço 
  de orquestração.