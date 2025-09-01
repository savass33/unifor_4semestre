import pandas as pd
import matplotlib.pyplot as plt

df = pd.read_csv('nba_stats.csv', on_bad_lines='skip')

freq_name = df["name"].value_counts()

freq_pos = df["positionId"].value_counts()

# Gráfico das posições
plt.figure(figsize=(8,6))
bars_pos = plt.bar(freq_pos.index, freq_pos.values, color="royalblue")

# Rótulos nos valores
for bar in bars_pos:
    plt.text(bar.get_x() + bar.get_width()/2,
             bar.get_height(),
             str(bar.get_height()),
             ha='center', va='bottom')

plt.title("Distribuição de Jogadores por Posicao (NBA)", fontsize=14)
plt.xlabel("Posicao", fontsize=12)
plt.ylabel("Número de Jogadores", fontsize=12)
plt.show()