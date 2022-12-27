using System;
using System.Windows.Forms;

namespace WindowsFormsApplication1
{
    public partial class Form1 : Form
    {
        bool VezJogador = true;
        int jogadas = 0;

        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(button1.Text))
            {
                button1.Text = VezJogador ? "X" : "O";
                VezJogador = !VezJogador;
                label1.Text = VezJogador ? "Vez do Jogador X" : "Vez do Jogador O";
                jogadas++;

                if (jogadas > 4)
                    ChecaJogo();
            }

        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(button2.Text))
            {
                button2.Text = VezJogador ? "X" : "O";
                VezJogador = !VezJogador;
                label1.Text = VezJogador ? "Vez do Jogador X" : "Vez do Jogador O";
                jogadas++;

                if (jogadas > 4)
                    ChecaJogo();
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(button3.Text))
            {
                button3.Text = VezJogador ? "X" : "O";
                VezJogador = !VezJogador;
                label1.Text = VezJogador ? "Vez do Jogador X" : "Vez do Jogador O";
                jogadas++;
                if (jogadas > 4)
                    ChecaJogo();
            }
        }

        private void button6_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(button6.Text))
            {
                button6.Text = VezJogador ? "X" : "O";
                VezJogador = !VezJogador;
                label1.Text = VezJogador ? "Vez do Jogador X" : "Vez do Jogador O";
                jogadas++;
                if (jogadas > 4)
                    ChecaJogo();
            }
        }

        private void button5_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(button5.Text))
            {
                button5.Text = VezJogador ? "X" : "O";
                VezJogador = !VezJogador;
                label1.Text = VezJogador ? "Vez do Jogador X" : "Vez do Jogador O";
                jogadas++;
                if (jogadas > 4)
                    ChecaJogo();
            }
        }

        private void button4_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(button4.Text))
            {
                button4.Text = VezJogador ? "X" : "O";
                VezJogador = !VezJogador;
                label1.Text = VezJogador ? "Vez do Jogador X" : "Vez do Jogador O";
                jogadas++;
                if (jogadas > 4)
                    ChecaJogo();
            }
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void button8_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(button8.Text))
            {
                button8.Text = VezJogador ? "X" : "O";
                VezJogador = !VezJogador;
                label1.Text = VezJogador ? "Vez do Jogador X" : "Vez do Jogador O";
                jogadas++;
                if (jogadas > 4)
                    ChecaJogo();
            }
        }

        private void button7_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(button7.Text))
            {
                button7.Text = VezJogador ? "X" : "O";
                VezJogador = !VezJogador;
                label1.Text = VezJogador ? "Vez do Jogador X" : "Vez do Jogador O";
                jogadas++;
                if (jogadas > 4)
                    ChecaJogo();
            }
        }

        private void button9_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(button9.Text))
            {
                button9.Text = VezJogador ? "X" : "O";
                VezJogador = !VezJogador;
                label1.Text = VezJogador ? "Vez do Jogador X" : "Vez do Jogador O";
                jogadas++;
                if (jogadas > 4)
                    ChecaJogo();
            }
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void ChecaJogo()
        {
            var jogadorVencedor = ChecaVencedor();

            if (!string.IsNullOrEmpty(jogadorVencedor))
            {
                if (jogadorVencedor.Equals("VELHA"))
                    ((Form2)this.Owner).label3.Text = jogadorVencedor;
                else
                    ((Form2)this.Owner).label3.Text = $"Jogador {jogadorVencedor} venceu o jogo";
            }
        }

        private string ChecaVencedor()
        {
            var vencedor = ChecarLinhasHorinzontaisJogadorX() || ChecarLinhasVerticaisJogadorX() || ChecarLinhasDiagonaisJogadorX() ? "X" : string.Empty;

            if (string.IsNullOrEmpty(vencedor))
                vencedor = ChecarLinhasHorinzontaisJogadorO() || ChecarLinhasVerticaisJogadorO() || ChecarLinhasDiagonaisJogadorO() ? "O" : string.Empty;

            if (string.IsNullOrEmpty(vencedor) && jogadas == 9)
                vencedor = "VELHA";

            return vencedor;
        }

        private bool ChecarLinhasHorinzontaisJogadorO()
        {
            return button1.Text.Equals("O") &&
                                            button2.Text.Equals("O") &&
                                            button3.Text.Equals("O")
                                            ||
                                            button4.Text.Equals("O") &&
                                            button5.Text.Equals("O") &&
                                            button6.Text.Equals("O")
                                            ||
                                            button7.Text.Equals("O") &&
                                            button8.Text.Equals("O") &&
                                            button9.Text.Equals("O");
        }

        private bool ChecarLinhasVerticaisJogadorO()
        {
            return button1.Text.Equals("O") &&
                                            button6.Text.Equals("O") &&
                                            button9.Text.Equals("O")
                                            ||
                                            button2.Text.Equals("O") &&
                                            button5.Text.Equals("O") &&
                                            button8.Text.Equals("O")
                                            ||
                                            button3.Text.Equals("O") &&
                                            button4.Text.Equals("O") &&
                                            button7.Text.Equals("O");
        }

        private bool ChecarLinhasVerticaisJogadorX()
        {
            return button1.Text.Equals("X") &&
                                            button6.Text.Equals("X") &&
                                            button9.Text.Equals("X")
                                            ||
                                            button2.Text.Equals("X") &&
                                            button5.Text.Equals("X") &&
                                            button8.Text.Equals("X")
                                            ||
                                            button3.Text.Equals("X") &&
                                            button4.Text.Equals("X") &&
                                            button7.Text.Equals("X");
        }

        private bool ChecarLinhasHorinzontaisJogadorX()
        {
            return button1.Text.Equals("X") &&
                                            button2.Text.Equals("X") &&
                                            button3.Text.Equals("X")
                                            ||
                                            button4.Text.Equals("X") &&
                                            button5.Text.Equals("X") &&
                                            button6.Text.Equals("X")
                                            ||
                                            button7.Text.Equals("X") &&
                                            button8.Text.Equals("X") &&
                                            button9.Text.Equals("X");
        }

        private bool ChecarLinhasDiagonaisJogadorX()
        {
            return button1.Text.Equals("X") &&
                                            button5.Text.Equals("X") &&
                                            button7.Text.Equals("X")
                                            ||
                                            button3.Text.Equals("X") &&
                                            button5.Text.Equals("X") &&
                                            button9.Text.Equals("X");
        }

        private bool ChecarLinhasDiagonaisJogadorO()
        {
            return button1.Text.Equals("O") &&
                                            button5.Text.Equals("O") &&
                                            button7.Text.Equals("O")
                                            ||
                                            button3.Text.Equals("O") &&
                                            button5.Text.Equals("O") &&
                                            button9.Text.Equals("O");
        }

        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void button10_Click(object sender, EventArgs e)
        {
            this.Visible = false;
        }

        private void button11_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
