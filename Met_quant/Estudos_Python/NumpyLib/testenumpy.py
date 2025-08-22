import numpy as np

print("######## ARRAYS X VETORES NUMPY ########")

# -------------------------------
# Criação de vetores
# -------------------------------
v1 = np.array([3, 5, 7])
v2 = np.array([1, 4, -7])

print("v1:", v1)
print("v2:", v2)

# Soma elemento a elemento
# Saída: [4 9 0]
print("Soma de v1 + v2 (elemento a elemento):", v1 + v2)

# -------------------------------
# Listas Python
# -------------------------------
a = [3, 5, 7]
b = [1, 4, -7]

# Listas Python não somam elemento a elemento, concatena
# Saída: [3, 5, 7, 1, 4, -7]
print("Soma de listas Python (concatenação):", a + b)

print("\n######## VETORES NUMPY ########")

# Arrays NumPy podem ser floats ou ints
a = np.array((2, 5))
b = np.array((1.5, 7.0))
num = 4

# Operações básicas
print("a:", a)
print("b:", b)
print("Soma a + b:", a + b)
print("Subtração a - b:", a - b)
print(f"Multiplicação de a por {num}:", a * num)

# Produto escalar (dot product)
print("Produto escalar (np.dot) a · b:", np.dot(a, b))

# Estatísticas
print("Média de a:", a.mean())
print("Maior valor de a:", a.max())
print("Menor valor de a:", a.min())

# -------------------------------
# MATRIZES
# -------------------------------
mat1 = np.array([[1, 2, 3], [4, 5, 6], [7, 8, 9]])
mat2 = np.eye(3)  # Matriz identidade 3x3

print("\nMatriz mat1:\n", mat1)
print("Matriz identidade mat2:\n", mat2)

# Produto matricial
print("Produto mat1 @ mat2:\n", mat1 @ mat2)
print("Produto np.matmul(mat1, mat2):\n", np.matmul(mat1, mat2))

# -------------------------------
# Informações sobre arrays
# -------------------------------
print("\n######## INFORMAÇÕES SOBRE ARRAYS ########")
print("Número de dimensões de mat1 (ndim):", mat1.ndim)
print("Formato da matriz mat1 (shape):", mat1.shape)
print("Número total de elementos em mat1 (size):", mat1.size)
print("Tipo dos elementos em mat1 (dtype):", mat1.dtype)

# Alterando tipo de array
mat1_float = mat1.astype(float)
print("Matriz mat1 convertida para float (dtype):", mat1_float.dtype)

# Indexação e fatiamento
print("\nPrimeira linha de mat1:", mat1[0, :])
print("Última coluna de mat1:", mat1[:, -1])
print("Submatriz 2x2 do canto superior esquerdo:\n", mat1[0:2, 0:2])

# Operações adicionais
print("\nSoma de todas as linhas de mat1:", mat1.sum(axis=1))  # soma por linha
print("Soma de todas as colunas de mat1:", mat1.sum(axis=0))   # soma por coluna
