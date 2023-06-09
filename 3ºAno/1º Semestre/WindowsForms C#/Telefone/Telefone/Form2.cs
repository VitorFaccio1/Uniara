using System;
using System.Drawing;
using System.Windows.Forms;

namespace Telefone
{
    public partial class Form2 : Form
    {
        public Contato Contato;

        public Form2()
        {
            InitializeComponent();
        }

        public Form2(Contato contato)
        {
            InitializeComponent();
            this.Contato = contato;
        }

        private void label4_Click(object sender, EventArgs e)
        {
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(textBox1.Text) ||
                string.IsNullOrEmpty(textBox2.Text) ||
                pictureBox1.Image is null)
            {
                MessageBox.Show("Por favor, preencha todos os campos corretamente.");
                return;
            }

            Contato = new Contato
            {
                Nome = textBox1.Text,
                Telefone = textBox2.Text,
                Imagem = pictureBox1.Image
            };

            DialogResult = DialogResult.OK;
            Close();
        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {
            OpenFileDialog dialog = new OpenFileDialog
            {
                Filter = "Arquivos de imagem|*.jpg;*.jpeg;*.png;*.gif"
            };

            if (dialog.ShowDialog() == DialogResult.OK)
                pictureBox1.Image = new Bitmap(dialog.FileName);
        }

        private void button2_Click(object sender, EventArgs e)
        {
            DialogResult = DialogResult.Cancel;
            Close();
        }
    }
}