# -*- coding: utf-8 -*-

"""
=================================================================
SCRIPT COMPLETO DE ESTATÍSTICA DESCRITIVA
=================================================================
Este script demonstra o cálculo das principais medidas de posição
para dois tipos de conjuntos de dados:

1. Dados Não Agrupados: Uma lista simples de números.
2. Dados Agrupados: Dados organizados em uma tabela de frequência com classes.

Cada seção é autoexplicativa e segue as definições padrão da estatística.
"""

# =================================================================
# PARTE 1: DADOS NÃO AGRUPADOS
# =================================================================
# Aqui os dados vêm em forma de lista ou tabela simples, sem nenhuma
# frequência associada.
# -----------------------------------------------------------------

print("="*50)
print(" PARTE 1: ANÁLISE DE DADOS NÃO AGRUPADOS")
print("="*50)

# --- Auxiliares ---
vetor = [31, 22, 3, 44, 51, 66, 47, 88, 66, 710, 11]
soma = sum(vetor)
vetor_ordenado = sorted(vetor)
tamanho = len(vetor)

print("Vetor de entrada:", vetor)
print("-" * 20)

# --- Principais medidas ---

# Média Aritmética:
# A soma de todos os valores dividida pelo número de valores.
media = soma / tamanho
print(f"Média Aritmética: {media:.2f}")

