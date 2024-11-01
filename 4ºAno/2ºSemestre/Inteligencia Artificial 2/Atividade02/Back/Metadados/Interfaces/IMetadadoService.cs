namespace Metadados.Interfaces;

public interface IMetadadoService
{
    Task<string> ProcessFileContentAsync(string text);
}