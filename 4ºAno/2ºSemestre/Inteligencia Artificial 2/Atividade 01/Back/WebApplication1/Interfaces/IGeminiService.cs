using WebApplication1.Models;

namespace WebApplication1.Interfaces;

public interface IGeminiService
{
    Task<List<string>> GetSymbolsAsync();

    Task<SymbolDetail> GetSymbolDetailsAsync(string symbol);

    Task<SymbolTicker> GetSymbolTickerAsync(string symbol);

    Task<SymbolCurrentOrderBook> GetSymbolCurrentOrderBookAsync(string symbol);
}