# Mediana:
# O valor central de um conjunto de dados ordenado.
if tamanho % 2 == 1:  # Se a quantidade de termos for ímpar, a mediana é o valor do centro
    mediana = vetor_ordenado[tamanho // 2]
else:  # Se for par, é a média dos dois valores centrais
    meio1 = vetor_ordenado[tamanho // 2 - 1]
    meio2 = vetor_ordenado[tamanho // 2]
    mediana = (meio1 + meio2) / 2
print(f"Mediana: {mediana}")

# Moda:
# O valor que aparece com mais frequência no conjunto de dados.
frequencia = {}  # Cria o dicionario
for i in vetor:
    if i in frequencia:  # Verifica se i ja foi adicionado ao dicionario
        frequencia[i] += 1  # Se já foi, aumenta o contador
    else:
        frequencia[i] = 1  # Se não existe, adiciona e inicializa em 1

# Encontrar o valor com a maior contagem
if frequencia:
    moda = max(frequencia, key=frequencia.get)
    vezes = frequencia[moda]
    if vezes > 1:
        print(f"Moda: {moda} (apareceu {vezes} vezes)")
    else:
        print("Moda: Não há moda (nenhum valor se repete)")
else:
    print("Moda: O vetor está vazio")

print("-" * 20)

# --- Outras Médias ---

# Média Ponderada:
# Somatória dos valores multiplicados por seus respectivos pesos,
# dividida pela somatória dos pesos.
somapeso = 0
somaponderada = 0
for i in range(tamanho):
    peso = i + 1  # Exemplo: o peso é a posição do elemento + 1
    somaponderada += vetor[i] * peso
    somapeso += peso
mediaPonderada = somaponderada / somapeso
print(f"Média Ponderada (pesos = 1, 2, 3...): {mediaPonderada:.2f}")

# Média Harmônica:
# O número de elementos dividido pela soma dos inversos de cada elemento.
somainversa = 0
for i in range(tamanho):
    somainversa += 1 / vetor[i]
mediaharmonica = tamanho / somainversa
print(f"Média Harmônica: {mediaharmonica:.2f}")

# Média Geométrica:
# A raiz n-ésima do produto de todos os elementos.
produtoInterno = 1
for i in range(tamanho):
    produtoInterno *= vetor[i]
mediageometrica = produtoInterno ** (1 / tamanho)
print(f"Média Geométrica: {mediageometrica:.2f}")


# =================================================================
# PARTE 2: DADOS AGRUPADOS
# =================================================================
# Conforme o PDF 'MQ_A5.pdf'. Os dados são organizados em classes
# com suas respectivas frequências.
# -----------------------------------------------------------------

print("\n")
print("="*50)
print(" PARTE 2: ANÁLISE DE DADOS AGRUPADOS")
print("="*50)

# --- Dados de Entrada (Tabela de Frequência do PDF) ---
dados_agrupados = [
    {'classe': '[0, 50)', 'lim_inf': 0, 'lim_sup': 50, 'freq': 18},
    {'classe': '[50, 100)', 'lim_inf': 50, 'lim_sup': 100, 'freq': 8},
    {'classe': '[100, 150)', 'lim_inf': 100, 'lim_sup': 150, 'freq': 6},
    {'classe': '[150, 200)', 'lim_inf': 150, 'lim_sup': 200, 'freq': 2},
    {'classe': '[200, 250)', 'lim_inf': 200, 'lim_sup': 250, 'freq': 5},
    {'classe': '[250, 300)', 'lim_inf': 250, 'lim_sup': 300, 'freq': 1},
    {'classe': '[300, 350)', 'lim_inf': 300, 'lim_sup': 350, 'freq': 2},
]
print("Tabela de Frequência de Entrada:")
for item in dados_agrupados:
    print(item)
print("-" * 20)

# --- Auxiliares ---
freq_acumulada = 0
for classe in dados_agrupados:
    classe['ponto_medio'] = (classe['lim_inf'] + classe['lim_sup']) / 2
    freq_acumulada += classe['freq']
    classe['freq_acum'] = freq_acumulada

n = freq_acumulada
h = dados_agrupados[0]['lim_sup'] - dados_agrupados[0]['lim_inf']

# --- Principais Medidas ---

# Média Aritmética para Dados Agrupados (Eq. 1.2 do PDF)
soma_produtos = sum(c['ponto_medio'] * c['freq'] for c in dados_agrupados)
media_agrupada = soma_produtos / n
print(f"Média Aritmética (Agrupada): {media_agrupada:.2f} mm")

# Mediana para Dados Agrupados (Eq. 1.3 do PDF)
posicao_mediana = n / 2
classe_mediana = None
fac_anterior = 0
for classe in dados_agrupados:
    if classe['freq_acum'] >= posicao_mediana:
        classe_mediana = classe
        break
    fac_anterior = classe['freq_acum']

Lm = classe_mediana['lim_inf']
fm = classe_mediana['freq']
mediana_agrupada = Lm + ((posicao_mediana - fac_anterior) / fm) * h
print(f"Mediana (Agrupada): {mediana_agrupada:.2f} mm")

# Moda para Dados Agrupados (Eq. 1.4 do PDF - Fórmula de Czuber)
classe_modal = max(dados_agrupados, key=lambda x: x['freq'])
indice_modal = dados_agrupados.index(classe_modal)
Lm_moda = classe_modal['lim_inf']
fm_moda = classe_modal['freq']
fant_moda = dados_agrupados[indice_modal - 1]['freq'] if indice_modal > 0 else 0
fpost_moda = dados_agrupados[indice_modal + 1]['freq'] if indice_modal < len(dados_agrupados) - 1 else 0
delta1 = fm_moda - fant_moda
delta2 = fm_moda - fpost_moda
moda_agrupada = Lm_moda + (delta1 / (delta1 + delta2)) * h
print(f"Moda (Agrupada): {moda_agrupada:.2f} mm")

print("-" * 20)

# --- Medidas Separatrizes (Quartis, Decis, Percentis) ---
# Exemplo com o 3º Quartil (Q3), como no PDF (Eq. 1.5)

# Quartis dividem em 4 partes, Decis em 10, Percentis em 100.
def calcular_separatriz(j, m, nome):
    """Calcula uma medida separatriz genérica (Quartil, Decil, Percentil).
    j: índice da medida (ex: 3 para o 3º quartil)
    m: número de divisões (4 para quartil, 10 para decil, 100 para percentil)
    nome: string para exibição (ex: 'Q3')
    """
    posicao = (j * n) / m
    classe_sep = None
    fac_ant_sep = 0
    for classe in dados_agrupados:
        if classe['freq_acum'] >= posicao:
            classe_sep = classe
            break
        fac_ant_sep = classe['freq_acum']

    Lm_sep = classe_sep['lim_inf']
    fm_sep = classe_sep['freq']
    valor_sep = Lm_sep + ((posicao - fac_ant_sep) / fm_sep) * h
    print(f"{nome} ({j}º {nome[0:1]}): {valor_sep:.2f} mm (Posição: {posicao})")

# Calculando o 3º Quartil
calcular_separatriz(j=3, m=4, nome="Quartil")
# Calculando o 8º Decil
calcular_separatriz(j=8, m=10, nome="Decil")
# Calculando o 65º Percentil
calcular_separatriz(j=65, m=100, nome="Percentil")

print("="*50)
