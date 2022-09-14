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
    public partial class LoginForm : Form
    {
        public LoginForm()
        {
            InitializeComponent();

            passwordBox.PasswordChar = '*';
            passwordBox.MaxLength = 10;
            loginBox.MaxLength = 10;

            ShoesShopUser.login = "";
            ShoesShopUser.password = "";
            ShoesShopUser.adminRights = false;
        }

        private void loginButton_Click(object sender, EventArgs e)
        {
            if (loginBox.Text == "")
            {
                MessageBox.Show("The login field must be filled in");
                return;
            }

            if (passwordBox.Text == "")
            {
                MessageBox.Show("The password field must be filled in");
                return;
            }

            ShoesShopUser.login = loginBox.Text;
            ShoesShopUser.password = passwordBox.Text;
            ShoesShopUser.adminRights = AuthManager.Authorization();

            if (ShoesShopUser.adminRights)
            {
                MessageBox.Show("Login Successfull");
            } else
            {
                MessageBox.Show("Login Failed");
            }

            this.Close();
        }
    }
}
