package blackjack;

import javax.swing.*;

class Blackjack {

	public static void main(String[] args) {
		int pal, apu, valcar = 0, tot, valjug, valmaq;
		int[] maq = new int[2];
		int[] jug = new int[2];
		int preg, preayu = 0;
		String car, voljug;

		JOptionPane.showMessageDialog(null,
				"Bienvenido al juego BlackJack \nEl objetivo es simple: ganarle al Croupier (la maquina) obteniendo el puntaje más cercano a 21   \nPresona OK para conocer el valor de las cartas y las reglas",
				"BlackJack", JOptionPane.DEFAULT_OPTION,
				new ImageIcon(Blackjack.class.getResource("/img/blackjack.jpg")));

		do {

			preg = Integer.parseInt(JOptionPane.showInputDialog("ingrese 1 para conocer el valor de las cartas"
					+ "\nIngrese 2 para conocer las reglas" + "\nIngrese 3 para empezar a jugar"));

			switch (preg) {

			case 1:
				JOptionPane.showMessageDialog(null,
						"Las figuras (el Valet, la Reina y el Rey) valen 10, el As vale 11 o 1 y todas las otras cartas conservan su valor"
								+ "\nPresiona OK para conocer las reglas",
						"BlackJack", JOptionPane.DEFAULT_OPTION,
						new ImageIcon(Blackjack.class.getResource("/img/blackjack.jpg")));
				break;
			case 2:
				JOptionPane.showMessageDialog(null,
						"Se reparten dos cartas a la vista primero para el jugador, y luego para el Crupier \nSi usted tiene Black Jack (valor de carta 10 + un AS)"
								+ " con sus dos primeras cartas, gana y se le duplica la apuesta"
								+ "\nSi la suma es menor a 21 entonces el Croupier preguntará si necesita otra carta"
								+ "\nSi al pedir una nueva carta se pasa de 21, el jugador pierde automáticamente la partida y su apuesta"
								+ "\nPresione OK para conocer los diferentes tipos de apuesta ",
						"BlackJack", JOptionPane.DEFAULT_OPTION,
						new ImageIcon(Blackjack.class.getResource("/img/comojugar.jpg")));
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "barajando los mazos", "BlackJack", JOptionPane.DEFAULT_OPTION,
						new ImageIcon(Blackjack.class.getResource("/img/barajando.gif")));
				break;

			default:
				JOptionPane.showMessageDialog(null, "error en el ingreso");
				break;
			}

			if (preg != 3) {
				preayu = Integer.parseInt(JOptionPane.showInputDialog(
						"ingrese 1 para volver atras y leer los valores o las reglas \nIngrese cualquier otro numero para empezar a jugar"));
			}

		} while (preayu == 1);

