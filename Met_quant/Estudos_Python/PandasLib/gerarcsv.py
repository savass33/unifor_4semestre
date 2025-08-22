import pandas as pd
from random import randint, choice
from datetime import datetime, timedelta

# Dados fictícios
nomes = ["Ana", "Bruno", "Carlos", "Diana", "Eduardo", "Fernanda", "Gabriel", "Helena", "Igor", "Juliana"]
departamentos = ["Vendas", "TI", "RH", "Financeiro", "Marketing"]
ativos = [True, False]

dados = []

for i in range(20):  # gera 20 linhas
    nome = choice(nomes)
    idade = randint(22, 60)
    dept = choice(departamentos)
    salario = randint(3000, 12000)
    # Gera uma data de admissão aleatória nos últimos 10 anos
    admissao = datetime.now() - timedelta(days=randint(0, 3650))
    ativo = choice(ativos)
    dados.append([nome, idade, dept, salario, admissao.strftime("%Y-%m-%d"), ativo])

# Cria o DataFrame
df = pd.DataFrame(dados, columns=["Nome", "Idade", "Departamento", "Salário", "Data_Admissao", "Ativo"])

# Salva em CSV
df.to_csv("funcionarios.csv", index=False)

print("CSV 'funcionarios.csv' criado com sucesso!")
print(df.head())