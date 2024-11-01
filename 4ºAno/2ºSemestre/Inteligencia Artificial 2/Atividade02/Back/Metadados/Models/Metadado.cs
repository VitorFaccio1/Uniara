using System.ComponentModel.DataAnnotations;

namespace Metadados.Models;

public sealed class Metadado
{
    [Key]
    public int Id { get; set; }

    public DateTime Data { get; set; }

    public string NomeArquivo { get; set; }

    public string FormatoArquivo { get; set; }

    public string Colunas { get; set; }
}