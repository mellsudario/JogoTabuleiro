package interfacegrafica;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.JPanel;

public class TabuleiroPanel extends JPanel {

	ArrayList<CasaPainel> trilha;
	ArrayList<Peca> pecas;

	private static final Color[][] CORES_LINHA = { 
			{ new Color(179, 229, 252), new Color(2, 136, 209) }, // linha 0 - azul
			{ new Color(200, 230, 201), new Color(56, 142, 60) }, // linha 1 - verde
			{ new Color(255, 224, 178), new Color(230, 81, 0) }, // linha 2 - laranja
			{ new Color(225, 190, 231), new Color(123, 31, 162) }, // linha 3 - roxo
	};
	private static final Color COR_START_FUNDO = new Color(255, 241, 118);
	private static final Color COR_START_BORDA = new Color(249, 168, 37);
	private static final Color COR_FIM_FUNDO = new Color(239, 154, 154);
	private static final Color COR_FIM_BORDA = new Color(198, 40, 40);

	private static final int R = 37; // raio da casa
	private static final int D = R * 2;

	public TabuleiroPanel() {
		this.pecas = new ArrayList<>();
		this.trilha = new ArrayList<>();
		criarTrilha();
	}

	private void criarTrilha() {
		int casasPorLinha = 10; // cada linha do tabuleiro tem 10 casas
		int margem = 50; // distância da borda esquerda até a primeira casa
		int espaco = 90; // distância entre o início de uma casa e a próxima
		int[] Y = { 30, 135, 240, 345 }; // posição vertical (Y) de cada uma das 4 linhas

		for (int r = 0; r < 4; r++) { // repete 4 vezes, uma pra cada linha
			int[] xs = new int[casasPorLinha]; // cria um array com 10 posições de X
			for (int c = 0; c < casasPorLinha; c++)
				xs[c] = margem + c * espaco; // preenche

			if (r % 2 == 1) { // se for linha ímpar (linhas 1 e 3), inverte a ordem
				for (int i = 0; i < casasPorLinha / 2; i++) { // percorre só metade do array
					int tmp = xs[i]; // guarda o valor da esquerda
					xs[i] = xs[casasPorLinha - 1 - i]; // coloca o da direita no lugar
					xs[casasPorLinha - 1 - i] = tmp; // coloca o guardado na direita
				}
			}
			for (int c = 0; c < casasPorLinha; c++)
				trilha.add(new CasaPainel(xs[c], Y[r])); // adiciona as 10 casas da linha à trilha
		}

		// casa 40
		trilha.add(new CasaPainel(margem, 450));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // suaviza bordas
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON); // qualidade das letras