		do {

			apu = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su apuesta"));

			int puntmaq = 0, puntjug = 0;

			for (int i = 0; i < maq.length; i++) {
				pal = (int) (Math.random() * 3 + 1);
				maq[i] = (int) (Math.random() * 13 + 1);
				valcar = maq[i];

				if (maq[i] == 11) {
					valcar = 10;
				} else if (maq[i] == 12) {
					valcar = 10;
				} else if (maq[i] == 13) {
					valcar = 10;

				} else if (maq[i] == 1 && puntmaq < 11) {
					valcar = 11;
				} else {

				}
				puntmaq = puntmaq + valcar;
				JOptionPane.showMessageDialog(null, "Le toco al dealer un " + valcar, "Blackjack",
						JOptionPane.PLAIN_MESSAGE,
						new ImageIcon(Blackjack.class.getResource("/img/" + maq[i] + pal + ".png")));
			}
			JOptionPane.showMessageDialog(null, "El dealer tiene en mano " + puntmaq, "Blackjack",
					JOptionPane.DEFAULT_OPTION, new ImageIcon(Blackjack.class.getResource("/img/mano.jpg")));

			for (int i = 0; i < jug.length; i++) {
				pal = (int) (Math.random() * 3 + 1);
				jug[i] = (int) (Math.random() * 13 + 1);
				valcar = jug[i];

				if (jug[i] == 11) {
					valcar = 10;
				} else if (jug[i] == 12) {
					valcar = 10;
				} else if (jug[i] == 13) {
					valcar = 10;

				} else if (jug[i] == 1 && puntjug < 11) {
					valcar = 11;
				} else {
				}
				puntjug = puntjug + valcar;
				JOptionPane.showMessageDialog(null, "Le toco al jugador un " + valcar, "Blackjack",
						JOptionPane.PLAIN_MESSAGE,
						new ImageIcon(Blackjack.class.getResource("/img/" + jug[i] + pal + ".png")));

			}

			JOptionPane.showMessageDialog(null, "El Jugador tiene en mano " + puntjug, "Blackjack",
					JOptionPane.DEFAULT_OPTION, new ImageIcon(Blackjack.class.getResource("/img/mano.jpg")));

			if (puntjug == 21) {
				tot = apu * 2;
				JOptionPane.showMessageDialog(null, "Gano el juego,tiene BlacJack, Duplica la apuesta" + " $" + tot, "Blackjack",
						JOptionPane.DEFAULT_OPTION, new ImageIcon(Blackjack.class.getResource("/img/ganajug.jpg")));

			} else if (puntjug < 21) {
				car = JOptionPane
						.showInputDialog("Quiere otra carta ? \nSi tu puntuacion es menor a la del dealer pierdes");
				if (car.equalsIgnoreCase("no") && puntjug < puntmaq) {
					JOptionPane.showMessageDialog(null, "Perdio el juego, Pierde la apuesta", "Blackjack",
							JOptionPane.DEFAULT_OPTION, new ImageIcon(Blackjack.class.getResource("/img/ganamaq.jpg")));
				} else if (car.equalsIgnoreCase("no") && puntjug == puntmaq) {
					JOptionPane.showMessageDialog(null, "Se empato el juego, Se queda con su apuesta " + " $" + apu,
							"Blackjack", JOptionPane.DEFAULT_OPTION,
							new ImageIcon(Blackjack.class.getResource("/img/empate.jpg")));
				} else {

				}

				while (car.equalsIgnoreCase("si") && puntjug < 21) {
					pal = (int) (Math.random() * 3 + 1);
					valjug = (int) (Math.random() * 13 + 1);
					valcar = valjug;
					if (valjug == 11) {
						valcar = 10;
					} else if (valjug == 12) {
						valcar = 10;
					} else if (valjug == 13) {
						valcar = 10;

					} else if (valjug == 1 && puntjug < 11) {
						valcar = 11;
					} else {

					}

					puntjug = puntjug + valcar;

					JOptionPane.showMessageDialog(null, "Al jugador le toco " + valcar, "Blackjack",
							JOptionPane.PLAIN_MESSAGE,
							new ImageIcon(Blackjack.class.getResource("/img/" + valjug + pal + ".png")));

					JOptionPane.showMessageDialog(null,
							"El jugador tiene en mano " + puntjug + "\nEl dealer tiene en mano " + puntmaq, "Blackjack",
							JOptionPane.DEFAULT_OPTION, new ImageIcon(Blackjack.class.getResource("/img/mano.jpg")));

					if (puntjug <=21) {
						car = (String) JOptionPane.showInputDialog(null,
								"Quiere otra carta ? Si tu puntuacion es menor a la del dealer pierdes", "Blackjack",
								JOptionPane.DEFAULT_OPTION,
								new ImageIcon(Blackjack.class.getResource("/img/blackjack.jpg")), null, null);
						if (car.equalsIgnoreCase("no") && puntjug < puntmaq) {
							JOptionPane.showMessageDialog(null, "Perdio el juego, Pierde la apuesta", "Blackjack",
									JOptionPane.DEFAULT_OPTION,
									new ImageIcon(Blackjack.class.getResource("/img/ganamaq.jpg")));
						} else if (car.equalsIgnoreCase("no") && puntjug == puntmaq) {
							JOptionPane.showMessageDialog(null,
									"Se empato el juego, Se queda con su apuesta " + " $" + apu, "Blackjack",
									JOptionPane.DEFAULT_OPTION,
									new ImageIcon(Blackjack.class.getResource("/img/empate.jpg")));
						} else {

						}

					}
				}
				if (puntjug > 21) {
					JOptionPane.showMessageDialog(null, "Perdio el juego, Pierde la apuesta", "Blackjack",
							JOptionPane.DEFAULT_OPTION, new ImageIcon(Blackjack.class.getResource("/img/ganamaq.jpg")));
				} else if (puntmaq < puntjug) {

					while (puntmaq < puntjug) {
						pal = (int) (Math.random() * 3 + 1);
						valmaq = (int) (Math.random() * 13 + 1);
						valcar = valmaq;
						if (valmaq == 11) {
							valcar = 10;
						} else if (valmaq == 12) {
							valcar = 10;
						} else if (valmaq == 13) {
							valcar = 10;

						} else if (valmaq == 1 && puntmaq < 11) {
							valcar = 11;
						} else {

						}
						puntmaq = puntmaq + valcar;
						JOptionPane.showMessageDialog(null, "Al Dealer le toco " + valcar, "Blackjack",
								JOptionPane.PLAIN_MESSAGE,
								new ImageIcon(Blackjack.class.getResource("/img/" + valmaq + pal + ".png")));
						JOptionPane.showMessageDialog(null,
								"El jugador tiene en mano " + puntjug + "\nEl Dealer tiene en mano " + puntmaq,
								"Blackjack", JOptionPane.DEFAULT_OPTION,
								new ImageIcon(Blackjack.class.getResource("/img/mano.jpg")));
					}
					if (puntmaq > 21) {
						tot = apu * 2;
						JOptionPane.showMessageDialog(null, "Gano el juego, Duplica la apuesta" + " $" + tot,
								"Blackjack", JOptionPane.DEFAULT_OPTION,
								new ImageIcon(Blackjack.class.getResource("/img/ganajug.jpg")));
					} else if (puntmaq == puntjug) {
						JOptionPane.showMessageDialog(null, "Se empato el juego, Se queda con su apuesta " + " $" + apu,
								"Blackjack", JOptionPane.DEFAULT_OPTION,
								new ImageIcon(Blackjack.class.getResource("/img/empate.jpg")));
					} else {
						JOptionPane.showMessageDialog(null, "Perdio el juego", "Blackjack",
								JOptionPane.DEFAULT_OPTION,
								new ImageIcon(Blackjack.class.getResource("/img/ganamaq.jpg")));
					}
				}
			}
			voljug = JOptionPane.showInputDialog("Quiere volver a jugar?");

		} while (voljug.equalsIgnoreCase("si"));
	}
}
