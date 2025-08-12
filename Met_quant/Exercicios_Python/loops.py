""" x = 12
i = 1

# Loop to print multiplication table of x
for i in range(1, 11):
    x += 1
    print(x)

lista = [1, 2, 3, 4, 5]

for valor in lista:
    print(valor)
print("Fim da lista")

boletim = {
    'Portugues': 7.5,
    'Matematica': 8.0, 
    'Historia': 6.5,
    'Geografia': 9.0,
}

for chave, valor in boletim.items():
    print (f"{chave}: {valor}") """

n = int (input("Digite a quantidade de numeros "))
soma = 0

for i in range(n):
    num = int(input(f"Digite o numero {i+1} "))
    soma += num

print(f"A soma dos números digitados foi: {soma}")