		desenharFundo(g2);
		desenharTrilha(g2);
		desenharPecas(g2);
	}

	private void desenharFundo(Graphics2D g2) {
		GradientPaint grad = new GradientPaint(0, 0, new Color(232, 245, 233), getWidth(), getHeight(),
				new Color(200, 230, 200));
		g2.setPaint(grad);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

	}

	private void desenharTrilha(Graphics2D g2) {
		int total = trilha.size();
		Font fontNormal = new Font("Arial Rounded MT Bold", Font.BOLD, 12);
		Font fontNumeros = new Font("Arial Rounded MT Bold", Font.BOLD, 11);

		for (int i = 0; i < total; i++) {
			CasaPainel c = trilha.get(i);
			int cx = c.getX() + R;
			int cy = c.getY() + R;

			Color fundo, borda;
			if (i == 0) { // primeira casa = START
				fundo = COR_START_FUNDO;
				borda = COR_START_BORDA;
			} else if (i == total - 1) { // última casa = FIM
				fundo = COR_FIM_FUNDO;
				borda = COR_FIM_BORDA;
			} else {
				int linha = i / 10;
				fundo = CORES_LINHA[Math.min(linha, 3)][0];
				borda = CORES_LINHA[Math.min(linha, 3)][1];
			}

			// sombra
			g2.setColor(new Color(0, 0, 0, 40));
			g2.fillOval(c.getX() + 2, c.getY() + 4, D, D);

			// corpo da casa
			g2.setColor(fundo);
			g2.fillOval(c.getX(), c.getY(), D, D);
			g2.setColor(borda);
			g2.setStroke(new BasicStroke(2f));
			g2.drawOval(c.getX(), c.getY(), D, D);

			// brilho bolinha branca
			Graphics2D g2b = (Graphics2D) g2.create();
			g2b.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
			g2b.setColor(Color.WHITE);
			g2b.fillOval(cx - R / 2 - 4, cy - R / 2 - 6, R - 4, (int) (R * 0.55));
			g2b.dispose();

			// número
			g2.setColor(new Color(62, 62, 62));

			String textoCasa;
			if (i == 0) {
				textoCasa = "START";
			} else if (i == total - 1) {
				textoCasa = "FIM";
			} else {
				textoCasa = String.valueOf(i);
			}

			Font fonte;
			if (i == 0 || i == total - 1) {
				fonte = fontNormal;
			} else {
				fonte = fontNumeros;
			}

			g2.setFont(fonte);
			FontMetrics fm = g2.getFontMetrics();
			int tx = cx - fm.stringWidth(textoCasa) / 2;
			int ty = cy + fm.getAscent() / 2 - 2;
			g2.drawString(textoCasa, tx, ty);

			g2.setStroke(new BasicStroke(1f));
		}
	}

	private void desenharPecas(Graphics2D g2) {
		int[][] offsets = { { -12, -12 }, { 12, -12 }, { -12, 12 }, { 12, 12 }, { 0, -12 }, { 0, 12 }, };

		for (int i = 0; i < trilha.size(); i++) {
			CasaPainel casa = trilha.get(i);
			ArrayList<Peca> pecasCasa = new ArrayList<>();
			for (Peca p : pecas)
				if (p.getPosicao() == i)
					pecasCasa.add(p);

			for (int j = 0; j < pecasCasa.size(); j++) {
				Peca peca = pecasCasa.get(j);

				int[] off;
				if (j < offsets.length) {
					off = offsets[j];
				} else {
					off = new int[] { 0, 0 };
				}

				int pecaCentroX = casa.getX() + R + off[0];
				int pecaCentroY = casa.getY() + R + off[1];
				int pecaRaio = 12;

				// sombra da peça
				g2.setColor(new Color(0, 0, 0, 80));
				g2.fillOval(pecaCentroX - pecaRaio + 1, pecaCentroY - pecaRaio + 3, pecaRaio * 2, pecaRaio * 2);

				// corpo da peça
				g2.setColor(peca.getCor());
				g2.fillOval(pecaCentroX - pecaRaio, pecaCentroY - pecaRaio, pecaRaio * 2, pecaRaio * 2);
				g2.setColor(Color.WHITE);
				g2.setStroke(new BasicStroke(2.5f));
				g2.drawOval(pecaCentroX - pecaRaio, pecaCentroY - pecaRaio, pecaRaio * 2, pecaRaio * 2);

				// brilho da peça
				Graphics2D g2p = (Graphics2D) g2.create();
				g2p.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.45f));
				g2p.setColor(Color.WHITE);
				g2p.fillOval(pecaCentroX - 5, pecaCentroY - pecaRaio + 2, 8, 5);
				g2p.dispose();

				g2.setStroke(new BasicStroke(1f));
			}
		}
	}

	public void incluirJogador(int posicao, Color cor) {
		Peca novaPeca = new Peca(posicao, cor);
		if (pecas.contains(novaPeca))
			return;
		pecas.add(novaPeca);
		repaint();
	}

	public void moverJogador(int posicao, Color cor) {
		for (Peca peca : pecas) {
			if (peca.getCor().equals(cor)) {
				peca.setPosicao(posicao);
				break;
			}
		}
		repaint();
	}
}