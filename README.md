# FEITV

## Descrição do Projeto

O presente projeto consiste em uma plataforma de Streaming de Vídeos, um pouco mais simples mas com funcionalidades importantes como: Cadastrar um usuário, fazer login, buscar vídeos e listar suas informações, curtir e descurtir vídeos e gerenciar favoritos.

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

---
