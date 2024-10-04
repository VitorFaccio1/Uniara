using Newtonsoft.Json;

namespace WebApplication1.Models;

public class SymbolDetail
{
    [JsonProperty("symbol")]
    public string Symbol { get; set; }

    [JsonProperty("base_currency")]
    public string BaseCurrency { get; set; }

    [JsonProperty("quote_currency")]
    public string QuoteCurrency { get; set; }

    [JsonProperty("tick_size")]
    public double TickSize { get; set; }

    [JsonProperty("quote_increment")]
    public double QuoteIncrement { get; set; }

    [JsonProperty("min_order_size")]
    public string MinOrderSize { get; set; }

    [JsonProperty("status")]
    public string Status { get; set; }

    [JsonProperty("wrap_enabled")]
    public bool WrapEnabled { get; set; }

    [JsonProperty("product_type")]
    public string ProductType { get; set; }

    [JsonProperty("contract_type")]
    public string ContractType { get; set; }

    [JsonProperty("contract_price_currency")]
    public string ContractPriceCurrency { get; set; }
}