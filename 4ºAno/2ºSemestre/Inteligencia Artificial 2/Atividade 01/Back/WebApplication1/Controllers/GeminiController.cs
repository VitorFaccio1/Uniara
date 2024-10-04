using Microsoft.AspNetCore.Mvc;
using WebApplication1.Interfaces;

namespace WebApplication1.Controllers;

[ApiController]
[Route("api/[controller]")]
public sealed class GeminiController : ControllerBase
{
    private readonly IGeminiService _geminiService;
    private readonly List<string> _famousSymbols;

    public GeminiController(IGeminiService geminiService)
    {
        _geminiService = geminiService;
        _famousSymbols = ["btcusd", "btcusdt", "btcgusd", "btceur", "btcgbp", "ethusd", "ethusdt", "ethgusd", "etheur", "ethgbp", "ltcusd", "ltcbtc", "ltceth", "xrpusd", "bchusd", "bchbtc", "bcheth", "dogeusd", "dogebtc", "dogeeth", "dotusd", "solusd", "solbtc", "soleth", "linkusd", "linkbtc", "linketh"];

    }

    [HttpGet("symbols")]
    public async Task<IActionResult> GetSymbols()
    {
        try
        {
            var symbols = await _geminiService.GetSymbolsAsync();

            var filteredSymbols = symbols?.Where(symbol => _famousSymbols.Contains(symbol)).ToList();

            if (filteredSymbols == null || !filteredSymbols.Any())
                return NotFound("Somente os símbolos mais famosos são aceitos!");

            return Ok(filteredSymbols);
        }
        catch (Exception ex)
        {
            return StatusCode(500, $"Ocorreu um erro com a chamada.\n" +
                $"Message: {ex.Message}");
        }
    }

    [HttpGet("details/{symbol}")]
    public async Task<IActionResult> GetSymbolDetail(string symbol)
    {
        if (string.IsNullOrEmpty(symbol))
            return BadRequest("Símbolo não pode ser nulo ou vazio.");

        if (!_famousSymbols.Contains(symbol))
            return NotFound("Somente os símbolos mais famosos são aceitos!");

        try
        {
            return Ok(await _geminiService.GetSymbolDetailsAsync(symbol));
        }
        catch (Exception ex)
        {
            return StatusCode(500, $"Ocorreu um erro com a chamada.\n" +
                $"Message: {ex.Message}");
        }
    }

    [HttpGet("ticker/{symbol}")]
    public async Task<IActionResult> GetSymbolTicker(string symbol)
    {
        if (string.IsNullOrEmpty(symbol))
            return BadRequest("Símbolo não pode ser nulo ou vazio.");

        if (!_famousSymbols.Contains(symbol))
            return NotFound("Somente os símbolos mais famosos são aceitos!");

        try
        {
            return Ok(await _geminiService.GetSymbolTickerAsync(symbol));
        }
        catch (Exception ex)
        {
            return StatusCode(500, $"Ocorreu um erro com a chamada.\n" +
                $"Message: {ex.Message}");
        }
    }

    [HttpGet("book/{symbol}/{buy}")]
    public async Task<IActionResult> GetSymbolCurrentOrderBook(string symbol, bool buy)
    {
        if (string.IsNullOrEmpty(symbol))
            return BadRequest("Símbolo não pode ser nulo ou vazio.");

        if (!_famousSymbols.Contains(symbol))
            return NotFound("Somente os símbolos mais famosos são aceitos!");

        try
        {
            var book = await _geminiService.GetSymbolCurrentOrderBookAsync(symbol);

            return Ok(buy ? book.Bids.Take(3) : book.Asks.Take(3));
        }
        catch (Exception ex)
        {
            return StatusCode(500, $"Ocorreu um erro com a chamada.\n" +
                $"Message: {ex.Message}");
        }
    }
}