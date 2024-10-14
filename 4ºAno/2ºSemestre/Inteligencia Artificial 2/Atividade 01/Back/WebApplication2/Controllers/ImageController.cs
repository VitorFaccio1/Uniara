using Microsoft.AspNetCore.Mvc;
using RestSharp;
using Tesseract;
using WebApplication2.Models;

[Route("api/[controller]")]
[ApiController]
public class ImageController : ControllerBase
{
    [HttpPost("convert-image")]
    public async Task<IActionResult> ConvertImage(IFormFile image)
    {
        if (image == null || image.Length == 0)
            return BadRequest("No image uploaded.");

        string textFromImage;
        try
        {
            using (var stream = new MemoryStream())
            {
                await image.CopyToAsync(stream);
                var ocrEngine = new TesseractEngine(@"./tessdata", "eng", EngineMode.Default);
                var img = Pix.LoadFromMemory(stream.ToArray());
                var page = ocrEngine.Process(img);
                textFromImage = page.GetText();
            }
        }
        catch (TesseractException ex)
        {
            return StatusCode(500, $"Tesseract initialization failed: {ex.Message}");
        }

        var responseText = await GetResponseFromGemini(textFromImage);
        return Ok(responseText);
    }

    private static async Task<string> GetResponseFromGemini(string text)
    {
        var apiKey = "AIzaSyDOGihRSUqZTjkir05QJyTPoT1MRMjLN7o";
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
                        new {  text }
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