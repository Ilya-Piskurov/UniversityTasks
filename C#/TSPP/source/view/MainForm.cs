using Aspose.Words;
using TSPP_ShoesSolution.source.model;
using TSPP_ShoesSolution.source.view;

namespace TSPP_ShoesSolution
{
    public partial class MainForm : Form
    {
        public MainForm()
        {
            InitializeComponent();
        }

        private void AuthButton_Click(object sender, EventArgs e)
        {
            LoginForm loginForm = new LoginForm();
            loginForm.Show();
        }

        private void OurTeam_Click(object sender, EventArgs e)
        {
            OurTeamForm ourTeamForm = new OurTeamForm();
            ourTeamForm.Show();
        }

        private void ShowAllButton_Click(object sender, EventArgs e)
        {
            InfoListBox.Items.Clear();
            List<string> shoes = ShoesManager.ReadDataOfShoes();
            foreach (string sho in shoes)
            {
                InfoListBox.Items.Add(sho);
            }
        }

        private void SearchByArticleButton_Click(object sender, EventArgs e)
        {
            if (ArticleTextBox.Text == "")
            {
                MessageBox.Show("Article can't be empty. Please fill article field.");
                return;
            }
            InfoListBox.Items.Clear();
            string result = ShoesManager.ReadRecordInDB(ArticleTextBox.Text.ToUpper());
            if (result == null)
            {
                MessageBox.Show("There are no shoes with this article");
                return;
            }
            InfoListBox.Items.Add(result);
        }

        private void AddNewRecordButton_Click(object sender, EventArgs e)
        {
            if (ShoesShopUser.adminRights == false)
            {
                MessageBox.Show("You must be an admin for this. Please login!");
                return;
            }

            AddRecordForm addRecordForm = new AddRecordForm();
            addRecordForm.Show();
        }

        private void CreateReportButton_Click(object sender, EventArgs e)
        {
            if (SaveFilePathBox.Text == "")
            {
                MessageBox.Show("You must put correctly path to save file!");
            }
            if (InfoListBox.Items.Count == 0)
            {
                MessageBox.Show("Report can't be empty!");
                return;
            }
            Document doc = new Document();
            DocumentBuilder documentBuilder = new DocumentBuilder(doc);
            foreach (string item in InfoListBox.Items)
            {
                documentBuilder.Writeln(item);
            }
            doc.Save(SaveFilePathBox.Text);
            MessageBox.Show("File successfuly saved!");
            //Todo SaveFileDialog
        }
    }
}