using Metadados.Data;
using Metadados.Interfaces;
using Metadados.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.CodeAnalysis;
using Newtonsoft.Json;

namespace Metadados.Controllers
{
    [Route("api/metadados")]
    [ApiController]
    public class MetadadosController : Controller
    {
        private readonly MetadadosContext _context;
        private readonly IMetadadoService _metadadoService;
        private readonly List<string> _fileFormats = [".csv", ".json", ".xml", ".txt"];

        public MetadadosController(
            MetadadosContext context,
            IMetadadoService metadadoService)
        {
            _context = context;
            _metadadoService = metadadoService;
        }

        [HttpPost("upload")]
        public async Task<IActionResult> Upload(IFormFile file)
        {
            if (file == null || file.Length == 0)
                return BadRequest("Nenhum arquivo enviado.");

            var formatFile = Path.GetExtension(file.FileName).ToLower();

            if (!_fileFormats.Contains(formatFile))
                return BadRequest("Tipo de arquivo errado, selecione apenas arquivos csv, json, xml ou txt!");

            using var reader = new StreamReader(file.OpenReadStream());
            var content = await reader.ReadToEndAsync();

            try
            {
                var processedContent = await _metadadoService.ProcessFileContentAsync(content);

                var metadado = GetMetadado(file, processedContent);

                _context.Metadado.Add(metadado);

                await _context.SaveChangesAsync();

                return Ok(metadado);
            }
            catch (Exception ex)
            {
                return StatusCode(500, $"Erro ao processar o arquivo: {ex.Message}");
            }
        }

        private static Metadado GetMetadado(IFormFile file, string processedContent)
        {
            processedContent = processedContent.Trim('`').Replace("json", "");

            var dictionary = JsonConvert.DeserializeObject<Dictionary<string, string>>(processedContent);

            var colunas = new List<Coluna>();

            foreach (var item in dictionary)
            {
                colunas.Add(new Coluna
                {
                    NomeColuna = item.Key,
                    TipoDado = item.Value
                });
            }

            string resultadoJson = JsonConvert.SerializeObject(colunas, Formatting.Indented);

            var metadado = new Metadado
            {
                NomeArquivo = file.FileName,
                Data = DateTime.Now,
                FormatoArquivo = Path.GetExtension(file.FileName),
                Colunas = resultadoJson
            };
            return metadado;
        }
    }
}