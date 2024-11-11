using HomeEasyApi.Models;
using Microsoft.EntityFrameworkCore;

namespace HomeEasyApi.Data
{
    public class HomeEasyApiContext : DbContext
    {
        public HomeEasyApiContext(DbContextOptions<HomeEasyApiContext> options)
            : base(options)
        {
        }

        public DbSet<Anuncio> Anuncio { get; set; } = default!;
    }
}