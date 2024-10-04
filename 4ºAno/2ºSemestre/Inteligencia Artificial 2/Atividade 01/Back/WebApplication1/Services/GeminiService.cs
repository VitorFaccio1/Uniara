using Newtonsoft.Json;
using WebApplication1.Interfaces;
using WebApplication1.Models;

namespace WebApplication1.Services;

public sealed class GeminiService : IGeminiService
{
    private readonly HttpClient _httpClient;

    public GeminiService(HttpClient httpClient)
    {
        _httpClient = httpClient;
    }

    public async Task<List<string>> GetSymbolsAsync()
    {
        var response = await _httpClient.GetAsync("https://api.gemini.com/v1/symbols");
        response.EnsureSuccessStatusCode();

        var data = await response.Content.ReadAsStringAsync();

        return JsonConvert.DeserializeObject<List<string>>(data);
    }

    public async Task<SymbolDetail> GetSymbolDetailsAsync(string symbol)
    {
        var response = await _httpClient.GetAsync($"https://api.gemini.com/v1/symbols/details/{symbol}");
        response.EnsureSuccessStatusCode();

        var data = await response.Content.ReadAsStringAsync();

        return JsonConvert.DeserializeObject<SymbolDetail>(data);
    }

    public async Task<SymbolTicker> GetSymbolTickerAsync(string symbol)
    {
        var response = await _httpClient.GetAsync($"https://api.gemini.com/v2/ticker/{symbol}");
        response.EnsureSuccessStatusCode();

        var data = await response.Content.ReadAsStringAsync();

        return JsonConvert.DeserializeObject<SymbolTicker>(data);
    }

    public async Task<SymbolCurrentOrderBook> GetSymbolCurrentOrderBookAsync(string symbol)
    {
        var response = await _httpClient.GetAsync($"https://api.gemini.com/v1/book/{symbol}");
        response.EnsureSuccessStatusCode();

        var data = await response.Content.ReadAsStringAsync();

        return JsonConvert.DeserializeObject<SymbolCurrentOrderBook>(data);
    }
}