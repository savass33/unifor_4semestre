import pandas as pd
import matplotlib.pyplot as plt

df = pd.read_csv('nba_stats.csv', on_bad_lines='skip')

# Variável contínua: minutos em quadra
minutes = df["avgMinutes"].dropna()   # removendo valores ausentes se houver

plt.figure(figsize=(8,6))
plt.hist(minutes, bins=20, color="red", edgecolor="black")

plt.title("Distribuição da Média de Minutos por Jogo (NBA)", fontsize=14)
plt.xlabel("Média de Minutos por Jogo", fontsize=12)
plt.ylabel("Frequência de Jogadores", fontsize=12)
plt.show()