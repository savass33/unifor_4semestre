import pandas as pd

# Criando um dicionário simples
dados = {
    "Nome": ["Ana", "Bruno", "Carlos"],
    "Idade": [25, 47, 32],
}

# Criando DataFrame a partir do dicionário
df = pd.DataFrame(dados)
print("DataFrame criado a partir do dicionário:")
print(df)

# Criando Series a partir do dicionário
# Aqui: as chaves viram índices e os valores viram valores da Series
s = pd.Series(dados)
print("\nSeries criada a partir do dicionário:")
print(s)

# -----------------------------------------
# Leitura de arquivo CSV
# -----------------------------------------
df = pd.read_csv('funcionarios.csv')

print("\nPrimeiras 5 linhas do DataFrame:")
print(df.head())  # mostra as primeiras 5 linhas

print("\nÚltimas 5 linhas do DataFrame:")
print(df.tail())  # mostra as últimas 5 linhas

print("\nDataFrame completo:")
print(df)

# Seleção de coluna
print("\nColuna Nome:")
print(df['Nome'])

# Filtros com condições
print("\nFuncionários menores de 18 anos:")
print(df[df["Idade"] < 18][["Nome", "Idade"]])

print("\nFuncionários com salário menor que 5000:")
print(df[df["Salario"] < 5000][["Nome", "Salario"]])

# -----------------------------------------
# Métodos de inspeção
# -----------------------------------------
print("\nInformações do DataFrame:")
print(df.info())   # precisa usar () para executar

print("\nEstatísticas descritivas:")
print(df.describe())  # também precisa de ()

# -----------------------------------------
# Operações comuns
# -----------------------------------------
print("\nSoma dos salários:", df["Salario"].sum())

print("Média das idades:", df["Idade"].mean())

print("\nContagem de valores da coluna Ativo:")
print(df["Ativo"].value_counts())

print("\nAgrupamento por Departamento (não mostra direto, precisa de operação):")
print(df.groupby("Departamento")["Salario"].mean())  # exemplo: média de salários por departamento

print("\nOrdenação por Salário (decrescente):")
print(df.sort_values(by="Salario", ascending=False))
