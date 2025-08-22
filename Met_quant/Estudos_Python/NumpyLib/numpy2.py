import numpy as np

# -------------------------------
# 1. Array de zeros
# -------------------------------
a = np.zeros(3)  # Cria um array com 3 elementos, todos 0
print("Array de zeros (1D, 3 elementos):")
print(a)
print("-" * 40)

# -------------------------------
# 2. Array de zeros com forma (shape)
# -------------------------------
z = np.zeros(10)       # Array de 10 zeros
z.shape = (5, 2)       # Transforma em uma matriz 5x2
print("Array de zeros 5x2:")
print(z)
print("-" * 40)

# -------------------------------
# 3. Array com linspace
# -------------------------------
z = np.linspace(2, 10, 5)  # 5 elementos igualmente espaçados entre 2 e 10
print("Array com linspace de 2 a 10 (5 elementos):")
print(z)
# Explicação: step = (stop - start)/(num-1)
print(f"Passo calculado automaticamente: {(10-2)/(5-1)}")
print("-" * 40)

# -------------------------------
# 4. Array de uns
# -------------------------------
y = np.ones(10)  # Array de 10 elementos, todos 1
print("Array de uns (10 elementos):")
print(y)
print("-" * 40)

# -------------------------------
# 5. Array aleatório de inteiros
# -------------------------------
x = np.random.randint(0, 10, size=10)  # Array com 10 inteiros aleatórios de 0 a 9
print("Array aleatório de inteiros (0 a 9):")
print(f"Primeiro elemento: {x[0]}")
print(f"Todos os elementos: {x}")
print("-" * 40)

# -------------------------------
# 6. Array aleatório de floats
# -------------------------------
f = np.random.rand(5)  # 5 números aleatórios entre 0 e 1
print("Array aleatório de floats (0 a 1):")
print(f)
print("-" * 40)

# -------------------------------
# 7. Matriz aleatória inteira
# -------------------------------
m = np.random.randint(0, 20, size=(3, 4))  # Matriz 3x4 de inteiros aleatórios 0-19
print("Matriz aleatória 3x4 de inteiros (0-19):")
print(m)
print("-" * 40)

# -------------------------------
# 8. Operações úteis
# -------------------------------
print("Soma de todos os elementos de x:", np.sum(x))
print("Máximo de x:", np.max(x))
print("Mínimo de x:", np.min(x))
print("Média de x:", np.mean(x))
print("-" * 40)

# -------------------------------
# 9. Indexação e fatiamento
# -------------------------------
print("Primeiros 3 elementos de x:", x[:3])
print("Últimos 3 elementos de x:", x[-3:])
print("Todos os elementos exceto o primeiro:", x[1:])
print("-" * 40)

# -------------------------------
# 10. Alterando valores
# -------------------------------
x[0] = 99
print("Alterando o primeiro elemento de x para 99:")
print(x)
