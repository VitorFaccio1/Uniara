using Newtonsoft.Json;

namespace WebApplication1.Models;

public class SymbolTicker
{
    [JsonProperty("symbol")]
    public string Symbol { get; set; }

    [JsonProperty("open")]
    public string Open { get; set; }

    [JsonProperty("high")]
    public string High { get; set; }

    [JsonProperty("low")]
    public string Low { get; set; }

    [JsonProperty("close")]
    public string Close { get; set; }

    [JsonProperty("changes")]
    public List<string> Changes { get; set; }

    [JsonProperty("bid")]
    public string Bid { get; set; }

    [JsonProperty("ask")]
    public string Ask { get; set; }
}