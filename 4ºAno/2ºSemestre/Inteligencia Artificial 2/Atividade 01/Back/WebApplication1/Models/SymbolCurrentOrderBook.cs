using Newtonsoft.Json;

namespace WebApplication1.Models;

public sealed class SymbolCurrentOrderBook
{
    [JsonProperty("bids")]
    public List<Bid> Bids { get; set; }

    [JsonProperty("asks")]
    public List<Ask> Asks { get; set; }

    public sealed class Ask
    {
        [JsonProperty("price")]
        public string Price { get; set; }

        [JsonProperty("amount")]
        public string Amount { get; set; }

        [JsonProperty("timestamp")]
        public string Timestamp { get; set; }
    }

    public sealed class Bid
    {
        [JsonProperty("price")]
        public string Price { get; set; }

        [JsonProperty("amount")]
        public string Amount { get; set; }

        [JsonProperty("timestamp")]
        public string Timestamp { get; set; }
    }
}