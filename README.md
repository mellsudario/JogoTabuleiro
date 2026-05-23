# 🎲 Jogo de Tabuleiro — POO em Java

Jogo de tabuleiro para 2 a 6 jogadores, com interface gráfica em Swing, casas especiais e três tipos de jogadores.

## Tipos de Jogador

| Tipo | Dados |
|------|-------|
| Normal | Soma livre |
| Sortudo | Soma sempre > 7 |
| Azarado | Soma sempre < 6 |

> É obrigatório ter pelo menos dois tipos diferentes na partida.

## Casas Especiais

| Casa(s) | Efeito |
|---------|--------|
| 5, 15, 30 | Avança 3 casas (Azarado não avança) |
| 10, 25, 38 | Perde a próxima rodada |
| 13 | Muda de tipo aleatoriamente |
| 17, 27 | Escolhe um adversário para voltar ao início |
| 20, 35 | Troca de lugar com o jogador mais atrás |

Dados iguais = joga novamente.

## Modo Debug

Ative no início da partida para digitar diretamente o número da casa de destino, sem depender dos dados.

## Estrutura

```
src/
├── main/             # Main.java
├── classes/          # Jogo, Tabuleiro, Casa (e subclasses), Jogador (e subclasses)
└── interfacegrafica/ # TabuleiroPanel, CasaPainel, Peca
```

## Conceitos Aplicados
Herança, polimorfismo, classes abstratas e encapsulamento.
