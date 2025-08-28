# Dados Nao agrupados: Aqui os dados vêm em forma de lista ou tabela simples, sem nenhuma frequência associada.

# Auxiliares

vetor = [31, 22, 3, 44, 51, 66, 47, 88, 66, 710, 11]
soma = sum(vetor)
vetor_ordenado = sorted(vetor)
tamanho = len(vetor)

print("Vetor:", vetor)


# Principais medidas

# Media:

media = soma / len(vetor)
print(f"Media: {media:.2f}")

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
frequencia = {} # Cria o dicionario 
for i in vetor:
    if i in frequencia: # Verifica se i ja foi adicionado ao dicionario
        frequencia[i] += 1 # Se já foi, aumenta o contador
    else:
        frequencia[i] = 1 # Se não existe, adiciona o numero como chave e inicializa a contagem em 1

# Encontrar o número mais contado
numero_mais_contado = max(frequencia, key=frequencia.get)
vezes = frequencia[numero_mais_contado]

print(f"Moda: {numero_mais_contado}, {vezes} vezes")

""" 
- Quartis: Dividem o conjunto de dados em quatro partes (Q1, Q2, Q3).

- Decis: Dividem o conjunto de dados em dez partes (D1, D2, ..., D9).

- Percentis: Dividem o conjunto de dados em cem partes (P1, P2, ..., P99).
 """


# Em boxplot: Limite minimo: Q1 - 1,5 * IQR || Limite maximo: Q3 + 1,5 * IQR
# IQR = Amplitude Interqurtil -> Diferença entre o Q1 e o Q3

# Media ponderada
# Somatoria dos valores e seus respectivos pesos divididos pela somatoria dos pesos

somapeso = 0
somaponderada = 0

for i in range(tamanho):
    peso = i + 1 # Comecar o peso em 1
    somaponderada += vetor[i] * peso
    somapeso += peso

mediaPonderada = somaponderada / somapeso

print(f"Media ponderada: {mediaPonderada:.2f}")

# Media harmonica
# Divide-se o número de elementos de um conjunto pela soma dos seus inversos

nElementos = tamanho
somainversa = 0

for i in range(tamanho):
    somainversa += 1 / vetor[i]

mediaharmonica = nElementos / somainversa

print(f"Media harmonica: {mediaharmonica:.2f}")

# Media geometrica
# Raiz n-ésima do produto de todos os elementos do conjunto, onde n é o número de elementos

nElementos = tamanho
produtoInterno = 1

for i in range(tamanho):
    produtoInterno *= vetor[i]

mediageometrica = produtoInterno ** (1 / nElementos)

print(f"Media geometrica: {mediageometrica:.2f}")