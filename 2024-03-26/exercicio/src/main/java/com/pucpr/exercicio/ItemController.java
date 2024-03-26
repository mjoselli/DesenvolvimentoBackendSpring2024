package com.pucpr.exercicio;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/*
Objetivo: Implementar um CRUD completo para um Array Map de itens no Spring Boot, utilizando Java.
Funcionalidades:
* Listar todos os itens: Exibir todos os itens presentes no Array Map.
* Buscar um item por ID: Obter um item específico pelo seu índice no Array Map.
* Adicionar um novo item: Inserir um novo item no final do Array Map.
* Atualizar um item: Substituir um item existente no Array Map pelo índice.
* Remover um item: Excluir um item do Array Map pelo seu índice.
Instruções:
1. Crie um projeto Spring Boot com as dependências Web.
2. Defina uma classe Item com os atributos nome, quantidade, valor e descritivo.
3. Implemente um Controller RESTful ItemController com os seguintes endpoints:
    * GET /api/itens: Retorna todos os itens do Array List.
    * GET /api/itens/{id}: Retorna o item com o índice especificado (id).
    * POST /api/itens: Adiciona um novo item ao Array Map.
    * PUT /api/itens/{id}: Atualiza o item com o índice especificado (id).
    * DELETE /api/itens/{id}: Remove o item com o índice especificado (id).
4. Teste a API com ferramentas como Postman ou curl.
 */
/* Parte 2
Implemente um CRUD completo para um Array List de itens no Spring Boot, utilizando Java e um banco de dados SQL.
 */
@RestController
@RequestMapping("api")
public class ItemController {
    List<Item> itens = new ArrayList<Item>();
    //retorna todos os itens
    @GetMapping("/item")
    public List<Item> getAll() {
        return itens;
    }

    //retorna um item específico
    @GetMapping("/item/{index}")
    public Item getById(@PathVariable int index) {
        return itens.get(index);
    }

    //adiciona um item
    @PostMapping("/item")
    public void add(@RequestBody Item item) {
        itens.add(item);
    }

    //atualiza um item
    @PutMapping("/item/{id}")
    public void update(@PathVariable int index,
                       @RequestBody Item item) {
        itens.set(index, item);
    }

    //deleta um item
    @DeleteMapping("/item/{index}")
    public void delete(@PathVariable int index) {
        itens.remove(index);
    }
}
