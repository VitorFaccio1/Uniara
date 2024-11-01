namespace Metadados.Models;

public sealed class GeminiResponse
{
    public Candidate[] candidates { get; set; }

    public sealed class Candidate
    {
        public Content content { get; set; }

        public sealed class Content
        {
            public Part[] parts { get; set; }

            public sealed class Part
            {
                public string text { get; set; }
            }
        }
    }
}