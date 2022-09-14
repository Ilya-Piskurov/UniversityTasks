using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using TSPP_ShoesSolution.source.model;

namespace TSPP_ShoesSolution.source.view
{
    public partial class AddRecordForm : Form
    {
        public AddRecordForm()
        {
            InitializeComponent();
        }

        private void addRecordButton_Click(object sender, EventArgs e)
        {
            if (textBox1.Text == "")
            {
                MessageBox.Show("The \"Name\" field can't be empty!");
                return;
            }
            if (textBox2.Text == "")
            {
                MessageBox.Show("The \"Article\" field can't be empty!");
                return;
            }
            if (textBox3.Text == "")
            {
                MessageBox.Show("The \"Count\" field can't be empty!");
                return;
            }
            if (textBox4.Text == "")
            {
                MessageBox.Show("The \"Price\" field can't be empty!");
                return;
            }
            ShoesManager.AddNewRecordInDB(textBox1.Text, textBox2.Text,
                textBox3.Text, textBox4.Text);
            MessageBox.Show("Record in DB created!");
            this.Close();
        }
    }
}
