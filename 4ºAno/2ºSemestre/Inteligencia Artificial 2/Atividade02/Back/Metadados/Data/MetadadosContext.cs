using Metadados.Models;
using Microsoft.EntityFrameworkCore;

namespace Metadados.Data;

public sealed class MetadadosContext : DbContext
{
    public MetadadosContext(DbContextOptions<MetadadosContext> options)
        : base(options)
    {
    }

    public DbSet<Metadado> Metadado { get; set; } = default!;
}