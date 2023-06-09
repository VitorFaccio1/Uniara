using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;

namespace Telefone
{
    public partial class Form1 : Form
    {
        public List<Contato> Contatos;

        public Form1()
        {
            InitializeComponent();

            Contatos = new List<Contato>();

            dataGridView1.Columns.Add("Nome", "Nome");
            dataGridView1.Columns.Add("Telefone", "Telefone");
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            Form2 form2 = new Form2();
            var result = form2.ShowDialog();

            if (result == DialogResult.OK)
            {
                if (Contatos.Any(c => c.Telefone.Equals(form2.Contato.Telefone)))
                {
                    MessageBox.Show("Contato com mesmo telefone já existe!!");
                    return;
                }

                Contatos.Add(form2.Contato);

                ShowDataGridViewWithContacts();
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (Contatos.Any())
            {
                if (dataGridView1.SelectedRows.Count == 1)
                {
                    int selectedIndex = dataGridView1.SelectedRows[0].Index;

                    if (selectedIndex < Contatos.Count)
                    {
                        var form2 = new Form2(Contatos[selectedIndex]);

                        if (form2.ShowDialog() == DialogResult.OK)
                        {
                            Contatos[selectedIndex] = form2.Contato;

                            ShowDataGridViewWithContacts();
                        }
                    }
                    else
                        MessageBox.Show("Impossivel alterar essa linha!!");

                }
                else
                    MessageBox.Show("Selecione aapenas uma linha para alteração!!");
            }
            else
                MessageBox.Show("Lista de contatos vazia!!");
        }

        private void button3_Click(object sender, EventArgs e)
        {
            if (Contatos.Any())
            {
                if (dataGridView1.SelectedRows.Count == 1)
                {
                    int selectedIndex = dataGridView1.SelectedRows[0].Index;

                    if (selectedIndex < Contatos.Count)
                    {
                        var contact = Contatos[selectedIndex];

                        var confirmation = MessageBox.Show($"Tem certeza que deseja remover o contato " +
                            $"com nome {contact.Nome} e telefone {contact.Telefone}",
                            "Confirmação de Exclusão", MessageBoxButtons.YesNo);

                        if (confirmation == DialogResult.Yes)
                            Contatos.Remove(Contatos[selectedIndex]);

                        ShowDataGridViewWithContacts();
                    }
                }
                else
                    MessageBox.Show("Selecione apenas uma linha para exclusão!!");
            }
            else
                MessageBox.Show("Lista de contatos vazia!!");
        }

        private void button4_Click(object sender, EventArgs e)
        {
            if (Contatos.Any())
            {
                var form3 = new Form3(Contatos);
                form3.ShowDialog();
            }
            else
                MessageBox.Show("Lista de contatos vazia!!");
        }

        private void ShowDataGridViewWithContacts()
        {
            dataGridView1.Rows.Clear();

            foreach (var contato in Contatos)
                dataGridView1.Rows.Add(new object[] { contato.Nome, contato.Telefone });
        }
    }
}