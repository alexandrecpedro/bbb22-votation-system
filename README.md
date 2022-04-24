<div align = "center">
    <h1> Sistema de Votação Online do BBB 22 </h1>
</div>
<br>

<div align = 'center' justify-content = 'space-around' >
   <img src= './project/logos/Avanade.png' alt = 'Avanade' >
   <img src= './project/logos/RedeGlobo.png' alt = 'Rede Globo' >
</div>

<h3 align = "center">
  Sistema de Votação Online do Big Brother Brasil 22 (2022)
</h3>

<p align="center">
 <a href="#objetivo">Objetivo</a> •
 <a href="#tecnologias">Tecnologias</a> •
 <a href="#percurso">Percurso</a> 
</p>

<br>
<br>

<div id="objetivo">
<h2> 💡 Objetivo </h2>
Construir um sistema que permita ao usuário votar num participante indicado para eliminação (paredão) do reality show Big Brother Brasil 22 (BBB 22), por semana.

E conseguir contar os votos totais (inclusive os feitos por robôs) e auditar os votos válidos (votos únicos por usuário), configurando uma porcentagem de votos válidos por candidato à eliminação.

Cada semana devemos auditar e configurar os 3 candidatos à eliminação para que o usuário possa escolher em qual participante remanescente do programa ele deseja votar.

A cada semana, o participante que obtiver o maior percentual de votos é eliminado do programa.

</div>
<br>
<br>

<div id="tecnologias">
<h2> 🛠 Tecnologias </h2>
As seguintes ferramentas foram usadas na construção do projeto:<br><br>
    
|                                                     Tipo              | Ferramentas                                |                                 Referência                                   |
| :---------------------------------------------------------------------------: | :--------------------------------------------------------------------------: | :--------------------------------------------------------------------------: |
|                    Banco de Dados Não-Relacional       |   MONGODB     |              https://www.mongodb.com/try/download/community                     |
|                           Robo 3T                                  |   ROBO 3T      |             https://robomongo.org/                                         |
|      Framework Java Spring Boot - construção do Back-end       |    SPRING BOOT       |               https://start.spring.io/                                       |
|      API Documentation Library for Spring Boot       |    OPENAPI 3       |              https://springdoc.org/                                       | 
|                           Framework Apache KAFKA                     | KAFKA   |              https://kafka.apache.org/        |    
|                           View and managing objects a Apache KAFKA         |     OFFSET EXPLORER           |              https://kafkatool.com/         |    
|                           Docker                                    |    DOCKER          |               https://hub.docker.com/                                            |      
|              API RESTful using JSON - Swagger UI           |   SWAGGER     |               https://swagger.io/                                            |    
|              Framework Angular - construção da API web           |  ANGULAR       |              https://angular.io/                                            |    
<br>

<p>Backend</p>
<img align='center' width =' 80px ' src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mongodb/mongodb-original.svg" />
<!-- <img align='center' width =' 80px ' src="https://dashboard.snapcraft.io/site_media/appmedia/2018/09/logo-256x256.png" /> -->
<img align='center' width =' 80px ' src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" />
<img align='center' width =' 250px ' src="https://springdoc.org/images/springdoc-openapi.png" />
<img align='center' width =' 250px ' src="https://static1.smartbear.co/swagger/media/assets/images/swagger_logo.svg" />
<br><br>
<p>Infraestrutura</p>
<img align='center' width =' 80px ' src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/apachekafka/apachekafka-original.svg" />
<img align='center' width =' 80px ' src="https://static.macupdate.com/products/53532/m/offset-explorer-logo.png?v=1633349540" />
<img align='center' width =' 100px ' src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/docker/docker-original.svg" />
<br><br>
<p>Frontend</p>
<img align='center' width =' 80px ' src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/angularjs/angularjs-original.svg" />
<br>
<br>

<div id="percurso">
<h2> 🔎 Percurso </h2>

<ol>
    <li>Parte 1 - Configurando/preparando ambiente (Infraestrutura)
      <ul>
        <li>Instalar Apache Kafka, Robo 3T, IntelliJ, VS Code, Docker Desktop</li>
        <li>Abrir e logar o Docker Desktop</li>
        <li>Abrir o VS Code</li>
        <li>Configurar uma pasta Docker, com as subpastas Kafka e MongoDB</li>
        <li>Criar os arquivos de configuração (docker-compose.yml) em cada subpasta criada</li>
        <!-- Comando docker-compose up -d (o -d é para subir o servidor em 2º plano) -->
        <li>Entrar em cada subpasta criada e subir o serviço para o Docker (docker-compose up -d)</li>
      </ul>
    </li>
    <br>
    <li>Parte 2 - Modelando o projeto no DrawIO</li>
    <br>
    <li>Parte 3 - Criando back-end com Java Spring Boot
      <ul>
        <li>Abrir o Spring Initializr e configurar o Spring Boot</li>
        <li>Gerar o arquivo Spring Boot e abrir no IntelliJ</li>
        <li>Verificar as dependências a serem usadas e configurar o Maven</li>
        <li>Fazer arquivo de configuração de acesso ao MongoDB e ao servidor Apache Kafka</li>
        <li>Povoar mecanicamente o MongoDB com alguns participantes do BBB, incluindo o id (arquivo JSON)</li>
        <li>Construir a API em Java Spring Boot - classes, objetos, datas e interfaces</li>
        <li>Criar a estrutura do microsserviço em Java Spring Boot - classes, objetos, datas e interfaces</li>
        <li>Importar o microsserviço na mesma pasta da API, no IntelliJ</li>
        <li>Construir as classes, datas, objetos e interfaces para o microsserviço</li>
        <li>Buildar os arquivos principais da API e do microsserviço</li>
        <li>Testar as rotas no Postman
        Rota POST 
        URL: http://localhost:8080/api/parametros/salvar
        Aba BODY:
        JSON =
        {
          "chave": "config.votacao",
          "valor": "3"
        }
        </li>
      </ul>
    </li>
    <br>
    <li>Parte 4 - Criando API web com Angular
      <ul>
        <li>Novo projeto: ng new nomeProjeto </li>
        <li>Iniciando projeto: ng server --open </li>
        <li>Novo componente: ng generate component nomeComponente </li>
        <li>Criar interface: src/app/model/participante.ts</li>
        <li>Criando rota: ng generate module app-routing --flat --module=app</li>
        <li>Importar HttpClientModule em app.module.ts [parte de imports]</li>
        <li>Criar serviço: src/app/service/RestService.ts</li>
        <li>Add @CrossOrigin em ParticipanteController.java e VotacaoController.java</li>
        <li>Implementar as rotas</li>
      </ul>
    </li>
    <br>
    <li>Parte 5 - Integrando back-end/front-end e acessando dados</li>  
</ol>
</div>
<br>
<br>
