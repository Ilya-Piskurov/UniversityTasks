using Npgsql;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TSPP_ShoesSolution.source.model
{
    static public class ShoesManager
    {
        static public List<string> ReadDataOfShoes()
        {
            List<string> result = new List<string>();

            NpgsqlConnection npgsqlConnection = new NpgsqlConnection(ServerAccess.connectionString);
            npgsqlConnection.Open();

            string query = "select name, article, count, price from public.shoes;";
            NpgsqlCommand command = new NpgsqlCommand(query, npgsqlConnection);

            NpgsqlDataReader reader = command.ExecuteReader();
            while (reader.Read())
            {
                result.Add(String.Format(@"Name = {0}, Article = {1}, Count = {2}, Price = {3}",
                    reader.GetString(0), reader.GetString(1),
                    reader.GetInt32(2).ToString(), reader.GetDouble(3).ToString()));
            }

            return result;
        }
        static public string ReadRecordInDB(string article)
        {
            string result = null;

            NpgsqlConnection npgsqlConnection = new NpgsqlConnection(ServerAccess.connectionString);
            npgsqlConnection.Open();

            string query = string.Format(@"select name, article, count, price from public.shoes where article = '{0}';", article);
            NpgsqlCommand command = new NpgsqlCommand(query, npgsqlConnection);
            try
            {
                NpgsqlDataReader reader = command.ExecuteReader();

                while (reader.Read())
                {
                    result = String.Format(@"Name = {0}, Article = {1}, Count = {2}, Price = {3}",
                        reader.GetString(0), reader.GetString(1),
                        reader.GetInt32(2).ToString(), reader.GetDouble(3).ToString());
                }
                return result;
            } catch
            {
                return result;
            }
        }
        static public void AddNewRecordInDB(string name, string article, string count, string price)
        {
            NpgsqlConnection npgsqlConnection = new NpgsqlConnection(ServerAccess.connectionString);
            npgsqlConnection.Open();

            string query = string.Format("INSERT INTO public.shoes(name, article, count, price) VALUES('{0}', '{1}', {2}, {3});",
                name, article, count, price);
            NpgsqlCommand command = new NpgsqlCommand(query, npgsqlConnection);
            command.ExecuteNonQuery();
        }
        //static public void EditRecordInDB(Shoes editedRecord);

    }
}
