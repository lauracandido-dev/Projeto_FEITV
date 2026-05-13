# FEITV

## Descrição do Projeto

O projeto consiste em uma plataforma de Streaming de Vídeos, um pouco mais simples mas com funcionalidades importantes como: Cadastrar um usuário, fazer login, buscar vídeos e listar suas informações, curtir e descurtir vídeos e gerenciar favoritos.

O sistema foi desenvolvido com as seguintes tecnologias: Swing (Java) + JDBC PostgreSQL + MVC (Model, View, Controller).

---

## Objetivos

- Implementar um sistema CRUD completo (Create, Read, Update, Delete)
- Aplicar conceitos de Programação Orientada a Objetos (POO)
- Integrar aplicação Java com banco de dados PostgreSQL
- Trabalhar com interface gráfica utilizando Java Swing
- Aplicar validações e boas práticas de desenvolvimento

---

## Conceitos Aplicados

### Programação Orientada a Objetos (POO)
- Encapsulamento
- Herança (Classe `Video`, `Filme` e `Serie`)
- Polimorfismo
- Composição
- Organização em camadas (MVC)

### Banco de Dados
- Modelagem relacional
- Chaves primárias e estrangeiras
- Relacionamento entre tabelas

---

## Estrutura do Banco de Dados

### Tabela: `cadastros`
- id (PK)
- usuario
- senha
- nome

### Tabela: `videos`
- id (PK)
- nomeVideo
- genero
- classificacao
- sinopse
- duracao (filme)
- temporadas (série)
- episodios (série)

### Tabela: `listaReproducao`
- id (PK)
- nomeLista
- descricaoLista
- usuario_id (FK)

### Tabela: `listavideo`
- id (PK)
- lista_id (FK)
- video_id (FK)

### Tabela: `avaliacoes`
- id (PK)
- usuario_id (FK)
- video_id (FK)
- avaliacao

**Observação:** Todas as tabelas tem IDs, e são gerenciadas pelo ID de cada uma delas, ficando mais seguro de fazer as ligações entre elas.

---

## Funcionalidades do Sistema

### Usuário
- Cadastro de usuário
- Login no sistema
- Exclusão de conta 
- Alteração  de senha

---

### Busca de Vídeos
- Busca por nome
- Exibição de:
  - Nome
  - Gênero
  - Classificação
  - Sinopse

Detalhe:
- Se for **Filme** → exibe duração
- Se for **Série** → exibe temporadas e episódios

---

### Listas de Reprodução
- Criar lista
- Editar nome da lista
- Excluir lista

---

### Gerenciamento de Vídeos na Lista
- Adicionar vídeo à lista
- Remover vídeo da lista

---

### Avaliações
- Curtir
- Descurtir
---

## Arquitetura do Projeto

O projeto foi estruturado utilizando o padrão MVC:

- **Model:** Representação dos dados (get, set, construtores) (`Usuario`, `Video`, `Filme` , `Serie`, `ListaReproducao` e `Avaliacoes`.)
- **View:** Interface gráfica
- **Controller:** Lógica de controle
- **DAO:** Acesso ao banco de dados

---

## Alguns Testes Realizados

- Validação de campos
- Inserção e exclusão de dados
- Testes de busca com diferentes entradas
- Atualização em tempo real no banco

---

## Interface do Sistema

A interface foi desenvolvida com foco em:

- Simplicidade
- Clareza de informações
- Feedback visual ao usuário 
- Qualidade visual

---

## Melhorias Futuras

- Interface mais moderna
- Sistema de recomendação de vídeos
- Upload de imagens
- Sistema de favoritos
- Ordenação e filtros avançados
- Autenticação mais segura (hash de senha)

---

## Conclusão e opinião pessoal

O projeto foi algo desafiador, tive algumas dificuldades principalmente na parte de desenvolver os controles. Porém foi um projeto muito importante para o meu desenvolvimento pois nele eu pude entender melhor os conceitos da POO, entendi como me organizar melhor tanto nas interfaces como nas tabelas do banco de dados e essa foi uma etapa crucial que eu irei levar adiante. 
O projeto me permitiu aplicar diversos conceitos importantes e ainda despertou a criatividade fazendo as interfaces, mudando meu pensamento para não só fazer a tela "bonita" mas pensar também na experiência do usuário.

---

## Autora
- Laura Candido da Silva 

## Repositório GitHub
- https://github.com/lauracandido-dev/Projeto_FEITV.git

## Link Vídeo
- https://drive.google.com/file/d/1laejtsG22kueKRCbV8klJRI-lmQ9030V/view?usp=sharing




