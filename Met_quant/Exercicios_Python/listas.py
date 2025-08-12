matriz = [[1,2,3],[4,5,6],[7,8,9]]

for linha in matriz:
    print(linha)


soma = 0

for i in range (len(matriz)):
    soma += matriz[i][i]

print(f"Soma da diagonal principal: {soma}")