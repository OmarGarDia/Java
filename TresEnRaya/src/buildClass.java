import java.awt.Color;

import javax.swing.JOptionPane;

public class buildClass {
	
	int turno;
	int puntosPlayer1;
	int puntosPlayer2;
	
	public buildClass(int turno, int puntosPlayer1, int puntosPlayer2) {
		super();
		this.turno = turno;
		this.puntosPlayer1 = puntosPlayer1;
		this.puntosPlayer2 = puntosPlayer2;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public int getPuntosPlayer1() {
		return puntosPlayer1;
	}

	public void setPuntosPlayer1(int puntosPlayer1) {
		this.puntosPlayer1 = puntosPlayer1;
	}

	public int getPuntosPlayer2() {
		return puntosPlayer2;
	}

	public void setPuntosPlayer2(int puntosPlayer2) {
		this.puntosPlayer2 = puntosPlayer2;
	}
	
	public void cambiarTurno() {
	
		if(getTurno()== 0) {
			setTurno(1);
		}else {
			setTurno(0);
		}
	}
	
	public int juego(int array[][]) {
		
		// Comprobación en la misma linea
		
		if(array[0][0]==array[0][1] && array[0][0] == array[0][2]) {
			return 1;
		}
		
		if(array[1][0]==array[1][1] && array[1][0] == array[1][2]) {
			return 2;
		}
		
		if(array[2][0]==array[2][1] && array[2][0] == array[2][2]) {
			return 3;
		}
		
		// Comprobación en la misma columna
		
		if(array[0][0]==array[1][0] && array[0][0] == array[2][0]) {
			return 4;
		}
		
		if(array[0][1]==array[1][1] && array[0][1] == array[2][1]) {
			return 5;
		}
		
		if(array[0][2]==array[1][2] && array[0][2] == array[2][2]) {
			return 6;
		}
		
		
		// Comprobación en diagonal
		
		if(array[0][0]==array[1][1] && array[0][0] == array[2][2]) {
			return 7;
		}
		
		if(array[2][0]==array[1][1] && array[2][0] == array[0][2]) {
			return 8;
		}
		
		
		return 0;
		
	}
	
	public int ejecutar(javax.swing.JButton bt, int i, int j, int array[][], javax.swing.JLabel jx, javax.swing.JLabel jo) {
		
		array[i][j]=getTurno();
		String n = new String();
		
		if(getTurno()==0) {
			n = "Jugador 1";
			bt.setForeground(Color.red);
		}else {
			n = "Jugador 2";
			bt.setForeground(Color.blue);
		}
		
		cambiarTurno();
		bt.setText(n);
		bt.setEnabled(false);
		
		if(juego(array)!= 0) {
			JOptionPane.showMessageDialog(null, "GANASTE!" + n);
			if(getTurno()== 1) {
				setPuntosPlayer1(getPuntosPlayer1()+1);	
				jx.setText(String.valueOf(getPuntosPlayer1()));
			}
			if(juego(array)== 0) {
				setPuntosPlayer2(getPuntosPlayer2()+1);
				jx.setText(String.valueOf(getPuntosPlayer2()));
			}
		}
		
		return 0;
	}
	
	public void raya(int array[][], javax.swing.JPanel p, int n, int i, int j) {
		array[i][j]= getTurno();
		
		if(juego(array)==n) {
			p.setVisible(true);
		}
	}
	
}
