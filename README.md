# medical-registry

O padrão Proxy (Procurador) é um dos padrões estruturais mais elegantes e presentes 
no dia a dia do desenvolvedor, especialmente no ecossistema Spring. 
Para garantir que o exemplo seja totalmente inédito para você, vamos usar um 
domínio de Acesso a Arquivos Confidenciais de Agências de Inteligência e 
Previsão do Tempo.

- a) Modelo Clássico (Protection Proxy)
  Neste exemplo usando *Records*, temos um sistema de arquivos confidenciais. 
  O Proxy garante que apenas agentes com credencial de "Diretor" possam ler os 
  relatórios reais.

- b) Modelo Spring REST (Cache Proxy Dinâmico)
  No Spring, você raramente escreve as classes Proxy manualmente como acima. 
  O framework gera **Proxies Dinâmicos** (usando CGLIB ou JDK Dynamic Proxies) 
  em tempo de execução através de anotações como `@Transactional`, `@Async`, 
  `@PreAuthorize` e `@Cacheable`.
  Aqui, o Proxy intercepta a requisição de clima: se já tivermos a resposta 
  em cache, o objeto real (que gasta cota da API externa) nem é chamado.
