""" x = 10

for i in range (1,11):
    x+=1
    if x % 2 == 0:
        print(x)
        print("par")
    else:
        print(x)
        print("impar")


 """

entrada = int(input("Digite um número: "))

match entrada % 2:
    case 0:
        print("O número é par")
    
    case 1:
        print("O número é impar")