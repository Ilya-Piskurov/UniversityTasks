using Npgsql;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TSPP_ShoesSolution.source.model
{
    static public class AuthManager
    {
        static public bool Authorization()
        {
            bool result = false;

            NpgsqlConnection npgsqlConnection = new NpgsqlConnection(ServerAccess.connectionString);

            npgsqlConnection.Open();
            string query = string.Format
            (
                @"select exists (select '{0}' from public.admins where login = '{1}');",
                ShoesShopUser.password, ShoesShopUser.login
            );
            NpgsqlCommand command = new NpgsqlCommand(query, npgsqlConnection);
            result = bool.Parse(command.ExecuteScalar().ToString());

            return result;
        }
    }
}
