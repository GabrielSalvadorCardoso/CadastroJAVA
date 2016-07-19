# CadastroJAVA

O programa tem objetivo de cadastrar os funcionarios em uma emprese de acordo com sua função

Observações importantes:
-A interface "Implementador" tem o objetivo de poupar esforço desnecessario na digitação, auxiliando no desenvolvimento do programa
-A função mkdirs() usada para criar o diretorio para armazenaento dos arquivos, cria o determinado diretorio apenas se ele não existir, se ele já foi criado previamente, o diretorio é mantido intacto assim como os arquivos que existem dentro dele.
-O nome dos arquivos(onde estão os dados dos funcionarios) são definidos pelo codigo do funcionario, isso garante que o funcionario seja cadastrado apenas uma vez, evitando redundância.
-Se um mesmo funcionario(com o mesmo codigo) for cadastrado mais de uma vez, os dados atuais substituirao os anteriores, isso pode ser util no caso de um aumento de salario, ou de carga horaria, por exemplo.
