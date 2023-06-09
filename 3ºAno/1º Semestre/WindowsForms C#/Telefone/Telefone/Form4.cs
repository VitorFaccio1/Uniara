using System;
using System.Windows.Forms;

namespace Telefone
{
    public partial class Form4 : Form
    {
        public Contato Contato { get; set; }

        public Form4(Contato contato)
        {
            InitializeComponent();
            Contato = contato;
            pictureBox1.Image = contato.Imagem;
            label1.Text = contato.Nome;
        }

        private void button12_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }
    }
}