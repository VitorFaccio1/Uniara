using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;

namespace Telefone
{
    public partial class Form3 : Form
    {
        public List<Contato> Contatos { get; set; }

        public Form3(List<Contato> contatos)
        {
            InitializeComponent();
            Contatos = contatos;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            AddNumber('1');
        }

        private void button2_Click(object sender, EventArgs e)
        {
            AddNumber('2');
        }

        private void button3_Click(object sender, EventArgs e)
        {
            AddNumber('3');
        }

        private void button6_Click(object sender, EventArgs e)
        {
            AddNumber('4');
        }

        private void button5_Click(object sender, EventArgs e)
        {
            AddNumber('5');
        }

        private void button4_Click(object sender, EventArgs e)
        {
            AddNumber('6');
        }

        private void button9_Click(object sender, EventArgs e)
        {
            AddNumber('7');
        }

        private void button8_Click(object sender, EventArgs e)
        {
            AddNumber('8');
        }

        private void button7_Click(object sender, EventArgs e)
        {
            AddNumber('9');
        }

        private void button11_Click(object sender, EventArgs e)
        {
            AddNumber('0');
        }

        private void button10_Click(object sender, EventArgs e)
        {
            RemoveNumber();
        }

        private void button12_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(label1.Text))
            {
                MessageBox.Show("Insira um numero valido!!!");
                return;
            }

            var contact = Contatos.FirstOrDefault(c => c.Telefone.Equals(label1.Text));

            if (contact != null)
            {
                var form4 = new Form4(contact);

                form4.ShowDialog();
            }
            else
            {
                MessageBox.Show("Não foi encontrado nenhum contato com esse telefone!! Tente outro numero!");
                return;
            }

        }

        private void AddNumber(char number)
        {
            label1.Text += number;
        }

        private void RemoveNumber()
        {
            if (label1.Text.Length > 0)
                label1.Text = label1.Text.Substring(0, label1.Text.Length - 1);
        }
    }
}