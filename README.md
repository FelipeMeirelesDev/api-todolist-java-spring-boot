<h1>🗒️ To Do List API - Spring Boot</h1>

<p>
  Esta é uma API REST de gerenciamento de tarefas, desenvolvida com Java e Spring Boot como parte do curso da Rocketseat ministrado pela professora <strong>Daniele Leão</strong>. O projeto simula uma aplicação de lista de tarefas (To Do List), com foco em autenticação, validação de dados e persistência em banco de dados relacional.
</p>

<h2>🚀 Funcionalidades</h2>
<ul>
  <li>✅ Cadastro de usuários com senha criptografada (BCrypt)</li>
  <li>✅ Autenticação via <code>Basic Auth</code> em endpoints protegidos</li>
  <li>✅ Criação de tarefas com título, descrição, prioridade e datas de início/fim</li>
  <li>✅ Atualização de tarefas</li>
  <li>✅ Listagem de tarefas por usuário</li>
  <li>✅ Validação de datas e permissões</li>
  <li>✅ Exclusão de tarefas</li>
</ul>

<h2>🔐 Segurança</h2>
<p>
  A autenticação é feita por <code>Basic Auth</code> com verificação de usuário e senha criptografada no banco de dados. Todas as rotas de tarefas são protegidas por um filtro que valida as credenciais antes de liberar o acesso.
</p>

<h2>🛠️ Tecnologias utilizadas</h2>
<ul>
  <li>Java 17</li>
  <li>Spring Boot</li>
  <li>Spring Web</li>
  <li>Spring Data JPA</li>
  <li>H2 Database (pode ser substituído por PostgreSQL ou MySQL)</li>
  <li>BCrypt (hash de senha)</li>
  <li>Jakarta Persistence</li>
  <li>Postman (para testes)</li>
</ul>

<h2>▶️ Como rodar o projeto</h2>
<ol>
  <li>
    Clone o repositório:
    <pre><code>git clone https://github.com/seu-usuario/nome-do-repo.git</code></pre>
  </li>
  <li>Abra o projeto em sua IDE (preferencialmente IntelliJ ou VSCode).</li>
  <li>
    Execute a aplicação backend via sua IDE (src/main/java/com.sistema.pizzariamania/PizzariaMania.Java) ou Utilizando esse comando: (mvn spring-boot: run)
  </li>
  <li>Acesse <code>http://localhost:8080</code> para interagir com a API via Postman ou qualquer outro programa de sua preferência para testar APIs.</li>
</ol>

<h2>💾 Acessando o banco de dados H2</h2>
<p>
  Para acessar o console do banco de dados em memória H2 durante a execução do projeto, siga os passos:
</p>
<ul>
  <li>Acesse <code>http://localhost:8080/h2-console</code></li>
  <li>No campo <strong>JDBC URL</strong>, use: <code>jdbc:h2:mem:testdb</code></li>
  <li>Usuário: <code>sa</code> (padrão)</li>
  <li>Senha: (deixe em branco, se não tiver sido alterada)</li>
  <li>Clique em <strong>Connect</strong> para visualizar e manipular as tabelas em tempo real.</li>
</ul>

<h2>📫 Testando a API</h2>

<h3>Criar usuário</h3>
<pre><code>POST /usuarios/
Content-Type: application/json</code></pre>
<pre><code>{
  "nome": "Felipe Meireles",
  "nomeUsuario": "felipedev",
  "senha": "123456"
}</code></pre>

<h3>Criar tarefa (requer autenticação Basic)</h3>
<pre><code>POST /tasks/
Authorization: Basic (username: felipedev, password: 123456)
Content-Type: application/json</code></pre>
<pre><code>{
  "titulo": "Estudar Spring Boot",
  "descricao": "Aprender sobre criação de APIs",
  "prioridade": "Alta",
  "startAt": "2025-04-25T10:00:00",
  "endAt": "2025-04-25T18:00:00"
}</code></pre>
