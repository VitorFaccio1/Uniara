using System.ComponentModel.DataAnnotations;
using System.Text.Json.Serialization;

namespace HomeEasyApi.Models;

public class Anuncio
{
    [Key]
    public int Id { get; set; }
    public string Titulo { get; set; }
    public string Descricao { get; set; }
}