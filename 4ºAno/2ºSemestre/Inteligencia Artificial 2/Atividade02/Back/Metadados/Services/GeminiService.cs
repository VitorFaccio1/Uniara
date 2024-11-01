using Metadados.Interfaces;
using Metadados.Models;
using RestSharp;

namespace Metadados.Services;

public sealed class MetadadoService : IMetadadoService
{
    public async Task<string> ProcessFileContentAsync(string text)
    {
        var apiKey = "AIzaSyCyRzzsVTUpbozkhhrf8WEYXyGzcThcFTM";
        var client = new RestClient("https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash-latest:generateContent");
        var request = new RestRequest("", Method.Post);
        request.AddHeader("Content-Type", "application/json");

        request.AddQueryParameter("key", apiKey);

        request.AddJsonBody(new
        {
            contents = new[]
            {
                new
                {
                    parts = new[]
                    {
                        new {  text = $"Me de o nome e o tipo de dado das colunas existente nesse texto: {text}" +
                        ", retorne apenas as nomes e tipos de coluna no formato json, mais nenhuma informação" }
                    }
                }
            }
        });

        var response = await client.ExecuteAsync(request);

        if (response.IsSuccessful)
        {
            var jsonResponse = System.Text.Json.JsonSerializer.Deserialize<GeminiResponse>(response.Content);
            return jsonResponse?.candidates[0]?.content?.parts[0]?.text ?? "";
        }
        else
            return $"Error: {response.StatusDescription} - {response.Content}";
    }
}