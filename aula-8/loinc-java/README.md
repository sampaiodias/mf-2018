# Loinc Java

Biblioteca que busca informações sobre o Loinc em um banco de dados SQL. É necessário iniciar o banco antes de utilizar este projeto (script: LoincCore.sql).

**ATENÇÃO**: Para realizar os testes é necessário alterar o usuário e senha utilizados pela classe de testes (LoincTest.java) pelo usuário e senha do usuário MySQL configurado na máquina. Por padrão, o usuário e senha utilizados são, respectivamente, "root" e "123456".

## Requisitos
* Java 8 ou superior
* MySQL 8 ou superior